package com.bridgelabz.ejet.condingclubregister;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.codingclubregister.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Register_For_Free_Test extends ReadWebinarPropertiesFile {
    Register_For_Free_Button enterRoom;
    Ph_Num_Field ph;
    Email_Field email;
    Full_Name_Field name;
    PassOut_Field pass;
    Education_Qualification qualification;
    public Register_For_Free_Test() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("CodingClubRegisterURL"));
        enterRoom = new Register_For_Free_Button(driver);
        ph = new Ph_Num_Field(driver);
        email = new Email_Field(driver);
        name = new Full_Name_Field(driver);
        pass = new PassOut_Field(driver);
        qualification = new Education_Qualification(driver);
    }
    @Test
    public void click_Enable_EnterButton() throws InterruptedException, AWTException {
        ph.valid_phNumber(prop.getProperty("Valid_PhNumber"));
        name.valid_FullName(prop.getProperty("Valid_FullName"));
        email.valid_email_id(prop.getProperty("Valid_EmailId"));
        qualification.eduction_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        pass.passOut_Submit(prop.getProperty("TwoThousandTwentyFour"));
        enterRoom.submitEnable_Button();
        Thread.sleep(2000);
    }
    @Test
    public void click_Disable_EnterButton() throws InterruptedException{
        Thread.sleep(4000);
        enterRoom.click_disable_Button();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
