package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.edu.pjwstk.gakko.utils.SeleniumHelper;

public class TasksPage {

    @FindBy(xpath = "//span[text()='Zadania']")
    private WebElement tasksButton;

    @FindBy(css = "button.btn-brand")
    private WebElement addNewTaskPoolButton;

    @FindBy(xpath = "//span[text()='Dodaj bezpośrednio w kursie']")
    private WebElement addDirectlyInTheCourseButton;

    @FindBy(id = "TaskPool_Name")
    private WebElement taskPoolNameInput;

    @FindBy(id = "TaskPool_Grade_Name")
    private WebElement gradeNameInput;

    @FindBy(id = "TaskPool_DateFrom")
    private WebElement taskDateFromInput;

    @FindBy(id = "TaskPool_DateTo")
    private WebElement taskDateToInput;

    @FindBy(id = "kt_content")
    private WebElement background;

    @FindBy(xpath = "//span[text()='Zadanie 1']")
    private WebElement firstTaskButton;

    @FindBy(xpath = "(//div[@class='note-editable'])[1]")
    private WebElement firstTaskFieldInput;

    @FindBy(css = "button.btn.btn-block")
    private WebElement addATaskButton;

    @FindBy(xpath = "//span[text()='Zadanie 2']")
    private WebElement secondTaskButton;

    @FindBy(xpath = "(//div[@class='note-editable'])[2]")
    private WebElement secondTaskFieldInput;

    @FindBy(id = "btnUpsertSubmit")
    private WebElement saveButton;


    private WebDriver driver;

    public static final Logger logger = LogManager.getLogger();

    public TasksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterTasksModule() {
        tasksButton.click();
    }


    public void addNewTaskPoolWithMultipleTasks(String taskName, String gradeName,
                               String dateFrom, String dateTo,
                               String firstTaskNote, String secondTaskNote ) throws InterruptedException {
        logger.info("Creating new Task pool with multiple tasks");
        logger.info("Clicking add new task button");
        addNewTaskPoolButton.click();
        logger.info("Clicking add new task button done");
        logger.info("Clicking directly in the course button");
        addDirectlyInTheCourseButton.click();
        logger.info("Clicking directly in the course button done");
        logger.info("Entering task pool name");
        taskPoolNameInput.sendKeys(taskName);
        logger.info("Entering task pool name done");
        logger.info("Entering grade name");
        gradeNameInput.sendKeys(gradeName);
        logger.info("Entering grade name done");
        logger.info("Entering date from");
        taskDateFromInput.clear();
        taskDateFromInput.sendKeys(dateFrom);
        logger.info("Entering date from done");
        logger.info("Entering date to");
        taskDateToInput.clear();
        taskDateToInput.sendKeys(dateTo);
        logger.info("Entering date to done");
        background.click();
        logger.info("Opening first task");
        firstTaskButton.click();
        logger.info("Opening first task done");
        logger.info("Entering first task note ");
        firstTaskFieldInput.sendKeys(firstTaskNote);
        logger.info("Entering first task note done");
        logger.info("Creating second task");
        addATaskButton.click();
        logger.info("Creating second task done");
        logger.info("Opening second task note");
        Thread.sleep(500);
        secondTaskButton.click();
        logger.info("Opening second task note done");
        logger.info("Entering second task note");
        secondTaskFieldInput.sendKeys(secondTaskNote);
        logger.info("Entering first task note done");
        logger.info("Clicking save button");
        saveButton.click();
        logger.info("Clicking save button done");
        logger.info("Create new Task pool with multiple tasks done");
    }
}
