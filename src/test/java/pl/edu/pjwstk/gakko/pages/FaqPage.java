package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqPage {

    @FindBy(xpath = "//a[@href='/edux/7984/faqs']")
    private WebElement faqModuleButton;

    @FindBy(className = "flaticon2-plus")
    private WebElement addNewQuestionButton;

    @FindBy(xpath = "//a[@href='/edux/7984/faqs/upsert']")
    private WebElement addInCourseButton;

    @FindBy(id = "Faq_Question")
    private WebElement questionInput;

    @FindBy(xpath = "//div[@class='note-editable']")
    private WebElement replyInput;

    @FindBy(xpath = "//button[text()='Zapisz']")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement faqAlert;


    private WebDriver driver;

    public FaqPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final Logger logger = LogManager.getLogger();

    public void enterFaqModule() {
        faqModuleButton.click();
    }

    public void createNewQuestion(String question, String reply) {
        logger.info("Creating new question");
        addNewQuestionButton.click();
        addInCourseButton.click();
        logger.info("Entering question");
        questionInput.sendKeys(question);
        logger.info("Entering question done");
        logger.info("Entering reply");
        replyInput.sendKeys(reply);
        logger.info("Entering reply done");
        logger.info("Clicking save button");
        saveButton.click();
        logger.info("Clicking save button done");
        logger.info("Creating new question done");
    }

    public String getMessage() {
        return faqAlert.getText();
    }


}
