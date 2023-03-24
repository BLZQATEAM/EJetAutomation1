package com.bridgelabz.ejet.registerinstatestcases.default_registration.test;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerinsta.defaultregistration.Education_Qualification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Education_Qualification_Test extends ReadWebinarPropertiesFile {
    Education_Qualification qualification;

    public Education_Qualification_Test() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegistrationInsta"));
        qualification = new Education_Qualification(driver);
    }
    @Test
    public void select_Engineering_Cs_Or_It() throws InterruptedException, AWTException {
        String msg=qualification.eduction_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        Assert.assertEquals(msg,"Engineering (CS/IT)");
    }
    @Test
    public void select_Engineering_Non_Cs_Or_It() throws InterruptedException, AWTException {
        String msg=qualification.eduction_Qualification(prop.getProperty("Engineering_Non_Cs_Or_It"));
        Assert.assertEquals(msg,"Engineering (Non IT)");
    }
    @Test
    public void select_Masters_Cs_Or_It() throws InterruptedException, AWTException {
        String msg=qualification.eduction_Qualification(prop.getProperty("Masters_Cs_Or_It"));
        Assert.assertEquals(msg,"Masters (CS/IT)");
    }
    @Test
    public void select_Masters_Non_Cs_Or_It() throws InterruptedException, AWTException {
        String msg=qualification.eduction_Qualification(prop.getProperty("Masters_Non_Cs_Or_It"));
        Assert.assertEquals(msg,"Masters (Non IT)");
    }
    @Test
    public void select_Other() throws InterruptedException, AWTException {
        String msg=qualification.eduction_Qualification(prop.getProperty("Other"));
        Assert.assertEquals(msg,"Others (Non Engineering and Non MSc/MCA)");
    }
    @Test
    public void not_select_EducationQualification() throws InterruptedException, AWTException {
        String msg = qualification.empty_Value();
        Assert.assertEquals(msg,"Stream Required");
    }
}
