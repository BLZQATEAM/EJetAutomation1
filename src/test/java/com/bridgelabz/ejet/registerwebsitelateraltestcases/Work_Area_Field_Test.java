package com.bridgelabz.ejet.registerwebsitelateraltestcases;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerwebsitelateral.Work_Area_Field;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

public class Work_Area_Field_Test extends ReadWebinarPropertiesFile {
    Work_Area_Field workarea;

    public Work_Area_Field_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegisterWebsiteLateral"));
        workarea = new Work_Area_Field(driver);
    }
    @Test
    public void select_Software_Developer() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Software_Dev"));
        Assert.assertEquals(msg,"Software Development");
    }
    @Test
    public void select_Db_Developer() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Db_Dev"));
        Assert.assertEquals(msg,"DBA/SQL Developer");
    }
    @Test
    public void select_Frontend() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Frontend"));
        Assert.assertEquals(msg,"Frontend - HTML/CSS");
    }
    @Test
    public void select_Manual_QA() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Manual_QA"));
        Assert.assertEquals(msg,"Manual QA");
    }
    @Test
    public void select_Data_Analyst() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Data_Analyst"));
        Assert.assertEquals(msg,"MIS/Data Analyst");
    }
    @Test
    public void select_Tech_Support() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Tech_Support"));
        Assert.assertEquals(msg,"Tech Support");
    }
    @Test
    public void select_Non_IT() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("Non_IT"));
        Assert.assertEquals(msg,"Non IT");
    }
    @Test
    public void select_NA() throws InterruptedException, AWTException {
        String msg=workarea.work_Area(prop.getProperty("NA"));
        Assert.assertEquals(msg,"Not Applicable");
    }
    @Test
    public void not_select_passOut_Year() throws InterruptedException, AWTException {
        String msg = workarea.empty_Value();
        Assert.assertEquals(msg,"Work Area Required");
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
