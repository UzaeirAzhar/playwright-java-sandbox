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
        // Consolidate both secrets and configurations into one properties object
        consolidateProperties("secrets.properties", "configurations.properties");
    }

    private void consolidateProperties(String... fileNames) {
        for (String fileName : fileNames) {
            try (InputStream input = getClass().getClassLoader().getResourceAsStream(fileName)) {
                if (input == null) {
                    logger.error("Unable to find {}", fileName);
                    continue;
                }
                properties.load(input);
                logger.info("{} loaded successfully", fileName);
            } catch (IOException ex) {
                logger.error("Error loading properties from file: {}", fileName, ex);
            }
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
