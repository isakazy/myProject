package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    private static String browserType=Config.getValue("browser");
    public static WebDriver getDriver() {
        if (driver == null) {
            if (browserType.equals("chrome")) {
             //   ChromeOptions options = new ChromeOptions();
              //  options.addArguments("--headless");
                driver = new ChromeDriver(/*options*/);
            } else if (browserType.equals("firefox")) {
              //  FirefoxOptions options = new FirefoxOptions();
             //   options.setHeadless(true);
                driver = new FirefoxDriver(/*options*/);
            } else if (browserType.equals("edge")) {
              //  EdgeOptions options = new EdgeOptions();
               // options.addArguments("--headless");
                driver = new EdgeDriver(/*options*/);
            } else {
                driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            return driver;
        }
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
            driver= null;
        }
    }



}
