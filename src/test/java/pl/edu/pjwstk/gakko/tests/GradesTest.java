package pl.edu.pjwstk.gakko.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.GradesPage;

public class GradesTest extends BaseTest{

    @Test
    public void addGradeTest() {

        int randomNumber = (int) (Math.random()*1000);

        GradesPage gradesPage = new GradesPage(driver);
        gradesPage.enterGradePage();
        gradesPage.addNewGrade("Nazwa Testowa" + randomNumber);

        Assert.assertTrue(gradesPage.gradesAddMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(),"Ocena została zapisana pomyślnie");

    }

    @Test
    public void addGradeWithSameNameTest() {

        GradesPage gradesPage = new GradesPage(driver);
        gradesPage.enterGradePage();
        gradesPage.addNewGrade("Nazwa Testowa");

        Assert.assertTrue(gradesPage.gradesAddMessage.isDisplayed());
        Assert.assertEquals(gradesPage.getMessage(),"Ocena o identycznych parametrach już istnieje");

    }

}
