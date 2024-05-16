package api.tests;

import api.pojo.register.rq.RegisterPojoRq;
import api.pojo.register.rs.RegisterPojoRs;
import api.pojo.user.rs.UserPojoRs;
import api.request.ApiRequests;
import api.specs.Specifications;
import com.codeborne.selenide.As;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class RegresTest {

    private static final String URL = "https://reqres.in/";
    private ApiRequests apiRequests;

    /**
     * 1.Get user list.
     * Expected result:
     * 1. Avatar contains id.
     * 2. Email ends with "@reqres.in
     * 3.
     */
    @Test
    public void getListUsersTest() {
        apiRequests = new ApiRequests();

        apiRequests
                .sendGetRequest(URL, 200, "api/users?page=2");

        UserPojoRs userPojoRs = apiRequests.response.getBody().as(UserPojoRs.class);

        userPojoRs.data
                .forEach(x -> Assert.assertTrue(x.avatar.contains(String.valueOf(x.getId()))));

        Assert.assertTrue(userPojoRs.data
                .stream()
                .allMatch(x -> x.getEmail().endsWith("@reqres.in")));

        ArrayList<String> avatars = userPojoRs.data
                .stream()
                .map(UserPojoRs.Datum::getAvatar).collect(Collectors.toCollection(ArrayList::new));
        for (int j = 0; j < avatars.size(); j++) {
            Assert.assertTrue(avatars.get(j).contains(String.valueOf(userPojoRs.data.get(j).id)));
        }
        System.out.println();
    }

    /**
     * Successfully register new user test
     * Steps:
     * 1. Register new user email "eve.holt@reqres.in" password "pistol"
     * Expected result:
     * User successfully registered
     * id = 4
     * token = "QpwL5tke4Pnpja7X4"
     */
    @Test
    public void registerUserTest() {
        apiRequests = new ApiRequests();

        RegisterPojoRq registerPojoRq = RegisterPojoRq
                .builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

        apiRequests
                .sendPostRequest(URL, 200, registerPojoRq, "api/register");

        RegisterPojoRs registerPojoRs = apiRequests.response.getBody().as(RegisterPojoRs.class);

        Assert.assertEquals("Invalid token", "QpwL5tke4Pnpja7X4", registerPojoRs.token);

        Assert.assertEquals("Invalid id", 4, registerPojoRs.id);
        System.out.println();
    }

    /**
     * Unsuccessfully register new user test
     * Steps:
     * 1. Register new user email "sydney@fife"
     * Expected result:
     * Status code = 400
     * Error = "Missing password"
     */
    @Test
    public void registerUserUnsuccessfullyTest() {
        apiRequests = new ApiRequests();

        RegisterPojoRq registerPojoRq = RegisterPojoRq
                .builder()
                .email("sydney@fife")
                .build();

        apiRequests
                .sendPostRequest(URL, 400, registerPojoRq, "api/register");

        RegisterPojoRs registerPojoRs = apiRequests.response.getBody().as(RegisterPojoRs.class);

        Assert.assertEquals("Invalid error","Missing password",registerPojoRs.error);
    }
}
