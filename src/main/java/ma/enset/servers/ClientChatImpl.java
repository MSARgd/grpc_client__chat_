package ma.enset.servers;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.stage.Stage;
import ma.enset.subs.Chat;
import ma.enset.subs.chatServiceGrpc;

public class ClientChatImpl  extends chatServiceGrpc.chatServiceImplBase {
    public static void main(String[] args) {
        try {
            new ChatApp().start(new Stage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 2023)
                .usePlaintext()
                .build();
        chatServiceGrpc.chatServiceStub stub = chatServiceGrpc.newStub(managedChannel);
        StreamObserver<Chat.ChatRequest> streamObserver = stub.chat(new StreamObserver<Chat.ChatResponse>() {
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
        /** ====================================================================**/

         streamObserver.onNext(Chat.ChatRequest.newBuilder()
         .setUserId(1)
         .setChatId(1)
         .setChatMessage("What up?")
         .build()
         );
        /**===================================================================**/
         try {
         Thread.sleep(3000);
         } catch (InterruptedException e) {
         e.printStackTrace();
         }
        /**============================================================**/
         streamObserver.onNext(Chat.ChatRequest.newBuilder()
         .setUserId(2)
         .setChatId(1)
         .setChatMessage("Nothing Much. You?")
         .build()
         );
        /**=======================================**/
         try {
         Thread.sleep(3000);
         } catch (InterruptedException e) {
         e.printStackTrace();
         }
         streamObserver.onNext(Chat.ChatRequest.newBuilder()
         .setUserId(1)
         .setChatId(1)
         .setChatMessage("Chillin")
         .build()
         );
         streamObserver.onCompleted();
    }
}