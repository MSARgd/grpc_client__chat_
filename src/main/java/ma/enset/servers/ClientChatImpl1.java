package ma.enset.servers;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ma.enset.subs.Chat;
import ma.enset.subs.chatServiceGrpc;

public class ClientChatImpl1 extends chatServiceGrpc.chatServiceImplBase {

    private final chatServiceGrpc.chatServiceStub stub;

    public ClientChatImpl1() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 2023)
                .usePlaintext()
                .build();
        this.stub = chatServiceGrpc.newStub(managedChannel);
    }

    public void sendMessage(int userId, int chatId, String chatMessage) {
        StreamObserver<Chat.ChatRequest> streamObserver = this.stub.chat(new StreamObserver<Chat.ChatResponse>() {
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

        streamObserver.onNext(Chat.ChatRequest.newBuilder()
                .setUserId(userId)
                .setChatId(chatId)
                .setChatMessage(chatMessage)
                .build());

        streamObserver.onCompleted();
    }
}
