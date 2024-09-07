package com.playwright.practice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SecretsConfig {
    private static final Logger logger = LoggerFactory.getLogger(SecretsConfig.class);
    private Properties properties = new Properties();

    public SecretsConfig() {
        loadProperties("secrets.properties");
        loadProperties("configurations.properties");
    }

    private void loadProperties(String fileName) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                logger.error("Unable to find {}", fileName);
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            logger.error("Error loading properties from file: {}", fileName, ex);
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
