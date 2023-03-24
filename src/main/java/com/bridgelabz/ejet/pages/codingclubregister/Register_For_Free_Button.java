package com.bridgelabz.ejet.pages.codingclubregister;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Register_For_Free_Button extends ReadWebinarPropertiesFile {
    @FindBy(id="poptsbtn")
    WebElement btn_room;

    JavascriptExecutor js = (JavascriptExecutor) driver;
    public Register_For_Free_Button(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void click_enable_Button() throws InterruptedException {
        js.executeScript("window.scrollBy(0,500)");
        String classValue = btn_room.getAttribute("class");
        Thread.sleep(3000);
        btn_room.click();
        System.out.println(classValue);
    }
    public void click_disable_Button() throws InterruptedException {
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        String classValue = btn_room.getAttribute("class");
        btn_room.click();
        System.out.println(classValue);
    }

    public void submitEnable_Button() throws InterruptedException {
        String classValue = btn_room.getAttribute("class");
        Thread.sleep(3000);
        btn_room.click();
        System.out.println(classValue);
    }
}
