package com.bridgelabz.ejet.ejet_reports;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Dashboard extends ReadWebinarPropertiesFile {
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

    @FindBy(xpath = "//button[@aria-label='Mar 25, 2023']")
    WebElement select_start_date;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/button[1]")
    WebElement end_date_cal;

    @FindBy(xpath="//button[@aria-label='Mar 27, 2023']")
    WebElement select_end_date;

    @FindBy(xpath = "//button[text()='Apply']")
    WebElement apply_button;

    public Dashboard(WebDriver driver) throws IOException {
        super();
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
        if(start_date.equals("25")) {
            date = select_start_date.getText();
            select_start_date.click();
        }
        System.out.println("Start Date : "+date);
        return date;
    }

    public String select_End_Date(String end_date) {
        end_date_cal.click();
        String date = null;
        if(end_date.equals("26")) {
            date = select_end_date.getText();
            select_end_date.click();
        }
        System.out.println("End Date : "+date);
        return date;
    }

    public void click_On_Apply() {
        apply_button.click();
    }

    public void dataValidationGetTable() throws InterruptedException {
        Thread.sleep(1000);
        //get table
        WebElement baseTable = driver.findElement(By.tagName("table"));

        //get 1st row all values
        WebElement tableRow = baseTable.findElement(By.xpath("//tbody/tr[1]"));
        String rowText = tableRow.getText();
        System.out.println("Third row of table : " + rowText);

        //get 1st Row Firstname
        WebElement firstName = tableRow.findElement(By.xpath("//tbody/tr[1]/td[4]"));
        String firstNameText = firstName.getText();
        System.out.println("Cell value for firstname is : " + firstNameText);
//        if(firstNameText.equals(prop.getProperty("myFirstName"))){
//            System.out.println(prop.getProperty("myFirstName") + "first name matched!!" + firstNameText);
//        }

        //1st Row : Lastname
        WebElement lastName = tableRow.findElement(By.xpath("//tbody/tr[1]/td[5]"));
        String lastNameText = lastName.getText();
        System.out.println("Cell value for lastname is : " + lastNameText);

        //1st Row :  Mobile no
        WebElement mobileNo = tableRow.findElement(By.xpath("//tbody/tr[1]/td[6]"));
        String mobileNoText = mobileNo.getText();
        System.out.println("Cell value for mobile is : " + mobileNoText);

        if(mobileNoText.equals(prop.getProperty("myPhoneNo"))){
            System.out.println(prop.getProperty("myPhoneNo") + "Phone no matched!!" + mobileNoText);
        }else {
            System.out.println("phone no Not Matched!!");
        }

        //1st Row : Email Id
        WebElement emailId = tableRow.findElement(By.xpath("//tbody/tr[1]/td[7]"));
        String emailIdText = emailId.getText();
        System.out.println("Cell value for Email is : " + emailIdText);

        if(emailIdText.equals(prop.getProperty("myEmailId"))){
            System.out.println(prop.getProperty("myEmailId") + "Email Id matched!!" + emailIdText);
        }else {
            System.out.println("email id Not Matched!!");
        }

        //1st Row Education Qualification
        WebElement eduQualification = tableRow.findElement(By.xpath("//tbody/tr[1]/td[12]"));
        String eduQualificationText = eduQualification.getText();
        System.out.println("Cell value for Edu qualification is : " + eduQualificationText);

        //1st Row PassOut year
        WebElement passOutYear = tableRow.findElement(By.xpath("//tbody/tr[1]/td[13]"));
        String passOutYearText = passOutYear.getText();
        System.out.println("Cell value for passOut year is : " + passOutYearText);
    }
}

