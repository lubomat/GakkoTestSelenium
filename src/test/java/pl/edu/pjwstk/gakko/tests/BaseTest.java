package pl.edu.pjwstk.gakko.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pl.edu.pjwstk.gakko.pages.LoginPage;
import pl.edu.pjwstk.gakko.utils.PropertiesLoader;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    protected static ExtentSparkReporter sparkReporter;

    protected static ExtentReports extentReports;

    @BeforeSuite
    public void beforeSuite() {
        sparkReporter = new ExtentSparkReporter("index.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
    }

    @BeforeMethod
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("https://gakko.pjwstk.edu.pl/edux/7984/");
        driver.manage().window().maximize();

        PropertiesLoader testUtils = new PropertiesLoader();
        Map<String, String> loginData = testUtils.readLoginDataFromFile("C:/Users/matlu/IdeaProjects/gakkoTest/src/config/login_credentials.txt");
        String login = loginData.get("login");
        String password = loginData.get("password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(login, password);
    }

    @AfterMethod
    public void afterSetup() {
        driver.quit();
    }
}

