package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    @FindBy(xpath = "//a[@href='/edux/7984/events']")
    private WebElement calendarModuleButton;

    @FindBy(className = "flaticon2-plus")
    private WebElement createNewEventButton;

    @FindBy(xpath = "//a[@href='/edux/7984/events/upsert']")
    private WebElement addDirectlyInTheCourseButton;

    @FindBy(id = "Event_Date")
    private WebElement dateInput;

    @FindBy(className = "note-editable")
    private WebElement noteInput;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement alertCalendarMessage;

    private WebDriver driver;

    public CalendarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final Logger logger = LogManager.getLogger();

    public void enterCalendarModule() {
        logger.info("Entering calendar module");
        calendarModuleButton.click();
        logger.info("Entering calendar module done");
    }

    public void createNewEvent(String date, String note) {
        logger.info("Creating new event");
        createNewEventButton.click();
        addDirectlyInTheCourseButton.click();
        logger.info("Cleaning date");
        dateInput.clear();
        logger.info("Cleaning date done");
        logger.info("Setting new date");
        dateInput.sendKeys(date);
        logger.info("Setting new date done");
        logger.info("Entering note");
        noteInput.sendKeys(note);
        logger.info("Entering note done");
        saveButton.click();
        logger.info("Creating new event done");
    }

    public String getMessage() {
       return alertCalendarMessage.getText();
    }
}
