package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.FaqPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class FaqTest extends BaseTest {

    @Test
    public void addNewQuestionTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating New Question Test");
        FaqPage faqPage = new FaqPage(driver);
        test.log(Status.PASS,"Entering faq module", SeleniumHelper.getScreenshot(driver));
        faqPage.enterFaqModule();
        test.log(Status.PASS,"Entering faq module", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Adding new question", SeleniumHelper.getScreenshot(driver));
        faqPage.createNewQuestion(
                "Testowe",
                "Test");
        test.log(Status.PASS,"Adding new question done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(faqPage.faqAlert.isDisplayed());
        Assert.assertEquals(faqPage.getMessage(),"Pytanie zostało zapisane pomyślnie");
    }

    @Test
    public void addSameQuestionTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating Same Question Test");
        FaqPage faqPage = new FaqPage(driver);
        test.log(Status.PASS,"Entering faq module", SeleniumHelper.getScreenshot(driver));
        faqPage.enterFaqModule();
        test.log(Status.PASS,"Entering faq module", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Adding same question", SeleniumHelper.getScreenshot(driver));
        faqPage.createNewQuestion(
                "Testowe",
                "Test");
        test.log(Status.PASS,"Adding same question done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(faqPage.faqAlert.isDisplayed());
        Assert.assertEquals(faqPage.getMessage(),"Faq o identycznych parametrach już istnieje");
    }

    @Test
    public void deleteQuestionTest() throws IOException {
        ExtentTest test = extentReports.createTest("Deleting Question Test");
        FaqPage faqPage = new FaqPage(driver);
        test.log(Status.PASS,"Entering faq module", SeleniumHelper.getScreenshot(driver));
        faqPage.enterFaqModule();
        test.log(Status.PASS,"Entering faq module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Deleting question", SeleniumHelper.getScreenshot(driver));
        faqPage.deleteQuestion();
        test.log(Status.PASS,"Deleting question test done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(faqPage.faqAlert.isDisplayed());
        Assert.assertEquals(faqPage.getMessage(),"Pytanie zostało usunięte pomyślnie");
    }


}
