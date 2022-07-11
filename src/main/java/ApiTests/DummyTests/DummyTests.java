package ApiTests.DummyTests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DummyTests {
    private final static String URL = "http://dummy.restapiexample.com/";

    @Test
    public void checkNumberOfEmployees(){
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOK200());
        int expectedNumberOfEmployees=24;
        List<EmployeesData> employees = given()
                .when()
                .get("api/v1/employees")
                .then().log().all()
                .extract().body().jsonPath().getList("data",EmployeesData.class);
        Assert.assertEquals(employees.size(), expectedNumberOfEmployees);

    }
    @Test
    public void getSimpleEmployee(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        EmployeesData employeeId1 = given()
                .when()
                .get("api/v1/employee/1")
                .then().log().all()
                .extract().body().jsonPath().getObject("data",EmployeesData.class);
        System.out.println(employeeId1.getEmployee_name());
    }

    @Test
    public void createNewDataInDataBase(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        CreateNewData user = new CreateNewData("test", "123", "23");
        RootSuccessRegister successRegister=given()
                .body(user)
                .post("api/v1/create")
                .then().log().all()
                .extract().as(RootSuccessRegister.class);
        Assert.assertEquals("success",successRegister.getStatus());
    }
    @Test
    public void updateDataInDataBase(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        CreateNewData user = new CreateNewData("test", "123", "23");
        RootSuccessRegister successRegister=given()
                .body(user)
                .put("api/v1/update/21")
                .then().log().all()
                .extract().as(RootSuccessRegister.class);
        Assert.assertEquals("Successfully! Record has been updated.",successRegister.getMessage());
    }

    @Test
    public void deleteDataInDataBase(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        DeleteUsers deleteRegister=given()
                .when()
                .delete("api/v1/delete/2")
                .then().log().all()
                .extract().as(DeleteUsers.class);
        Assert.assertEquals("Successfully! Record has been deleted",deleteRegister.getMessage());
    }
}
