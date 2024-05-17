package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.GradesPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class GradesTest extends BaseTest{

    @Test
    public void addGradeTest() throws IOException {

        int randomNumber = (int) (Math.random()*1000);

        ExtentTest test = extentReports.createTest("Creating New Grade Test");
        GradesPage gradesPage = new GradesPage(driver);
        test.log(Status.PASS,"Entering grades page", SeleniumHelper.getScreenshot(driver));
        gradesPage.enterGradePage();
        test.log(Status.PASS,"Entering grades page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Creating new grade", SeleniumHelper.getScreenshot(driver));
        gradesPage.addNewGrade("Nazwa Testowa" + randomNumber);
        test.log(Status.PASS,"Creating new grade Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(gradesPage.gradesAddMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(),"Ocena została zapisana pomyślnie");

    }

    @Test
    public void addGradeWithExistingNameTest() throws IOException {

        ExtentTest test = extentReports.createTest("Creating New Grade With Existing Name Test");
        GradesPage gradesPage = new GradesPage(driver);
        test.log(Status.PASS,"Entering grades page", SeleniumHelper.getScreenshot(driver));
        gradesPage.enterGradePage();
        test.log(Status.PASS,"Entering grades page done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Creating new grade with existing name", SeleniumHelper.getScreenshot(driver));
        gradesPage.addNewGrade("Nazwa Testowa");
        test.log(Status.PASS,"Creating new grade with existing name Done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(gradesPage.gradesAddMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(),"Ocena o identycznych parametrach już istnieje");

    }

}
