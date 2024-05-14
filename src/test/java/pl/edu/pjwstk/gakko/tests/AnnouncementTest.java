package pl.edu.pjwstk.gakko.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AnnouncementPage;

public class AnnouncementTest extends BaseTest {

    @Test
    public void createAnnouncementTest() {

        AnnouncementPage announcementPage = new AnnouncementPage(driver);
        announcementPage.enterAnnouncementModule();
        announcementPage.createNewAnnouncement("Ogłoszenie testowe");

        Assert.assertTrue(announcementPage.savedSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(announcementPage.getSuccessfullyMessage(), "Ogłoszenie zostało zapisane pomyślnie");

    }
}
