package com.bridgelabz.ejet.pages.codingclubregister;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Full_Name_Field extends ReadWebinarPropertiesFile {
    @FindBy(id="poptusername")
    WebElement txt_uname;
    @FindBy(id="poptuservalid")
    WebElement error;
    @FindBy(xpath="//p[text()='You must enter a Full Name']")
    WebElement username_err_msg1;
    @FindBy(xpath="//p[text()='First Name Min 3 character required']")
    WebElement username_err_msg2;
    @FindBy(xpath="//p[text()='Please enter first & last name (min. 3 letters each) separated by a space.']")
    WebElement username_err_msg3;
    @FindBy(xpath="//p[text()='Name must contain alphabetic only']")
    WebElement username_err_msg4;
    @FindBy(xpath="//p[text()='No space after fullname and character']")
    WebElement username_err_msg5;
    @FindBy(xpath="//p[text()='No space after first & last name']")
    WebElement username_err_msg6;

    public Full_Name_Field(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_FullName(String valid_name) throws InterruptedException, AWTException {
        if(!txt_uname.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }

        txt_uname.sendKeys(valid_name);
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=false;
        if (error_msg.equals("You must enter a Full Name")) {
            value= username_err_msg1.isDisplayed();
        } else if (error_msg.equals("First Name Min 3 character required")) {
            value= username_err_msg2.isDisplayed();
        } else if (error_msg.equals("Please enter first & last name (min. 3 letters each) separated by a space.")) {
            value= username_err_msg3.isDisplayed();
        } else if (error_msg.equals("Name must contain alphabetic only")) {
            value= username_err_msg4.isDisplayed();
        } else if (error_msg.equals("No space after fullname and character")) {
            value= username_err_msg5.isDisplayed();
        } else if (error_msg.equals("No space after first & last name")) {
            value= username_err_msg6.isDisplayed();
        }
        for(int i=0;i<valid_name.length();i++){
            txt_uname.sendKeys(Keys.BACK_SPACE);
        }
        return value;
    }
    public boolean invalid_FullName(String invalid_name) throws InterruptedException, AWTException {
        if(!txt_uname.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }
        txt_uname.sendKeys(invalid_name);
        Thread.sleep(3000);
        String error_msg=error.getText();
        boolean value=false;
        if (error_msg.equals("First Name Min 3 character required")) {
            value= username_err_msg2.isDisplayed();
        } else if (error_msg.equals("Please enter first & last name (min. 3 letters each) separated by a space.")) {
            value= username_err_msg3.isDisplayed();
        } else if (error_msg.equals("Name must contain alphabetic only")) {
            value= username_err_msg4.isDisplayed();
        } else if (error_msg.equals("No space after fullname and character")) {
            value= username_err_msg5.isDisplayed();
        } else if (error_msg.equals("No space after first & last name")) {
            value= username_err_msg6.isDisplayed();
        }

        for(int i=0;i<invalid_name.length();i++){
            txt_uname.sendKeys(Keys.BACK_SPACE);
        }
        return value;
    }
    public boolean removing_Value_From_FullNameField(String name) throws InterruptedException, AWTException {
        if(!txt_uname.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }
        txt_uname.sendKeys(name);
        Thread.sleep(3000);
        for (int i=0;i<name.length();i++){
            txt_uname.sendKeys(Keys.BACK_SPACE);
        }
        String error_msg=error.getText();
        boolean  value= username_err_msg1.isDisplayed();

        for(int i=0;i<name.length();i++){
            txt_uname.sendKeys(Keys.BACK_SPACE);
        }
        return value;
    }

}
