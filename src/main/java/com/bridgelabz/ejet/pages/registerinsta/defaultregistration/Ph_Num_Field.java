package com.bridgelabz.ejet.pages.registerinsta.defaultregistration;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Ph_Num_Field extends ReadWebinarPropertiesFile {
    @FindBy(id="deftphnumber")
    WebElement txt_ph;
    @FindBy(id="defphicon")
    WebElement tick_icon;
    //    @FindBy(id="deftphnumbervalid")
//    WebElement error;
    @FindBy(xpath="//p[text()='Invalid Phone Number']")
    WebElement invalid_ph_num_msg;
    @FindBy(xpath="//p[text()='Phone Number Required']")
    WebElement ph_num_req_msg;

    public Ph_Num_Field(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean valid_phNumber(String ph) throws InterruptedException {
        txt_ph.sendKeys(ph);
        Thread.sleep(3000);
        boolean icon = tick_icon.isDisplayed();
        return icon;
    }
    public Boolean invalid_PhNumber(String invalid_ph) throws InterruptedException {
        txt_ph.sendKeys(invalid_ph);
        Thread.sleep(3000);
        boolean value= invalid_ph_num_msg.isDisplayed();
        return value;
    }

    public Boolean user_Remove_Invalid_PhNum_From_PhField(String num) throws InterruptedException {
        txt_ph.sendKeys(num);
        Thread.sleep(3000);
        for (int i=0;i<num.length();i++){
            txt_ph.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        boolean value= ph_num_req_msg.isDisplayed();
        return value;
    }
    public Boolean user_Remove_Valid_PhNum_From_PhField(String num) throws InterruptedException {
        txt_ph.sendKeys(num);
        Thread.sleep(3000);
        for (int i=0;i<num.length();i++){
            txt_ph.sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(3000);
        boolean value= tick_icon.isDisplayed();
        return value;
    }

}
