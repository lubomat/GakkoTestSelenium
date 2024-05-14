package pl.edu.pjwstk.gakko.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AdvertisementPage;

public class AdvertisementTest extends BaseTest {

    @Test
    public void createAdvertisementTest() {

        AdvertisementPage advertisementPage = new AdvertisementPage(driver);
        advertisementPage.enterAdvertisementModule();
        advertisementPage.createNewAdvertisement("Ogłoszenie testowe");

        Assert.assertTrue(advertisementPage.savedSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(advertisementPage.getSuccessfullyMessage(), "Ogłoszenie zostało zapisane pomyślnie");

    }
}
