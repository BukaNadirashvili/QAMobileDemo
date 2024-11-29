package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;

public class ProgressBarPage extends BasePage {

    private By startProgressButton =
            By.xpath("//android.widget.TextView[@text=\"START PROGRESS\"]");
    private By resetProgressButton =
            By.xpath("//android.widget.TextView[@text=\"RESET PROGRESS\"]");
    private By progressEndPercentage =
            By.xpath("//android.widget.TextView[@text=\"100% \"]");
    private By progressStartPercentage =
            By.xpath("//android.widget.TextView[@text=\"0% \"]");

    // Click the Start Progress button
    public void clickStartProgressButton() {
        click(startProgressButton);
    }

    // Click the Reset Progress button
    public void clickResetProgressButton() {
        click(resetProgressButton);
    }

    // Check if the progress text is 100%
    public boolean isProgressEnd() {
        return !findElements(progressEndPercentage).isEmpty();
    }

    // Check if the progress text is 0%
    public boolean isProgressReset() {
        return !findElements(progressStartPercentage).isEmpty();
    }

}