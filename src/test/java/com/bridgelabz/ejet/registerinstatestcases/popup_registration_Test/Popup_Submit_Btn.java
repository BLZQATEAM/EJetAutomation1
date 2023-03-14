package com.bridgelabz.ejet.registerinstatestcases.popup_registration_Test;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerinsta.popupregisterinsta.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Popup_Submit_Btn extends ReadWebinarPropertiesFile {
    Submit_Btn submit;
    Register_By_Popup reg_popup;

    Ph_Num_Field ph;
    Email_Field email;
    Full_Name_Field name;
    PassOut_Field pass;
    Education_Qualification qualification;
    Aggregate_Percentage aggregate;

    public Popup_Submit_Btn() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegistrationInsta"));
        submit = new Submit_Btn(driver);
        reg_popup = new Register_By_Popup(driver);
        ph = new Ph_Num_Field(driver);
        email = new Email_Field(driver);
        name = new Full_Name_Field(driver);
        pass = new PassOut_Field(driver);
        qualification = new Education_Qualification(driver);
        aggregate = new Aggregate_Percentage(driver);
    }
    @Test
    public void click_Enable_EnterButton() throws InterruptedException, AWTException {
        reg_popup.click_eligibility_Scholarship_btn();
        Thread.sleep(5000);
        ph.valid_phNumber(prop.getProperty("Valid_PhNumber"));
        name.valid_FullName(prop.getProperty("Valid_FullName"));
        email.valid_email_id(prop.getProperty("Valid_EmailId"));
        qualification.eduction_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        pass.passout_Year_Enterbtn(prop.getProperty("TwoThousandTwentyFour"));
        aggregate.aggregate_Per_EnterBtn(prop.getProperty("Above_Seventy"));
        Thread.sleep(3000);
        submit.click_Sumbit_Button();
    }
}
