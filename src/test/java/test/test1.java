package test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.java.hu.Ha;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.bouncycastle.crypto.agreement.jpake.JPAKEUtil;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.cashWise;
import utilities.*;

import java.security.Key;
import java.util.HashMap;
import java.util.List;


public class test1 {
    @Test
    public void test1() {
        Driver.getDriver().get(Config.getValue("testLink"));
        Driver.getDriver().switchTo().frame("attentive_creative");
        Driver.getDriver().findElement(By.xpath("//div[@id='page1']/button")).click();
        Driver.getDriver().switchTo().defaultContent();


    }

    @Test
    public void Test2(){
        Driver.getDriver().get(Config.getValue("testLink"));
        Driver.getDriver().switchTo().frame("attentive_creative");
        Driver.getDriver().findElement(By.xpath("//div[@id='page1']/button")).click();
        Driver.getDriver().switchTo().defaultContent();

        List<WebElement> list =  Driver.getDriver().findElements(By.xpath("//nav[@id='primaryNavigation']/ul/li/a[@class='heading']"));
        Actions actions = new Actions(Driver.getDriver());
        for(int i = 0; i < list.size(); i ++ ){
            actions.moveToElement(list.get(i)).perform();
            ApplicationFlow.pause(2000);


        }



    }
 @Test
    public void test(){
        Driver.getDriver().get("https://www.gerbergear.com/en-us/product-customization-page?productId=30-001417");
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='attentive_creative']")));
        Driver.getDriver().findElement(By.xpath("//button[@id='closeIconContainer']")).click();
        Driver.getDriver().switchTo().defaultContent();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver()
        .findElement(By.xpath("//button[.='Close Knife']"))).perform();
        ApplicationFlow.pause(1000);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//div[.='Custom Multi-tool + Sheath + Bit Set']"))).perform();
        ApplicationFlow.pause(1000);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//div[.='Reset']"))).perform();
        ApplicationFlow.pause(1000);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//span[.=' Free ground shipping on orders over $50.']"))).release().perform();
        ApplicationFlow.pause(1000);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//a/span[@class='icon icon-profile']"))).release().perform();
        ApplicationFlow.pause(1000);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//div[.='Share & Save']"))).release().perform();
        ApplicationFlow.pause(1000);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas"))).click().clickAndHold().moveToElement(Driver.getDriver().findElement(By.xpath("//div[.='Sheath']"))).release().perform();

 }

 @Test
    public void test2(){
     Driver.getDriver().get("https://www.gerbergear.com/en-us/product-customization-page?productId=30-001417");
     Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@id='attentive_creative']")));
     Driver.getDriver().findElement(By.xpath("//button[@id='closeIconContainer']")).click();
     Driver.getDriver().switchTo().defaultContent();
     Actions actions = new Actions(Driver.getDriver());

     int centerX = 100;
     int centerY = 100;
     int radius = 50;

     actions.moveToElement(Driver.getDriver().findElement(By.xpath("//canvas")), centerX, centerY).clickAndHold().perform();

     int numSteps = 360;  // Number of steps for a full circle
     double angleIncrement = 360.0 / numSteps;
     for (int i = 0; i < numSteps; i++) {
         double angle = Math.toRadians(angleIncrement * i);
         int xOffset = (int) (radius * Math.cos(angle));
         int yOffset = (int) (radius * Math.sin(angle));
         actions.moveToElement( Driver.getDriver().findElement(By.xpath("//canvas")), centerX + xOffset, centerY + yOffset).perform();
     }
     actions.release().perform();

 }

 @Test
    public void test3(){
     cashWise cashWise = new cashWise();
     Faker faker = new Faker();
     Driver.getDriver().get(Config.getValue("cashWise"));
     cashWise.language.click();
     cashWise.english.click();
     ApplicationFlow.pause(500);
     cashWise.singUP.click();
     Assert.assertTrue(cashWise.singUpPopUp.isDisplayed());

     cashWise.emailInput.sendKeys(faker.internet().emailAddress());
     cashWise.passwordInput.sendKeys(Config.getValue("cashWisePassword"));
     cashWise.confPass.sendKeys(Config.getValue("cashWisePassword"));
     cashWise.continueButton.click();


     cashWise.firstName.sendKeys(faker.name().firstName());
     cashWise.lastName.sendKeys(faker.name().lastName());
     cashWise.companyName.sendKeys(faker.company().name());
     cashWise.dropDown.click();
     cashWise.IT.click();
     cashWise.address.sendKeys(faker.address().fullAddress());
     cashWise.currancyDrop.click();
     cashWise.USD.click();
     cashWise.singUpLast.click();

     String url = "https://cashwise.us/dashboard/infographics";
     ApplicationFlow.pause(1000);
     Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());


 }
 @Test
 public void listOfSellers(){
        String token = CashwiseAuthorization.getToken();
        String url = "https://backend.cashwise.us/api/myaccount/sellers/all";
        Response response = RestAssured.given().auth().oauth2(token).get(url);
        System.out.println(response.statusCode());

        int size = response.jsonPath().getList("JSON").size();

        for (int i = 0; i < size; i++) {
            String name = response.jsonPath().getString("[" + i + "].seller_name");
            Assert.assertFalse(name.isEmpty());

        }


 }

 @Test
    public void generateToken(){
        String url = "https://backend.cashwise.us/api/myaccount/auth/login";
     RequestBody requestBody = new RequestBody();
     requestBody.setEmail("isakazy@gmail.com");
     requestBody.setPassword("isakazyamanbaev");
     Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post(url);
     System.out.println(response.statusCode());
     String token = response.jsonPath().getString("jwt_token");
     System.out.println(token);

 }





 @Test
    public void API(){
     String endPoint = Config.getValue("cashWiseApi") + "/api/myaccount/sellers/all";
     String token = CashwiseAuthorization.getToken();
     Response response = RestAssured.given().auth().oauth2(token).get(endPoint);
     System.out.println(response.statusCode());
   //  response.prettyPrint();
     int size = response.jsonPath().getList("JSON").size();

     for(int i= 0; i < size;  i ++ ){
         String email = response.jsonPath().getString("[" + i + "].seller_name");
            System.out.println(email);
        }

     Assert.assertEquals(response.statusCode(), 200 );
 }

 @Test
    public void APiDelete(){
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("cashWiseApi") + "us/api/myaccount/sellers/88";
        Response response = RestAssured.given().auth().oauth2(token).delete(url);
        System.out.println(response.statusCode());
        String email = response.jsonPath().getString("email");
        String date = response.jsonPath().getString("created");
        Assert.assertFalse(email.endsWith("reqres.com"));
       String  day = date.substring(8);
       int number = Integer.parseInt(day);
       Assert.assertTrue(number >= 22 );


        response.prettyPrint();

 }
 @Test
    public void getSeller(){
     String token = CashwiseAuthorization.getToken();
     String url = Config.getValue("cashWiseApi") + "/api/myaccount/sellers/88";
     Response response = RestAssured.given().auth().oauth2(token).get(url);
     System.out.println(response.statusCode());
     response.prettyPrint();
   //  response.jsonPath().getString("email");
 }

 @Test
    public void getAllSellers(){
       String token = CashwiseAuthorization.getToken();
       String url = Config.getValue("cashWiseApi")+ "/api/myaccount/sellers/all";
       Response response = RestAssured.given().auth().oauth2(token).get(url);
     System.out.println(response.statusCode());
     response.prettyPrint();

 }

 @Test
    public void updateSeller(){
        RequestBody requestBody = new RequestBody();
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("cashWiseApi")+ "/api/myaccount/sellers/94";
        requestBody.setCompany_name("AZAT");
        requestBody.setSeller_name("Ubaidylbek");
        requestBody.setEmail("ubaidylbek@gamil.com");
        requestBody.setPhone_number("702 94 49 24");
        requestBody.setAddress("frunze 269");
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).put(url);
       // System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200);

        try{
            response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") + "/api/myaccount/sellers/94" );
            String companyName = response.jsonPath().getString("company_name");
            Assert.assertEquals(companyName, "AZAT");
        }
        catch (Exception e){
            System.out.println(response.statusCode());
        }
        finally {
            response.prettyPrint();
        }

 }

 @Test
    public void PostSeller(){
        Faker faker = new Faker();
        String url = Config.getValue("cashWiseApi") + "/api/myaccount/sellers";
        String token = CashwiseAuthorization.getToken();
        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name(faker.company().name());
        requestBody.setSeller_name(faker.name().firstName());
        requestBody.setEmail(faker.internet().emailAddress());
        requestBody.setPhone_number(faker.phoneNumber().phoneNumber());
        requestBody.setAddress(faker.address().fullAddress());

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post(url);
     Assert.assertEquals(200, response.statusCode());

     try{
         response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") + "/api/myaccount/sellers/all" );
         int size = response.jsonPath().getList("JSON").size();
         boolean companyFound = false;

       for(int i = 0; i < size; i ++ ) {
          String companyName = response.jsonPath().getString("[" + i + "].company_name" );
          if("doorDash".equals(companyName)){
              companyFound = true;
          }
       }
       Assert.assertTrue(companyFound);

     }
     catch (Exception e){
         response.statusCode();
     }
 }


 @Test
    public void postSellerTwo(){
        String url = Config.getValue("cashWiseApi") + "/api/myaccount/sellers";
        String token = CashwiseAuthorization.getToken();

        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name("samsung");
        requestBody.setSeller_name("du ho choi");
        requestBody.setEmail("samdfdasdassfa@gmail.com");
        requestBody.setPhone_number("312231241241");
        requestBody.setAddress("korea ");

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(requestBody).post(url);
     Assert.assertEquals(response.statusCode(), 200);

        try{
            response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") +"/api/myaccount/sellers/all");
            int size = response.jsonPath().getList("JSON").size();
            boolean companyFound = false;
            for(int i = 0; i < size; i ++ ){
                String company = response.jsonPath().getString("["+ i + "].company_name");
                if(company.equals("samsung")){
                    companyFound = true;
                }
            }
            Assert.assertTrue(companyFound);
        }
        catch (Exception e ){
            response.statusCode();
        }
        finally {
            response.prettyPrint();
        }


 }

 @Test
    public void getListOfBankAccounts(){
        String url = Config.getValue("cashWiseApi")+ "/api/myaccount/bankaccount";
        String token = CashwiseAuthorization.getToken();
        Response response = RestAssured.given().auth().oauth2(token).get(url);
     System.out.println(response.statusCode());
     response.prettyPrint();

 }

 @Test
    public void PostProduct(){
        String url = Config.getValue("cashWiseApi")+ "/api/myaccount/products";
        String token = CashwiseAuthorization.getToken();

       HashMap <String, Object> params = new HashMap<>();
       params.put("page", 1 );
       params.put("size", 20);

       Response response =  RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).params(params).get(url);
     System.out.println(response.statusCode());
     response.prettyPrint();
 }


 @Test
    public void GetAllSellers(){
     String url = Config.getValue("cashWiseApi")+ "/api/myaccount/sellers";
     String token = CashwiseAuthorization.getToken();
     HashMap<String, Object> params = new HashMap<>();
     params.put("isArchived", false);
     params.put("page", 1);
     params.put("size", 40);
     Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).params(params).get(url);
     System.out.println(response.statusCode());
     response.prettyPrint();
     Assert.assertEquals(200, response.statusCode());
 }


 @Test
    public void GetSingleSeller(){
     String url = Config.getValue("cashWiseApi")+ "/api/myaccount/sellers/1604";
     String token = CashwiseAuthorization.getToken();
     Response response = RestAssured.given().auth().oauth2(token).get(url);
     Assert.assertEquals(response.statusCode(), 200 );
     response.prettyPrint();
 }

 @Test
    public void JSONPath(){
     String token = CashwiseAuthorization.getToken();
     Response response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") + "/api/myaccount/categories/income") ;
     response.statusCode();
     response.jsonPath().getList("JSON[0].SELLER_ID");

 }

 @Test
    public void seleniumNavigateTest() throws InterruptedException {

        Driver.getDriver().get(Config.getValue("guru99"));
        Driver.getDriver().navigate().to("https://demo.guru99.com/test/guru99home/");

        Driver.getDriver().navigate().back();
 }

    @Test
    public void allSellersJson(){
        String token = CashwiseAuthorization.getToken();
        String url = "https://backend.cashwise.us/api/myaccount/sellers/all";
        Response response = RestAssured.given().auth().oauth2(token).get(url);
        int size = response.jsonPath().getList("JSON").size();
        System.out.println(response.statusCode());
        for(int i = 0; i < size; i ++){
          String name =   response.jsonPath().getString("[" + i + "].seller_name");
            System.out.println(name);
            }
        }

        @Test
    public void PostSeller2(){
        // the code is not finished. finish the code
            RequestBody body = new RequestBody();
            body.setCompany_name("waterfall ");
            body.setSeller_name("kukushka");
            body.setEmail("kuhka@gmail.com");
            body.setPhone_number("00000000001");
            body.setAddress("howlwo");
        String token = CashwiseAuthorization.getToken();
        String endPoint = Config.getValue("cashWiseApi") + "/api/myaccount/sellers";
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(body).post(endPoint);
            Assert.assertEquals(200, response.statusCode());

            System.out.println(response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") + "/api/myaccount/sellers/all"));
            System.out.println(response.statusCode());
            response.prettyPrint();

        }

        @Test
        public void ConfirmName() throws JsonProcessingException {
            String token = CashwiseAuthorization.getToken();
            Response  response = RestAssured.given().auth().oauth2(token).get(Config.getValue("cashWiseApi") + "/api/myaccount/sellers/all");

            int size = response.jsonPath().getList("JSON").size();
            boolean isFound = false;
            for(int i = 0; i < size; i ++ ){
          String name = response.jsonPath().getString("["+ i +"].seller_name");
          if(name.equals("Elnura Alinova")){
              isFound = true;
              break;
          }
            }
            Assert.assertTrue(isFound);





        }



    @Test
    public void Test() throws JsonProcessingException {
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("cashWiseApi") + "/api/myaccount/sellers";
        HashMap<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 30);
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).params(params).get(url);
        System.out.println(response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        boolean isPresent = false;
        for (CustomResponse sellerId : customResponse.getResponses()) {
            if (sellerId.getSeller_id() == 88) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
    }


    @Test
    public void sellerName() throws JsonProcessingException {
        String token = CashwiseAuthorization.getToken();
        String url = Config.getValue("cashWiseApi") + "/api/myaccount/sellers";

        HashMap<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 30);
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).params(params).get(url);
        System.out.println(response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        boolean isPresent = false;
        for (CustomResponse names : customResponse.getResponses()) {

            if (names.getSeller_name().equals("Anara")) {
                isPresent = true;
                break;
            }
        }
        Assert.assertTrue(isPresent);
    }


}



