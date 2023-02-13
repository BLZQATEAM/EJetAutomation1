package TestPackage;

import basePackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.io.IOException;

public class Enter_Room_Test extends BaseClass {
    Enter_Room_Button enterRoom;
    Ph_Num_Field ph;
    Email_Field email;
    Full_Name_Field name;
    PassOut_Field pass;
    Education_Qualification qualification;
    public Enter_Room_Test() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        enterRoom = new Enter_Room_Button(driver);
        ph = new Ph_Num_Field(driver);
        email = new Email_Field(driver);
        name = new Full_Name_Field(driver);
        pass = new PassOut_Field(driver);
        qualification = new Education_Qualification(driver);
    }
    @Test
    public void click_Enable_EnterButton() throws InterruptedException, AWTException {
        ph.valid_phNumber("9790486505");
        email.valid_email_id("mythili@gmail.com");
        name.valid_FullName("Mythili Annamalai");
        pass.passOut_Year("After 2024");
        qualification.eduction_Qualification("Masters (Non IT)");
        Thread.sleep(3000);
        String value = enterRoom.click_enable_EnterButton();
       Assert.assertEquals(value.contains("actv"),true);
    }
    @Test
    public void click_Disable_EnterButton() throws InterruptedException, AWTException {

        Thread.sleep(3000);
        String value = enterRoom.click_disable_EnterButton();
        Assert.assertEquals(value.contains("actv"),false);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
