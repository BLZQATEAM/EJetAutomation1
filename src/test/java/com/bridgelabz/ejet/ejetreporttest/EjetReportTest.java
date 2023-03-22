package com.bridgelabz.ejet.ejetreporttest;

import com.bridgelabz.ejet.ejet_reports.Dashboard;
import com.bridgelabz.ejet.ejet_reports.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class EjetReportTest {
    public static void main(String args[]) throws IOException, InterruptedException, IOException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://ejetreports.bridgelabz.com/");
        Login logIn = new Login(driver);
        logIn.login("pm.reports@bridgelabz.com","Br1dge1@bz");

        Dashboard dashboard = new Dashboard(driver);
        dashboard.select_Reports();
        dashboard.select_Report_Type("New Lead Report With Date Range");
        dashboard.select_Lead_Activity("orientation");
        dashboard.select_Start_Date("16");
        dashboard.select_End_Date("17");
    }
}
