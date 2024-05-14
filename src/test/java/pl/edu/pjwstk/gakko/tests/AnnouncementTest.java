package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AnnouncementPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class AnnouncementTest extends BaseTest {

    @Test
    public void createAnnouncementTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating Announcement Test");
        AnnouncementPage announcementPage = new AnnouncementPage(driver);
        test.log(Status.PASS, "Logging done", SeleniumHelper.getScreenshot(driver));
        announcementPage.enterAnnouncementModule();
        test.log(Status.PASS, "Entering announcement module done", SeleniumHelper.getScreenshot(driver));
        announcementPage.createNewAnnouncement("Ogłoszenie testowe");
        test.log(Status.PASS, "Creating new announcement done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(announcementPage.savedSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(announcementPage.getSuccessfullyMessage(), "Ogłoszenie zostało zapisane pomyślnie");

    }
}
