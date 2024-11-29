package tests;

import base.BaseTest;
import com.qamobiledemo.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        registrationPage = new RegistrationPage();
    }

    // Check if user can type in the username field
    public void checkIfUserCanTypeInUsernameField() {
        // Set the username field
        registrationPage.setUsernameField("John");

        // Get the username field
        String fieldText = registrationPage.getUsernameField();

        // The default text for the username field is Username
        // Check if the user-entered username field doesn't equal the Username
        Assert.assertFalse(fieldText.equals("Username"),
                "\n User can't type in username field \n");
    }

    // Check if the username field is required.
    public void checkIfUsernameFieldIsRequired() {
        // Navigate to the Registration page
        textBoxPage.navigateToRegistrationPage();

        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the validation message exists
        Assert.assertTrue(registrationPage.isUsernameIsRequiredErrorMessageExists(),
                "\n The user didn't enter username and the error message does not exist. \n");
    }

    // Check if user can delete the username field
    public void checkIfUserCanDeleteUsernameField() {
        // username string
        String text = "John";

        // Set the username field
        registrationPage.setUsernameField(text);

        // Delete the username Field
        registrationPage.deleteUsernameText();

        // Get length of the field
        int fieldLength = registrationPage.getUsernameField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(text.length() > fieldLength,
                "\n User can't delete username field  \n");
    }

    // Check if user can type in the email field
    public void checkIfUserCanTypeInEmailField() {
        // Set the email field
        registrationPage.setEmailField("test@example.com");

        // Get the email field
        String fieldText = registrationPage.getEmailField();

        // The default text for the email field is Email
        // Check if the user-entered email field doesn't equal the Email
        Assert.assertFalse(fieldText.equals("Email"),
                "\n User can't type in email field \n");
    }

    // Check if the email field is required
    public void checkIfEmailFieldIsRequired() {
        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the validation message exists
        Assert.assertTrue(registrationPage.isEmailIsRequiredErrorMessageExists(),
                "\n The user didn't enter email and the error message does not exist. \n");
    }

    // Check if user entered email is correct
    public void checkEmailField() {
        // email string
        String email = "test@example.com";

        // Set the email field
        registrationPage.setEmailField(email);

        // Click the Register button
        registrationPage.clickRegisterButton();

        // Get the email field value
        String emailFieldValue = registrationPage.getEmailField();

        // Check if the email is valid and the validation message doesn't exist
        Assert.assertTrue(registrationPage.validateEmail(emailFieldValue)
                        && !registrationPage.isEmailInvalid(),
                "\n Incorrect email address \n");
    }

    // Check if user can delete the email field
    public void checkIfUserCanDeleteEmailField() {
        // email string
        String email = "test@example.com";

        // Set the email field
        registrationPage.setEmailField(email);

        // Delete the email Field
        registrationPage.deleteEmailText();

        // Get length of the field
        int fieldLength = registrationPage.getEmailField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(email.length() > fieldLength,
                "\n User can't delete email field  \n");
    }

    // Check if user can type in the password field
    public void checkIfUserCanTypeInPasswordField() {
        // Set the password field
        registrationPage.setPasswordField("passwordtest");

        // Get the password field
        String fieldText = registrationPage.getPasswordField();

        // The default text for the password field is Password
        // Check if the user-entered password field doesn't equal the Password
        Assert.assertFalse(fieldText.equals("Password"),
                "\n User can't type in password field \n");
    }

    // Check if the password field is required
    public void checkIfPasswordFieldIsRequired() {
        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the validation message exists
        Assert.assertTrue(registrationPage.isPasswordIsRequiredErrorMessageExists(),
                "\n The user didn't enter password and the error message does not exist. \n");
    }

    // Check the password field minimum length
    public void checkPasswordMinimumLength() {
        // password string
        String password = "passwordtest";

        // Set the password field
        registrationPage.setPasswordField(password);

        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the password field minimum length is correct and validation message
        // doesn't exist
        Assert.assertTrue(registrationPage.checkPasswordMinimumLength(password)
        && !registrationPage.checkPasswordMinimumLengthErrorTextExists(),
                "\n Invalid password minimum length \n ");
    }

    // Check if user can delete the password field
    public void checkIfUserCanDeletePasswordField() {
        // password string
        String password = "passwordtest";

        // Set the password field
        registrationPage.setPasswordField(password);

        // Delete the password Field
        registrationPage.deletePasswordText();

        // Get length of the field
        int fieldLength = registrationPage.getPasswordField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(password.length() > fieldLength,
                "\n User can't delete password field  \n");
    }

    // Check if user can type in the confirm password field
    public void checkIfUserCanTypeInConfirmPasswordField() {
        // Set the confirm password field
        registrationPage.setConfirmPasswordField("confirmpasswordtest");

        // Get the confirm password field
        String fieldText = registrationPage.getConfirmPasswordField();

        // The default text for the confirm password field is Confirm Password
        // Check if the user-entered confirm password field doesn't equal the Confirm Password
        Assert.assertFalse(fieldText.equals("Confirm Password"),
                "\n User can't type in confirm password field \n");
    }

    // Check if the confirm password field is required.
    public void checkIfConfirmPasswordFieldIsRequired() {
        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the validation message exists
        Assert.assertTrue(registrationPage.isConfirmPasswordIsRequiredErrorMessageExists(),
                "\n The user didn't enter confirm password" +
                        "and the error message does not exist. \n");
    }

    // Check if the confirm password field is equal to the password field
    public void checkIfConfirmPasswordFieldEqualsPassword() {
        // Set the password field
        registrationPage.setPasswordField("passwordtest");

        // Get the password field
        String password = registrationPage.getPasswordField();

        // Set the confirm password field
        registrationPage.setConfirmPasswordField("passwordtest");

        // Get the confirm password field
        String confirmPassword = registrationPage.getConfirmPasswordField();

        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the confirm password and password field are equal
        Assert.assertTrue(password.equals(confirmPassword)
                && !registrationPage.isPasswordMatchErrorMessageExists(),
                "\n Password and confirm password fields don't match \n");
    }

    // Check if user can delete the confirm password field
    public void checkIfUserCanDeleteConfirmPasswordField() {
        // confirm password string
        String confirmPassword = "confirmpasswordtest";

        // Set the confirm password field
        registrationPage.setConfirmPasswordField(confirmPassword);

        // Delete the confirm password Field
        registrationPage.deleteConfirmPasswordText();

        // Get length of the field
        int fieldLength = registrationPage.getConfirmPasswordField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(confirmPassword.length() > fieldLength,
                "\n User can't delete confirm password field  \n");
    }

    // Check successful registration
    public void checkSuccessfulRegistration() {
        // Set the username field
        registrationPage.setUsernameField("test");

        // Set the email field
        registrationPage.setEmailField("test@example.com");

        // Set the password field
        registrationPage.setPasswordField("testtest");

        // Set the confirm password field
        registrationPage.setConfirmPasswordField("testtest");

        // Click the Register button
        registrationPage.clickRegisterButton();

        // Check if the registration was successful
        Assert.assertTrue(registrationPage.isSuccessfulRegistrationTextExists(),
                "\n Registration wasn't successful \n");
    }

}
