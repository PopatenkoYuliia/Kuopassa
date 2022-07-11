package ApiTests.DummyTests;

public class DeleteUsers {
    private String status;
    private String data;
    private String message;

    public DeleteUsers() {
    }

    public DeleteUsers(String status, String data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
