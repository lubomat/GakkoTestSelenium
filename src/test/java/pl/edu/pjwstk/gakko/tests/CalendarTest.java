package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.CalendarPage;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

import java.io.IOException;

public class CalendarTest extends BaseTest{

    @Test
    public void createNewEventTest() throws IOException {
        ExtentTest test = extentReports.createTest("Creating New Event Test");
        CalendarPage calendarPage = new CalendarPage(driver);
        test.log(Status.PASS,"Entering calendar module", SeleniumHelper.getScreenshot(driver));
        calendarPage.enterCalendarModule();
        test.log(Status.PASS,"Entering calendar module done", SeleniumHelper.getScreenshot(driver));
        test.log(Status.PASS,"Creating new event", SeleniumHelper.getScreenshot(driver));
        calendarPage.createNewEvent("2025-06-14 20:00", "Nazwa testowa");
        test.log(Status.PASS,"Creating new event test done", SeleniumHelper.getScreenshot(driver));

        Assert.assertTrue(calendarPage.alertCalendarMessage.isDisplayed());
        Assert.assertEquals(calendarPage.getMessage(),"Wydarzenie zostało zapisane pomyślnie");
    }
}
