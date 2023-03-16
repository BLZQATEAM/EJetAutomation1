package com.bridgelabz.ejet.webinartestcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.Email_Field;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class Email_Field_Test extends BaseClass {
    Email_Field email;

    public Email_Field_Test() {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        email = new Email_Field(driver);
    }
    @Test
    public void enter_valid_emailId() throws InterruptedException {
        boolean msg=email.valid_email_id("mythiliannamalai45@gmail.com");
        Assert.assertFalse(msg);
    }
    @Test
    public void enter_emptyString_emailField() throws InterruptedException {
        boolean msg=email.invalid_email_id(" ");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void enter_invalid_emailId() throws InterruptedException {
        boolean msg=email.invalid_email_id("@gmail.com");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void enter_emailId_with_space() throws InterruptedException {
        boolean msg=email.invalid_email_id("mythiliannamalai45 @gmail.com");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void after_space_enter_valid_email() throws InterruptedException {
        boolean msg=email.invalid_email_id(" mythiliannamalai45@gmail.com");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void without_dot_enter_email() throws InterruptedException {
        boolean msg=email.invalid_email_id("mythiliannamalai45@gmailcom");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void without_at_enter_email() throws InterruptedException {
        boolean msg=email.invalid_email_id("mythiliannamalai45gmail.com");
        Assert.assertTrue(msg,"Invalid Email");
    }
    @Test
    public void without_dotcom_enter_email() throws InterruptedException {
        boolean msg=email.invalid_email_id("mythiliannamalai45@gmail");
        Assert.assertTrue(msg,"Invalid Email");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
