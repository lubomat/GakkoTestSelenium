package pl.edu.pjwstk.gakko.tests;

import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.LessonsPage;

public class LessonsTest extends BaseTest {

    @Test
    public void addEmptyLessonTest() throws InterruptedException {
        LessonsPage lessonsPage = new LessonsPage(driver);
        lessonsPage.enterLessonsModule();
        lessonsPage.addEmptyLesson("Test","2025-09-13 13:00");
    }

    @Test
    public void addLessonWithChapterTest() throws InterruptedException {
        LessonsPage lessonsPage = new LessonsPage(driver);
        lessonsPage.enterLessonsModule();
        lessonsPage.addNewWithChapterLesson(
                "Test",
                "2025-09-13 13:00");
    }

}
