package pl.edu.pjwstk.gakko.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    public WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);
        driver.get("https://gakko.pjwstk.edu.pl/edux/7984/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterSetup() {
//        driver.quit();
    }
}

