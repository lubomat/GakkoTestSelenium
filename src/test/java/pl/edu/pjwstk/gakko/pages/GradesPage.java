package pl.edu.pjwstk.gakko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GradesPage {

    @FindBy(xpath = "//span[text()='Oceny']")
    private WebElement gradesPageButton;

    @FindBy(xpath = "//span[text()='Dodaj nową ocenę']")
    private WebElement addNewGradeButton;

    @FindBy(xpath = "//span[text()='Dodaj bezpośrednio w kursie']")
    private WebElement gradeOptionButton;

    @FindBy(id = "Grade_Name")
    private WebElement gradeNameInput;

    @FindBy(id = "Grade_Numeric")
    private WebElement gradeNumericSelect;

    @FindBy(css = "button.btn.btn-primary.float-right")
    private WebElement saveButton;

    @FindBy(css = "div.alert-text")
    public WebElement gradesAddSuccessfullyMessage;

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
        addNewGradeButton.click();
        gradeOptionButton.click();
        gradeNameInput.sendKeys(name);
        Select select = new Select(gradeNumericSelect);
        select.selectByValue("true");
        saveButton.click();
    }

    public String getSuccessfullyMessage() {
        return gradesAddSuccessfullyMessage.getText();
    }

}
