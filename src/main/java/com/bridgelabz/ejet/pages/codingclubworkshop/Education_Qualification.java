package com.bridgelabz.ejet.pages.codingclubworkshop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.io.IOException;

public class Education_Qualification {
    WebDriver driver;

    @FindBy(id ="poptdegree")
    WebElement dr_stream;
    @FindBy(id ="poptdegreevalid")
    WebElement error;
    @FindBy(xpath="//div[text()=' Engineering (CS/IT) ']")
    WebElement dr_Ecs;
    @FindBy(xpath="//div[text()=' Engineering (Non IT) ']")
    WebElement dr_Enon;
    @FindBy(xpath="//div[text()=' Masters (CS/IT) ']")
    WebElement dr_Mcs;
    @FindBy(xpath="//div[text()=' Masters (Non IT) ']")
    WebElement dr_Mnon;
    @FindBy(xpath="//div[text()=' Others (Non Engineering and Non MSc/MCA) ']")
    WebElement dr_other;
    public Education_Qualification(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    public String eduction_Qualification(String education) throws InterruptedException, AWTException {

        JavascriptExecutor jsexe = (JavascriptExecutor)driver;
        jsexe.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        String value = null;
        dr_stream.click();
        Thread.sleep(3000);
        if (education.equals("Engineering (CS/IT)")) {
            value=dr_Ecs.getText();
            dr_Ecs.click();
        } else if (education.equals("Engineering (Non IT)")) {
            value=dr_Enon.getText();
            dr_Enon.click();
        } else if (education.equals("Masters (CS/IT)")) {
            value=dr_Mcs.getText();
            dr_Mcs.click();
        } else if (education.equals("Masters (Non IT)")) {
            value=dr_Mnon.getText();
            dr_Mnon.click();
        } else if (education.equals("Others (Non Engineering and Non MSc/MCA)")) {
            value=dr_other.getText();
            dr_other.click();
        }
        return value;
    }

    public String empty_Value() throws InterruptedException {
        JavascriptExecutor jsexe = (JavascriptExecutor)driver;
        jsexe.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        dr_stream.click();
        Thread.sleep(3000);
        String value =error.getText();
        return value;
    }
}
