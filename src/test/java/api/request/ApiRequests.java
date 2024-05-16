package api.request;

import api.pojo.base.rq.BasePojoRq;
import api.specs.Specifications;
import io.restassured.response.Response;

import java.net.URI;

import static io.restassured.RestAssured.given;

/**
 * Class for sending ap requests.
 */
public class ApiRequests {

    public Response response = null;

    /**
     * Send get request.
     * @param url - URL.
     * @param statusCode - ожидаемый статус код.
     * @param endpoint - эндпоинт.
     */
    public ApiRequests sendGetRequest(String url, int statusCode, String endpoint) {
        Specifications.installSpecification(Specifications.requestSpec(url),Specifications.responseSpec(statusCode));
        response = given()
                .when()
                .get(endpoint);
        return this;
    }

    /**
     * Send post request.
     * @param url - URL.
     * @param statusCode - expected status code.
     * @param body - request body.
     * @param endpoint - request endpoint.
     */
    public ApiRequests sendPostRequest(String url, int statusCode, BasePojoRq body, String endpoint) {
        Specifications.installSpecification(Specifications.requestSpec(url),Specifications.responseSpec(statusCode));
        response = given()
                .when()
                .body(body)
                .post(endpoint);
        return this;
    }

}
