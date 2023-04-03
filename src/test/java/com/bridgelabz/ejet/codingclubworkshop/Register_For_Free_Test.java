package com.bridgelabz.ejet.codingclubworkshop;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.codingclubworkshop.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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

    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("CodingClub_Workshop"));
        enterRoom = new Register_For_Free_Button(driver);
        ph = new Ph_Num_Field(driver);
        email = new Email_Field(driver);
        name = new Full_Name_Field(driver);
        pass = new PassOut_Field(driver);
        qualification = new Education_Qualification(driver);
    }
    @Test
    public void click_Enable_EnterButton() throws InterruptedException, AWTException {
        ph.user_PhNum_From_PhField(prop.getProperty("Valid_PhNumber"));
        name.user_FullName(prop.getProperty("Valid_FullName"));
        email.user_email_id(prop.getProperty("Valid_EmailId"));
        qualification.eduction_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        pass.passOut_Year(prop.getProperty("TwoThousandTwentyFour"));
        Thread.sleep(3000);
        enterRoom.click_enable_Button();
    }
    @Test
    public void click_Disable_EnterButton() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        enterRoom.click_disable_Button();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
