package com.bridgelabz.ejet.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReadWebinarPropertiesFile {
    public static WebDriver driver = null;
    public Properties prop;
    public ReadWebinarPropertiesFile() throws IOException {
        prop = new Properties();
        FileInputStream ip;
        ip = new FileInputStream(
                "C:\\Users\\dell\\Documents\\QADevPrograms\\EJetTestScript\\src\\main\\java\\com\\bridgelabz\\ejet\\testdata\\Webinar.properties");
        prop.load(ip);

    }
    public void  initialization(String url){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        if(url.equals(prop.getProperty("Reg_Url"))){
            driver.get(prop.getProperty("Reg_Url"));
        }else if (url.equals(prop.getProperty("Orientation_Url"))){
            driver.get(prop.getProperty("Orientation_Url"));
        }else if(url.equals(prop.getProperty("RegistrationInsta"))){
            driver.get(prop.getProperty("RegistrationInsta"));
        }else if(url.equals(prop.getProperty("RegisterWebsiteLateral"))){
            driver.get(prop.getProperty("RegisterWebsiteLateral"));
        }else if(url.equals(prop.getProperty("indexPage_Url"))){
            driver.get(prop.getProperty("indexPage_Url"));
        }else if (url.equals(prop.getProperty("RegisterWebsiteUserUrl"))){
            driver.get(prop.getProperty("RegisterWebsiteUserUrl"));
        }
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
