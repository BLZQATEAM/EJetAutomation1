package com.bridgelabz.ejet.pages.registerinsta.popupregisterinsta;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Aggregate_Percentage extends ReadWebinarPropertiesFile {
    @FindBy(id = "poptcgpa")
    WebElement aggregate_drpdwn;
    @FindBy(xpath = "(//div[text()=' Below 60% '])[2]")
    WebElement below_sixty;
    @FindBy(xpath = "(//div[text()=' 60% - 70% '])[2]")
    WebElement sixty_to_seventy;
    @FindBy(xpath = "(//div[text()=' 70% and Above '])[2]")
    WebElement above_seventy;
    @FindBy(xpath = "//p[text()='CGPA Required']")
    WebElement aggregate_req_msg;

    public Aggregate_Percentage(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public String aggregate_Per(String percentage) throws AWTException, InterruptedException {
        Robot robot=new Robot();
        aggregate_drpdwn.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        String value = null;
        aggregate_drpdwn.click();
        Thread.sleep(3000);
        if (percentage.equals("Below 60%")) {
            value=below_sixty.getText();
            below_sixty.click();
        } else if (percentage.equals("60% - 70%")) {
            value=sixty_to_seventy.getText();
            sixty_to_seventy.click();
        } else if (percentage.equals("70% and Above")) {
            value=above_seventy.getText();
            above_seventy.click();
        }
        return value;
    }
    public String empty_Value() throws AWTException, InterruptedException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        aggregate_drpdwn.click();
        Thread.sleep(3000);
        String value =aggregate_req_msg.getText();
        return value;
    }
    public void aggregate_Per_EnterBtn(String percentage) throws InterruptedException {
        Thread.sleep(3000);
        String value = null;
        aggregate_drpdwn.click();
        Thread.sleep(3000);
        if (percentage.equals("Below 60%")) {
            value=below_sixty.getText();
            below_sixty.click();
        } else if (percentage.equals("60% - 70%")) {
            value=sixty_to_seventy.getText();
            sixty_to_seventy.click();
        } else if (percentage.equals("70% and Above")) {
            value=above_seventy.getText();
            above_seventy.click();
        }
    }
}
