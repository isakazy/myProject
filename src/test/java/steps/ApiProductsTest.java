package steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiProductsTest {
    Response response;
    @Given("the api endpoint is {string}")
    public void the_api_endpoint_is(String EndPoint) {
        RestAssured.baseURI = EndPoint;

    }

}
