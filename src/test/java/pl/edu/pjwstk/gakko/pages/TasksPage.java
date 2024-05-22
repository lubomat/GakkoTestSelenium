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

    @FindBy(css = "div.note-editable")
    private WebElement noteInput;

    @FindBy(xpath = "//span[text()='Zadanie 2']")
    private WebElement secondTaskButton;

    @FindBy(css = "textarea[name='Tasks[1][Content]']")
    private WebElement secondNoteInput;

    @FindBy(css = "button.btn.btn-block")
    private WebElement addATaskButton;

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

    public void addNewTaskPool(String taskName, String gradeName,
                               String dateFrom, String dateTo,
                               String taskNote ) {
        addNewTaskPoolButton.click();
        addDirectlyInTheCourseButton.click();
        taskPoolNameInput.sendKeys(taskName);
        gradeNameInput.sendKeys(gradeName);
        taskDateFromInput.clear();
        taskDateFromInput.sendKeys(dateFrom);
        taskDateToInput.clear();
        taskDateToInput.sendKeys(dateTo);
        background.click();
        firstTaskButton.click();
        noteInput.sendKeys(taskNote);
        saveButton.click();

    }
}
