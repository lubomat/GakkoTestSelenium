package pl.edu.pjwstk.gakko.tests;

import org.testng.annotations.Test;
import pl.edu.pjwstk.gakko.pages.TasksPage;

public class TasksTest extends BaseTest{

    @Test
    public void addTaskWithMultipleTasksTest() throws InterruptedException {
        TasksPage tasksPage = new TasksPage(driver);
        tasksPage.enterTasksModule();
        tasksPage.addNewTaskPoolWithMultipleTasks(
                "Testowa nazwa puli",
                "Testowa nazwa oceny",
                "2025-05-22 00:00",
                "2025-05-23 00:00",
                "pierwsze zadanie testowe",
                "drugie zadanie testowe");

    }

}
