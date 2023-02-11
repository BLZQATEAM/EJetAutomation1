package com.bridgelabz.ejet.testcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.Webinar_Registration_Page;
import org.testng.Assert;
import org.testng.annotations.*;

public class Webinar_Registration_Page_Test extends BaseClass {

    Webinar_Registration_Page page;

    public Webinar_Registration_Page_Test(){
        super();
    }

    @BeforeMethod
    public void initialization() throws InterruptedException {
        setUp();
        page = new Webinar_Registration_Page(driver);
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
        String error2 = page.verify_Error_Msg_1("+91-999999");
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

    @AfterMethod
    public void close_Browser(){
        driver.close();
    }
}

