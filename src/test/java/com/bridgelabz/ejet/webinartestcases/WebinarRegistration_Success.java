package com.bridgelabz.ejet.webinartestcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.WebinarRegistration_Page;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class WebinarRegistration_Success extends BaseClass {
    WebinarRegistration_Page page;
    @BeforeTest
    public void setUp() throws InterruptedException {
        initialization();
        page = new WebinarRegistration_Page(driver);
    }

    @Test
    public void webinarUserRegistrationSuccess_AndRedirectOnAttendOrientationScreen() throws InterruptedException, IOException {
        page.enterData_InFields();
        boolean msg = page.clickEnter();
        Thread.sleep(3000);
        Assert.assertTrue(msg);
        //page.dataValidation();
    }

    @AfterTest
    public void close_Browser(){
        driver.close();
    }
}
