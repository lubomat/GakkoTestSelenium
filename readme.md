# PJWSTK GakkoTest Selenium Automation Project

This project automates various functionalities of the **Gakko** application using **Selenium** and **TestNG**. It is designed to test modules such as Announcements, Forum, Grades, Lessons, and Tasks.

## Features
- Automates tests for various modules: **Announcements**, **Forum**, **Grades**, **Lessons**, and **Tasks**.
- Uses **Page Object Model (POM)** for better test maintainability.
- Includes screenshot capture for debugging and reporting.
- Reports test results using **Extent Reports**.
- Centralized configuration via a `login_credentials.txt` file for login credentials.

## Modules Automated
- Announcements: Create, edit, and delete announcements
- Forum: Create, edit, delete threads, and add messages.
- Grades: Add, edit, and delete grades.
- Lessons: Create lessons with chapters, including special chapter types like "Show Answer".
- Tasks: Create task pools with multiple tasks and delete task pools.
- Reporting:
  The project generates detailed reports using Extent Reports.
  Reports include test results and screenshots.

## Technologies Used
- **Java** - Programming language.
- **Selenium WebDriver** - Browser automation.
- **TestNG** - Test framework.
- **Extent Reports** - Reporting library.
- **Log4j** - Logging framework.
- **Maven** - Dependency and project management.

### Project Structure

- **index.html** - Extent report file generated after running tests.
- **pom.xml** - Maven configuration and dependencies.

#### `src/`
- **main/**
    - **java/**
        - **org.example/**
            - `Main.java` - Entry point of the application.
    - **resources/**
        - **login_credentials.txt** - File containing login credentials.

- **test/**
    - **java/**
        - **pl.edu.pjwstk.gakko/**
            - **pages/**
                - `AnnouncementPage.java` - Handles announcement module interactions.
                - `ForumPage.java` - Handles forum module interactions.
                - `GradesPage.java` - Handles grades module interactions.
                - `LessonsPage.java` - Handles lessons module interactions.
                - `LoginPage.java` - Handles login interactions.
                - `TasksPage.java` - Handles tasks module interactions.
            - **tests/**
                - `AnnouncementTest.java` - Test cases for announcements.
                - `ForumTest.java` - Test cases for forum.
                - `GradesTest.java` - Test cases for grades.
                - `LessonsTest.java` - Test cases for lessons.
                - `TasksTest.java` - Test cases for tasks.
            - **utils/**
                - `PropertiesLoader.java` - Utility to load properties.
                - `SeleniumHelper.java` - Helper methods for Selenium.
    - **resources/**
        - **screenshots/** - Directory for screenshots taken during tests.
        - **log4j2.xml** - Configuration for logging.


## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/lubomat/gakkoTest.git
   cd gakkoTest
   
2. Create a configuration file for login credentials:
   - Navigate to the src/config directory.
   - Create a file named login_credentials.txt.
   - Add your login credentials: 
       login=your-username
       password=your-password



