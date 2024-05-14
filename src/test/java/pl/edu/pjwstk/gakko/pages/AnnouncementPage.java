package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}