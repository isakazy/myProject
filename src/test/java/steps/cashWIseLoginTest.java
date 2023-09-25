package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.runtime.Runtime;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.cashWise;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

import javax.management.DescriptorRead;
import java.time.Duration;

public class cashWIseLoginTest {
    cashWise cash = new cashWise();

    @Given("user is on the log in page")
    public void user_is_on_the_log_in_page() {
        Driver.getDriver().get(Config.getValue("cashWise"));
    }
    @When("user clicks on the sing in button")
    public void user_clicks_on_the_sing_in_button() {
      cash.singIn.click();
    }
    @Then("the sing in pop up must be displayed")
    public void the_sing_in_pop_up_must_be_displayed() {
        Assert.assertTrue(cash.singUpPopUp.isDisplayed());
    }
    @When("when user inputs a valid username {string}")
    public void when_user_inputs_a_valid_username(String username) {
        cash.emailInput.sendKeys(username);

    }
    @When("user inputs a valid password {string}")
    public void user_inputs_a_valid_password(String password) {
      cash.passwordInput.sendKeys(password);
    }
    @When("user clicks on the singTWo in button")
    public void user_clicks_on_the_sing_t_wo_in_button_in_button() {
       cash.singInTwo.click();
    }

    @Then("user must be logged in")
    public void user_must_be_logged_in() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='smokewise']")));
      Assert.assertTrue(element.isDisplayed());
    }
    @When("when user inputs an invalid username {string}")
    public void when_user_inputs_an_invalid_username(String wrongEmail) {
        cash.emailInput.sendKeys(wrongEmail);
    }
    @When("user inputs a invalid password {string}")
    public void user_inputs_a_invalid_password(String wrongPassword) {
        cash.passwordInput.sendKeys(wrongPassword);
    }
    @Then("wrong email or password text must be displayed")
    public void wrong_email_or_password_text_must_be_displayed() {
       Assert.assertTrue(cash.pleaseEnterCorrectUsernameText.isDisplayed());
      // Assert.assertTrue(cash.wrongPassOrEmailText.isDisplayed());
    }


    @Given("user in on the dashboard")
    public void user_in_on_the_dashboard() {
        Driver.getDriver().get(Config.getValue("cashWise"));
        cash.singIn.click();
        cash.emailInput.sendKeys("isakazy@gmail.com");
        cash.passwordInput.sendKeys("isakazyamanbaev");
        cash.singInTwo.click();
        ApplicationFlow.pause(4000);

    }
    @Given("user clicks on his name")
    public void user_clicks_on_his_name() {
        cash.logOutDropDown.click();

    }
    @When("user selects log out")
    public void user_selects_log_out() {
        cash.logOutLink.click();


    }
    @Then("log out alert must be displayed")
    public void log_out_alert_must_be_displayed() {
       Assert.assertTrue(cash.logOutAlert.isDisplayed());
    }
    @When("user clicks on log out alert")
    public void user_clicks_on_log_out_alert() {
        cash.logOutButton.click();
    }
    @Then("verify the user was logged out")
    public void verify_the_user_was_logged_out() {
        String mainUrl = "https://cashwise.us/main";
        Assert.assertEquals(mainUrl, Driver.getDriver().getCurrentUrl());
    }


}
