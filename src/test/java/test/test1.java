package test;

import com.github.javafaker.App;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import java.util.concurrent.TimeUnit;



public class test1 {
    @Test
    public void test1() {
        Driver.getDriver().get(Config.getValue("testLink"));
        WebElement canvas = Driver.getDriver().findElement(By.xpath("//canvas"));

        ApplicationFlow.pause(4000);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(canvas, 640, 140).click().clickAndHold().moveByOffset(1280, 140).release().perform();

    }

}

