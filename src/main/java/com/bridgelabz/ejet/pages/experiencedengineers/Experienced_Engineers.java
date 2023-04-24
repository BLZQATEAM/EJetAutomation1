package com.bridgelabz.ejet.pages.experiencedengineers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.security.Key;
import java.util.Set;

public class Experienced_Engineers {
    WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Click To Register')]")
    WebElement Click_To_Reg;
    @FindBy( xpath= "//span[text()='OUR TEAM']")
    WebElement Our_team;
    @FindBy( xpath= "//span[text()='FOR BUSINESS']")
    WebElement For_Business;
    @FindBy( xpath= "//div[contains(text(),'Welcome to BridgeLabz!')]")
    WebElement welcome_msg;
    @FindBy( xpath= "//div[text()='About Us']")
    WebElement about_us;
    @FindBy( xpath= "//span[contains(text(),'Checkout Our Credentials Deck')]")
    WebElement credentials_deck;

    public Experienced_Engineers(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String click_registration_btn() throws InterruptedException {
        String parentWindowHandleID = driver.getWindowHandle();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        Click_To_Reg.click();
        Thread.sleep(3000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(3000);
        String msg = null;
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            Thread.sleep(3000);
            if (!windowHandle.equals(parentWindowHandleID)) {
                msg = welcome_msg.getText();
            }
        }
        return msg;
    }
    public String click_Our_Team(){
        Our_team.click();
        String msg = about_us.getText();
        return msg;
    }
    public String click_For_Business() throws InterruptedException {
        String parentWindowHandleID = driver.getWindowHandle();
        For_Business.click();
        Thread.sleep(3000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(3000);
        String msg = null;
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            Thread.sleep(3000);
            if (!windowHandle.equals(parentWindowHandleID)) {
                msg = credentials_deck.getText();
            }
        }
        return msg;
    }
}
