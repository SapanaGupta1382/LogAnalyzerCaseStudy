package com.mycasestudy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class util {
    public static int getProperties() {
        int maxEntries=0;
        try (InputStream input = new FileInputStream("C:/Projects/mycasestudy/src/main/resources/logAnalyzer.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            // get the property value and print it out
            maxEntries = Integer.parseInt(prop.getProperty("logAnalyzer.maxEnteries"));
            return maxEntries;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return maxEntries;
    }
}
