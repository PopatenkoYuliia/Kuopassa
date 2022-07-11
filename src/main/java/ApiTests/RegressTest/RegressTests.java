package ApiTests.RegressTest;

import ApiTests.DummyTests.EmployeesData;
import ApiTests.DummyTests.Specifications;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class RegressTests {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkEmailContains() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<Users> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", Users.class);
        users.stream().forEach(x -> x.getEmail().endsWith("regres.in"));
    }

    @Test
    public void getSingleUser() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Users singleUser = given()
                .when()
                .get("/api/users/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data",Users.class);

    }
@Test
    public void singleUserNotFound() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseExpected(404));
        Users user = given()
                .when()
                .get("/api/users/23")
                .then().log().all()
                .extract().as(Users.class);
    }

    @Test
    public void createUserAndCheckDataCreate() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseExpected(201));
        UsersCreate user = new UsersCreate("morpheus","leader");
        UsersCreate createUser= given()
                .when()
                .body(user)
                .post("/api/users")
                .then().log().all()
                .extract().as(UsersCreate.class);
        String regex = "(.{5})$";
        String currentTime= Clock.systemUTC().instant().toString().replaceAll(regex,"");
        Assert.assertEquals(currentTime, createUser.getCreatedAt().replaceAll(regex,""));
        System.out.println(currentTime);
        System.out.println(createUser.getCreatedAt().replaceAll(regex,""));
    }

    @Test
    public void updateUser() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseExpected(200));
        UsersCreate userUpdate = new UsersCreate("morpheus", "zion resident");
        UsersCreate userUpdated = given()
                .when()
                .body(userUpdate)
                .put("api/users/2")
                .then().log().all()
                .extract().as(UsersCreate.class);
        Assert.assertEquals(userUpdate.getJob(),userUpdated.getJob());


    }
    @Test
    public void checkListResource() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<ListResource> resources = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ListResource.class);
        List<Integer> years =resources.stream().map(ListResource::getYear).collect(Collectors.toList());
        List<Integer> sortedYears=years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(years,sortedYears);
    }
}
