package pl.edu.pjwstk.gakko.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AdvertisementPage;

public class AdvertisementTest extends BaseTest {

    @Test
    public void addAdvertisementTest() {
        AdvertisementPage advertisementPage = new AdvertisementPage(driver);
        advertisementPage.enterAdvertisement();
    }
}
