package com.bridgelabz.ejet.experiencedengineer;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.experiencedengineers.Experienced_Engineers;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;

public class ExperiencedEngineerTest extends ReadWebinarPropertiesFile {
    Experienced_Engineers Exp_Eng;
    public ExperiencedEngineerTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("Experienced_Engineer"));
        Exp_Eng = new Experienced_Engineers(driver);
    }
    @Test
    public void click_registration() throws InterruptedException {
        String text = Exp_Eng.click_registration_btn();
        Assert.assertEquals(text,"Welcome To BridgeLabz!");
    }
    @Test
    public void click_our_team(){
        String text = Exp_Eng.click_Our_Team();
        Assert.assertEquals(text,"ABOUT US");
    }
    @Test
    public void click_for_Business() throws InterruptedException {
        String text = Exp_Eng.click_For_Business();
        Assert.assertEquals(text,"Checkout Our Credentials Deck");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
