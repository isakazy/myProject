package test;

import com.github.javafaker.App;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.DbUtilities;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;



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
    public void tryTest() throws MalformedURLException, SQLException {

    }


}

