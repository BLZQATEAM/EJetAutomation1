package com.bridgelabz.ejet.webinartestcases;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.ejet_reports.Dashboard;
import com.bridgelabz.ejet.ejetreporttest.EjetReportTest;
import com.bridgelabz.ejet.pages.webinar.WebinarRegistration_Page;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;

public class WebinarRegistration_Success extends BaseClass {
    WebinarRegistration_Page page;
    Dashboard dashboard;
    EjetReportTest report;
    @BeforeTest
    public void setUp() throws InterruptedException, IOException {
        initialization();
        page = new WebinarRegistration_Page(driver);
        dashboard = new Dashboard(driver);
        report = new EjetReportTest();
    }

    @Test
    public void webinarUserRegistrationSuccess_AndRedirectOnAttendOrientationScreen() throws InterruptedException, IOException {
        page.enterData_InFields();
        boolean msg = page.clickEnter();
        Thread.sleep(3000);
        Assert.assertTrue(msg);
        report.main();
    }

    @AfterTest
    public void close_Browser(){
        driver.close();
    }
}
