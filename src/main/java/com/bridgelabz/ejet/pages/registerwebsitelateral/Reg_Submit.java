package com.bridgelabz.ejet.pages.registerwebsitelateral;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Reg_Submit extends ReadWebinarPropertiesFile {
    @FindBy(id ="deftsbtn")
    WebElement btn_submit;

    public Reg_Submit(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void click_enable_EnterButton() throws InterruptedException, AWTException {
        String classValue = btn_submit.getAttribute("class");
        Thread.sleep(3000);
        btn_submit.click();
        System.out.println(classValue);

    }
    public void click_disable_EnterButton() throws InterruptedException, AWTException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
//        String classValue = btn_submit.getAttribute("class");
        btn_submit.click();
    }
}
