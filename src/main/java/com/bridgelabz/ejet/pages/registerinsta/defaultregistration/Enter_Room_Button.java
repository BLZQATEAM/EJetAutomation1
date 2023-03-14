package com.bridgelabz.ejet.pages.registerinsta.defaultregistration;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Enter_Room_Button extends ReadWebinarPropertiesFile {
    @FindBy(id="deftsbtn")
    WebElement btn_room;
    public Enter_Room_Button(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String click_enable_EnterButton() throws InterruptedException, AWTException {

        String classValue = btn_room.getAttribute("class");
        Thread.sleep(3000);
        btn_room.click();
        System.out.println(classValue);
        return classValue;
    }
    public String click_disable_EnterButton() throws InterruptedException, AWTException {
        Robot robot=new Robot();
        //robot.mouseWheel(5);
        btn_room.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        String classValue = btn_room.getAttribute("class");
        btn_room.click();
        System.out.println(classValue);
        return classValue;
    }

}
