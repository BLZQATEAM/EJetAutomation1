package com.bridgelabz.ejet.pages;

import com.bridgelabz.ejet.base.BaseClass;
import com.bridgelabz.ejet.ejet_reports.Dashboard;
import com.bridgelabz.ejet.ejet_reports.Login;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class WebinarRegistration_Page extends BaseClass {
    @FindBy(id="deftphnumber")
    WebElement phone_Number;

    @FindBy(id="deftemail")
    WebElement txt_email;

    @FindBy(id="deftusername")
    WebElement txt_uname;

    @FindBy(name="passoutYear")
    WebElement drop_passout;

    @FindBy(name="gradStream")
    WebElement dr_stream;

    @FindBy(xpath="//div[@value='2024']")
    WebElement d_2024;

    @FindBy(xpath="//div[text()=' Engineering (CS/IT) ']")
    WebElement dr_Ecs;

    @FindBy(xpath="//span[contains(text(),'ENTER ROOM')]")
    WebElement btn_room;

    public WebinarRegistration_Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void enterData_InFields() throws InterruptedException {
        Thread.sleep(3000);
        phone_Number.sendKeys("7038053665");
        Thread.sleep(3000);
        txt_email.sendKeys("sheetal.chaudhari2@bridgelabz.com");
        Thread.sleep(3000);
        txt_uname.sendKeys("Sheetal Chaudhari");

        dr_stream.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        drop_passout.click();
        d_2024.click();

        dr_stream.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        dr_stream.click();
        dr_Ecs.click();
        Thread.sleep(3000);
    }

    public boolean clickEnter() throws InterruptedException {
        Thread.sleep(3000);
        boolean value = btn_room.isEnabled();
        btn_room.click();
        Thread.sleep(3000);
        return value;
    }

//    public void dataValidation() throws IOException, InterruptedException {
//        driver.navigate().to("https://ejetreports.bridgelabz.com/");
//        Login logIn = new Login(driver);
//        logIn.login("pm.reports@bridgelabz.com","Br1dge1@bz");
//
//        Dashboard dashboard = new Dashboard(driver);
//        dashboard.select_Reports();
//        dashboard.select_Report_Type("Get Registered Lead User by Slot Type With Date Range");
//    }
}
