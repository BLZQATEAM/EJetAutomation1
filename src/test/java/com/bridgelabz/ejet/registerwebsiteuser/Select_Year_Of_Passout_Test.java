package com.bridgelabz.ejet.registerwebsiteuser;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.pages.registerwebsiteuser.Select_Year_Of_Passout;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Select_Year_Of_Passout_Test extends ReadWebinarPropertiesFile {
    Select_Year_Of_Passout select_year_of_passout;

    public Select_Year_Of_Passout_Test() throws IOException {
        super();
    }
    @BeforeTest
    public void setUp() throws IOException {
        initialization(prop.getProperty("RegisterWebsiteUserUrl"));
        select_year_of_passout = new Select_Year_Of_Passout(driver);
    }
    @Test
    public void select_TwoThousandTwentyFour_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("TwoThousandTwentyFour"));
        Assert.assertEquals(msg,"2024");
    }
    @Test
    public void select_TwoThousandTwentyThree_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("TwoThousandTwentyThree"));
        Assert.assertEquals(msg,"2023");
    }
    @Test
    public void select_TwoThousandTwentyTwo_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("TwoThousandTwentyTwo"));
        Assert.assertEquals(msg,"2022");
    }
    @Test
    public void select_TwoThousandTwentyOne_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("TwoThousandTwentyOne"));
        Assert.assertEquals(msg,"2021");
    }
    @Test
    public void select_TwoThousandTwenty_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("TwoThousandTwenty"));
        Assert.assertEquals(msg,"2020");
    }
    @Test
    public void select_Before_TwoThousandTwenty_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("Before_TwoThousandTwenty"));
        Assert.assertEquals(msg,"Before 2020");
    }
    @Test
    public void select_After_TwoThousandTwentyFour_Test() throws InterruptedException{
        String msg = select_year_of_passout.passOut_Year(prop.getProperty("After_TwoThousandTwentyFour"));
        Assert.assertEquals(msg,"After 2024");
    }
    @Test
    public void not_Select_any_passOut_Year_Test() throws InterruptedException{
        String msg = select_year_of_passout.empty_PassOut_Value();
        Assert.assertEquals(msg,"Year Required");
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
