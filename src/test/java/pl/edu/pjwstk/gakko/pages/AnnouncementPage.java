package pl.edu.pjwstk.gakko.pages;

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

    public void enterAnnouncementModule() {
        announcementButton.click();
    }

    public void createNewAnnouncement(String note) {
        addNewAnnouncementButton.click();
        announcementOptionButton.click();
        noteAnnouncementInput.sendKeys(note);
        saveButton.click();
    }

    public String getSuccessfullyMessage() {
        return savedSuccessfullyMessage.getText();
    }
}
