package pl.edu.pjwstk.gakko.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.BibliographyPage;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BibliographyTest extends BaseTest {

    @Test
    public void addBookTest() {
        BibliographyPage bibliographyPage = new BibliographyPage(driver);
        bibliographyPage.enterBibliographyModule();
        bibliographyPage.createBook(
                "Title Test",
                "Author Test",
                "Publisher Test",
                "Comment Test");
        Path filePath = Paths.get("src/test/resources/coverBookTest.jpg").toAbsolutePath();
        bibliographyPage.uploadCoverFile(filePath.toString());
        bibliographyPage.clickSave();

        Assert.assertTrue(bibliographyPage.bookAddedAlertMessage.isDisplayed());
        Assert.assertEquals(bibliographyPage.getMessage(),"Książka została zapisana pomyślnie");
    }

}
