package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public abstract class TestRunner {
    public Properties props = loadProperties();

    public Properties loadProperties() {
        Properties properties = new Properties();

        try {
            InputStream propertiesFile = getClass().getClassLoader().getResourceAsStream("testData.properties");
            properties.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}