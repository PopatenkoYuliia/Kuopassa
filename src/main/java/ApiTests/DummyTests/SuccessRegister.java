package ApiTests.DummyTests;

public class SuccessRegister extends CreateNewData {
    private Integer id;

    public SuccessRegister() {
    }

    public SuccessRegister(String name, String salary, String age, Integer id) {
        super(name, salary, age);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
