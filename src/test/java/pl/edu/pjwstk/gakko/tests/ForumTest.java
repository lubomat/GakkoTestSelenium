package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.ForumPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class ForumTest extends BaseTest {

    private String getRandomTitleName() {
        int randomNumber = (int) (Math.random() * 1000);
        return "Nowy tytuł testowy" + randomNumber;
    }
    @Test(priority = 0)
    public void createNewThreadTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating New Thread Test");
        ForumPage forumPage = new ForumPage(driver);
        test.log(Status.PASS, "Enter forum page", SeleniumHelper.getScreenshot(driver));
        forumPage.enterForumPage();
        test.log(Status.PASS, "Enter forum page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering title and note", SeleniumHelper.getScreenshot(driver));

        String titleName = getRandomTitleName();

        forumPage.CreateNewThread(titleName, "Testowa treść wiadomości");
        test.log(Status.PASS, "Entering title and note done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Creating new thread test done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(forumPage.forumAlertMessage.isDisplayed());
        Assert.assertEquals(forumPage.getMessage(), "Wątek został zapisany pomyślnie");
    }

    @Test(priority = 1)
    public void editThreadTest() throws IOException {

        ExtentTest test = extentReports.createTest("Edit Thread Test");
        ForumPage forumPage = new ForumPage(driver);
        test.log(Status.PASS, "Enter forum page", SeleniumHelper.getScreenshot(driver));
        forumPage.enterForumPage();
        test.log(Status.PASS, "Enter forum page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Click edit button", SeleniumHelper.getScreenshot(driver));
        forumPage.editThread("Nowy tytuł testowy");
        test.log(Status.PASS, "Click edit button done", SeleniumHelper.getScreenshot(driver));

    }

    @Test(priority = 2)
    public void createNewThreadWithExistingNameTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating New Thread With Existing Name Test");
        ForumPage forumPage = new ForumPage(driver);
        test.log(Status.PASS, "Enter forum page", SeleniumHelper.getScreenshot(driver));
        forumPage.enterForumPage();
        test.log(Status.PASS, "Enter forum page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering title and note", SeleniumHelper.getScreenshot(driver));
        forumPage.CreateNewThread("Nowy tytuł testowy", "Testowa treść wiadomości");
        test.log(Status.PASS, "Entering title and note done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Creating new thread test done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(forumPage.forumAlertMessage.isDisplayed());
        Assert.assertEquals(forumPage.getMessage(), "Wątek o identycznym tytule już istnieje");
    }

    @Test(priority = 3)
    public void addMessageToExistingThreadTest() throws IOException {

        ExtentTest test = extentReports.createTest("Add Message To Existing Thread Test");
        ForumPage forumPage = new ForumPage(driver);
        test.log(Status.PASS, "Enter forum page", SeleniumHelper.getScreenshot(driver));
        forumPage.enterForumPage();
        test.log(Status.PASS, "Enter forum page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering new note", SeleniumHelper.getScreenshot(driver));
        forumPage.addMessageToExistingThread("Nowa notatka testowa");
        test.log(Status.PASS, "Entering new note done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Adding message to existing thread test done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(forumPage.forumAlertMessage.isDisplayed());
        Assert.assertEquals(forumPage.getMessage(), "Wiadomość została zapisana pomyślnie");

    }

    @Test(priority = 4)
    public void deletingThread() throws IOException {

        ExtentTest test = extentReports.createTest("Deleting Thread Test");
        ForumPage forumPage = new ForumPage(driver);
        test.log(Status.PASS, "Enter forum page", SeleniumHelper.getScreenshot(driver));
        forumPage.enterForumPage();
        test.log(Status.PASS, "Enter forum page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting click delete button", SeleniumHelper.getScreenshot(driver));
        forumPage.clickDeleteButtonForRow();
        test.log(Status.PASS, "Deleting click delete button done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting thread done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(forumPage.forumAlertMessage.isDisplayed());
        Assert.assertEquals(forumPage.getMessage(),"Wątek został usunięty pomyślnie");
    }


}
