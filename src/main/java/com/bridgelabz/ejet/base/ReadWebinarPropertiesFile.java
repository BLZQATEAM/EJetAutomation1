package com.bridgelabz.ejet.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReadWebinarPropertiesFile {
    public WebDriver driver;
    public Properties prop;
    public ReadWebinarPropertiesFile() throws IOException {
        prop = new Properties();
        FileInputStream ip;
        ip = new FileInputStream(
                "C:\\Users\\dell\\Documents\\QADevPrograms\\EJetTestScript\\src\\main\\java\\com\\bridgelabz\\ejet\\testdata\\Webinar.properties");
        prop.load(ip);

    }
    public void  initialization(String url){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
        if(url.equals(prop.getProperty("Reg_Url"))){
            driver.get(prop.getProperty("Reg_Url"));
        }else if (url.equals(prop.getProperty("Orientation_Url"))){
            driver.get(prop.getProperty("Orientation_Url"));
        }else if(url.equals(prop.getProperty("RegistrationInsta"))){
            driver.get(prop.getProperty("RegistrationInsta"));
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
