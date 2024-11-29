package tests;

import base.BaseTest;
import com.qamobiledemo.pages.AccordionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AccordionTest extends BaseTest {

    AccordionPage accordionPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        accordionPage = new AccordionPage();
    }

    // Check the first accordion open
    public void checkFirstAccordionOpen() {
        // Navigate to the Accordion Page
        textBoxPage.navigateToAccordionPage();

        // Click the first accordion open button
        accordionPage.clickFirstAccordionOpenButton();

        // Check if the first accordion text is visible
        Assert.assertTrue(accordionPage.isFirstAccordionTextVisible(),
                "\n The first accordion text isn't visible \n");
    }

    // Check the second accordion open
    public void checkSecondAccordionOpen() {
        // Click the second accordion open button
        accordionPage.clickSecondAccordionOpenButton();

        // Check if the second accordion text is visible
        Assert.assertTrue(accordionPage.isSecondAccordionTextVisible(),
                "\n The second accordion text isn't visible \n");
    }

    // Check the third accordion open
    public void checkThirdAccordionOpen() {
        // Click the third accordion open button
        accordionPage.clickThirdAccordionOpenButton();

        // Check if the third accordion text is visible
        Assert.assertTrue(accordionPage.isThirdAccordionTextVisible(),
                "\n The third accordion text isn't visible \n");
    }

    // Check the first accordion close
    public void checkFirstAccordionClose() {
        // Click the first accordion close button
        accordionPage.clickAccordionCloseButton();

        // Check if the first accordion text is visible
        Assert.assertFalse(accordionPage.isFirstAccordionTextVisible(),
                "\n The first accordion text is visible \n");
    }

    // Check the second accordion close
    public void checkSecondAccordionClose() {
        // Click the second accordion close button
        accordionPage.clickAccordionCloseButton();

        // Check if the second accordion text is visible
        Assert.assertFalse(accordionPage.isSecondAccordionTextVisible(),
                "\n The second accordion text is visible \n");
    }

    // Check the third accordion close
    public void checkThirdAccordionClose() {
        // Click the third accordion close button
        accordionPage.clickAccordionCloseButton();

        // Check if the third accordion text is visible
        Assert.assertFalse(accordionPage.isThirdAccordionTextVisible(),
                "\n The third accordion text is visible \n");
    }

}
