package com.bridgelabz.ejet.pages.webinar;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Phone_Number_Field extends BaseClass {
    @FindBy(id="deftphnumber")
    WebElement phone_Number;
    @FindBy(id="deftphnumbervalid")
    WebElement invalid_ph_no_msg;
    @FindBy(id="defphicon")
    WebElement ph_no_icon;

    public Phone_Number_Field(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String verify_Error_Msg_1(String phn_no) {
        phone_Number.sendKeys(phn_no);
        String invalid_msg = invalid_ph_no_msg.getText();
        return invalid_msg;
    }
    public boolean verify_Tick_Icon(String valid_phn_no){
        phone_Number.sendKeys(valid_phn_no);
        Boolean icon = ph_no_icon.isDisplayed();
        return icon;
    }
    public void phoneNumberExist(){
        phone_Number.sendKeys("7038053686");
    }
}
