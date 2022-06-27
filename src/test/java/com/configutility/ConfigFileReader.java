package com.configutility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    /**
     * @properties is a Properties class instance
     * @propertyFilePath is path of configuration properties file
     */

    public Properties properties;
    public final String propertyFilePath = "src/test/resources/configs/configuration.properties";

    /**
     * @ileReder() constructor to initialise properties class
     */
    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
