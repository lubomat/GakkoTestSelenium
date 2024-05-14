package pl.edu.pjwstk.gakko.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertisementPage {
    @FindBy(xpath = "//span[text()='Ogłoszenia']")
    private WebElement advertisementButton;

    @FindBy(xpath = "//span[text()='Dodaj nowe ogłoszenie']")
    private WebElement addNewAdvertisementButton;

    @FindBy(xpath = "//span[text()='Dodaj bezpośrednio w kursie']")
    private WebElement advertisementOptionButton;

    @FindBy(className = "note-editable")
    private WebElement noteAdvertisementInput;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement savedSuccessfullyMessage;

    private WebDriver driver;

    public AdvertisementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterAdvertisementModule() {
        advertisementButton.click();
    }

    public void createNewAdvertisement(String note) {
        addNewAdvertisementButton.click();
        advertisementOptionButton.click();
        noteAdvertisementInput.sendKeys(note);
        saveButton.click();
    }

    public String getSuccessfullyMessage() {
        return savedSuccessfullyMessage.getText();
    }
}
