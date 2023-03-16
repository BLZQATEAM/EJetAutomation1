package com.bridgelabz.ejet.pages.registerwebsitelateral;

import com.bridgelabz.ejet.base.ReadPropertiesFile;
import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Experience_Field extends ReadWebinarPropertiesFile {
    @FindBy(id ="deftyexpr")
    WebElement exp_year;
    @FindBy(xpath="//p[text()='Experience(Years) Required']")
    WebElement error;
    @FindBy(xpath="//div[text()=' None ']")
    WebElement none;
    @FindBy(xpath="//div[text()=' 0 to 6 months ']")
    WebElement zero_to_six_month;
    @FindBy(xpath="//div[text()=' 7 to 12 months ']")
    WebElement seven_to_twelve_month;
    @FindBy(xpath="//div[text()=' 1 - 2 Years ']")
    WebElement one_to_two_year;
    @FindBy(xpath="//div[text()=' 2 - 3 Years ']")
    WebElement two_to_three_year;
    @FindBy(xpath="//div[text()=' 3+ Years ']")
    WebElement above_three_year;

    public Experience_Field(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String experience_Year(String education) throws InterruptedException, AWTException {
        Robot robot = new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        String value = null;
        exp_year.click();
        Thread.sleep(3000);
        if (education.equals("None")) {
            value = none.getText();
            none.click();
        } else if (education.equals("0 to 6 months")) {
            value = zero_to_six_month.getText();
            zero_to_six_month.click();
        } else if (education.equals("7 to 12 months")) {
            value = seven_to_twelve_month.getText();
            seven_to_twelve_month.click();
        } else if (education.equals("1 - 2 Years")) {
            value = one_to_two_year.getText();
            one_to_two_year.click();
        } else if (education.equals("2 - 3 Years")) {
            value = two_to_three_year.getText();
            two_to_three_year.click();
        } else if (education.equals("3+ Years")) {
            value = above_three_year.getText();
            above_three_year.click();
        }
        return value;
    }
    public String empty_Value() throws AWTException, InterruptedException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        exp_year.click();
        Thread.sleep(3000);
        String value =error.getText();
        return value;
    }

}
