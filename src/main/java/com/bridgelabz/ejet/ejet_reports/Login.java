package com.bridgelabz.ejet.ejet_reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class Login {
    WebDriver driver;

    @FindBy(id="outlined-basic")
    WebElement email_id;
    @FindBy(id = "outlined-adornment-password")
    WebElement password;
    @FindBy(xpath = "//button[text()='Login']")
    WebElement login_button;

    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String email, String pwd) throws InterruptedException, IOException {
        Thread.sleep(3000);
        email_id.sendKeys(email);
        Thread.sleep(3000);
        password.sendKeys(pwd);
        Thread.sleep(3000);
        login_button.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println("the page title is: " +title);
    }
}
