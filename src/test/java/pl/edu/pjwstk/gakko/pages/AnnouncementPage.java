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
    @FindBy(xpath = "//span[text()='Ogłoszenia']")
    private WebElement announcementButton;

    @FindBy(xpath = "//span[text()='Dodaj nowe ogłoszenie']")
    private WebElement addNewAnnouncementButton;

    @FindBy(xpath = "//span[text()='Dodaj bezpośrednio w kursie']")
    private WebElement announcementOptionButton;

    @FindBy(className = "note-editable")
    private WebElement noteAnnouncementInput;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement savedSuccessfullyMessage;

    @FindBy(css = "button.swal2-confirm.swal2-styled")
    private WebElement deleteAgreeButton;

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
        addNewAnnouncementButton.click();
        announcementOptionButton.click();
        logger.info("Entering note to new announcement");
        noteAnnouncementInput.sendKeys(note);
        logger.info("Entering note to new announcement done");
        saveButton.click();
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
        logger.info("Clicking the delete button");
        deleteAgreeButton.click();
        logger.info("Clicking the delete button done");
    }
}
