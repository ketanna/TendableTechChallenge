package com.tendable.Pages;

import com.tendable.BasePage.BasePage;
import org.openqa.selenium.By;


public class OurSolution extends BasePage {

    By ourSolutionPageText = By.id("text-142615");

    public OurSolution() {
        super(driver);
    }

    public String verifyOurSolutionURL() {
        return driver.getCurrentUrl();
    }

    public boolean verifyOurSolutionPageTextIsDisplayed() {
        return driver.findElement(ourSolutionPageText).isDisplayed();
    }
}
