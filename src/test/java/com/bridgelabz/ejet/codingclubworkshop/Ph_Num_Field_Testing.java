package com.bridgelabz.ejet.codingclubworkshop;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.codingclubworkshop.Ph_Num_Field;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Ph_Num_Field_Testing extends ReadWebinarPropertiesFile {

    Ph_Num_Field ph;

    public Ph_Num_Field_Testing() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("CodingClub_Workshop"));
        ph = new Ph_Num_Field(driver);
    }
    @Test(priority=1)
    public void new_User_Enter_Valid_PhNumber() throws InterruptedException, AWTException {

        boolean ph_tick_icon = ph.valid_phNumber(prop.getProperty("Valid_PhNumber"));
        Assert.assertTrue(ph_tick_icon);
    }
    @Test(priority=2)
    public void new_User_Enter_EmptyString() throws InterruptedException, AWTException {
        boolean msg=ph.invalid_PhNumber(" ");
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=3)
    public void new_User_Enter_SpecialChar() throws InterruptedException, AWTException {
        boolean msg=ph.invalid_PhNumber(prop.getProperty("SpecialChar_PhNumber"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=4)
    public void new_User_Enter_Character() throws InterruptedException, AWTException {
        boolean msg=ph.invalid_PhNumber(prop.getProperty("Char_PhNumber"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=5)
    public void new_User_Enter_Space_Between_PhNumber() throws InterruptedException, AWTException {
        boolean msg=ph.invalid_PhNumber(prop.getProperty("Space_PhNumber"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=6)
    public void new_User_Enter_plus_NinetyOne() throws InterruptedException, AWTException {
        boolean msg=ph.invalid_PhNumber(prop.getProperty("Plus_NinetyOne_PhNumber"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=7)
    public void new_User_Enter_plus_NinetyOne_And_Hyphen() throws InterruptedException, AWTException {
        boolean msg=ph.invalid_PhNumber(prop.getProperty("Plus_NinetyOne_Hyphen"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=8)
    public void new_User_Enter_NineDigit_PhNumber() throws InterruptedException, AWTException {
        boolean msg=ph.user_Remove_Invalid_PhNum_From_PhField(prop.getProperty("Nine_Digit_PhNumber"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Invalid Phone Number");
    }
    @Test(priority=9)
    public void new_User_After_Enter_InValidData_RemoveData_Form_PhField() throws InterruptedException, AWTException {
        boolean msg=ph.user_Remove_Invalid_PhNum_From_PhField(prop.getProperty("Nine_Digit_PhNumber"));
        System.out.println(msg);
        Assert.assertTrue(msg,"Phone Number Required");
    }
    @Test(priority=10)
    public void new_User_After_Enter_ValidData_RemoveData_Form_PhField() throws InterruptedException, AWTException {
        boolean msg=ph.user_Remove_Valid_PhNum_From_PhField(prop.getProperty("Valid_PhNumber"));
        System.out.println(msg);
        Assert.assertFalse(msg);
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
