package com.bridgelabz.ejet.webinartestcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.pages.FullName_Field;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FullName_Field_Test extends BaseClass {
    FullName_Field name;
    public FullName_Field_Test() {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initialization();
        name = new FullName_Field(driver);
    }
    @Test
    public void enter_valid_name() throws InterruptedException {
        boolean msg = name.valid_fullname("Mythili Annamalai");
        Assert.assertFalse(msg);
    }
    @Test
    public void enter_emptyString_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName(" ");
        Assert.assertTrue(msg,"First Name Min 3 character required");
    }
    @Test
    public void enter_twoChar_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName("my");
        Assert.assertTrue(msg,"First Name Min 3 character required");
    }
    @Test
    public void enter_threeChar_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName("myt");
        Assert.assertTrue(msg,"Please enter first & last name (min. 3 letters each) separated by a space.");
    }
    @Test
    public void without_space_user_enter_firstName_And_lastName_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName("mythiliannamalai");
        Assert.assertTrue(msg,"Please enter first & last name (min. 3 letters each) separated by a space.");
    }
    @Test
    public void after_enter_lastName_user_provide_space_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName("mythili annamalai ");
        Assert.assertTrue(msg,"No space after first & last name");
    }
    @Test
    public void inBetween_firstName_And_lastName_user_provide_doubleSpace_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName("mythili  annamalai");
        Assert.assertTrue(msg,"No space after fullname and character");
    }
    @Test
    public void user_enter_threeGroup_of_name() throws InterruptedException {
        boolean msg = name.invalid_fullName("mythili naveen kumar");
        Assert.assertTrue(msg,"No space after fullname and character");
    }
    @Test
    public void user_enter_numericChar_nameField() throws InterruptedException {
        boolean msg = name.invalid_fullName("mythili45 naveen");
        Assert.assertTrue(msg,"Name must contain alphabetic only");
    }
    @Test
    public void user_remove_validName_from_Field() throws InterruptedException {
        boolean msg = name.removing_value_from_fullNameField("mythili annamalai");
        Thread.sleep(500);
        Assert.assertTrue(msg,"You must enter a Full Name");
    }
    @Test
    public void user_remove_invalidName_from_Field() throws InterruptedException {
        boolean msg = name.removing_value_from_fullNameField("myt");
        Thread.sleep(500);
        Assert.assertTrue(msg,"You must enter a Full Name");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
