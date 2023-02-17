package com.bridgelabz.ejet.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass extends ReadPropertiesFile {
    public WebDriver driver;

    public void initialization() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://bldev.bridgelabz.com/attendorientation?fc=Scholarship&sc=WBR-SCH-EMAIL&ab_webinar=true&id=");
        driver.get(properties.getProperty("webinarLandingPage_URL"));
        Thread.sleep(1000);
    }
}
