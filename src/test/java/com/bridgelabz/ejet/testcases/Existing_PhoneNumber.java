package com.bridgelabz.ejet.testcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.Phone_No_Field;
import com.bridgelabz.ejet.pages.WebinarRegistration_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Existing_PhoneNumber extends BaseClass {
    Phone_No_Field number;
    WebinarRegistration_Page page;

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        initialization();
        number = new Phone_No_Field(driver);
        page = new WebinarRegistration_Page(driver);
    }

    @Test
    public void verifyExistingPhoneNumber_registration() throws InterruptedException {
        number.phoneNumberExist();
        boolean msg = page.clickEnter();
        Thread.sleep(3000);
        Assert.assertTrue(msg);
    }

    @AfterMethod
    public void close_Browser(){
        driver.close();
    }
}
