package com.bridgelabz.ejet.pages.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Index_Main_Page {
    WebDriver driver;

    @FindBy (partialLinkText = "Click Here to Register!")
    WebElement click_here;
    @FindBy(xpath = "//span[contains(text(),'Register Below To Know More!')]")
    WebElement unique_element;
    @FindBy(id="cta-apply")
    WebElement apply_now_btn;

    public Index_Main_Page(WebDriver driver) throws IOException {
        super();
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void click_To_Register() throws InterruptedException, AWTException {
        click_here.click();
        Thread.sleep(1000);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        unique_element.isDisplayed();
    }

    public void click_On_Apply_Now() throws InterruptedException {
        apply_now_btn.click();
        Thread.sleep(3000);
    }

    public void click_Attend_Orientation_Button() throws InterruptedException {
        String parentId = driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println("The current window id is: " + parentId);
        WebElement Attend_orientation = new WebDriverWait(driver, Duration.ofMinutes(2))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Click to attend orientation')]")));
        Attend_orientation.click();
        Thread.sleep(30000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
