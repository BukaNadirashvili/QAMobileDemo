package tests;

import base.BaseTest;
import com.qamobiledemo.pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class FormTest extends BaseTest {

    FormPage formPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        formPage = new FormPage();
    }

    // Check if user can type in the Username field
    public void checkIfUserCanTypeInUsernameField() {
        // Set the Username field
        formPage.setUsernameField("John");

        // Get the Username field
        String fieldText = formPage.getUsernameField();

        // The default text for the Username field is Username
        // Check if the user-entered Username field doesn't equal the Username.
        Assert.assertFalse(fieldText.equals("Username"),
                "\n User can't type in Username field \n");
    }

    // Check if Username field is required
    public void checkIfUsernameFieldIsRequired() {
        textBoxPage.navigateToFormPage();
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isUsernameIsRequiredErrorMessageExists(),
                "\n The user didn't enter Username and the error message does not exist. \n");
    }

    // Check if user can delete the Username field
    public void checkIfUserCanDeleteUsernameField() {
        // Username string
        String username = "John";

        // Set the Username field
        formPage.setUsernameField(username);

        // Delete the Username Field
        formPage.deleteUsernameText();

        // Get length of the field
        int fieldLength = formPage.getUsernameField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(username.length() > fieldLength,
                "\n User can't delete the Username field  \n");
    }

    // Check if user can type in the Email field
    public void checkIfUserCanTypeInEmailField() {
        // Set the Email field
        formPage.setEmailField("test@example.com");

        // Get the Email field
        String fieldText = formPage.getEmailField();

        // The default text for the Email field is Email
        // Check if the user-entered Email field doesn't equal the Email.
        Assert.assertFalse(fieldText.equals("Email"),
                "\n User can't type in Email field \n");
    }

    // Check if Email field is required
    public void checkIfEmailFieldIsRequired() {
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isEmailIsRequiredErrorMessageExists(),
                "\n The user didn't enter Email and the error message does not exist. \n");
    }

    // Check if user entered email is correct
    public void checkEmailField() {
        // Email
        String email = "test@example.com";

        // Set the Email field
        formPage.setEmailField(email);

        // Click the Submit button
        formPage.clickSubmitButton();

        // Get the email field value
        String emailFieldValue = formPage.getEmailField();

        // Check if the email is valid and the validation message doesn't exist
        Assert.assertTrue(formPage.validateEmail(emailFieldValue)
                        && !formPage.isEmailInvalid(),
                "\n Incorrect email address \n");
    }

    // Check if user can delete the Email field
    public void checkIfUserCanDeleteEmailField() {
        // Email string
        String email = "test@test.com";

        // Set the Email field
        formPage.setEmailField(email);

        // Delete the Email Field
        formPage.deleteEmailText();

        // Get length of the field
        int fieldLength = formPage.getEmailField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(email.length() > fieldLength,
                "\n User can't delete Email field  \n");
    }

    // Check if user can type in the Mobile Number field
    public void checkIfUserCanTypeInMobileNumberField() {
        // Set the Mobile Number field
        formPage.setMobileNumberField("1234567890");

        // Get the Mobile Number field
        String fieldText = formPage.getMobileNumberField();

        // The default text for the Mobile Number field is Mobile Number
        // Check if the user-entered Mobile Number field doesn't equal the Mobile Number.
        Assert.assertFalse(fieldText.equals("Mobile Number"),
                "\n User can't type in the Mobile Number field \n");
    }

    // Check if Mobile Number field is required
    public void checkIfMobileNumberFieldIsRequired() {
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isMobileNumberIsRequiredErrorMessageExists(),
                "\n The user didn't enter Mobile Number" +
                        " and the error message does not exist. \n");
    }

    // Check if the Mobile Number field length is 10 characters
    public void checkMobileNumberFieldLength() {
        // Set the Mobile Number field
        formPage.setMobileNumberField("1234567890");

        // Get the Mobile Number field
        String mobileNumberField = formPage.getMobileNumberField();

        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the Mobile Number field length is 10 characters
        Assert.assertTrue(mobileNumberField.length() == 10
        && !formPage.isMobileNumberMinRequiredCharactersErrorMessageExists(),
        "\n Mobile number field isn't 10 characters \n");
    }

    // Check if user can delete the Mobile Number field
    public void checkIfUserCanDeleteMobileNumberField() {
        // Mobile number string
        String mobileNumber = "1234567890";

        // Set the Mobile Number field
        formPage.setMobileNumberField(mobileNumber);

        // Delete the Mobile NUmber Field
        formPage.deleteMobileNumberText();

        // Get length of the field
        int fieldLength = formPage.getMobileNumberField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(mobileNumber.length() > fieldLength,
                "\n User can't delete the Mobile Number field  \n");
    }

    // Check if Gender field is required
    public void checkIfGenderFieldIsRequired() {
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isGenderIsRequiredErrorMessageExists(),
                "\n The user didn't enter Gender and the error message does not exist \n");
    }

    // Check if user can select the date of birth field
    public void checkDateOfBirthDatePicker() {
        // Set the year variable
        String year = "2020";

        // Set the month variable
        String month = "August";

        // Set the day variable
        String day = "25";

        // Get the selected month
        String selectedMonth = formPage.getMonthText();

        // Click the date of birth date picker
        formPage.clickDateOfBirthDatePicker();

        // Click the year text
        formPage.clickYearText();

        // Set the year
        formPage.setYear(formPage.getCurrentYear(), year);

        // Set the month
        formPage.setMonth(selectedMonth, month);

        // Set the day
        formPage.setDay(day);

        // Click the ok button
        formPage.datePickerOkButtonClick();

        // Check if expected date of birth selected
        Assert.assertTrue(formPage.checkIfDateSelected(year, month, day),
                "\n Date picker didn't select date as excepted \n");
    }

    // Check if date of birth isn't in future
    public void CheckDateOfBirthIsFuture() {
        // Get the array of the day of tomorrow
        String[] tomorrowDateInfo = formPage.getTomorrowDateInfo();

        // Set the day variable
        String day = tomorrowDateInfo[0];

        // Set the month variable
        String month = tomorrowDateInfo[1];

        // Set the year variable
        String year = tomorrowDateInfo[2];

        // Get the selected month
        String selectedMonth = formPage.getMonthText();

        // Click the date of birth date picker
        formPage.clickDateOfBirthDatePicker();

        // Get the selected year
        String selectedYear = formPage.getYearText();

        // Click the year text
        formPage.clickYearText();

        // Set the year
        formPage.setYear(selectedYear, year);

        // Set the month
        formPage.setMonth(selectedMonth, month);

        // Set the day
        formPage.setDay(day);

        // Click the ok button
        formPage.datePickerOkButtonClick();

        // Click the form submit button
        formPage.clickSubmitButton();

        // Check if the date of birth field value is in future and
        // error text exists
        Assert.assertTrue(formPage.checkIfDateOfBirthFieldValueIsInFuture()
        && formPage.checkDateOfBirthFutureErrorText(),
                "\n Date of birth field value is in future and error text doesn't exist \n");

    }

    // Check if Image field is required
    public void checkIfImageFieldIsRequired() {
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isImageIsRequiredErrorMessageExists(),
                "\n The user didn't select Image and the error message does not exist. \n");
    }

    // Check if user can select image (first image)
    public void checkIfUserCanSelectImage() {
        // Click the image field
        formPage.clickImageField();

        // Click the image to select image
        formPage.clickImageToSelect();

        // Check if image path is visible
        Assert.assertFalse(formPage.isImageFieldEmpty(),
                "\n User selected image but image path not visible \n");
    }

    // Check if privacy policy checkbox is required
    public void checkIfPrivacyPolicyCheckboxIsRequired() {
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isPrivacyPolicyCheckboxIsRequiredErrorMessageExists(),
                "\n The user didn't checked privacy policy checkbox" +
                        " and the error message does not exist. \n");
    }

    // Check if user can type in the Description field
    public void checkIfUserCanTypeInDescriptionField() {
        // Set the Description field
        formPage.setDescriptionField("Description example");

        // Get the Description field
        String fieldText = formPage.getDescriptionField();

        // The default text for the Description field is Description
        // Check if the user-entered Description field doesn't equal the Description
        Assert.assertFalse(fieldText.equals("Description"),
                "\n User can't type in Description field \n");
    }

    // Check if the Description field is required
    public void checkIfDescriptionFieldIsRequired() {
        // Click the Submit button
        formPage.clickSubmitButton();

        // Check if the validation message exists
        Assert.assertTrue(formPage.isDescriptionFieldIsRequiredErrorMessageExists(),
                "\n The user didn't enter Description" +
                        " and the error message does not exist. \n");
    }

    // Check if user can delete the Description field
    public void checkIfUserCanDeleteDescriptionField() {
        // Description string
        String description = "Description example";

        // Set the Description field
        formPage.setDescriptionField(description);

        // Delete the Description Field
        formPage.deleteDescriptionText();

        // Get length of the field
        int fieldLength = formPage.getDescriptionField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(description.length() > fieldLength,
                "\n User can't delete the Description field  \n");
    }

    // Check if user entered valid data in the form
    // and the form submitted successfully
    public void checkFormSubmit() {
        // Set the username field
        formPage.setUsernameField("usernametest");

        // Set the email field
        formPage.setEmailField("test@example.com");

        // Set the mobile number field
        formPage.setMobileNumberField("0123456789");

        // Set the gender field
        formPage.clickMaleGenderButton();

        // Set the date of birth field

        // Click the date of birth date picker
        formPage.clickDateOfBirthDatePicker();

        // Click the year text
        formPage.clickYearText();

        // Set the year
        formPage.setYear(formPage.getCurrentYear(), "2020");

        // Set the month
        formPage.setMonth(formPage.getMonthText(),"December");

        // Set the day
        formPage.setDay("1");

        // Click the ok button
        formPage.datePickerOkButtonClick();

        // Set the image field

        // Click the image field
        formPage.clickImageField();

        // Click the image to select
        formPage.clickImageToSelect();

        // Check the privacy & policy checkbox
        formPage.clickPrivacyPolicyCheckbox();

        // Set the description field
        formPage.setDescriptionField("Description example");

        // Click the submit button
        formPage.clickSubmitButton();

        // Check if the submit alert title exists
        Assert.assertTrue(formPage.checkFormSubmittedAlertTitleExists(),
                "\n Form not submitted \n");
    }

}
