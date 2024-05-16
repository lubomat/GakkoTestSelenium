package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.AnnouncementPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class AnnouncementTest extends BaseTest {
    @Test(priority = 0)
    public void createAnnouncementTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating Announcement Test");
        AnnouncementPage announcementPage = new AnnouncementPage(driver);
        test.log(Status.PASS, "Login done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering announcement module", SeleniumHelper.getScreenshot(driver));
        announcementPage.enterAnnouncementModule();
        test.log(Status.PASS, "Entering announcement module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Creating new announcement done", SeleniumHelper.getScreenshot(driver));
        announcementPage.createNewAnnouncement("Ogłoszenie testowe");
        test.log(Status.PASS, "Creating new announcement done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(announcementPage.savedSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(announcementPage.getSuccessfullyMessage(), "Ogłoszenie zostało zapisane pomyślnie");
    }
    @Test(priority = 2)
    public void deleteAnnouncementTest() throws IOException {
        ExtentTest test = extentReports.createTest("Deleting Announcement Test");
        AnnouncementPage announcementPage = new AnnouncementPage(driver);
        test.log(Status.PASS, "Login done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering announcement module ", SeleniumHelper.getScreenshot(driver));
        announcementPage.enterAnnouncementModule();
        test.log(Status.PASS, "Entering announcement module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting announcement", SeleniumHelper.getScreenshot(driver));
        announcementPage.deleteFirstAnnouncement();
        test.log(Status.PASS, "Deleting announcement done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(announcementPage.deletedSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(announcementPage.getDeletedSuccessfullyMessage(),"Ogłoszenie zostało usunięte pomyślnie");
    }
    @Test(priority = 1)
    public void editAnnouncementTest() throws IOException {
        ExtentTest test = extentReports.createTest("Editing Announcement Test");
        AnnouncementPage announcementPage = new AnnouncementPage(driver);
        test.log(Status.PASS, "Login done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering announcement module ", SeleniumHelper.getScreenshot(driver));
        announcementPage.enterAnnouncementModule();
        test.log(Status.PASS, "Entering announcement module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Editing announcement", SeleniumHelper.getScreenshot(driver));
        announcementPage.editAnnouncement("Ogłoszenie edytowane");
        test.log(Status.PASS, "Editing announcement done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(announcementPage.editedSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(announcementPage.getEditedSuccessfullyMessage(),"Ogłoszenie zostało zapisane pomyślnie");
    }
}
