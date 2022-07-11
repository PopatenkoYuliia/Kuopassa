package ApiTests.DummyTests;

public class RootSuccessRegister {
        private String status;
    private SuccessRegister data;
    private String message;

    public RootSuccessRegister() {
    }

    public RootSuccessRegister(String status, SuccessRegister data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public CreateNewData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

