package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import utilities.CashwiseAuthorization;

public class getSellersTest {

    Response response;

    @Given("the API endpoint is {string}")
    public void the_api_endpoint_is(String getEndPoint) {
        RestAssured.baseURI = getEndPoint;
    }

    @When("a GET request is sent")
    public void a_get_request_is_sent() {
        response = RestAssured.given().auth().oauth2(CashwiseAuthorization.getToken()).get();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals((int) statusCode, 200);
    }

    @Then("the response body should contain {string}")
    public void the_response_body_should_contain(String companyName) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        Assert.assertEquals(companyName, customResponse.getCompany_name());
    }
    @Then("verify the sellerName is not null")
    public void verify_the_seller_name_is_not_null() throws JsonProcessingException {
        int size = response.jsonPath().getList("JSON").size();
        System.out.println(response.statusCode());
        for (int i = 0; i < size; i++) {
            String name = response.jsonPath().getString("[" + i + "].seller_name");
            Assert.assertNotNull(name);
        }
    }

    @Then("verify the sellerID is not null")
    public void verify_the_seller_id_is_not_null() {
        int size = response.jsonPath().getList("JSON").size();
        System.out.println(response.statusCode());
        for (int i = 0; i < size; i++) {
            String id = String.valueOf(Integer.parseInt(response.jsonPath().getString("[" + i + "].seller_id")));
            Assert.assertNotNull(id);
        }
    }

    @When("a POST request is sent")
    public void a_post_request_is_sent() {
        RequestBody body = new RequestBody();
        body.setCompany_name("englishClasses");
        body.setSeller_name("Elnura Alinova");
        body.setEmail("elnura@gmail.com");
        body.setPhone_number("00000000000");
        body.setAddress("NY Ocean Pacific");
        response = RestAssured.given().auth().oauth2(CashwiseAuthorization.getToken()).contentType(ContentType.JSON)
                .body(body).post();
    }
    @Then("response status code must be {int}")
    public void response_status_code_must_be(Integer statusCode) {
        Assert.assertEquals(201, (int) statusCode);
    }



    @Then("verify seller name {string} is in the list")
    public void verify_seller_name_is_in_the_list(String name ) {
        int size = response.jsonPath().getList("JSON").size();
        boolean isFound = false;
        for(int i = 0; i < size; i ++ ){
            String myName = response.jsonPath().getString("["+ i +"].seller_name");
            if(myName.equals(name)){
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound);

    }



    // THE TEST IF FAILING BECAUSE THERE ARE SELLERS WITH NULL EMAIL
    @Then("verify sellers email end with {string}")
    public void verify_sellers_email_end_with(String dotCom) {
        int size = response.jsonPath().getList("JSON").size();
        boolean endWith = false;
        for(int i = 0; i < size; i ++ ){
            String end = response.jsonPath().getString("["+ i +"].email");
            if(end != null && end.length() >= 3 ){
                String com =  end.substring(end.length() - 3);
                if(com.equals(dotCom)){
                    endWith = true;
                    break;
            }

            }
        }
        Assert.assertTrue(endWith);
    }






}














