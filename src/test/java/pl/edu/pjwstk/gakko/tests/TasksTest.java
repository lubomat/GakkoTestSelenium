package pl.edu.pjwstk.gakko.tests;

import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.TasksPage;

public class TasksTest extends BaseTest{

    @Test
    public void addTaskTest() {
        TasksPage tasksPage = new TasksPage(driver);
        tasksPage.enterTasksModule();

    }
}
