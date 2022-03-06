package com.getYourLawyer.utilities;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class's main responsibility is reading data's from the configuration.properties file
 */

public class ConfigurationReader {

    private static Properties properties;

    static {

        try {
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {

        return properties.getProperty(keyName);
    }


}