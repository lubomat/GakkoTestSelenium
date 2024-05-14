package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "userNameInput")
    private WebElement userNameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void logIn(String login, String password) {
        logger.info("entering login and password");
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
        logger.info("entering login and password done");
    }
}
