package ma.enset.interceptors;

import io.grpc.*;

public class ChatInterceptor  implements ServerInterceptor {

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {

        return  new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>() {
            @Override
            protected ServerCall.Listener<ReqT> delegate() {
                return super.delegate();
            }

            @Override
            public void onMessage(ReqT message) {
                super.onMessage(message);
            }

            @Override
            public void onHalfClose() {
                super.onHalfClose();
            }

            @Override
            public void onCancel() {
                super.onCancel();
            }

            @Override
            public void onComplete() {
                super.onComplete();
            }

            @Override
            public void onReady() {
                super.onReady();
            }

            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        }
    }
}
