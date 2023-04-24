package com.bridgelabz.ejet.pages.codingclubworkshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.IOException;

public class Register_For_Free_Button {
    WebDriver driver;

    @FindBy(id="poptsbtn")
    WebElement btn_room;
    public Register_For_Free_Button(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void click_enable_Button() throws InterruptedException, AWTException {
        if(!btn_room.isDisplayed()){
            Robot robot=new Robot();
            robot.mouseWheel(5);
        }
        String classValue = btn_room.getAttribute("class");
        Thread.sleep(3000);
        btn_room.click();
        System.out.println(classValue);

    }
    public void click_disable_Button() throws InterruptedException, AWTException {
        Robot robot=new Robot();
        robot.mouseWheel(5);
        Thread.sleep(3000);
        String classValue = btn_room.getAttribute("class");
        btn_room.click();
        System.out.println(classValue);
    }
}
