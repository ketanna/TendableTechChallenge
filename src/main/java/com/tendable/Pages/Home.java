package com.tendable.Pages;

import com.tendable.BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class Home extends BasePage {

    By ourStoryMenu = By.xpath("//*[@id='main-navigation-new']/ul/li[1]/a");
    By ourSolutionMenu = By.xpath("//*[@id='main-navigation-new']/ul/li[2]/a");
    By whyTendableMenu = By.xpath("//*[@id='main-navigation-new']/ul/li[3]/a");
    By requestDemoBtn = By.xpath("//*[@class='button-links-panel']//a[3]");
    By contactUsBtn = By.xpath("//*[@class='button-links-panel']//a[1]");


    public Home() {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageURL() {
        return driver.getCurrentUrl();
    }

    public boolean verifyOurStoryMenuIsDisplayed() {
        return driver.findElement(ourStoryMenu).isDisplayed();
    }

    public boolean verifyOurSolutionMenuIsDisplayed() {
        return driver.findElement(ourSolutionMenu).isDisplayed();
    }

    public boolean verifyWhyTendableMenuIsDisplayed() {
        return driver.findElement(whyTendableMenu).isDisplayed();
    }

    public boolean verifyRequestDemoBtnIsDisplayedAndEnabled() {
        if (driver.findElement(requestDemoBtn).isDisplayed()) {
            return driver.findElement(requestDemoBtn).isEnabled();
        } else {
            return false;
        }
    }

    public boolean verifyContactUsBtnIsEnabled() {
        return driver.findElement(contactUsBtn).isEnabled();
    }

    public void clickContactUsBtn() {
        driver.findElement(contactUsBtn).click();
    }

    public void clickOurStoryMenu() {
        driver.findElement(ourStoryMenu).click();
    }

    public void clickOurSolutionMenu() {
        driver.findElement(ourSolutionMenu).click();

    }

    public void clickWhyTendableMenu() {
        driver.findElement(whyTendableMenu).click();
    }

}
