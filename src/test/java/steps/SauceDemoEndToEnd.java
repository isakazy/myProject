package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import pages.SauceDemo;
import utilities.Config;
import utilities.Driver;

public class SauceDemoEndToEnd {
    SauceDemo sauceDemo = new SauceDemo();

    @Given("user is on the login page of sauceDemo")
    public void user_is_on_the_login_page_of_sauce_demo() {
        Driver.getDriver().get(Config.getValue("sauceDemo"));
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), Config.getValue("sauceDemo"));
    }
    @When("user provides a valid userName")
    public void user_provides_a_valid_user_name() {
      sauceDemo.emailInput.sendKeys(Config.getValue("sauceUser"));
    }
    @When("user provides a valid password")
    public void user_provides_a_valid_password() {
        sauceDemo.passwordInput.sendKeys(Config.getValue("saucePassword"));
    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        sauceDemo.logInButton.click();
    }
    @Then("verify the user was logged in to sauceDemo")
    public void verify_the_user_was_logged_in_to_sauce_demo() {

       Assert.assertEquals(Driver.getDriver().getCurrentUrl(), Config.getValue("sauceDemoMain"));
    }
    @When("user navigates to T-shirt")
    public void user_navigates_to_t_shirt() {
        sauceDemo.tShirt.click();
    }
    @Then("verify the user was redirected to T-shirt page")
    public void verify_the_user_was_redirected_to_t_shirt_page() {

      Assert.assertEquals(Driver.getDriver().getCurrentUrl(),Config.getValue("sauceDemoTshirtPage"));
    }
    @Then("user clicks on the add to card button")
    public void user_clicks_on_the_add_to_card_button() {
       sauceDemo.addToCardButton.click();
    }
    @Then("verify the item was added to card")
    public void verify_the_item_was_added_to_card() {
       Assert.assertTrue(sauceDemo.removeButton.isDisplayed());
       Assert.assertTrue(sauceDemo.cardItem.isDisplayed());
    }
    @When("user navigates to card")
    public void user_navigates_to_card() {
      sauceDemo.cardItem.click();
    }
    @Then("verify the user was redirected to the card")
    public void verify_the_user_was_redirected_to_the_card() {
       Assert.assertEquals(Driver.getDriver().getCurrentUrl(), Config.getValue("sauceDemoCartPage"));
    }
    @Then("verify the item is in the cart")
    public void verify_the_item_is_in_the_cart() {
       Assert.assertTrue(sauceDemo.itemLabelOnCard.isDisplayed());
    }
    @When("user clicks on the check out button")
    public void user_clicks_on_the_check_out_button() {
       sauceDemo.checkout.click();
    }
    @Then("verify the user was redirected to check our info page")
    public void verify_the_user_was_redirected_to_check_our_info_page() {

       Assert.assertEquals(Driver.getDriver().getCurrentUrl(), Config.getValue("sauceDemoCheckOutPage"));
    }
    @Then("user provides his valid first name")
    public void user_provides_his_valid_first_name() {
        sauceDemo.firstNameInput.sendKeys(Config.getValue("sauceDemoFirstName"));
    }
    @Then("user provides his valid last name")
    public void user_provides_his_valid_last_name() {
       sauceDemo.lastNameInput.sendKeys(Config.getValue("sauceDemoLastName"));
    }
    @Then("user provide his valid zip code")
    public void user_provide_his_valid_zip_code() {
        sauceDemo.inputZipCode.sendKeys(Config.getValue("sauceDemoZip"));
    }
    @When("user clicks on the continue button")
    public void user_clicks_on_the_continue_button() {
       sauceDemo.continueButton.click();
    }
    @Then("verify the user was redirected to checkout overview page")
    public void verify_the_user_was_redirected_to_checkout_overview_page() {

       Assert.assertEquals(Driver.getDriver().getCurrentUrl(), Config.getValue("sauceDemoOverviewPage"));
    }
    @Then("verify the item is displayed")
    public void verify_the_item_is_displayed() {
        Assert.assertTrue(sauceDemo.overViewItem.isDisplayed());
    }
    @Then("verify the payment info is displayed")
    public void verify_the_payment_info_is_displayed() {
       Assert.assertTrue(sauceDemo.paymentInfo.isDisplayed());
    }
    @Then("verify hte shipping info is displayed")
    public void verify_hte_shipping_info_is_displayed() {
       Assert.assertTrue(sauceDemo.shippingInfo.isDisplayed());
    }
    @Then("verify the  prise is displayed")
    public void verify_the_prise_is_displayed() {
        Assert.assertTrue(sauceDemo.price.isDisplayed());
    }
    @Then("verify the total price is displayed")
    public void verify_the_total_price_is_displayed() {
       Assert.assertTrue(sauceDemo.totalPrise.isDisplayed());
    }
    @When("user click on finish button")
    public void user_click_on_finish_button() {
       sauceDemo.finishButton.click();
    }
    @Then("verify the user was redirected to the login page")
    public void verify_the_user_was_redirected_to_the_login_page() {
       Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
    }
    @Then("verify the checkout was complete")
    public void verify_the_checkout_was_complete() {
       String word = "Thank you for your order!";
       Assert.assertEquals(sauceDemo.cheOutCompleteText.getText(), word);
    }
}
