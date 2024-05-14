package pl.edu.pjwstk.gakko.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "userNameInput")
    private WebElement userNameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String login, String password) {
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
