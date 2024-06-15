package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "Chapter_Title")
    private WebElement chapterTitleInput;

    @FindBy(id = "Chapter_PointsToPass")
    private WebElement pointsInput;

    @FindBy(css = "div.note-editable[role='textbox']")
    private WebElement noteInput;

    @FindBy(id = "btnSubmitForm")
    private WebElement submitButton;

    @FindBy(css = "div.alert-text")
    public WebElement lessonsAlertMessage;

    @FindBy(xpath = "//select[@name='Chapter.Elements[0][ElementType]']")
    private WebElement dropdownSelector;

    @FindBy(name = "Chapter.Elements[0][BoldText]")
    private WebElement boldTextInput;

    @FindBy(name = "Chapter.Elements[0][QuestionText]")
    private WebElement questionInput;

    @FindBy(name = "Chapter.Elements[0][AnswerText]")
    private WebElement answerInput;


    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public LessonsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public String getMessage() {
        return lessonsAlertMessage.getText();
    }

    public void enterLessonsModule() {
        lessonsModuleButton.click();
    }

    public void addEmptyLesson(String name, String date) {
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

    public void addLessonWithChapter(String name, String date,
                                     String chapter, String points,
                                     String note) {
        logger.info("Adding lesson");
        logger.info("Clicking add lesson button");
        addLessonButton.click();
        directlyInCourseButton.click();
        logger.info("Clicking add lesson button done");
        logger.info("Setting name");
        nameInput.sendKeys(name);
        logger.info("Setting name done");
        logger.info("Clearing and setting date");
        dateInput.clear();
        dateInput.sendKeys(date);
        logger.info("Clearing and setting date done");
        logger.info("Clicking save");
        saveButton.click();
        logger.info("Clicking save done");
        logger.info("Clicking add chapter");
        addChapterButton.click();
        logger.info("Clicking add chapter done");
        logger.info("Setting chapter title");
        chapterTitleInput.sendKeys(chapter);
        logger.info("Setting chapter title done");
        logger.info("Cleaning and setting points");
        pointsInput.clear();
        pointsInput.sendKeys(points);
        logger.info("Cleaning and setting points done");
        logger.info("Entering note");
        noteInput.sendKeys(note);
        logger.info("Entering note done");
        logger.info("Clicking submit button");
        submitButton.click();
        logger.info("Clicking submit button done");
    }

    public void addLessonWithShowAnswerChapterType(String name, String date,
                                                   String chapter, String points,
                                                   String text, String question,
                                                   String answer) {
        logger.info("Adding lesson");
        logger.info("Clicking add lesson button");
        addLessonButton.click();
        directlyInCourseButton.click();
        logger.info("Clicking add lesson button done");
        logger.info("Setting name");
        nameInput.sendKeys(name);
        logger.info("Setting name done");
        logger.info("Clearing and setting date");
        dateInput.clear();
        dateInput.sendKeys(date);
        logger.info("Clearing and setting date done");
        logger.info("Clicking save");
        saveButton.click();
        logger.info("Clicking save done");
        addChapterButton.click();
        logger.info("Clicking add chapter done");
        logger.info("Setting chapter title");
        chapterTitleInput.sendKeys(chapter);
        logger.info("Setting chapter title done");
        logger.info("Cleaning and setting points");
        pointsInput.clear();
        pointsInput.sendKeys(points);
        logger.info("Cleaning and setting points done");
        logger.info("Selecting 'Pokaż odpowiedź' option from dropdown");
        Select dropdown = new Select(dropdownSelector);
        dropdown.selectByValue("ShowAnswer");
        logger.info("Selecting 'Pokaż odpowiedź' option from dropdown done");
        boldTextInput.sendKeys(text);
        questionInput.sendKeys(question);
        answerInput.sendKeys(answer);
        submitButton.click();

    }

}
