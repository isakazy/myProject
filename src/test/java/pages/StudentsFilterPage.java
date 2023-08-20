package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudentsFilterPage {
    WebDriver driver;

    public StudentsFilterPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[.='Add student']")
    public WebElement addStudentButton;

    @FindBy(name = "name")
    public WebElement firstNameInput;

    @FindBy(name = "name")
    public WebElement lastNameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberInput;

    @FindBy(id = "mui-component-select-groupId")
    public WebElement groupDropDown;

    @FindBy(id = "mui-component-select-studyFormat")
    public WebElement studyFormatDropDown;

    @FindBy(xpath = "(//div/button)[1]")
    public WebElement studentFilterBtn;

    @FindBy(xpath = "(//div/button)[13]")
    public WebElement resetFilterBtn;

    @FindBy(xpath = "(//div/button)[14]")
    public WebElement applyBtn;

    @FindBy(xpath = "(//div/button)[2]")
    public WebElement filterBtn;

    @FindBy(xpath = "//li[.='ONLINE']")
    public WebElement optionOnline;

    @FindBy(xpath = "//*[@id=\"menu-groupId\"]/div[3]/ul/li[3]")
    public WebElement secondOption;







}
