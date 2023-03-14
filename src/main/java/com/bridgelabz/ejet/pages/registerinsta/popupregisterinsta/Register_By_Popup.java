package com.bridgelabz.ejet.pages.registerinsta.popupregisterinsta;

import com.bridgelabz.ejet.base.ReadWebinarPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Register_By_Popup extends ReadWebinarPropertiesFile {
    @FindBy(xpath = "(//span[contains(text(),'Check your eligibility for scholarship')])[1]")
    WebElement eligibility_scholarship_btn;

    public Register_By_Popup(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void click_eligibility_Scholarship_btn() throws InterruptedException {
        Thread.sleep(3000);
        eligibility_scholarship_btn.click();
    }

}
