package com.tendable.Pages;

import com.tendable.BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ContactUs extends BasePage {


    By contactBtn = By.xpath("//*[@data-target='.toggle-163701']");
    By fullNameInputField = By.id("form-input-fullName");
    By orgNameInputField = By.id("form-input-organisationName");
    By phNumberInputField = By.id("form-input-cellPhone");
    By emailInputField = By.id("form-input-email");
    By jobRoleField = By.id("form-input-jobRole");
    By messageField = By.id("form-input-message");
    By iAgreeRadioBtn = By.id("form-input-consentAgreed-0");
    By submitBtn = By.name("form_page_submit");
    By submitFormError = By.id("contactMarketingPipedrive-163701");
    By submitFormSuccessMsg = By.xpath("//*[@class='form-wrapper-163701 w-full mb-6 mr-6']//h3");


    public ContactUs() {
        super(driver);
    }


    public boolean verifyContactBtnIsEnable() {
        return driver.findElement(contactBtn).isEnabled();
    }

    public boolean verifySubmitFormErrorIsDisplayed() {
        return driver.findElement(submitFormError).isDisplayed();
    }


    public boolean verifySubmitFormSuccessMsg1IsDisplayed() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        return driver.findElement(submitFormSuccessMsg).isDisplayed();
    }


    public void clickContactBtn() {
        driver.findElement(contactBtn).click();

    }

    public void captureFullNameInputField(String FullName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(fullNameInputField).clear();
        driver.findElement(fullNameInputField).sendKeys(FullName);
    }

    public void captureOrgNameInputField(String OrgName) {
        driver.findElement(orgNameInputField).clear();
        driver.findElement(orgNameInputField).sendKeys(OrgName);
    }

    public void capturePhNumberInputField(String PhNumber) {
        driver.findElement(phNumberInputField).clear();
        driver.findElement(phNumberInputField).sendKeys(PhNumber);
    }

    public void captureEmailInputField(String Email) {
        driver.findElement(emailInputField).clear();
        driver.findElement(emailInputField).sendKeys(Email);
    }

    public WebElement jobRoleField() {
        return driver.findElement(jobRoleField);
    }

    public void captureMessageField(String Message) {
        driver.findElement(messageField).clear();
        driver.findElement(messageField).sendKeys(Message);

    }

    public void clickIAgreeRadioBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");
        driver.findElement(iAgreeRadioBtn).click();
    }

    public void clickSubmitBtn() {
        WebElement Element = driver.findElement(submitBtn);
        if (driver.findElement(submitBtn).isDisplayed()) {
            Element.submit();
        } else {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            Element.submit();
        }
    }

}