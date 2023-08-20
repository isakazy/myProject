package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AnnouncementAllaPage {

    public  AnnouncementAllaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Add an announcement']")
    public WebElement btnAddAnnouncement;

    @FindBy(name = "text")
    public  WebElement textInput;

    @FindBy(id = "mui-component-select-groups")
    public  WebElement chooseGroup;

    @FindBy(xpath = "(//div/ul/li)[13]")
    public WebElement firstOptionInDropdown;

    @FindBy(xpath = "//button[.='Add']")
    public  WebElement addBtn;
}
