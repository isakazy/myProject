package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.CashwiseAuthorization;
import utilities.Config;

public class category {
    @Test
    public void createCategory() throws JsonProcessingException {
        RequestBody requestBody = new RequestBody();
        requestBody.setCategory_title("trip to vegas ");
        requestBody.setCategory_description("wedding");
        requestBody.setFlag(true);

        String token = CashwiseAuthorization.getToken();
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/categories");
        System.out.println(response.statusCode());
        response.prettyPrint();

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(customResponse.getCategory_id());
        System.out.println(customResponse.getCreated());

    }

    @Test
    public void getAllCategories() throws JsonProcessingException {
        String token = CashwiseAuthorization.getToken();
        Response response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") + "/api/myaccount/categories/income") ;
        response.statusCode();
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        int size = response.jsonPath().getList("JSON").size();
        for(int i = 0; i < size; i ++ ){

          int id =  customResponse.getCategory_id();
            System.out.println(id);
        }

    }
}
