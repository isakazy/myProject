package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StudymateAnnouncementPage {

    public StudymateAnnouncementPage() {
        PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(xpath = "(//a)[5]")
        public WebElement announcementPage;

       @FindBy(id = "mui-component-select-groupId")
       public WebElement announcementSearchDropD;

       @FindBy(xpath = "//body/div[5]/div[3]/ul/li")
       public WebElement announcementGroupMenu;

       @FindBy(xpath = "//div/button")
       public WebElement fromCalendaryBtn;

      @FindBy(xpath = "(//button[@type='button'])[3]")
       public WebElement tillCalendaryBtn;

       @FindBy(xpath = "(//button[.='1'])[2]")
       public WebElement firstDayInCalendary;

       @FindBy(xpath = "(//button[.='30'])")
       public WebElement lastDayInCalendary;


       @FindBy(xpath = "//div[@class='css-q8s1he']/div[3]/p")
       public WebElement announcementByDate;

       @FindBy(xpath = "//div/ul/li[.='studymateTest']")
       public WebElement studymateTest;

       @FindBy(xpath = "//div/p[.='study']")
       public WebElement expectedAnnouncement;


     //  @FindBy(className = "sc-jIILKHfcfmEs")
      // public WebElement announcementTest;

    ////div/button[.='1']

















}
