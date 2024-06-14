package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LessonsPage {

    @FindBy(xpath = "//a[@href='/edux/7984/lessons']")
    private WebElement lessonsModuleButton;

    @FindBy(className = "flaticon2-plus")
    private WebElement addLessonButton;

    @FindBy(xpath = "//a[@href='/edux/7984/lessons/upsert']")
    private WebElement directlyInCourseButton;

    @FindBy(id = "Lesson_Name")
    private WebElement nameInput;

    @FindBy(id = "Lesson_PublicationDate")
    private WebElement dateInput;

    @FindBy(css = "button.mr-2.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(className = "flaticon2-plus")
    private WebElement addChapterButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public LessonsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void enterLessonsModule() {
        lessonsModuleButton.click();
    }

    public void addEmptyLesson(String name, String date) throws InterruptedException {
        logger.info("Adding lesson");
        logger.info("Clicking add lesson button");
        addLessonButton.click();
        directlyInCourseButton.click();
        logger.info("Clicking add lesson button done");
        logger.info("Setting name");
        nameInput.sendKeys(name);
        logger.info("Setting name done");
        logger.info("Clearing and seting date");
        dateInput.clear();
        dateInput.sendKeys(date);
        logger.info("Clearing and seting date done");
        logger.info("Clicking save");
        saveButton.click();
        logger.info("Clicking save done");
    }

    public void addNewWithChapterLesson(String name, String date) throws InterruptedException {
        logger.info("Adding lesson");
        logger.info("Clicking add lesson button");
        addLessonButton.click();
        directlyInCourseButton.click();
        logger.info("Clicking add lesson button done");
        logger.info("Setting name");
        nameInput.sendKeys(name);
        logger.info("Setting name done");
        logger.info("Clearing and seting date");
        dateInput.clear();
        dateInput.sendKeys(date);
        logger.info("Clearing and seting date done");
        logger.info("Clicking save");
        saveButton.click();
        logger.info("Clicking save done");
        addChapterButton.click();
    }
}
