package pl.edu.pjwstk.gakko.tests;

import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AdvertisementPage;

public class AdvertisementTest extends BaseTest {

    @Test
    public void addAdvertisementTest() {

        int randomNumber = (int) (Math.random() * 100);

        AdvertisementPage advertisementPage = new AdvertisementPage(driver);
        advertisementPage.enterAdvertisementModule();
        advertisementPage.createNewAdvertisement("Ogłoszenie testowe numer " + randomNumber);



    }
}
