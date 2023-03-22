package ma.enset.subs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Chat.proto")
public final class chatServiceGrpc {

  private chatServiceGrpc() {}

  public static final String SERVICE_NAME = "chatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ma.enset.subs.Chat.ChatRequest,
      ma.enset.subs.Chat.ChatResponse> getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "chat",
      requestType = ma.enset.subs.Chat.ChatRequest.class,
      responseType = ma.enset.subs.Chat.ChatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ma.enset.subs.Chat.ChatRequest,
      ma.enset.subs.Chat.ChatResponse> getChatMethod() {
    io.grpc.MethodDescriptor<ma.enset.subs.Chat.ChatRequest, ma.enset.subs.Chat.ChatResponse> getChatMethod;
    if ((getChatMethod = chatServiceGrpc.getChatMethod) == null) {
      synchronized (chatServiceGrpc.class) {
        if ((getChatMethod = chatServiceGrpc.getChatMethod) == null) {
          chatServiceGrpc.getChatMethod = getChatMethod = 
              io.grpc.MethodDescriptor.<ma.enset.subs.Chat.ChatRequest, ma.enset.subs.Chat.ChatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "chatService", "chat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.subs.Chat.ChatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ma.enset.subs.Chat.ChatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new chatServiceMethodDescriptorSupplier("chat"))
                  .build();
          }
        }
     }
     return getChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static chatServiceStub newStub(io.grpc.Channel channel) {
    return new chatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static chatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new chatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static chatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new chatServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class chatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.subs.Chat.ChatRequest> chat(
        io.grpc.stub.StreamObserver<ma.enset.subs.Chat.ChatResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getChatMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ma.enset.subs.Chat.ChatRequest,
                ma.enset.subs.Chat.ChatResponse>(
                  this, METHODID_CHAT)))
          .build();
    }
  }

  /**
   */
  public static final class chatServiceStub extends io.grpc.stub.AbstractStub<chatServiceStub> {
    private chatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private chatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected chatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new chatServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ma.enset.subs.Chat.ChatRequest> chat(
        io.grpc.stub.StreamObserver<ma.enset.subs.Chat.ChatResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class chatServiceBlockingStub extends io.grpc.stub.AbstractStub<chatServiceBlockingStub> {
    private chatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private chatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected chatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new chatServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class chatServiceFutureStub extends io.grpc.stub.AbstractStub<chatServiceFutureStub> {
    private chatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private chatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected chatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new chatServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHAT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final chatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(chatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chat(
              (io.grpc.stub.StreamObserver<ma.enset.subs.Chat.ChatResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class chatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    chatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ma.enset.subs.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("chatService");
    }
  }

  private static final class chatServiceFileDescriptorSupplier
      extends chatServiceBaseDescriptorSupplier {
    chatServiceFileDescriptorSupplier() {}
  }

  private static final class chatServiceMethodDescriptorSupplier
      extends chatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    chatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (chatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new chatServiceFileDescriptorSupplier())
              .addMethod(getChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
