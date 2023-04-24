package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerwebsiteuser.Educational_Qualification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Educational_Qualification_Test extends ReadWebinarPropertiesFile {
    Educational_Qualification educational_qualification;

    public Educational_Qualification_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegisterWebsiteUserUrl"));
        educational_qualification = new Educational_Qualification(driver);
    }
    @Test
    public void select_Engineering_Cs_Test() throws InterruptedException {
        String msg=educational_qualification.education_Qualification(prop.getProperty("Engineering_Cs_Or_It"));
        Assert.assertEquals(msg,"Engineering (CS/IT)");
    }
    @Test
    public void select_Engineering_Non_It_Test() throws InterruptedException{
        String msg=educational_qualification.education_Qualification(prop.getProperty("Engineering_Non_Cs_Or_It"));
        Assert.assertEquals(msg,"Engineering (Non IT)");
    }
    @Test
    public void select_Masters_Cs_Test() throws InterruptedException{
        String msg=educational_qualification.education_Qualification(prop.getProperty("Masters_Cs_Or_It"));
        Assert.assertEquals(msg,"Masters (CS/IT)");
    }
    @Test
    public void select_Masters_Non_It_Test() throws InterruptedException{
        String msg=educational_qualification.education_Qualification(prop.getProperty("Masters_Non_Cs_Or_It"));
        Assert.assertEquals(msg,"Masters (Non IT)");
    }
    @Test
    public void select_Others_Test() throws InterruptedException{
        String msg=educational_qualification.education_Qualification(prop.getProperty("Other"));
        Assert.assertEquals(msg,"Others (Non Engineering and Non MSc/MCA)");
    }
    @Test
    public void without_Selecting_Education_Qualification_Test() throws InterruptedException{
        String msg = educational_qualification.without_Selecting_Education_Qualification();
        Assert.assertEquals(msg,"Stream Required");
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
