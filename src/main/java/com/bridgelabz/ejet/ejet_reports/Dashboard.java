package com.bridgelabz.ejet.ejet_reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Dashboard {
    WebDriver driver;

    @FindBy(xpath = "//div[text()='Reports']")
    WebElement reports;

    @FindBy(id = "demo-simple-select")
    WebElement select_reports_drop;

    @FindBy(xpath = "//li[text()='New Lead Report With Date Range']")
    WebElement select_report_type;

    @FindBy(id = "outlined")
    WebElement lead_activity_drop;

    @FindBy(xpath = "//li[text()='orientation']")
    WebElement select_lead_activity;

    @FindBy(xpath = "//body/div[@id='menu-slotType']/div[3]/ul[1]/li[6]")
    WebElement select_slot_type;

    @FindBy (xpath = "(//button[@aria-label='Choose date'])[1]")
    WebElement start_date_cal;

    @FindBy(xpath = "//button[@aria-label='Mar 16, 2023']")
    WebElement select_start_date;

    @FindBy(xpath = "//button[@aria-label='Choose date']")
    WebElement end_date_cal;

    @FindBy(xpath="//button[@aria-label='Mar 17, 2023']")
    WebElement select_end_date;

    @FindBy(xpath = "//button[text()='Apply']")
    WebElement apply_button;

    public Dashboard(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void select_Reports() throws InterruptedException {
        Thread.sleep(4000);
        reports.click();
    }

    public String select_Report_Type(String reports) throws InterruptedException {
        Thread.sleep(4000);
        select_reports_drop.click();
        String report_Type = null;
        if (reports.equals("New Lead Report With Date Range")) {
            report_Type = select_report_type.getText();
            select_report_type.click();
        }
        return report_Type;
    }

    public String select_Lead_Activity(String lead_activity) throws InterruptedException {
        Thread.sleep(4000);
        lead_activity_drop.click();
        String slot_Type = null;
        if (lead_activity.equals("orientation")) {
            slot_Type = select_lead_activity.getText();
            select_lead_activity.click();
        }
        return slot_Type;
    }

    public String select_Start_Date(String start_date) throws InterruptedException {
        start_date_cal.click();
        Thread.sleep(3000);
        String date = null;
        if(start_date.equals("16")) {
            date = select_start_date.getText();
            select_start_date.click();
        }
        return date;
    }

    public String select_End_Date(String end_date) throws InterruptedException {
        end_date_cal.click();
        String date = null;
        if(end_date.equals("17")) {
            date = select_end_date.getText();
            select_end_date.click();
        }
        return date;
    }

    public void click_On_Apply() {
        apply_button.click();
    }
}

