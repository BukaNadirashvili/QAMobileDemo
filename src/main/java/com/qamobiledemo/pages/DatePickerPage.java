package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class DatePickerPage extends BasePage {

    private By datePicker = By.xpath("//android.widget.TextView" +
            "[@text=\"Select Date\"]");
    private By yearText = By.xpath("//android.widget.TextView" +
            "[@resource-id=\"android:id/date_picker_header_year\"]");
    private By datePickerOkButton =
            By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private By nextMonthButton = By.id("android:id/next");
    private By previousMonthButton = By.id("android:id/prev");

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

    // Click the date picker
    public void clickDatePicker() {
        click(datePicker);
    }

    // Click the year text
    public void clickYearText() {
        click(yearText);
    }

    // Click the date picker OK button
    public void datePickerOkButtonClick() {
        click(datePickerOkButton);
    }

    // Set the year
    public void setYear(String targetYear) {
        try {
            // Get the current year
            int currentYear = LocalDate.now().getYear();

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
    public void setMonth(String targetMonth) {
        try {
            // Get the current month as an integer
            int currentMonthValue = LocalDate.now().getMonthValue();

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

    // Method to convert month name to month number
    private String monthNameToNumber(String monthName) {
        return monthMap.get(monthName);
    }

    // Check if the date selected
    public boolean checkIfDateSelected(String year, String month, String day) {
        try {
            // Build the XPath dynamically using the parameters for year, month number, and day
            String xpath = "//android.widget.TextView" +
                    "[@text='Selected Date: "
                    + monthNameToNumber(month) + "/" + day + "/" + year + "']";

            // Find elements using the dynamic XPath and check if any elements are found
            return !findElements(By.xpath(xpath)).isEmpty();

        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return false;
        }
    }
}
