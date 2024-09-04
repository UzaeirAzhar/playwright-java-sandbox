package com.playwright.practice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SecretsConfig {
    private Properties properties = new Properties();

    public SecretsConfig() {
        loadProperties("secrets.properties");
        loadProperties("configurations.properties");
    }

    private void loadProperties(String fileName) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find secrets.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getUrl() {
        return properties.getProperty("nbc.url");
    }

    public String getStudentEmail() {
        return properties.getProperty("student.email");
    }

    public String getStudentPassword() {
        return properties.getProperty("student.password");
    }

    public String getTeacherEmail() {
        return properties.getProperty("teacher.email");
    }

    public String getTeacherPassword() {
        return properties.getProperty("teacher.password");
    }
}
