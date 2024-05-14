package pl.edu.pjwstk.gakko.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    public Map<String, String> readLoginDataFromFile(String filePath) {
        Map<String, String> loginData = new HashMap<>();
        Properties properties = new Properties();

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
            loginData.put("login", properties.getProperty("login"));
            loginData.put("password", properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loginData;
    }
}
