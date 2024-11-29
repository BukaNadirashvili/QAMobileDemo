package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;

public class FormPage extends BasePage {

    private By usernameField =
            By.xpath("//android.widget.EditText[@hint='Username']");
    private By emailField = By.xpath("//android.widget.EditText[@hint='Email']");
    private By mobileNumberField =
            By.xpath("//android.widget.EditText[@hint='Mobile Number']");
    private By maleGenderButton =
            By.xpath("//android.widget.TextView[@text=\"Male\"]");
    private By femaleGenderButton =
            By.xpath("//android.widget.TextView[@text=\"Female\"]");
    private By dateOfBirthDatePicker =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"Date Of Birth\"]/following-sibling::android.view.ViewGroup" +
                    "[1]/android.widget.TextView");
    private By nextMonthButton = By.id("android:id/next");
    private By previousMonthButton = By.id("android:id/prev");
    private By yearText = By.xpath("//android.widget.TextView" +
            "[@resource-id=\"android:id/date_picker_header_year\"]");
    private By datePickerOkButton =
            By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private By dateOfBirthFutureErrorText =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"Date of birth cannot be in the future\"]");
    private By pickImageField =
            By.xpath("//android.widget.TextView[@text=\"Pick an Image\"]");
    private By image =
            By.id("com.google.android.providers.media.module:id/icon_thumbnail");
    private By privacyPolicyCheckbox =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"☐ I agree to the privacy policy\"]");
    private By descriptionField =
            By.xpath("//android.widget.EditText[@hint='Description']");
    private By submitButton =
            By.xpath("//android.widget.TextView[@text=\"SUBMIT\"]");
    private By usernameIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private By emailIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Email is required\"]");
    private By invalidEmailErrorText =
            By.xpath("//android.widget.TextView[@text=\"Invalid email address\"]");
    private By mobileNumberMinLengthErrorText =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"Mobile number must be 10 digits\"]");
    private By mobileNumberIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Mobile number is required\"]");
    private By genderIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Gender is required\"]");
    private By imageIsRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Image is required\"]");
    private By privacyPolicyRequiredErrorText =
            By.xpath("//android.widget.TextView" +
                    "[@text=\"You must accept the terms and conditions\"]");
    private By descriptionRequiredErrorText =
            By.xpath("//android.widget.TextView[@text=\"Description is required\"]");
    private By formSubmitAlertTitle = By.id("com.qademoapp:id/alertTitle");

    // Create a map of month names to month numbers
    private static final Map<String, String> monthMap = new HashMap<>();

    static {
        monthMap.put("January", "1");
        monthMap.put("February", "2");
        monthMap.put("March", "3");
        monthMap.put("April", "4");
        monthMap.put("May", "5");
        monthMap.put("June", "6");
        monthMap.put("July", "7");
        monthMap.put("August", "8");
        monthMap.put("September", "9");
        monthMap.put("October", "10");
        monthMap.put("November", "11");
        monthMap.put("December", "12");
    }

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    // Set the Username field
    public void setUsernameField(String text) {
        // Find the year scroll element
        WebElement wheelElement = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup"));

        // Convert it to remote web element
        RemoteWebElement element = (RemoteWebElement) wheelElement;

        if(findElements(usernameField).isEmpty()) {
            scrollToElement(element, "up", 0.5);
        }


        setText(usernameField, text);
    }

    // Get the Username field
    public String getUsernameField() {
        return getText(usernameField);
    }

    // Click the Submit button
    public void clickSubmitButton() {
        scrollToElementByText("SUBMIT");
        click(submitButton);
    }

    // Check if the Username required validation message exists
    public boolean isUsernameIsRequiredErrorMessageExists() {
        return !findElements(usernameIsRequiredErrorText).isEmpty();
    }

    // Delete the Username field
    public void deleteUsernameText() {
        find(usernameField).sendKeys(Keys.BACK_SPACE);
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

    // Set the Mobile Number field
    public void setMobileNumberField(String text) {
        setText(mobileNumberField, text);
    }

    // Get the Mobile Number field
    public String getMobileNumberField() {
        return getText(mobileNumberField);
    }

    // Check if the Mobile Number required validation message exists
    public boolean isMobileNumberIsRequiredErrorMessageExists() {
        return !findElements(mobileNumberIsRequiredErrorText).isEmpty();
    }

    // Check if the Mobile Number field at least 10 characters
    public boolean isMobileNumberMinRequiredCharactersErrorMessageExists() {
        return !findElements(mobileNumberMinLengthErrorText).isEmpty();
    }

    // Delete the Mobile Number field
    public void deleteMobileNumberText() {
        find(mobileNumberField).sendKeys(Keys.BACK_SPACE);
    }

    // Click the male gender button
    public void clickMaleGenderButton() {
        click(maleGenderButton);
    }

    // Click the female gender button
    public void clickFemaleGenderButton() {
        click(femaleGenderButton);
    }

    // Click the date of birth date picker
    public void clickDateOfBirthDatePicker() {
        click(dateOfBirthDatePicker);
    }

    // Get the month text
    public String getMonthText() {
        try {
            String dateString = getText(dateOfBirthDatePicker);

            // Define the formatter for the input string format (MM/dd/yyyy)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");

            // Parse the input string to a LocalDate object
            LocalDate date = LocalDate.parse(dateString, formatter);

            // Get the full month name and format it with only the first letter capitalized
            String monthName = date.getMonth().name();  // This gives the month in uppercase
            return monthName.substring(0, 1) + monthName.substring(1).toLowerCase(); // Capitalize first letter only
        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return "";
        }
    }

    // Click the year text
    public void clickYearText() {
        click(yearText);
    }

    // Get the year text
    public String getYearText() {
        return getText(yearText);
    }

    // Get the current year
    public String getCurrentYear() {
        // Get the current year
        return String.valueOf(LocalDate.now().getYear());
    }

    // Set the year
    public void setYear(String selectedYear, String targetYear) {
        try {
            // Get the current year
            int currentYear = Integer.parseInt(selectedYear);

            // If current year equals to the target year don't scroll
            if(currentYear != Integer.parseInt(targetYear)) {

                // The direction to scroll
                String direction = "";

                // Set scroll direction according the target year value
                if(currentYear > Integer.parseInt(targetYear)) {
                    direction = "up";
                } else if(currentYear < Integer.parseInt(targetYear)) {
                    direction = "down";
                }

                // Find the year scroll element
                WebElement wheelElement = driver.findElement(By.id("android:id/date_picker_year_picker"));

                // Convert it to remote web element
                RemoteWebElement element = (RemoteWebElement) wheelElement;

                // While element not found scroll to the related direction
                while(findElements(
                        By.xpath("//android.widget.TextView" +
                                "[@resource-id=\"android:id/text1\" and @text=\"" + targetYear + "\"]")).isEmpty()
                ) {
                    scrollToElement(element, direction, 0.5);
                }
            }

            // Click the year element
            click(By.xpath("//android.widget.TextView" +
                    "[@resource-id=\"android:id/text1\" and @text=\"" + targetYear + "\"]"));

        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
        }
    }

    // Set the month
    public void setMonth(String currentMonth, String targetMonth) {
        try {
            // Convert the parameter month string to a Month enum
            Month currentMonthEnum = Month.valueOf(currentMonth.toUpperCase());

            // Get the month number for the parameter month
            int currentMonthValue = currentMonthEnum.getValue();

            // Convert the parameter month string to a Month enum
            Month parameterMonthEnum = Month.valueOf(targetMonth.toUpperCase());

            // Get the month number for the parameter month
            int parameterMonthValue = parameterMonthEnum.getValue();

            if(parameterMonthValue != currentMonthValue) {
                // Calculate the number of months away from the current month
                int monthsDifference = parameterMonthValue - currentMonthValue;


                // Compare the parameter month with the current month
                if (parameterMonthValue < currentMonthValue) {
                    for(int i = 0; i < abs(monthsDifference); i++) {
                        click(previousMonthButton);
                    }
                } else {
                    for(int i = 0; i < monthsDifference; i++) {
                        click(nextMonthButton);
                    }
                }
            }
        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
        }
    }

    // Set the day
    public void setDay(String day) {
        try {
            click(find(
                    By.xpath("//android.view.View[contains(@content-desc, '" + day + " ')]"))
            );
        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
        }
    }

    // Click the date picker OK button
    public void datePickerOkButtonClick() {
        click(datePickerOkButton);
    }

    // Method to convert month name to month number
    private String monthNameToNumber(String monthName) {
        return monthMap.get(monthName);
    }

    // Check if the date selected
    public boolean checkIfDateSelected(String year, String month, String day) {
        try {
            // Build the XPath dynamically using the parameters for year, month number, and day
            //android.widget.TextView[@text="12/10/2024"]
            String xpath = "//android.widget.TextView" +
                    "[@text='" + monthNameToNumber(month) + "/" + day + "/" + year + "']";

            // Find elements using the dynamic XPath and check if any elements are found
            return !findElements(By.xpath(xpath)).isEmpty();

        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return false;
        }
    }

    public String[] getTomorrowDateInfo() {
        // Get the current date and add 1 day to get tomorrow's date
        LocalDate tomorrowDate = LocalDate.now().plusDays(1);

        // Extract day, month (full name), and year
        int day = tomorrowDate.getDayOfMonth();
        String month = tomorrowDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = tomorrowDate.getYear();

        // Return the values as a string array
        return new String[]{String.valueOf(day), month, String.valueOf(year)};
    }

    // Check if the date of birth selected date is in the future error text exists
    public boolean checkDateOfBirthFutureErrorText() {
        return !findElements(dateOfBirthFutureErrorText).isEmpty();
    }

    // Check if the date of birth field value is in future
    public boolean checkIfDateOfBirthFieldValueIsInFuture() {
        // The date string in the format MM/dd/yyyy
        String dateString = getText(dateOfBirthDatePicker);

        // Define the date format
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        try {
            // Parse the input date string into a Date object
            Date inputDate = sdf.parse(dateString);

            // Get the current date
            Date currentDate = new Date();

            // Check if the input date is in the future
            return inputDate.after(currentDate);

        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return false;
        }
    }

    // Check if the Gender required validation message exists
    public boolean isGenderIsRequiredErrorMessageExists() {
        return !findElements(genderIsRequiredErrorText).isEmpty();
    }

    // Click the image field
    public void clickImageField() {
        click(pickImageField);
    }

    // Click the image to select
    public void clickImageToSelect() {
        click(image);
    }

    // Check if the Image required validation message exists
    public boolean isImageIsRequiredErrorMessageExists() {
        return !findElements(imageIsRequiredErrorText).isEmpty();
    }

    // Check if the image field is empty
    public boolean isImageFieldEmpty() {
        return findElements(
                By.xpath("//android.widget.TextView[starts-with(@text, 'Image Selected')]"))
                .isEmpty();
    }

    // Click the privacy policy checkbox
    public void clickPrivacyPolicyCheckbox() {
        click(privacyPolicyCheckbox);
    }

    // Check if the privacy policy required validation message exists
    public boolean isPrivacyPolicyCheckboxIsRequiredErrorMessageExists() {
        return !findElements(privacyPolicyRequiredErrorText).isEmpty();
    }

    // Set the Description field
    public void setDescriptionField(String text) {
        setText(descriptionField, text);
    }

    // Get the Description field
    public String getDescriptionField() {
        return getText(descriptionField);
    }

    // Check if the Description required validation message exists
    public boolean isDescriptionFieldIsRequiredErrorMessageExists() {
        return !findElements(descriptionRequiredErrorText).isEmpty();
    }

    // Delete the Description field
    public void deleteDescriptionText() {
        find(descriptionField).sendKeys(Keys.BACK_SPACE);
    }

    // Check if the form submitted alert title exists
    public boolean checkFormSubmittedAlertTitleExists() {
        return !findElements(formSubmitAlertTitle).isEmpty();
    }

}
