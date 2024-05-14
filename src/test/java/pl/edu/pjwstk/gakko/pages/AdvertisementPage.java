package pl.edu.pjwstk.gakko.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertisementPage {

    @FindBy(xpath = "//span[text()='Ogłoszenia']")
    private WebElement advertisementButton;

    private WebDriver driver;

    public AdvertisementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterAdvertisement() {
        advertisementButton.click();
    }
}
