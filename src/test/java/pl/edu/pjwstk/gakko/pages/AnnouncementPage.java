package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

public class AnnouncementPage {
    @FindBy(xpath = "//a[@href='/edux/7984/announcements']")
    private WebElement announcementButton;

    @FindBy(css = "button.btn-brand")
    private WebElement addNewAnnouncementButton;

    @FindBy(xpath = "//a[@href='/edux/7984/announcements/upsert']")
    private WebElement announcementOptionButton;

    @FindBy(className = "note-editable")
    private WebElement noteAnnouncementInput;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement savedSuccessfullyMessage;

    @FindBy(css = "div.alert-text")
    public WebElement deletedSuccessfullyMessage;

    @FindBy(css = "div.alert-text")
    public WebElement editedSuccessfullyMessage;

    @FindBy(css = "button.swal2-confirm.swal2-styled")
    private WebElement deleteAgreeButton;

    @FindBy(xpath = "//td[contains(@class, 'kt-datatable__cell--center')]//a[@class='btn btn-sm btn-clean btn-icon btn-icon-md'][1]")
    private WebElement editButton;

    private WebDriver driver;

    public AnnouncementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final Logger logger = LogManager.getLogger();

    public void enterAnnouncementModule() {
        logger.info("Entering announcement module");
        announcementButton.click();
        logger.info("Entering announcement module done");
    }

    public void createNewAnnouncement(String note) {
        logger.info("Creating new announcement");
        logger.info("Click the add new announcement button");
        addNewAnnouncementButton.click();
        logger.info("Click the add new announcement button done");
        announcementOptionButton.click();
        logger.info("Entering note to new announcement");
        noteAnnouncementInput.sendKeys(note);
        logger.info("Entering note to new announcement done");
        logger.info("Click the save button");
        saveButton.click();
        logger.info("Click the save button done");
        logger.info("Creating new announcement done");
    }

    public String getSuccessfullyMessage() {
        return savedSuccessfullyMessage.getText();
    }

    public void deleteFirstAnnouncement() {
        logger.info("Deleting announcement");
        logger.info("Marking the checkbox");
        String xpath = String.format("//tr[@data-row='0']//a[contains(@class," +
                " 'delete-link')]//i[contains(@class, 'la-trash')]");
        SeleniumHelper.waitForElementToExist(driver, By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();
        logger.info("Marking the checkbox done");
        logger.info("Click the delete button");
        deleteAgreeButton.click();
        logger.info("Click the delete button done");
        logger.info("Deleting announcement done");
    }

    public String getDeletedSuccessfullyMessage() {
        return deletedSuccessfullyMessage.getText();
    }

    public void editAnnouncement(String editedNote) {
        logger.info("Editing announcement note");
        logger.info("Click the edit button");
        editButton.click();
        logger.info("Click the edit button done");
        logger.info("Clearing the announcement note");
        noteAnnouncementInput.clear();
        logger.info("Clearing the announcement note done");
        logger.info("Entering edited note to announcement");
        noteAnnouncementInput.sendKeys(editedNote);
        logger.info("Entering the new note to announcement done");
        logger.info("Click the save button");
        saveButton.click();
        logger.info("Click the save button done");
        logger.info("Editing announcement note done");
    }

    public String getEditedSuccessfullyMessage() {
        return editedSuccessfullyMessage.getText();
    }
}
