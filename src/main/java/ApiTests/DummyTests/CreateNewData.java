package ApiTests.DummyTests;

public class CreateNewData {
    private String name;
    private String salary;
    private String age;


    public CreateNewData() {
    }

    public CreateNewData(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getAge() {
        return age;
    }

}
