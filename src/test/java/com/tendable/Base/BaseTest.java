package com.tendable.Base;

import com.tendable.BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import java.util.Properties;

public class BaseTest {

    public static Properties prop;
    public static WebDriver driver;


    /**
     * This Constructor is to load properties from config properties file
     */
    public BaseTest() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\Resources\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is to initialize the browser based on browser property
     */
    public static WebDriver init() {
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("No Browsers found");
        }
        BasePage basePage = new BasePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }


    /**
     * This method is to launch URL
     */
    public static void launchURL() {
        driver.get(prop.getProperty("url"));
    }


    /**
     * This method is to select value from Drop down
     */
    public static void dropDownSelect(WebElement element, String value) {
        Select s = new Select(element);
        s.selectByValue(value);
    }


    /**
     * This method will run at the beginning of each test
     */
    @BeforeTest
    public static void beforeTestCase() {
        init();
        launchURL();
    }

    /**
     * This method will run at the end of each test
     */
    @AfterTest
    public static void afterTestCase() {
        driver.quit();
    }

}
