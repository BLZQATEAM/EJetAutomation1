package com.bridgelabz.ejet.registerinstatestcases.default_registration.test;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerinsta.defaultregistration.Aggregate_Percentage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

public class Aggregate_Percentage_Test extends ReadWebinarPropertiesFile {
    Aggregate_Percentage aggregate;

    public Aggregate_Percentage_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegistrationInsta"));
        aggregate = new Aggregate_Percentage(driver);
    }
    @Test
    public void select_Below_Sixty() throws InterruptedException, AWTException {
        String msg=aggregate.aggregate_Per(prop.getProperty("Below_Sixty"));
        Assert.assertEquals(msg,"Below 60%");
    }
    @Test
    public void select_Sixty_To_Seventy() throws InterruptedException, AWTException {
        String msg=aggregate.aggregate_Per(prop.getProperty("Sixty_To_Seventy"));
        Assert.assertEquals(msg,"60% - 70%");
    }
    @Test
    public void select_Above_Seventy() throws InterruptedException, AWTException {
        String msg=aggregate.aggregate_Per(prop.getProperty("Above_Seventy"));
        Assert.assertEquals(msg,"70% and Above");
    }
    @Test
    public void not_select_passOut_Year() throws InterruptedException, AWTException {
        String msg = aggregate.empty_Value();
        Assert.assertEquals(msg,"CGPA Required");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
