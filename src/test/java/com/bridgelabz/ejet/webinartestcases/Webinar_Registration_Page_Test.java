package com.bridgelabz.ejet.webinartestcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.Phone_Number_Field;
import org.testng.Assert;
import org.testng.annotations.*;

public class Webinar_Registration_Page_Test extends BaseClass {

    Phone_Number_Field page;

    public Webinar_Registration_Page_Test(){
        super();
    }

    @BeforeTest
    public void setUp() throws InterruptedException {
        initialization();
        page = new Phone_Number_Field(driver);
    }

    @Test
    public void invalid_phn_No_Starting_With_Zero() throws InterruptedException {
        String error = page.verify_Error_Msg_1("09996999");
        System.out.println("The actual error is:" + error);
        Assert.assertEquals(error, "Invalid Phone Number");
        Thread.sleep(3000);
    }
    @Test
    public void invalid_phn_No_Starting_With_Plus_Ninty_One_And_Hyphen() throws InterruptedException {
        String error1 = page.verify_Error_Msg_1("+91-999999");
        System.out.println("The actual error is:" + error1);
        Assert.assertEquals(error1, "Invalid Phone Number");
        Thread.sleep(3000);
    }
    @Test
    public void invalid_phn_No_Starting_With_Plus_Ninty_One() throws InterruptedException {
        String error2 = page.verify_Error_Msg_1("+91999999");
        System.out.println("The actual error is:" + error2);
        Assert.assertEquals(error2, "Invalid Phone Number");
        Thread.sleep(3000);
    }

    @Test
    public void valid_phn_no(){
        Boolean display = page.verify_Tick_Icon("9199993243");
        System.out.println("The actual result is:" + display);
        Assert.assertTrue(display);
    }

    @AfterTest
    public void close_Browser(){
        driver.close();
    }
}

