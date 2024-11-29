package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class RegistrationPage extends BasePage {

    private By usernameField = By.xpath("//android.widget.EditText[1]");
    private By emailField = By.xpath("//android.widget.EditText[2]");
    private By passwordField = By.xpath("//android.widget.EditText[3]");
    private By confirmPasswordField = By.xpath("//android.widget.EditText[4]");
    private By registerButton = accessibilityId("REGISTER");
    private By usernameIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private By emailIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Email is required\"]");
    private By invalidEmailErrorText =
            By.xpath("//android.widget.TextView[@text=\"Enter a valid email address\"]");
    private By passwordIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Password is required\"]");
    private By passwordLengthErrorText =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"Password must be at least 6 characters\"]");
    private By confirmPasswordIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Confirm password is required\"]");
    private By passwordMatchErrorText =
            By.xpath("//android.widget.TextView[@text=\"Passwords must match\"]");
    private By registrationSuccessfulText =
            By.xpath("//android.widget.TextView[@text=\"Registration Successful!\"]");

    // Set the username field
    public void setUsernameField(String text) {
        setText(usernameField, text);
    }

    // Get the username field
    public String getUsernameField() {
        return getText(usernameField);
    }

    // Click the Register button
    public void clickRegisterButton() {
        click(registerButton);
    }

    // Check if the username required validation message exists
    public boolean isUsernameIsRequiredErrorMessageExists() {
        return !findElements(usernameIsRequiredErrorText).isEmpty();
    }

    // Delete the username field
    public void deleteUsernameText() {
        find(usernameField).sendKeys(Keys.BACK_SPACE);
    }

    // Set the email field
    public void setEmailField(String text) {
        setText(emailField, text);
    }

    // Get the email field
    public String getEmailField() {
        return getText(emailField);
    }

    // Check if the email required validation message exists
    public boolean isEmailIsRequiredErrorMessageExists() {
        return !findElements(emailIsRequiredErrorText).isEmpty();
    }

    // Validate the email field
    public boolean validateEmail(String email) {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE).matcher(email);
        return matcher.matches();
    }

    // Check if an email validation error message exists
    public boolean isEmailInvalid() {
        return !findElements(invalidEmailErrorText).isEmpty();
    }

    // Delete the email field
    public void deleteEmailText() {
        find(emailField).sendKeys(Keys.BACK_SPACE);
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

    // Check the password minimum length is more than 6 characters
    public boolean checkPasswordMinimumLength(String password) {
        return password.length() > 6;
    }

    // Check if the password field length error text exists
    public boolean checkPasswordMinimumLengthErrorTextExists() {
        return !findElements(passwordLengthErrorText).isEmpty();
    }

    // Delete the password field
    public void deletePasswordText() {
        find(passwordField).sendKeys(Keys.BACK_SPACE);
    }

    // Set the confirm password field
    public void setConfirmPasswordField(String text) {
        setText(confirmPasswordField, text);
    }

    // Get the confirm password field
    public String getConfirmPasswordField() {
        return getText(confirmPasswordField);
    }

    // Check if the confirm password required validation message exists
    public boolean isConfirmPasswordIsRequiredErrorMessageExists() {
        return !findElements(confirmPasswordIsRequiredErrorText).isEmpty();
    }

    // Check if password match error message exists
    public boolean isPasswordMatchErrorMessageExists() {
        return !findElements(passwordMatchErrorText).isEmpty();
    }

    // Delete the confirm password field
    public void deleteConfirmPasswordText() {
        find(confirmPasswordField).sendKeys(Keys.BACK_SPACE);
    }

    // Check if the successful registration text exists
    public boolean isSuccessfulRegistrationTextExists() {
        return !findElements(registrationSuccessfulText).isEmpty();
    }
}
