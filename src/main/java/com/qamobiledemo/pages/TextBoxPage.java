package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class TextBoxPage extends BasePage {

    private By fullNameField = By.xpath("//android.widget.TextView[@text=\"" +
            "Full Name\"]/following-sibling::android.widget.EditText[1]");
    private By emailField = By.xpath("//android.widget.TextView[@text=\"" +
            "Email\"]/following-sibling::android.widget.EditText[1]");
    private By addressField = By.xpath("//android.widget.TextView[@text=" +
            "\"Address\"]/following-sibling::android.widget.EditText[1]");
    private By commentField = By.xpath("//android.widget.TextView[@text=" +
            "\"Comment\"]/following-sibling::android.widget.EditText[1]");
    private By submitButton = accessibilityId("Submit");
    private By fullNameIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Full Name is required\"]");
    private By emailIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Email is required\"]");
    private By addressRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Address is required\"]");
    private By invalidEmailErrorText =
            By.xpath("//android.widget.TextView[@text=\"Invalid email\"]");
    private By menuHamburgerIcon = By.xpath("//android.widget.ImageView");
    private By checkBoxMenuItem = accessibilityId("Check Box");
    private By tableMenuItem = accessibilityId("Table");
    private By accordionMenuItem = accessibilityId("Accordion");
    private By progressBarMenuItem = accessibilityId("Progress Bar");
    private By formMenuItem = accessibilityId("Form");
    private By alertMenuItem = accessibilityId("Alerts");
    private By modalMenuItem = accessibilityId("Modal");
    private By registrationMenuItem = accessibilityId("Registration");
    private By loginMenuItem = accessibilityId("Login");
    private By selectMenuItem = accessibilityId("Select");
    private By datePickerMenuItem = accessibilityId("Date Picker");

    // Set the Full Name field
    public void setFullNameField(String text) {
        setText(fullNameField, text);
    }

    // Get the Full Name field
    public String getFullNameField() {
        return getText(fullNameField);
    }

    // Click the Submit button
    public void clickSubmitButton() {
        click(submitButton);
    }

    // Check if the Full Name required validation message exists
    public boolean isFullNameIsRequiredErrorMessageExists() {
       return !findElements(fullNameIsRequiredErrorText).isEmpty();
    }

    // Check if the Full Name minimum characters validation error message exists
    public boolean isFullNameMinimumCharactersErrorMessageExists(int minimumCharacters) {
        return !findElements(By.xpath("//android.widget.TextView[@text=\"Full " +
                "Name should be at least " + minimumCharacters + " characters\"]")).isEmpty();
    }

    // Check if the Full Name maximum characters validation error message exists
    public boolean isFullNameMaximumCharactersErrorMessageExists(int maximumCharacters) {
        return !findElements(By.xpath("//android.widget.TextView[@text=\"Full Name" +
                " should be maximum " + maximumCharacters + " characters\"]")).isEmpty();
    }

    // Delete the Full Name field
    public void deleteFullNameText() {
        find(fullNameField).sendKeys(Keys.BACK_SPACE);
    }

    // Set the Email field
    public void setEmailField(String text) {
        setText(emailField, text);
    }

    // Get the Email field
    public String getEmailField() {
        return getText(emailField);
    }

    // Check if the Email required validation message exists
    public boolean isEmailIsRequiredErrorMessageExists() {
        return !findElements(emailIsRequiredErrorText).isEmpty();
    }

    // Validate the Email field
    public boolean validateEmail(String email) {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE).matcher(email);
        return matcher.matches();
    }

    // Check if an email validation error message exists
    public boolean isEmailInvalid() {
        return !findElements(invalidEmailErrorText).isEmpty();
    }

    // Delete the Email field
    public void deleteEmailText() {
        find(emailField).sendKeys(Keys.BACK_SPACE);
    }

    // Set the Address field
    public void setAddressField(String text) {
        setText(addressField, text);
    }

    // Get the Address field
    public String getAddressField() {
        return getText(addressField);
    }

    // Check if the Address required validation message exists
    public boolean isAddressIsRequiredErrorMessageExists() {
        return !findElements(addressRequiredErrorText).isEmpty();
    }

    // Check if the Address minimum characters validation error message exists
    public boolean isAddressMinimumCharactersErrorMessageExists(int minimumCharacters) {
        return !findElements(By.xpath("//android.widget.TextView[@text=\"Address " +
                "should be at least " + minimumCharacters + " characters\"]")).isEmpty();
    }

    // Check if the Address maximum characters validation error message exists
    public boolean isAddressMaximumCharactersErrorMessageExists(int maximumCharacters) {
        return !findElements(By.xpath("//android.widget.TextView[@text=\"Address should be " +
                "maximum " + maximumCharacters + "characters\"]")).isEmpty();
    }

    // Delete the Address field
    public void deleteAddressText() {
        find(addressField).sendKeys(Keys.BACK_SPACE);
    }

    // Set the Comment field
    public void setCommentField(String text) {
        setText(commentField, text);
    }

    // Get the Comment field
    public String getCommentField() {
        return getText(commentField);
    }

    // Check if the Comment maximum characters validation error message exists
    public boolean isCommentMaximumCharactersErrorMessageExists(int maximumCharacters) {
        return !findElements(By.xpath("//android.widget.TextView[@text=\"Comment " +
                "should be maximum " + maximumCharacters + " characters\"]")).isEmpty();
    }

    // Navigate to the Checkbox page
    public void navigateToCheckboxPage() {
        click(menuHamburgerIcon);
        click(checkBoxMenuItem);
    }

    // Navigate to the Table page
    public void navigateToTablePage() {
        click(menuHamburgerIcon);
        click(tableMenuItem);
    }

    // Navigate to the Accordion page
    public void navigateToAccordionPage() {
        click(menuHamburgerIcon);
        click(accordionMenuItem);
    }

    // Navigate to the Progress Bar page
    public void navigateToProgressBarPage() {
        click(menuHamburgerIcon);
        click(progressBarMenuItem);
    }

    // Navigate to the Progress Form page
    public void navigateToFormPage() {
        click(menuHamburgerIcon);
        click(formMenuItem);
    }

    // Navigate to the Alerts page
    public void navigateToAlertPage() {
        click(menuHamburgerIcon);
        click(alertMenuItem);
    }

    // Navigate to the Modal page
    public void navigateToModalPage() {
        click(menuHamburgerIcon);
        click(modalMenuItem);
    }

    // Navigate to the Registration page
    public void navigateToRegistrationPage() {
        click(menuHamburgerIcon);
        click(registrationMenuItem);
    }

    // Navigate to the Login page
    public void navigateToLoginPage() {
        click(menuHamburgerIcon);
        click(loginMenuItem);
    }

    // Navigate to the Select page
    public void navigateToSelectPage() {
        click(menuHamburgerIcon);
        click(selectMenuItem);
    }

    // Navigate to the Date Picker page
    public void navigateToDatePickerPage() {
        click(menuHamburgerIcon);
        click(datePickerMenuItem);
    }


}
