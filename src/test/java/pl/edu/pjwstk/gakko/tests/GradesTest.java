package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.GradesPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class GradesTest extends BaseTest {

    private String getRandomGradeName() {
        int randomNumber = (int) (Math.random() * 1000);
        return "Nazwa Testowa" + randomNumber;
    }
    @Test(priority = 0)
    public void addGradeTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating New Grade Test");
        GradesPage gradesPage = new GradesPage(driver);
        test.log(Status.PASS, "Entering grades page", SeleniumHelper.getScreenshot(driver));
        gradesPage.enterGradePage();
        test.log(Status.PASS, "Entering grades page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Creating new grade", SeleniumHelper.getScreenshot(driver));

        String gradeName = getRandomGradeName();

        gradesPage.addNewGrade(gradeName);
        test.log(Status.PASS, "Creating new grade Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(gradesPage.gradesAlertMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(), "Ocena została zapisana pomyślnie");

    }

    @Test(priority = 2)
    public void addGradeWithExistingNameTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating New Grade With Existing Name Test");
        GradesPage gradesPage = new GradesPage(driver);
        test.log(Status.PASS, "Entering grades page", SeleniumHelper.getScreenshot(driver));
        gradesPage.enterGradePage();
        test.log(Status.PASS, "Entering grades page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Creating new grade with existing name", SeleniumHelper.getScreenshot(driver));
        gradesPage.addNewGrade("Nazwa Testowa");
        test.log(Status.PASS, "Creating new grade with existing name Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(gradesPage.gradesAlertMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(), "Ocena o identycznych parametrach już istnieje");

    }

    @Test(priority = 1)
    public void editGradeInLastRowTest() throws IOException {

        ExtentTest test = extentReports.createTest("Editing Grade Test");
        GradesPage gradesPage = new GradesPage(driver);
        test.log(Status.PASS, "Entering grades page", SeleniumHelper.getScreenshot(driver));
        gradesPage.enterGradePage();
        test.log(Status.PASS, "Entering grades page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Click edit button", SeleniumHelper.getScreenshot(driver));
        gradesPage.editGradeInLastRow("Nazwa Testowa");
        test.log(Status.PASS, "Click edit button done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(gradesPage.gradesAlertMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(), "Ocena została zapisana pomyślnie");

    }

    @Test(priority = 3)
    public void deleteGradeInLastRowTest() throws IOException {

        ExtentTest test = extentReports.createTest("Deleting Grade Test");
        GradesPage gradesPage = new GradesPage(driver);
        test.log(Status.PASS, "Entering grades page", SeleniumHelper.getScreenshot(driver));
        gradesPage.enterGradePage();
        test.log(Status.PASS, "Entering grades page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS, "Deleting in last row grade", SeleniumHelper.getScreenshot(driver));
        gradesPage.deleteGradeInLastRow();
        test.log(Status.PASS, "Deleting in last row grade done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(gradesPage.gradesAlertMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(), "Ocena została usunięta pomyślnie");

    }

}
