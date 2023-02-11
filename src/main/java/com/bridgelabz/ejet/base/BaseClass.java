package com.bridgelabz.ejet.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public WebDriver driver;

    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bldev.bridgelabz.com/attendorientation?fc=Scholarship&sc=WBR-SCH-EMAIL&ab_webinar=true&id=");
        Thread.sleep(1000);
    }
}
