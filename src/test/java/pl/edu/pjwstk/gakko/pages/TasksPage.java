package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {

    @FindBy(xpath = "//span[text()='Zadania']")
    private WebElement tasksButton;

    private WebDriver driver;

    public static final Logger logger = LogManager.getLogger();

    public TasksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterTasksModule() {
        tasksButton.click();
    }
}
