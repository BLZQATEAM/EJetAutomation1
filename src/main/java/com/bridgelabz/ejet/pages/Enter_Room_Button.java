package com.bridgelabz.ejet.pages;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Enter_Room_Button extends BaseClass {
    @FindBy(xpath="//span[contains(text(),'ENTER ROOM')]")
    WebElement btn_room;

    public Enter_Room_Button(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean clickEnter() throws InterruptedException {
        Thread.sleep(3000);
        boolean value = btn_room.isEnabled();
        btn_room.click();
        Thread.sleep(3000);
        return value;
    }

}
