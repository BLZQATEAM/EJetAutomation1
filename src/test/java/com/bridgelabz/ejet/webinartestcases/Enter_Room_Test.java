package com.bridgelabz.ejet.testcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.webinar.Enter_Room_Button;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class Enter_Room_Test extends BaseClass {
    Enter_Room_Button enterRoom;

    public Enter_Room_Test() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        enterRoom = new Enter_Room_Button(driver);
    }
    @Test
    public void click_EnterButton() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        boolean msg = enterRoom.clickEnter();
        Assert.assertTrue(msg);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
