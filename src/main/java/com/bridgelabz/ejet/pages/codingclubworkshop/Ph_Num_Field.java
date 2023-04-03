package com.bridgelabz.ejet.pages.codingclubworkshop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Ph_Num_Field {
    WebDriver driver;
    @FindBy(id="poptphnumber")
    WebElement txt_ph;
    @FindBy(id="popphicon")
    WebElement tick_icon;
    @FindBy(id="poptphnumbervalid")
    WebElement error;
    @FindBy(xpath="//p[text()='Invalid Phone Number']")
    WebElement invalid_ph_num_msg;
    @FindBy(xpath="//p[text()='Phone Number Required']")
    WebElement ph_num_req_msg;

    public Ph_Num_Field(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_phNumber(String ph) throws InterruptedException, AWTException {
        if(!error.isDisplayed()){
            JavascriptExecutor jsexe = (JavascriptExecutor)driver;
            jsexe.executeScript("window.scrollBy(0,500)");
        }
        Thread.sleep(3000);
        txt_ph.sendKeys(ph);
        Thread.sleep(3000);
        boolean icon = tick_icon.isDisplayed();
        for (int i=0;i<ph.length();i++){
            txt_ph.sendKeys(Keys.BACK_SPACE);
        }
        return icon;
    }
    public Boolean invalid_PhNumber(String invalid_ph) throws InterruptedException, AWTException {
        if(!error.isDisplayed()){
            JavascriptExecutor jsexe = (JavascriptExecutor)driver;
            jsexe.executeScript("window.scrollBy(0,500)");
        }
        txt_ph.sendKeys(invalid_ph);
        Thread.sleep(3000);
        boolean value= invalid_ph_num_msg.isDisplayed();
        for(int i=0;i<invalid_ph.length();i++){
            txt_ph.sendKeys(Keys.BACK_SPACE);
        }
        return value;
    }

    public Boolean user_Remove_Invalid_PhNum_From_PhField(String num) throws InterruptedException, AWTException {
        if(!error.isDisplayed()){
            JavascriptExecutor jsexe = (JavascriptExecutor)driver;
            jsexe.executeScript("window.scrollBy(0,500)");
        }
        txt_ph.sendKeys(num);
        Thread.sleep(3000);
        for (int i=0;i<num.length();i++){
            txt_ph.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        boolean value= ph_num_req_msg.isDisplayed();
        return value;
    }
    public Boolean user_Remove_Valid_PhNum_From_PhField(String num) throws InterruptedException, AWTException {
        if(!error.isDisplayed()){
            JavascriptExecutor jsexe = (JavascriptExecutor)driver;
            jsexe.executeScript("window.scrollBy(0,500)");
        }
        txt_ph.sendKeys(num);
        Thread.sleep(3000);
        for (int i=0;i<num.length();i++){
            txt_ph.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        boolean value= tick_icon.isDisplayed();
        return value;
    }
    public void user_PhNum_From_PhField(String num) {
        if (!error.isDisplayed()) {
            JavascriptExecutor jsexe = (JavascriptExecutor) driver;
            jsexe.executeScript("window.scrollBy(0,500)");
        }
        txt_ph.sendKeys(num);
    }
}
