package tests;

import base.BaseTest;
import com.qamobiledemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LoginPageTests extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        loginPage = new LoginPage();
    }

    // Check if user can type in the username field
    public void checkIfUserCanTypeInUsernameField() {
        // Set the username field
        loginPage.setUsernameField("John");

        // Get the username field
        String fieldText = loginPage.getUsernameField();

        // The default text for the username field is Username
        // Check if the user-entered username field doesn't equal the Username
        Assert.assertFalse(fieldText.equals("Username"),
                "\n User can't type in the username field \n");
    }

    // Check if the username field is required.
    public void checkIfUsernameFieldIsRequired() {
        // Navigate to the Login page
        textBoxPage.navigateToLoginPage();

        // Click the Login button
        loginPage.clickLoginButton();

        // Check if the validation message exists
        Assert.assertTrue(loginPage.isUsernameIsRequiredErrorMessageExists(),
                "\n The user didn't enter the username and the error message does not exist. \n");
    }

    // Check if user can delete the username field
    public void checkIfUserCanDeleteUsernameField() {
        // username string
        String username = "John";

        // Set the username field
        loginPage.setUsernameField(username);

        // Delete the username Field
        loginPage.deleteUsernameText();

        // Get length of the field
        int fieldLength = loginPage.getUsernameField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(username.length() > fieldLength,
                "\n User can't delete the username field  \n");
    }

    // Check if user can type in the password field
    public void checkIfUserCanTypeInPasswordField() {
        // Set the password field
        loginPage.setPasswordField("passwordtest");

        // Get the password field
        String fieldText = loginPage.getPasswordField();

        // The default text for the password field is Password
        // Check if the user-entered password field doesn't equal the Password
        Assert.assertFalse(fieldText.equals("Password"),
                "\n User can't type in the password field \n");
    }

    // Check if the password field is required.
    public void checkIfPasswordFieldIsRequired() {
        // Click the Login button
        loginPage.clickLoginButton();

        // Check if the validation message exists
        Assert.assertTrue(loginPage.isPasswordIsRequiredErrorMessageExists(),
                "\n The user didn't enter the password and the error message does not exist. \n");
    }

    // Check if user can delete the password field
    public void checkIfUserCanDeletePasswordField() {
        // password string
        String password = "passwordtest";

        // Set the password field
        loginPage.setPasswordField(password);

        // Delete the password Field
        loginPage.deletePasswordText();

        // Get length of the field
        int fieldLength = loginPage.getPasswordField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(password.length() > fieldLength,
                "\n User can't delete the password field  \n");
    }

    // Check the correct username and wrong password
    public void CheckCorrectUsernameAndWrongPassword() {
        // Set the username field
        loginPage.setUsernameField("correctusername");

        // Set the password field
        loginPage.setPasswordField("wrongpassword");

        // Click the Login Button
        loginPage.clickLoginButton();

        // Check if user login info is correct
        Assert.assertTrue(loginPage.IsUserNotFoundErrorMessageExists(),
                "\n Wrong password but validation message doesn't exist \n");
    }

    // Check the correct password and wrong username
    public void CheckCorrectPasswordAndWrongUsername() {
        // Set the username field
        loginPage.setUsernameField("wrongusername");

        // Set the password field
        loginPage.setPasswordField("correctpassword");

        // Click the Login Button
        loginPage.clickLoginButton();

        // Check if user login info is correct
        Assert.assertTrue(loginPage.IsUserNotFoundErrorMessageExists(),
                "\n Wrong username but validation message doesn't exist \n");

    }
}
