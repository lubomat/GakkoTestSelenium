package pl.edu.pjwstk.gakko.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.GradesPage;

public class GradesTest extends BaseTest{

    @Test
    public void gradeTest() {

        int randomNumber = (int) (Math.random()*1000);

        GradesPage gradesPage = new GradesPage(driver);
        gradesPage.enterGradePage();
        gradesPage.addNewGrade("Nazwa Testowa" + randomNumber);

        Assert.assertTrue(gradesPage.gradesAddSuccessfullyMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getSuccessfullyMessage(),"Ocena została zapisana pomyślnie");

    }

}
