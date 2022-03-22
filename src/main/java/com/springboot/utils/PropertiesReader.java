package com.springboot.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created This class to read values from properties in
 * config.properties file
 */
public class PropertiesReader {

    private static String Par = "";

    public static String ReadData(String par, String fileName) throws Exception {
        File file = new File("src/main/resources/" + fileName);
        FileInputStream fileInput = null;
        Properties prop = new Properties();
        try {
            fileInput = new FileInputStream(file);
        } catch (Exception e) {

            throw new Exception("Please create a property file.");
        }

        try {
            prop.load(fileInput);
        } catch (Exception e) {
            throw new Exception("Please check property file Inputs.");
        }

        return Par = prop.getProperty(par);
    }

}