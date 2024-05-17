package pl.edu.pjwstk.gakko.tests;

import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.GradesPage;

public class GradesTest extends BaseTest{

    @Test
    public void gradeTest() {

        GradesPage gradesPage = new GradesPage(driver);
        gradesPage.enterGradePage();
        gradesPage.addNewGrade("Nazwa Testowa");

    }
}
