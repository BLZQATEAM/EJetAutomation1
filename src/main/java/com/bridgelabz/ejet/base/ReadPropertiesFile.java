package com.bridgelabz.ejet.base;


import java.io.*;
import java.util.Properties;

public class ReadPropertiesFile {
    public Properties properties;
    private final String propertyFilePath= "C:\\Users\\dell\\Documents\\QADevPrograms\\EJetTestScript\\src\\main\\java\\com\\bridgelabz\\ejet\\testdata\\TestData.properties";

    public ReadPropertiesFile(){
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
}
