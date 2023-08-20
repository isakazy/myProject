package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrashPage {
    public TrashPage(){
        PageFactory.initElements(Driver.getDriver(), this );
    }
    @FindBy(xpath = "//nav/a[2]")
    public WebElement groupsPageLink;
    @FindBy(xpath = "//nav/a[3]")
    public WebElement coursesPageLink;
    @FindBy(xpath = "//nav/a[4]")
    public WebElement teachersPageLink;
    @FindBy(xpath = "//nav/a[5]")
    public WebElement  studentsPageLink;
    @FindBy(xpath = "//nav/a[6]")
    public WebElement announcementsPageLink;
    @FindBy(xpath = "//nav/a[7]")
    public WebElement trashPageLink;
    @FindBy(xpath = "(//li/button)[last()-1]")
    public  WebElement lastPagebutton;
    @FindBy(xpath = "(//tbody/tr)[last()]/td[3]/div/*[1]")
    public WebElement lastItemsRecoveryButton;
    @FindBy(xpath = "(//p[contains(text(),'from')])[last()]")
    public WebElement textOfItems;

    @FindBy(xpath = "//nav/a")
    public List<WebElement> navBarItems;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> listOfTrash;

    @FindBy(xpath = "//li[.='Trash']")
    public WebElement trashLink;

    @FindBy(xpath = "(//p)[13]")
    public WebElement numberOfTrash;

    @FindBy(xpath = "(//input)[2]")
    public WebElement
            trashNumberInput;
    @FindBy(xpath = "//p[.='Items in the cart are automatically deleted after 7 days from the date of adding!']")
    public WebElement itemsWillBeDeletedText;}
