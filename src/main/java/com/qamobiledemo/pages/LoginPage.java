package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class LoginPage extends BasePage {

    private By usernameField = By.xpath("//android.widget.EditText[1]");
    private By passwordField = By.xpath("//android.widget.EditText[2]");
    private By loginButton = accessibilityId("LOGIN");
    private By usernameIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private By passwordIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Password is required\"]");
    private By userNotFoundErrorMessageText =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"No user found. Please register first.\"]");

    // Set the username field
    public void setUsernameField(String text) {
        setText(usernameField, text);
    }

    // Get the username field
    public String getUsernameField() {
        return getText(usernameField);
    }

    // Click the Login button
    public void clickLoginButton() {
        click(loginButton);
    }

    // Check if the username required validation message exists
    public boolean isUsernameIsRequiredErrorMessageExists() {
        return !findElements(usernameIsRequiredErrorText).isEmpty();
    }

    // Delete the username field
    public void deleteUsernameText() {
        find(usernameField).sendKeys(Keys.BACK_SPACE);
    }

    // Set the password field
    public void setPasswordField(String text) {
        setText(passwordField, text);
    }

    // Get the password field
    public String getPasswordField() {
        return getText(passwordField);
    }

    // Check if the password required validation message exists
    public boolean isPasswordIsRequiredErrorMessageExists() {
        return !findElements(passwordIsRequiredErrorText).isEmpty();
    }

    // Delete the password field
    public void deletePasswordText() {
        find(passwordField).sendKeys(Keys.BACK_SPACE);
    }

    // Check if no user found error message exists
    public boolean IsUserNotFoundErrorMessageExists() {
        return !findElements(userNotFoundErrorMessageText).isEmpty();
    }
}
