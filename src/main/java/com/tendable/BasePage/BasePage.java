package com.tendable.BasePage;


import org.openqa.selenium.WebDriver;


public class BasePage {

    public static WebDriver driver;

    /**
     * @param driver
     * This method is to initialize WebDriver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


}
