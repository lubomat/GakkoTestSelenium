package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GradesPage {

    @FindBy(xpath = "//span[text()='Oceny']")
    private WebElement gradesPageButton;

    @FindBy(xpath = "//span[text()='Dodaj nową ocenę']")
    private WebElement addNewGradeButton;

    @FindBy(xpath = "//span[text()='Dodaj bezpośrednio w kursie']")
    private WebElement addNewGradeOptionButton;

    @FindBy(id = "Grade_Name")
    private WebElement gradeNameInput;

    @FindBy(id = "Grade_Numeric")
    private WebElement gradeNumericSelect;

    @FindBy(css = "button.btn.btn-primary.float-right")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement gradesAlertMessage;

    private WebDriver driver;

    public GradesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private static final Logger logger = LogManager.getLogger();

    public void enterGradePage() {
        gradesPageButton.click();
    }

    public void addNewGrade(String name) {
        logger.info("Click on add new grade button");
        addNewGradeButton.click();
        logger.info("Click on add new grade button done");
        logger.info("Click on add new grade option button");
        addNewGradeOptionButton.click();
        logger.info("Click on add new grade option button done");
        logger.info("Enter name");
        gradeNameInput.sendKeys(name);
        logger.info("Enter name done");
        logger.info("Select numeric");
        Select select = new Select(gradeNumericSelect);
        select.selectByValue("true");
        logger.info("Select numeric done");
        logger.info("Click save button");
        saveButton.click();
        logger.info("Click save button done");
    }

    public String getMessage() {
        return gradesAlertMessage.getText();
    }

    public void clickEditButtonInLastRow() {
        logger.info("Find last grade on list and click on edit grade button");
        List<WebElement> rows = driver.findElements(By.cssSelector("tr.kt-datatable__row"));
        WebElement lastRow = rows.get(rows.size() - 1);
        WebElement editButton = lastRow.findElement(By.cssSelector("a[href*='/grades/upsert/']"));
        editButton.click();
        logger.info("Find last grade on list and click on edit grade button done");
    }

    public void editGradeInLastRow(String editedName) {
        clickEditButtonInLastRow();
        gradeNameInput.clear();
        gradeNameInput.sendKeys(editedName);
        logger.info("Click on save button");
        saveButton.click();
        logger.info("Click on save button done");
    }

}
