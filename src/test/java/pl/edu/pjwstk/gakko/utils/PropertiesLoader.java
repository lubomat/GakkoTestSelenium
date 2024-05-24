package pl.edu.pjwstk.gakko.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

    private static final Logger logger = LogManager.getLogger();
    public Map<String, String> readLoginDataFromFile(String filePath) {
        Map<String, String> loginData = new HashMap<>();
        Properties properties = new Properties();

        try {
            logger.info("Opening file: login_credentials.txt ");
            FileInputStream inputStream = new FileInputStream(filePath);
            logger.info("File opened successfully.");
            logger.info("Loading properties from file.");
            properties.load(inputStream);
            logger.info("Properties loaded successfully.");
            logger.info("Reading login property.");
            loginData.put("login", properties.getProperty("login"));
            logger.debug("Reading login successfully.");
            logger.info("Reading password property.");
            loginData.put("password", properties.getProperty("password"));
            logger.info("Reading password property successfully.");
        } catch (IOException e) {
            logger.error("An error occurred white reading the file login_credentials.txt");
        }
        return loginData;
    }
}
