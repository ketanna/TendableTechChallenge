package com.tendable.Pages;

import com.tendable.BasePage.BasePage;
import org.openqa.selenium.By;


public class OurStory extends BasePage {

    By ourStoryPageText = By.xpath("//*[@alt='Tendable meaning']");


    public OurStory() {
        super(driver);
    }

    public String verifyOurStoryURL() {
        return driver.getCurrentUrl();
    }

    public boolean verifyOurStoryPageTextIsDisplayed() {
        return driver.findElement(ourStoryPageText).isDisplayed();
    }

}
