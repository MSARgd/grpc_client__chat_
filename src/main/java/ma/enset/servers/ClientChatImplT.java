//package ma.enset.servers;
//package ma.enset.servers;
//
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.stub.StreamObserver;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import ma.enset.subs.Chat;
//import ma.enset.subs.chatServiceGrpc;
//
//public class ClientChatImpl extends chatServiceGrpc.chatServiceImplBase {
//
//    private TextArea chatArea;
//    private ListView<String> userList;
//    private TextField messageField;
//    private Button sendButton;
//    private ManagedChannel channel;
//
//    public static void main(String[] args) {
//        launch(ChatApp.class); // Launch the ChatApp interface
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        BorderPane root = new BorderPane();
//        HBox hBox = new HBox();
//        messageField = new TextField();
//        sendButton = new Button("Send");
//        hBox.getChildren().addAll(messageField, sendButton);
//        root.setBottom(hBox);
//        chatArea = new TextArea();
//        chatArea.setEditable(false);
//        userList = new ListView<>();
//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(chatArea, userList);
//        root.setCenter(vBox);
//        primaryStage.setScene(new Scene(root, 400, 400));
//        primaryStage.setOnCloseRequest(event -> {
//            // Shutdown the channel when the interface is closed
//            if (channel != null) {
//                channel.shutdownNow();
//            }
//        });
//        primaryStage.show();
//
//        // Connect to the gRPC server
//        channel = ManagedChannelBuilder.forAddress("localhost", 2023)
//                .usePlaintext()
//                .build();
//        chatServiceGrpc.chatServiceStub stub = chatServiceGrpc.newStub(channel);
//        StreamObserver<Chat.ChatRequest> streamObserver = stub.chat(new StreamObserver<Chat.ChatResponse>() {
//            @Override
//            public void onNext(Chat.ChatResponse chatResponse) {
//                // Update the chat area with new messages
//                Platform.runLater(() -> {
//                    chatArea.appendText(String.format("[%d] %s: %s%n", chatResponse.getChatId(), chatResponse.getUserId(),
//                            chatResponse.getChatMessage()));
//                });
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                // Show an error message if there is a problem with the connection
//                Platform.runLater(() -> {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Connection Error");
//                    alert.setContentText(throwable.getMessage());
//                    alert.showAndWait();
//                });
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//        });
//
//        // Send messages when the send button is clicked
//        sendButton.setOnAction(event -> {
//            int userId = 1; // Change this to your user ID
//            int chatId = 1; // Change this to the ID of the chat you want to send messages to
//            String message = messageField.getText().trim();
//            if (!message.isEmpty()) {
//                streamObserver.onNext(Chat.ChatRequest.newBuilder()
//                        .setUserId(userId)
//                        .setChatId(chatId)
//                        .
