package api.tests;

import api.pojo.user.UserPojoRs;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class RegresTest {

    private static final String URL = "https://reqres.in/";

    @Test
    public void getListUsersTest() {
        UserPojoRs userPojoRs = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getObject("", UserPojoRs.class);

        userPojoRs.data
                .forEach(x -> Assert.assertTrue(x.avatar.contains(String.valueOf(x.getId()))));

        Assert.assertTrue(userPojoRs.data
                .stream()
                .allMatch(x -> x.getEmail().endsWith("@regres.in")));

        ArrayList<String> avatars = userPojoRs.data
                .stream()
                .map(UserPojoRs.Datum::getAvatar).collect(Collectors.toCollection(ArrayList::new));
        for (int j = 0; j < avatars.size(); j++) {
            Assert.assertTrue(avatars.get(j).contains(String.valueOf(userPojoRs.data.get(j).id)));
        }
        System.out.println();
    }
}
