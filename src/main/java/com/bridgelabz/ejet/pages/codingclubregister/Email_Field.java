package com.bridgelabz.ejet.pages.codingclubregister;

import com.bridgelabz.ejet.base.ReadPropertiesFile;
import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Email_Field extends ReadWebinarPropertiesFile {
    @FindBy(id="poptemail")
    WebElement txt_email;
    @FindBy(id="poptemailvalid")
    WebElement error;
    @FindBy(xpath="//p[text()='Invalid Email']")
    WebElement invalid_email_msg;
    @FindBy(xpath="//p[text()='Email Required']")
    WebElement email_req_msg;

    public Email_Field(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_email_id(String valid_emailid) throws InterruptedException, AWTException {
        if(!txt_email.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }
        txt_email.sendKeys(valid_emailid);
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=false;
        if (error_msg.equals("Invalid Email")) {
            value= invalid_email_msg.isDisplayed();

        } else if (error_msg.equals("Email Required")) {
            value= email_req_msg.isDisplayed();
        }
        return value;

    }
    public boolean invalid_email_id(String valid_emailid) throws InterruptedException, AWTException {
        if(!txt_email.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }
        txt_email.sendKeys(valid_emailid);
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=invalid_email_msg.isDisplayed();
        return value;

    }

    public boolean user_remove_emailid_From_Field(String valid_emailid) throws InterruptedException, AWTException {
        if(!txt_email.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }
        txt_email.sendKeys(valid_emailid);
        Thread.sleep(3000);
        for (int i=0;i<valid_emailid.length();i++){
            txt_email.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=email_req_msg.isDisplayed();
        return value;
    }
}
