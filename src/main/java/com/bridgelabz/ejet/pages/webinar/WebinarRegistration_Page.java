package com.bridgelabz.ejet.pages.webinar;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import com.bridgelabz.ejet.ejet_reports.Dashboard;
import com.bridgelabz.ejet.ejet_reports.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class WebinarRegistration_Page extends ReadWebinarPropertiesFile {

    WebDriver driver;
    Dashboard dashboard = new Dashboard(driver);

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

    public WebinarRegistration_Page(WebDriver driver) throws IOException {
        super();
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void enterData_InFields() throws InterruptedException {
        Thread.sleep(3000);
        phone_Number.sendKeys(prop.getProperty("myPhoneNo"));
        Thread.sleep(3000);
        txt_email.sendKeys(prop.getProperty("myEmailId"));
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
}
