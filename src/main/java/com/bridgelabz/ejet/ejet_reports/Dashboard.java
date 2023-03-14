package com.bridgelabz.ejet.ejet_reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class Dashboard {
    WebDriver driver;

    @FindBy(xpath = "//div[text()='Reports']")
    WebElement reports;
    @FindBy(id = "demo-simple-select")
    WebElement select_reports_drop;
    @FindBy(xpath = "//li[text()='Get Registered Lead User by Slot Type With Date Range']")
    WebElement select_report_type;
    @FindBy(xpath = "//label[text()='Slot Type']")
    WebElement slot_type;
    @FindBy(xpath = "//li[text()='ORIENTATION REGISTERED']")
    WebElement select_slot_type;
    @FindBy(xpath = "//span[text()='Start Date']")
    WebElement start_date_drop;

    @FindBy(xpath = "//button[@aria-label='Mar 1, 2023']")
    WebElement select_start_date;
    @FindBy(xpath = "//span[text()='End Date']")
    WebElement end_date_drop;

    @FindBy(xpath = "//button[@aria-label='Mar 11, 2023']")
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
        if (reports.equals("Get Registered Lead User by Slot Type With Date Range")) {
            report_Type = select_report_type.getText();
            select_report_type.click();
        }
        return report_Type;
    }

    public void select_Slot_Type(String slotType) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.id("outlined")).click();
        driver.findElement(By.xpath("//body/div[@id='menu-slotType']/div[3]/ul[1]/li[6]")).click();

//        List<WebElement> allOptions = driver.findElements(By.id("menu-slotType"));
//
//        for (int i = 0; i < allOptions.size(); i++) {
//            if (allOptions.get(i).getText().contains(slotType)) {
//                Thread.sleep(100);
//                allOptions.get(i).click();
//                Thread.sleep(100);
//                System.out.println("clicked");
//                break;
//            }
//        }
    }


//        slot_type.click();
//        String slot_Type = null;
//        if (slot.equals("ORIENTATION REGISTERED")) {
//            slot_Type = select_slot_type.getText();
//            select_slot_type.click();
//        }
//        return slot_Type;
//}
        public String select_Start_Date (String end_date) throws InterruptedException {
            Thread.sleep(3000);
            start_date_drop.click();
            String date = null;
            if (end_date.equals("1")) {
                date = select_start_date.getText();
                select_start_date.click();
            }
            return date;

        }
        public String select_End_Date (String start_date) throws InterruptedException {
            Thread.sleep(3000);
            end_date_drop.click();
            String date = null;
            if (start_date.equals("1")) {
                date = select_end_date.getText();
                select_end_date.click();
            }
            return date;
        }
        public void click_On_Apply () {
            apply_button.click();
        }
}

