package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class AlertPage extends BasePage {

    private By firstAlertButton =
            By.xpath("//android.widget.TextView[@text=\"SHOW FIRST ALERT\"]");
    private By secondAlertButton =
            By.xpath("//android.widget.TextView[@text=\"SHOW SECOND ALERT (5S DELAY)\"]");
    private By confirmBoxButton =
            By.xpath("//android.widget.Button[@content-desc=\"SHOW CONFIRM BOX\"]");
    private By promptButton =
            By.xpath("//android.widget.TextView[@text=\"SHOW PROMPT BOX\"]");
    private By alertTitle = By.id("com.qademoapp:id/alertTitle");
    private By promptTitle =
            By.xpath("//android.widget.TextView[@text=\"Enter Text\"]");
    private By okButton = By.id("android:id/button1");
    private By alertPageTitle =
            By.xpath("//android.widget.TextView[@text=\"Alerts\"]");
    private By cancelButton = By.id("android:id/button2");
    private By promptInputField = By.xpath("//android.widget.EditText");
    private By promptCancelButton = accessibilityId("CANCEL");
    private By promptOkButton = accessibilityId("OK");

    // Click the first alert button
    public void clickFirstAlertButton() {
        click(firstAlertButton);
    }

    // Click the second alert button
    public void clickSecondAlertButton() {
        click(secondAlertButton);
    }

    // Click the confirm box button
    public void clickConfirmBoxButton() {
        click(confirmBoxButton);
    }

    // Click the prompt button
    public void clickPromptButton() {
        click(promptButton);
    }

    // Get the alert title
    public String getAlertTitle() {
        return getText(alertTitle);
    }

    // Get the prompt title
    public String getPromptTitle() {
        return getText(promptTitle);
    }

    // Click the OK button
    public void clickOkButton() {
        click(okButton);
    }

    // Get the Alert page title
    public String getAlertPageTitle() {
        return getText(alertPageTitle);
    }

    // Click the Cancel button
    public void clickCancelButton() {
        click(cancelButton);
    }

    // Set the prompt input field
    public void setPromptInputField(String text) {
        setText(promptInputField, text);
    }

    // Get the prompt input field
    public String getPromptInputField() {
        return getText(promptInputField);
    }

    // Delete the prompt input field
    public void deletePromptInputText() {
        find(promptInputField).sendKeys(Keys.BACK_SPACE);
    }

    // Click the prompt box cancel button
    public void clickPromptCancelButton() {
        click(promptCancelButton);
    }

    // Click the prompt Ok button
    public void clickPromptOkButton() {
        click(promptOkButton);
    }

}