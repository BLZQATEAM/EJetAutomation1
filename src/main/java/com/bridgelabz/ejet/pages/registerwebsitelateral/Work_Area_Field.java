package com.bridgelabz.ejet.pages.registerwebsitelateral;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Work_Area_Field extends ReadWebinarPropertiesFile {
    @FindBy(id ="deftwarea")
    WebElement work_area;
    @FindBy(xpath="//p[text()='Work Area Required']")
    public WebElement error;
    @FindBy(xpath="//div[text()=' Software Development ']")
    public WebElement software_dev;
    @FindBy(xpath="//div[text()=' DBA/SQL Developer ']")
    public WebElement db_dev;
    @FindBy(xpath="//div[text()=' Frontend - HTML/CSS ']")
    public WebElement frontend;
    @FindBy(xpath="//div[text()=' Manual QA ']")
    public WebElement manual_qa;
    @FindBy(xpath="//div[text()=' MIS/Data Analyst ']")
    public WebElement data_analyst;
    @FindBy(xpath="//div[text()=' Tech Support ']")
    public WebElement tech_support;
    @FindBy(xpath="//div[text()=' Non IT ']")
    public WebElement non_it;
    @FindBy(xpath="//div[text()=' Not Applicable ']")
    public WebElement NA;

    public Work_Area_Field(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String work_Area(String education) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        String value = null;
        work_area.click();
        Thread.sleep(3000);
        if (education.equals("Software Development")) {
            value = software_dev.getText();
            software_dev.click();
        } else if (education.equals("DBA/SQL Developer")) {
            value = db_dev.getText();
            db_dev.click();
        } else if (education.equals("Frontend - HTML/CSS")) {
            value = frontend.getText();
            frontend.click();
        } else if (education.equals("Manual QA")) {
            value = manual_qa.getText();
            manual_qa.click();
        } else if (education.equals("MIS/Data Analyst")) {
            value = data_analyst.getText();
            data_analyst.click();
        } else if (education.equals("Tech Support")) {
            value = tech_support.getText();
            tech_support.click();
        }else if (education.equals("Non IT")) {
            value = non_it.getText();
            non_it.click();
        }else if (education.equals("Not Applicable")) {
            value = NA.getText();
            NA.click();
        }
        return value;
    }
    public String empty_Value() throws AWTException, InterruptedException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        work_area.click();
        Thread.sleep(3000);
        String value =error.getText();
        return value;
    }
}
