package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.LessonsPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class LessonsTest extends BaseTest {

    @Test(priority = 2)
    public void addEmptyLessonTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating new empty lesson");
        LessonsPage lessonsPage = new LessonsPage(driver);
        test.log(Status.PASS,"Entering Lessons module", SeleniumHelper.getScreenshot(driver));
        lessonsPage.enterLessonsModule();
        test.log(Status.PASS,"Entering Lessons module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Creating empty lesson", SeleniumHelper.getScreenshot(driver));
        lessonsPage.addEmptyLesson(
                "Test",
                "2025-09-13 13:00");
        test.log(Status.PASS,"Creating empty lesson done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(lessonsPage.lessonsAlertMessage.isDisplayed());
        Assert.assertEquals(lessonsPage.getMessage(),"Lekcja została zapisana pomyślnie");
    }

    @Test(priority = 3)
    public void addLessonWithChapterTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating lesson with chapter");
        LessonsPage lessonsPage = new LessonsPage(driver);
        test.log(Status.PASS,"Entering Lessons module", SeleniumHelper.getScreenshot(driver));
        lessonsPage.enterLessonsModule();
        test.log(Status.PASS,"Entering Lessons module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Creating lesson with chapter", SeleniumHelper.getScreenshot(driver));
        lessonsPage.addLessonWithChapter(
                "Test",
                "2025-09-13 13:00",
                "Testowy rozdział",
                "80",
                "Testowa treść");
        test.log(Status.PASS,"Creating lesson with chapter done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(lessonsPage.lessonsAlertMessage.isDisplayed());
        Assert.assertEquals(lessonsPage.getMessage(),"Lekcja została zapisana pomyślnie");
    }

    @Test(priority = 0)
    public void addLessonWithShowAnswerChapterTypeTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating lesson with chapter");
        LessonsPage lessonsPage = new LessonsPage(driver);
        test.log(Status.PASS,"Entering Lessons module", SeleniumHelper.getScreenshot(driver));
        lessonsPage.enterLessonsModule();
        test.log(Status.PASS,"Entering Lessons module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Creating lesson with chapter", SeleniumHelper.getScreenshot(driver));
        lessonsPage.addLessonWithShowAnswerChapterType(
                "Test",
                "2025-09-13 13:00",
                "Testowy rozdział",
                "70",
                "testowy tekst wytłuszczony",
                "testowe pytanie",
                "testowa odpowiedz");

        Assert.assertTrue(lessonsPage.lessonsAlertMessage.isDisplayed());
        Assert.assertEquals(lessonsPage.getMessage(),"Rozdział został zapisany pomyślnie");

    }

    @Test(priority = 1)
    public void showAnswerLessonCheckTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating lesson with chapter");
        LessonsPage lessonsPage = new LessonsPage(driver);
        test.log(Status.PASS,"Entering Lessons module", SeleniumHelper.getScreenshot(driver));
        lessonsPage.enterLessonsModule();
        test.log(Status.PASS,"Entering Lessons module done", SeleniumHelper.getScreenshot(driver));
        lessonsPage.showAnswer();

        Assert.assertTrue(lessonsPage.answerInfo.isDisplayed());

    }

}


