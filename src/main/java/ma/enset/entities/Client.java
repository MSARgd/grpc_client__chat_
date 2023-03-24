package ma.enset.entities;

import io.grpc.Metadata;

public class Client {
    public int id;
    public Metadata clientMetadata;

    public Client() {
    }

    public Client(int id, Metadata clientMetadata) {
        this.id = id;
        this.clientMetadata = clientMetadata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Metadata getClientMetadata() {
        return clientMetadata;
    }

    public void setClientMetadata(Metadata clientMetadata) {
        this.clientMetadata = clientMetadata;
    }
}
