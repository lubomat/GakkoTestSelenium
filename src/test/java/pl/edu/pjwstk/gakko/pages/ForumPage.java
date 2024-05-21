package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumPage {

    @FindBy(xpath = "//span[text()='Forum']")
    private WebElement forumPageButton;

    @FindBy(className = "flaticon2-plus")
    private WebElement createNewThreadButton;

    @FindBy(id = "Thread_Title")
    private WebElement titleInput;

    @FindBy(className = "note-editable")
    private WebElement noteInput;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement forumAlertMessage;

    @FindBy(css = "a[href*='/forum/upsert/']")
    private WebElement editLink;

    @FindBy(css = "td[data-field='Actions'] a:nth-of-type(1)")
    private WebElement openThreadLink;

    @FindBy(xpath = "//a[text()='Dodaj wiadomość']")
    private WebElement addMessageButton;

    @FindBy(css = "tr.kt-datatable__row:first-child a.delete-link")
    private WebElement deleteButtonForRow;

    @FindBy(css = "button.swal2-confirm.swal2-styled")
    private WebElement deleteAgreeButton;

    private WebDriver driver;

    public ForumPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final Logger logger = LogManager.getLogger();

    public void enterForumPage() {
        logger.info("Entering forum page");
        forumPageButton.click();
        logger.info("Entering forum page done");
    }

    public void CreateNewThread(String title, String note) {
        logger.info("Creating new thread");
        logger.info("Click on add new thread");
        createNewThreadButton.click();
        logger.info("Click on add new thread done");
        logger.info("Entering title");
        titleInput.sendKeys(title);
        logger.info("Entering title done");
        logger.info("Entering note");
        noteInput.sendKeys(note);
        logger.info("Entering note done");
        logger.info("Click on save button");
        saveButton.click();
        logger.info("Click on save button done");
        logger.info("Creating new thread done");
    }

    public String getMessage() {
        return forumAlertMessage.getText();
    }

    public void editThread(String editedTitle) {
        logger.info("Editing existing thread");
        logger.info("Click on edit link");
        editLink.click();
        logger.info("Click on edit link done");
        logger.info("Clearing title");
        titleInput.clear();
        logger.info("Clearing title done");
        logger.info("Entering new title");
        titleInput.sendKeys(editedTitle);
        logger.info("Entering new title done");
        logger.info("Click on save button");
        saveButton.click();
        logger.info("Click on save button done");
        logger.info("Editing existing thread done");
    }

    public void addMessageToExistingThread(String messageNote) {
        logger.info("Adding new message to existing thread");
        logger.info("Entering to thread");
        openThreadLink.click();
        logger.info("Entering to thread done");
        logger.info("Click on add new message");
        addMessageButton.click();
        logger.info("Click on add new message done");
        logger.info("Adding new message");
        noteInput.sendKeys(messageNote);
        logger.info("Adding new message done");
        logger.info("Click on save button");
        saveButton.click();
        logger.info("Click on save button done");
        logger.info("Adding new message to existing thread done");
    }

    public void clickDeleteButtonForRow() {
        logger.info("Deleting thread");
        logger.info("Click delete button");
        deleteButtonForRow.click();
        logger.info("Click delete button done");
        logger.info("Click Yes, delete! button");
        deleteAgreeButton.click();
        logger.info("Click Yes, delete! button done");
        logger.info("Deleting thread done");
    }


}
