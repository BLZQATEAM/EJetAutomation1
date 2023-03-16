package com.bridgelabz.ejet.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass extends ReadPropertiesFile {
    public WebDriver driver;

    public void initialization() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.get("https://bldev.bridgelabz.com/attendorientation?fc=Scholarship&sc=WBR-SCH-EMAIL&ab_webinar=true&id=");
        driver.get(properties.getProperty("webinarLandingPage_URL"));
        Thread.sleep(1000);
    }
}
