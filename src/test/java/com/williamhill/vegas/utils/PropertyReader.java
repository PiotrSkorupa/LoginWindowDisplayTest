package com.williamhill.vegas.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    Properties properties;

    InputStream inputStream = null;

    public PropertyReader() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try {
            inputStream = new FileInputStream("src/test/java/com/williamhill/vegas/resources/Config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.print("Unable to load Config.properties");
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }
}

