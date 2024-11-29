package tests;

import base.BaseTest;
import com.qamobiledemo.pages.DatePickerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class DatePickerTest extends BaseTest {

    DatePickerPage datePickerPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        datePickerPage = new DatePickerPage();
    }

    // Check if date picker works as expected
    public void checkDatePicker() {
        // Navigate to the date picker page
        textBoxPage.navigateToDatePickerPage();

        // Set the year variable
        String year = "2000";

        // Set the month variable
        String month = "August";

        // Set the day variable
        String day = "25";

        // Click the date picker
        datePickerPage.clickDatePicker();

        // Click the year text
        datePickerPage.clickYearText();

        // Set the year
        datePickerPage.setYear(year);

        // Set the month
        datePickerPage.setMonth(month);

        // Set the day
        datePickerPage.setDay(day);

        // Click the ok button
        datePickerPage.datePickerOkButtonClick();

        Assert.assertTrue(datePickerPage.checkIfDateSelected(year, month, day),
                "\n Date picker didn't select date as excepted \n");

    }
}
