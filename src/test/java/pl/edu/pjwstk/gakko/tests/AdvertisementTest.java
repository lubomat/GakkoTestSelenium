package pl.edu.pjwstk.gakko.tests;

import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AdvertisementPage;

public class AdvertisementTest extends BaseTest {

    @Test
    public void addAdvertisementTest() {
        AdvertisementPage advertisementPage = new AdvertisementPage(driver);
        advertisementPage.enterAdvertisement();
    }
}
