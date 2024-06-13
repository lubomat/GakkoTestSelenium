package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.BibliographyPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BibliographyTest extends BaseTest {

    @Test
    public void addBookTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating New Book Test");
        BibliographyPage bibliographyPage = new BibliographyPage(driver);
        test.log(Status.PASS, "Entering bibliography module", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.enterBibliographyModule();
        test.log(Status.PASS, "Entering bibliography module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Adding new book", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering title, author, publisher and comment", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.createBook(
                "Title Test",
                "Author Test",
                "Publisher Test",
                "Comment Test");
        test.log(Status.PASS, "Entering title, author, publisher and comment done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Uploading cover book file", SeleniumHelper.getScreenshot(driver));
        Path filePath = Paths.get("src/test/resources/coverBookTest.jpg").toAbsolutePath();
        bibliographyPage.uploadCoverFile(filePath.toString());
        test.log(Status.PASS, "Uploading cover book file done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Adding new book done", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.clickSave();
        test.log(Status.PASS, "Creating New Book Test Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(bibliographyPage.bookAlertMessage.isDisplayed());
        Assert.assertEquals(bibliographyPage.getMessage(),"Książka została zapisana pomyślnie");
    }

    @Test
    public void addSameBookTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating Same Book Test");
        BibliographyPage bibliographyPage = new BibliographyPage(driver);
        test.log(Status.PASS, "Entering bibliography module", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.enterBibliographyModule();
        test.log(Status.PASS, "Entering bibliography module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Adding new book", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Entering title, author, publisher and comment", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.createBook(
                "Title Test",
                "Author Test",
                "Publisher Test",
                "Comment Test");
        test.log(Status.PASS, "Entering title, author, publisher and comment done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Uploading cover book file", SeleniumHelper.getScreenshot(driver));
        Path filePath = Paths.get("src/test/resources/coverBookTest.jpg").toAbsolutePath();
        bibliographyPage.uploadCoverFile(filePath.toString());
        test.log(Status.PASS, "Uploading cover book file done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Adding new book done", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.clickSave();
        test.log(Status.PASS, "Creating Same Book Test Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(bibliographyPage.bookAlertMessage.isDisplayed());
        Assert.assertEquals(bibliographyPage.getMessage(),"Książka o identycznych parametrach już istnieje");
    }

    @Test
    public void deleteBookTest() throws IOException {
        ExtentTest test = extentReports.createTest("Deleting Book Test");
        BibliographyPage bibliographyPage = new BibliographyPage(driver);
        test.log(Status.PASS, "Entering bibliography module", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.enterBibliographyModule();
        test.log(Status.PASS, "Entering bibliography module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting book", SeleniumHelper.getScreenshot(driver));
        bibliographyPage.deleteBook();
        test.log(Status.PASS, "Deleting book done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting Book Test Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(bibliographyPage.bookAlertMessage.isDisplayed());
        Assert.assertEquals(bibliographyPage.getMessage(),"Książka została usunięta pomyślnie");

    }

}
