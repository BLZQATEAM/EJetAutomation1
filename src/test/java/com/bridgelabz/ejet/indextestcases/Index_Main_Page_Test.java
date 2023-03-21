package com.bridgelabz.ejet.indextestcases;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.index.Index_Main_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class Index_Main_Page_Test extends ReadWebinarPropertiesFile {
    Index_Main_Page index_main_page;
    public Index_Main_Page_Test() throws IOException {
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization(prop.getProperty("indexPage_Url"));
        index_main_page = new Index_Main_Page(driver);
    }

    @Test
    public void click_To_Register_And_Check_Navigated_To_Lateral_Page() throws InterruptedException, AWTException, IOException {
        index_main_page.click_To_Register();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Thread.sleep(3000);
        Assert.assertEquals("https://bridgelabz.com/registerwebsitelateral?fc=Lateral&sc=WBS-LAT-WHN",url);
    }

    @Test
    public void click_On_Apply_Now_And_Check_Navigated_To_RegisterWebsiteUser_Page() throws InterruptedException, IOException {
        index_main_page.click_On_Apply_Now();
        String title = driver.getTitle();
        System.out.println("The title of the page is:" +title);
        Assert.assertEquals("BridgeLabz: Guaranteed Emerging Tech Job",title);
    }

    @Test
    public void click_Attend_Orientation_Button_And_Check_Navigated_To_Webinar_page() throws InterruptedException {
        index_main_page.click_Attend_Orientation_Button();
        String title = driver.getTitle();
        System.out.println("The title of the page is:" +title);
        Assert.assertEquals("BridgeLabz: Guaranteed Emerging Tech Job",title);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
