package com.bridgelabz.ejet.registerwebsitelateraltestcases;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerwebsitelateral.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Reg_Submit_Test extends ReadWebinarPropertiesFile {
    Ph_Num_Field ph;
    Full_Name_Field name;
    Email_Field email;
    Education_Qualification qualification;
    Experience_Field experience;
    Work_Area_Field workarea;
    Reg_Submit submit;

    public Reg_Submit_Test() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegisterWebsiteLateral"));
        submit = new Reg_Submit(driver);
        ph = new Ph_Num_Field(driver);
        name = new Full_Name_Field(driver);
        email = new Email_Field(driver);
        qualification = new Education_Qualification(driver);
        experience = new Experience_Field(driver);
        workarea = new Work_Area_Field(driver);
    }
    @Test
    public void click_Enable_SubmitButton() throws InterruptedException, AWTException {
        ph.valid_phNumber(prop.getProperty("Valid_PhNumber"));
        name.valid_FullName(prop.getProperty("Valid_FullName"));
        email.valid_email_id(prop.getProperty("Valid_EmailId"));
        qualification.eduction_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        experience.experience_Year(prop.getProperty("Seven_To_Twelve_Month"));
        workarea.work_Area(prop.getProperty("Manual_QA"));
        submit.click_enable_EnterButton();
    }
    @Test
    public void click_Disable_SubmitButton() throws InterruptedException, AWTException {
        Thread.sleep(3000);
        submit.click_disable_EnterButton();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
