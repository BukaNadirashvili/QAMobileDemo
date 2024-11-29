package tests;

import base.BaseTest;
import com.qamobiledemo.pages.ProgressBarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ProgressBarTest extends BaseTest {

    ProgressBarPage progressBarPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        progressBarPage = new ProgressBarPage();
    }

    // Check if after Start Progress button click
    // progress bar percentage is 100%
    public void checkProgressBarProgress() {
        // Navigate to the Progress Bar page
        textBoxPage.navigateToProgressBarPage();

        // Click the Start Progress button
        progressBarPage.clickStartProgressButton();

        // Check if the progress bar text is 100%
        Assert.assertTrue(progressBarPage.isProgressEnd(),
                "\n Progress bar not reached 100% \n");

    }

    // Check if after Reset Progress button click
    // progress bar percentage is 0%
    public void checkProgressBarReset() {
        // Click the Start Progress button
        progressBarPage.clickStartProgressButton();

        // Click the reset button
        progressBarPage.clickResetProgressButton();

        // Check if the progress bar text is 0%
        Assert.assertTrue(progressBarPage.isProgressReset(),
                "\n Progress bar percentage isn't 0% \n");
    }

}
