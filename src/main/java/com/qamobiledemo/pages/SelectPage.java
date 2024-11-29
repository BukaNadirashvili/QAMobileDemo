package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static io.appium.java_client.AppiumBy.accessibilityId;

public class SelectPage extends BasePage {

    private By singleSelect = By.xpath("//android.view.ViewGroup[4]");
    private By singleSelectResult =
            By.xpath("//android.widget.TextView[starts-with(@text, 'Selected:')]");
    private By multiSelect = By.xpath("//android.view.ViewGroup[5]");
    private By multiSelectFirstOption = accessibilityId("Option 1");
    private By multiSelectSecondOption = accessibilityId("Option 2");
    private By multiSelectOptionsResult =
            By.xpath("//android.widget.TextView[starts-with(@text, 'Selected:')]");

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    // Click the single select
    public void clickSingleSelect() {
        click(singleSelect);
    }

    // Click the options and check if result is valid for
    // each option
    public boolean checkSingleSelectOptions() {
        // Get the count of the elements
        int elementsCount =
                findElements(
                        By.xpath("//android.widget.ScrollView" +
                                "/android.view.ViewGroup/android.view.ViewGroup" +
                                "/android.widget.TextView")).size();

        for(int i = 0; i < elementsCount; i++) {

            // Skip the single select click if first iteration
            if(i != 0) {
                clickSingleSelect();
            }

            // The current element
            WebElement element =
                    find(By.xpath("//android.widget.TextView[@text=\"Option " + (i + 1) + "\"]"));

            String currentElementText = getText(element).replaceAll("\\s+", "").toLowerCase();

            // Click the option
            click(element);

            // Get the selected option text from the result text
            String resultText = getText(singleSelectResult).split(" ")[1].toLowerCase();

            if(!resultText.equals(currentElementText)) {
                return false;
            }
        }

        return true;

    }

    // Set the multiselect options and then compare selected
    // option texts with result options
    public boolean checkMultiSelectOptions(String[] options) {

        try {
            // Array of the current element texts
            String[] selectedElementTexts = new String[options.length];

            for(int i = 0; i < options.length; i++) {

                // get the current element current element
                WebElement element =
                        find(By.xpath("//android.widget.TextView[@text=\"" + options[i] + "\"]"));

                // Get the current element text
                String currentElementText = getText(element).replaceAll("\\s+", "").toLowerCase();

                // Add the current element text to the array of the selected element texts
                selectedElementTexts[i] = currentElementText;

                // Click the option
                click(element);
            }
            // Click the multiselect
            clickMultiSelect();

            // Get the selected option(s) text from the result text
            Set<String> resultText = new HashSet<>(Arrays.asList(extractOptions(getText(multiSelectOptionsResult))));

            // Create the set of the selected element texts
            Set<String> selectedElementsSet = new HashSet<>(Arrays.asList(selectedElementTexts));

            // Compare if result options equals to the selected element texts
            return resultText.equals(selectedElementsSet);
        } catch(Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return  false;
        }


    }

    public String[] extractOptions(String str) {
        // Remove "Selected:" and trim any leading/trailing whitespace
        String optionsPart = str.replace("Selected:", "").trim();

        // If there are options, split by comma and trim spaces around them
        if (!optionsPart.isEmpty()) {
            // Split options by comma and store in an array
            String[] optionsArray = optionsPart.split(",");

            // Trim spaces around each option and return the array
            for (int i = 0; i < optionsArray.length; i++) {
                optionsArray[i] = optionsArray[i].trim();
            }

            return optionsArray;
        }

        // Return an empty array if no options are present
        return new String[0]; // or `new String[]{}`; both are fine for an empty array
    }

    // Click the multi select
    public void clickMultiSelect() {
        click(multiSelect);
    }

    // Click the first option in the multi select
    public void clickFirstOptionInMultiSelect() {
        click(multiSelectFirstOption);
    }

    // Click the second option in the multi select
    public void clickSecondOptionInMultiSelect() {
        click(multiSelectSecondOption);
    }
    
}
