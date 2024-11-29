package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class ModalPage extends BasePage {

    private By modalButton = accessibilityId("OPEN MODAL");
    private By modalTitle = By.xpath("//android.widget.TextView[@text=\"Modal\"]");
    private By cancelButton = accessibilityId("CLOSE");

    // Click the modal button
    public void clickModalButton() {
        click(modalButton);
    }

    // Get the modal title
    public String getModalTitle() {
        return getText(modalTitle);
    }

    // Click the Cancel button
    public void clickCancelButton() {
        click(cancelButton);
    }

    // Check if the modal button exists
    public boolean checkModalBUttonExists() {
        return !findElements(modalButton).isEmpty();
    }


}
