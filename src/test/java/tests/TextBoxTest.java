package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TextBoxTest extends BaseTest {

    // Check if user can type in the Full Name field
    public void checkIfUserCanTypeInFullNameField() {
        // Set the Full Name field
        textBoxPage.setFullNameField("John");

        // Get the Full Name field
        String fieldText = textBoxPage.getFullNameField();

        // The default text for the Full Name field is Full Name
        // Check if the user-entered Full Name field doesn't equal the Full Name.
        Assert.assertFalse(fieldText.equals("Full Name"),
                "\n User can't type in Full Name field \n");
    }

    // Check if Full Name field is required.
    public void checkIfFullNameFieldIsRequired() {
        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(textBoxPage.isFullNameIsRequiredErrorMessageExists(),
                "\n The user didn't enter Full Name and the error message does not exist. \n");
    }

    // Check the Full Name field minimum characters
    public void checkFullNameFieldMinimumCharacters() {
        // Count of minimum characters
        int minimumCharacters = 2;

        // Set the Full Name field
        textBoxPage.setFullNameField("Jo");

        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Get length of the field
        int fieldLength = textBoxPage.getFullNameField().length();

        // Minimum characters should be less than field length and
        // validation text should not appear
        Assert.assertTrue(minimumCharacters <= fieldLength &&
                        !textBoxPage.isFullNameMinimumCharactersErrorMessageExists(minimumCharacters),
                "\n Full Name must have at least " + minimumCharacters + " characters \n");
    }

    // Check the Full Name field maximum characters
    public void checkFullNameFieldMaximumCharacters() {
        // Count of maximum characters
        int maximumCharacters = 25;

        // Set the Full Name field
        textBoxPage.setFullNameField("Jo");

        // Get length of the field
        int fieldLength = textBoxPage.getFullNameField().length();

        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Maximum characters should be more than field length and
        // validation text should not appear
        Assert.assertTrue(maximumCharacters >= fieldLength &&
                        !textBoxPage.isFullNameMaximumCharactersErrorMessageExists(maximumCharacters),
                "\n Full Name field must be no longer than " +
                        maximumCharacters + " characters \n");
    }

    // Check if user can delete the Full Name field
    public void checkIfUserCanDeleteFullNameField() {
        // Full Name string
        String text = "John";

        // Set the Full Name field
        textBoxPage.setFullNameField(text);

        // Delete the Full Name Field
        textBoxPage.deleteFullNameText();

        // Get length of the field
        int fieldLength = textBoxPage.getFullNameField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(text.length() > fieldLength,
                "\n User can't delete Full Name field  \n");
    }

    // Check if user can type in the Email field
    public void checkIfUserCanTypeInEmailField() {
        // Set the Email field
        textBoxPage.setEmailField("test@test.com");

        // Get the Email field
        String fieldText = textBoxPage.getEmailField();

        // The default text for the Email field is name@email.com
        // Check if the user-entered Email field doesn't equal the name@email.com.
        Assert.assertFalse(fieldText.equals("name@email.com"),
                "\n User can't type in Email field \n");
    }

    // Check if Email field is required.
    public void checkIfEmailFieldIsRequired() {
        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(textBoxPage.isEmailIsRequiredErrorMessageExists(),
                "\n The user didn't enter Email and the error message does not exist. \n");
    }

    // Check if user entered email is correct
    public void checkEmailField() {
        // Email
        String email = "test@test.com";

        // Set the Email field
        textBoxPage.setEmailField(email);

        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Get the email field value
        String emailFieldValue = textBoxPage.getEmailField();

        // Check if the email is valid and the validation message doesn't exist
        Assert.assertTrue(textBoxPage.validateEmail(emailFieldValue)
                        && !textBoxPage.isEmailInvalid(),
                "\n Incorrect email address \n");
    }

    // Check if user can delete the Email field
    public void checkIfUserCanDeleteEmailField() {
        // Email string
        String email = "test@test.com";

        // Set the Email field
        textBoxPage.setEmailField(email);

        // Delete the Email Field
        textBoxPage.deleteEmailText();

        // Get length of the field
        int fieldLength = textBoxPage.getEmailField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(email.length() > fieldLength,
                "\n User can't delete Email field  \n");
    }

    // Check if user can type in the Address field
    public void checkIfUserCanTypeInAddressField() {
        // Set the Address field
        textBoxPage.setAddressField("Address Example");

        // Get the Address field
        String fieldText = textBoxPage.getAddressField();

        // The default text for the Address field is Address
        // Check if the user-entered Address field doesn't equal the Address.
        Assert.assertFalse(fieldText.equals("Address"),
                "\n User can't type in Address field \n");
    }

    // Check if the Address field is required.
    public void checkIfAddressFieldIsRequired() {
        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(textBoxPage.isAddressIsRequiredErrorMessageExists(),
                "\n The user didn't enter Address and the error message does not exist. \n");
    }

    // Check the Address field minimum characters
    public void checkAddressFieldMinimumCharacters() {
        // Count of minimum characters
        int minimumCharacters = 2;

        // Set the Address field
        textBoxPage.setAddressField("Jo");

        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Get length of the field
        int fieldLength = textBoxPage.getAddressField().length();

        // Minimum characters should be less than field length and
        // validation text should not appear
        Assert.assertTrue(minimumCharacters <= fieldLength &&
                        !textBoxPage.isAddressMinimumCharactersErrorMessageExists(minimumCharacters),
                "\n Address must have at least " + minimumCharacters + " characters \n");
    }

    // Check the Address field maximum characters
    public void checkAddressFieldMaximumCharacters() {
        // Count of maximum characters
        int maximumCharacters = 50;

        // Set the Address field
        textBoxPage.setAddressField("Jo");

        // Get length of the field
        int fieldLength = textBoxPage.getAddressField().length();

        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Maximum characters should be more than field length and
        // validation text should not appear
        Assert.assertTrue(maximumCharacters >= fieldLength &&
                        !textBoxPage.isAddressMaximumCharactersErrorMessageExists(maximumCharacters),
                "\n Address field must be no longer than " +
                        maximumCharacters + " characters \n");
    }

    // Check if user can delete the Address field
    public void checkIfUserCanDeleteAddressField() {
        // Address string
        String address = "Address Example";

        // Set the Address field
        textBoxPage.setAddressField(address);

        // Delete the Address Field
        textBoxPage.deleteAddressText();

        // Get length of the field
        int fieldLength = textBoxPage.getAddressField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(address.length() > fieldLength,
                "\n User can't delete the Address field  \n");
    }

    // Check if user can type in the Comment field
    public void checkIfUserCanTypeInCommentField() {
        // Set the Comment field
        textBoxPage.setCommentField("Comment Example");

        // Get the Comment field
        String fieldText = textBoxPage.getCommentField();

        // The default text for the Comment field is Comment
        // Check if the user-entered Comment field doesn't equal the Comment.
        Assert.assertFalse(fieldText.equals("Comment"),
                "\n User can't type in Comment field \n");
    }

    // Check the Comment field maximum characters
    public void checkCommentFieldMaximumCharacters() {
        // Count of maximum characters
        int maximumCharacters = 100;

        // Set the Comment field
        textBoxPage.setCommentField("Comment Example");

        // Get length of the field
        int fieldLength = textBoxPage.getCommentField().length();

        // Click the Submit button
        textBoxPage.clickSubmitButton();

        // Maximum characters should be more than field length and
        // validation text should not appear
        Assert.assertTrue(maximumCharacters >= fieldLength &&
                        !textBoxPage.isCommentMaximumCharactersErrorMessageExists(maximumCharacters),
                "\n Comment field must be no longer than " +
                        maximumCharacters + " characters \n");
    }

}