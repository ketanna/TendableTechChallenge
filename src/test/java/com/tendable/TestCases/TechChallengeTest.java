package com.tendable.TestCases;

import com.tendable.Base.BaseTest;
import com.tendable.Pages.*;
import com.tendable.Util.JsonParser;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Map;

public class TechChallengeTest extends BaseTest {

    Home home = new Home();
    OurStory ourStory = new OurStory();
    OurSolution ourSolution = new OurSolution();
    WhyTendable whyTendable = new WhyTendable();
    ContactUs contactUs = new ContactUs();
    JsonParser jsonParser = new JsonParser();


    public TechChallengeTest() {
        super();
    }

    /**
     * 1. Confirm accessibility of the top-level menus: Home, Our Story, Our Solution, and Why
     * Tendable.
     */
    @Test(priority = 1)
    public void verifyTopLevelMenuTest() {
        try {
            init();
            launchURL();
        } catch (Exception e) {
            Assert.fail("Unable to create web session and launch URL", e);
        }
        Assert.assertEquals("https://www.tendable.com/", home.verifyHomePageURL());
        Assert.assertTrue(home.verifyOurStoryMenuIsDisplayed());
        Assert.assertTrue(home.verifyOurSolutionMenuIsDisplayed());
        Assert.assertTrue(home.verifyWhyTendableMenuIsDisplayed());

    }

    /**
     * 2. Verify that the "Request a Demo" button is present and active on each of the
     * aforementioned top-level menu pages.
     */
    @Test(priority = 2)
    public void verifyReqADemoBtnTest() {
        Assert.assertTrue(home.verifyRequestDemoBtnIsDisplayedAndEnabled());

        try {
            home.clickOurStoryMenu();
        } catch (Exception e) {
            Assert.fail("Unable to click Our Story menu", e);
        }

        Assert.assertEquals("https://www.tendable.com/our-story", ourStory.verifyOurStoryURL());
        Assert.assertTrue(ourStory.verifyOurStoryPageTextIsDisplayed());

        Assert.assertTrue(home.verifyRequestDemoBtnIsDisplayedAndEnabled());

        try {
            home.clickOurSolutionMenu();
        } catch (Exception e) {
            Assert.fail("Unable to click Our Solution menu", e);
        }

        Assert.assertEquals("https://www.tendable.com/our-solution", ourSolution.verifyOurSolutionURL());
        Assert.assertTrue(ourSolution.verifyOurSolutionPageTextIsDisplayed());

        Assert.assertTrue(home.verifyRequestDemoBtnIsDisplayedAndEnabled());

        try {
            home.clickWhyTendableMenu();
        } catch (Exception e) {
            Assert.fail("Unable to click Why Tendable menu", e);
        }

        Assert.assertEquals("https://www.tendable.com/why-tendable", whyTendable.verifyWhyTendableURL());
        Assert.assertTrue(whyTendable.verifyWhyTendablePageTextIsDisplayed());

        Assert.assertTrue(home.verifyRequestDemoBtnIsDisplayedAndEnabled());
    }


    /**
     * 3. Navigate to the "Contact Us" section, choose "Marketing", and complete the form—
     * excluding the "Message" field. On submission, an error should arise. Ensure your script
     * confirms the error message's appearance. If the error is displayed, mark the test as PASS.
     */
    @Test(priority = 3)
    public void verifyMarketingFormSubmissionErrorMessagePassTest() throws InterruptedException {
      /*  init();
        launchURL();*/
        Assert.assertTrue(home.verifyContactUsBtnIsEnabled());

        try {
            home.clickContactUsBtn();
        } catch (Exception e) {
            Assert.fail("Unable to click ContactUS button", e);
        }

        Assert.assertTrue(contactUs.verifyContactBtnIsEnable());

        try {
            contactUs.clickContactBtn();
            for (Map<String, Object> map : jsonParser.getJsonData()) {
                contactUs.captureFullNameInputField((String) map.get("FullName"));
                contactUs.captureOrgNameInputField((String) map.get("OrganisationName"));
                contactUs.capturePhNumberInputField((String) map.get("PhoneNumber"));
                contactUs.captureEmailInputField((String) map.get("Email"));
                WebElement jobRole = contactUs.jobRoleField();
                dropDownSelect(jobRole, "Other");
                contactUs.clickIAgreeRadioBtn();
                contactUs.clickSubmitBtn();
            }
        } catch (Exception e) {
            Assert.fail("Unable to capture all details on the marketing form and submit", e);
        }
        Thread.sleep(3000);
        Assert.assertTrue(contactUs.verifySubmitFormErrorIsDisplayed());
    }

    /**
     * 3. If absent, it's a FAIL.
     */
    @Test(priority = 4)
    public void verifyMarketingFormSubmissionErrorMessageFailTest() {

        try {
            Thread.sleep(2000);
            Map<String, Object> map = jsonParser.getJsonData().get(0);
            contactUs.captureMessageField((String) map.get("Message"));
            contactUs.clickSubmitBtn();
        } catch (Exception e) {
            Assert.fail("Unable to capture in the message field and submit", e);
        }

        Assert.assertEquals(contactUs.verifySubmitFormSuccessMsg1IsDisplayed(), contactUs.verifySubmitFormErrorIsDisplayed());
    }

}
