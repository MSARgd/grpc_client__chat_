package ma.enset.servers;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ma.enset.subs.Chat;
import ma.enset.subs.chatServiceGrpc;
public class ChatApp extends Application{
    private chatServiceGrpc.chatServiceStub stub;
    private StreamObserver<Chat.ChatRequest> streamObserver;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        HBox hBox = new HBox();
        TextArea textArea = new TextArea();
        textArea.setPrefWidth(300);
        textArea.setPrefRowCount(2);
//        textArea.setPadding(new Insets(20));
        Button btn = new Button("send");
        btn.setPrefWidth(100);

        btn.setPadding(new Insets(20));
        hBox.setSpacing(20);
        // Create the gRPC channel and stub
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 2023)
                .usePlaintext()
                .build();
        stub = chatServiceGrpc.newStub(managedChannel);


        // Create the streamObserver
        streamObserver = stub.chat(new StreamObserver<Chat.ChatResponse>() {
            @Override
            public void onNext(Chat.ChatResponse chatResponse) {
                System.out.println("[CLIENT] Received Message for Chat ID [" +
                        chatResponse.getChatId() + "] from User ID [" + chatResponse.getUserId() + "] Message is: " +
                        chatResponse.getChatMessage());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());

            }

            @Override
            public void onCompleted() {

            }

        });

        // Add an event listener to the button
        btn.setOnAction(event -> {
            String message = textArea.getText();
            if (!message.isEmpty()) {
                // Create a ChatRequest message with the user's input
                Chat.ChatRequest request = Chat.ChatRequest.newBuilder()
                        .setChatMessage(message)
                        .build();

                // Send the message to the server
                streamObserver.onNext(request);

                // Clear the input field
                textArea.clear();
            }
        });

        hBox.getChildren().addAll(textArea,btn);
        root.setTop(hBox);
        primaryStage.setScene(new Scene(root,400,400));
        primaryStage.show();
    }
}

