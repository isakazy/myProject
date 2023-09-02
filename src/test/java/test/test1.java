package test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.bouncycastle.crypto.agreement.jpake.JPAKEUtil;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.cashWise;
import utilities.*;

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

     String url = "https://cashwise.us/dashboard";
     ApplicationFlow.pause(1000);
     Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());


 }


 @Test
    public void API(){
        CustomResponse customResponse = new CustomResponse();
     String endPoint = "https://reqres.in/api/users?page=2";
     Response response = RestAssured.get(endPoint);
     response.prettyPrint();
     System.out.println(customResponse.getLast_name());
 }
}


