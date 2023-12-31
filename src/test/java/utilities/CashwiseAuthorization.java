package utilities;

import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CashwiseAuthorization {

    public static String getToken() {
        String url = "https://backend.cashwise.us/api/myaccount/auth/login";
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail(Config.getValue("username"));
        requestBody.setPassword(Config.getValue("password"));
        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(url);
        String token = response.jsonPath().getString("jwt_token");
        return token;
    }
}

    /*

     */

    /*
      RequestBody requestBody = new RequestBody();
        requestBody.setEmail(Config.getValue("username"));
        requestBody.setPassword(Config.getValue("password"));
        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(requestBody).post(Config.getValue("cashwiseApiUrl") + "/api/myaccount/auth/login");
        return response.jsonPath().getString("jwt_token");


     */


