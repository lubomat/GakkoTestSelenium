package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BibliographyPage {


    @FindBy(xpath = "//a[@href='/edux/7984/books']")
    private WebElement bibliographyButton;

    @FindBy(css = "button.btn-brand")
    private WebElement addNewBookButton;

    @FindBy(xpath = "//a[@href='/edux/7984/books/upsert']")
    private WebElement addInTheCourseButton;

    @FindBy(id = "Book_Title")
    private WebElement titleInput;

    @FindBy(id = "Book_Author")
    private WebElement authorInput;

    @FindBy(id = "Book_Publisher")
    private WebElement publisherInput;

    @FindBy(xpath = "//input[@id='Book_Required' and @value='true']")
    private WebElement mandatoryItemRadioButton;

    @FindBy(id = "Book_Comment")
    private WebElement commentInput;

    @FindBy(id = "coverFile")
    private WebElement coverFileInput;

    @FindBy(xpath = "//button[text()='Zapisz']")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement bookAddedAlertMessage;

    private WebDriver driver;

    public BibliographyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final Logger logger = LogManager.getLogger();


    public void enterBibliographyModule() {
        logger.info("Entering bibliography module");
        bibliographyButton.click();
        logger.info("Entering bibliography module done");
    }

    public void uploadCoverFile(String filePath) {
        logger.info("Uploading file");
        coverFileInput.sendKeys(filePath);
        logger.info("Uploading file done");
    }

    public void createBook(String title, String author, String publisher,
                           String comment) {
        logger.info("Creating new book");
        addNewBookButton.click();
        addInTheCourseButton.click();
        logger.info("Entering title");
        titleInput.sendKeys(title);
        logger.info("Entering title done");
        logger.info("Entering author name");
        authorInput.sendKeys(author);
        logger.info("Entering author name done");
        logger.info("Entering publisher name");
        publisherInput.sendKeys(publisher);
        logger.info("Entering publisher name done");
        logger.info("Entering comment");
        commentInput.sendKeys(comment);
        logger.info("Entering comment done");
    }
    public void clickSave() {
        logger.info("Clicking save");
        saveButton.click();
        logger.info("Clicking save done");
        logger.info("Creating new book done");

    }

    public String getMessage() {
        return bookAddedAlertMessage.getText();
    }
}
