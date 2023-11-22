package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemo {
    public SauceDemo(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
      @FindBy(xpath = "//input[@name ='user-name']")
      public WebElement emailInput;

     @FindBy(xpath = "//input[@name ='password']")
    public WebElement passwordInput;

     @FindBy(xpath = "//input[@id='login-button']")
    public WebElement logInButton;

     @FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']")
    public WebElement tShirt;


     @FindBy(xpath = "//button[.='Add to cart']")
    public WebElement addToCardButton;


     @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

     @FindBy(xpath = "//a/span[.='1']")
    public WebElement cardItem;

     @FindBy(xpath = "//div[@class='cart_item_label']")
    public WebElement itemLabelOnCard;

     @FindBy(xpath = "//button[@id='checkout']")
     public WebElement checkout;

     @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstNameInput;

     @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastNameInput;

     @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement inputZipCode;

     @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

     @FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']")
    public WebElement overViewItem;

     @FindBy(xpath = "//div[.='Payment Information']")
    public WebElement paymentInfo;

     @FindBy(xpath = "//div[.='Shipping Information']")
    public WebElement shippingInfo;

     @FindBy(xpath = "//div[.='Price Total']")
    public WebElement price;

     @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement totalPrise;

     @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishButton;

     @FindBy(xpath = "//h2[.='Thank you for your order!']")
    public WebElement cheOutCompleteText;





}

