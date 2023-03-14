package com.bridgelabz.ejet.pages;

import com.bridgelabz.ejet.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;

public class PassOut_Field extends BaseClass {
    @FindBy(name="passoutYear")
    WebElement drop_passout;
    @FindBy(xpath="//p[text()='Year Required']")
    WebElement error;
    @FindBy(xpath="//div[@value='2023']")
    WebElement d_2023;
    @FindBy(xpath="//div[@value='2022']")
    WebElement d_2022;
    @FindBy(xpath="//div[@value='2021']")
    WebElement d_2021;
    @FindBy(xpath="//div[@value='2020']")
    WebElement d_2020;
    @FindBy(xpath="//div[@value='2024']")
    WebElement d_2024;
    @FindBy(xpath="//div[@value='Before 2020']")
    WebElement d_B_2020;
    @FindBy(xpath="//div[@value='After 2024']")
    WebElement d_A_2024;

    public PassOut_Field(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String passout(String pass) throws InterruptedException, AWTException {
        drop_passout.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(3000);
        drop_passout.click();
        Thread.sleep(3000);
        String value = null;

        if (pass.equals("2023")) {
            value=d_2023.getText();
            Thread.sleep(3000);
            d_2023.click();
            Thread.sleep(3000);
        } else if (pass.equals("2022")) {
            value=d_2022.getText();
            Thread.sleep(3000);
            d_2022.click();
            Thread.sleep(3000);
        } else if (pass.equals("2021")) {
            value=d_2021.getText();
            Thread.sleep(3000);
            d_2021.click();
            Thread.sleep(3000);
        } else if (pass.equals("2024")) {
            value=d_2024.getText();
            Thread.sleep(3000);
            d_2024.click();
            Thread.sleep(3000);
        } else if (pass.equals("2020")) {
            value=d_2020.getText();
            Thread.sleep(3000);
            d_2020.click();
            Thread.sleep(3000);
        } else if (pass.equals("After 2024")) {
            value=d_A_2024.getText();
            Thread.sleep(3000);
            d_A_2024.click();
            Thread.sleep(3000);
        } else if (pass.equals("Before 2020")) {
            value=d_B_2020.getText();
            Thread.sleep(3000);
            d_B_2020.click();
            Thread.sleep(3000);
        }
        return value;
    }
    public String empty_Value() throws AWTException, InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", drop_passout);
        Thread.sleep(3000);
        drop_passout.click();
        Thread.sleep(3000);
        String value =error.getText();
        return value;
    }
}
