package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    private By searchField = By.xpath("//android.widget.EditText[1]");
    private By newNameField = By.xpath("//android.widget.EditText[2]");
    private By newAgeField = By.xpath("//android.widget.EditText[3]");
    private By addRowButton =
            By.xpath("//android.view.ViewGroup[@content-desc=\"Add Row\"]");
    private By emptyFieldModalOkButton = By.id("android:id/button1");
    private By emptyFieldModalErrorText =
            By.xpath("//android.widget.TextView[@resource-id=\"android:id/message\"]");
    private By firstDeleteButton =
            By.xpath("(//android.view.ViewGroup[@content-desc=\"Delete\"])[1]");
    private By firstEditButton =
            By.xpath("(//android.view.ViewGroup[@content-desc=\"Edit\"])[1]");
    private By firstItemNameField =
            By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                    "/android.view.ViewGroup/android.view.ViewGroup[not(*)]" +
                    "/following-sibling::android.widget.TextView[1]");
    private By firstItemAgeField =
            By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                    "/android.view.ViewGroup/android.view.ViewGroup[not(*)]" +
                    "/following-sibling::android.widget.TextView[2]");
    private By firstItemSaveButton =
            By.xpath("//android.view.ViewGroup[@content-desc=\"Save\"]");

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    // Set the Search field
    public void setSearchField(String text) {
        setText(searchField, text);
    }

    // Get the Search field
    public String getSearchField() {
        return getText(searchField);
    }

    // Clear the Search field
    public void clearSearchField() {
        clearText(searchField);
    }

    // Set the New Name field
    public void setNewNameField(String text) {
        setText(newNameField, text);
    }

    // Get the New Name field
    public String getNewNameField() {
        return getText(newNameField);
    }

    // Clear the New Name field
    public void clearNewNameField() {
        clearText(newNameField);
    }

    // Set the Age field
    public void setNewAgeField(String text) {
        setText(newAgeField, text);
    }

    // Get the New Age Field
    public String getNewAgeField() {
        return getText(newAgeField);
    }

    // Clear the New Age field
    public void clearNewAgeField() {
        clearText(newAgeField);
    }

    // Click the Add Row button
    public void clickAddRowButton() {
        click(addRowButton);
    }

    // Click empty field modal Ok button
    public void clickEmptyModalOkButton() {
        click(emptyFieldModalOkButton);
    }

    // Check if the empty field modal error text exists
    public boolean checkEmptyFieldModalErrorTextExists() {
        return !findElements(emptyFieldModalErrorText).isEmpty();
    }

    // Check search by Name
    public boolean SearchByNameCheck(String searchString) {

        try {

            // Find the list of names
            List<WebElement> elements = findElements(
                    By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                            "/android.view.ViewGroup/android.view." +
                            "ViewGroup[not(*)]/following-sibling::android.widget.TextView[1]"));

            // Use a loop to find a search string in the list of names
            for (WebElement el : elements) {
                if(el.getText().contains(searchString)) {
                    return true;
                }
            }

            return false;

        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return  false;
        }

    }

    // Check if the new row added
    public boolean isNewRowAdded(String newName, String NewAge) {

        try {

            // Find the list of names
            List<WebElement> elements = findElements(
                    By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                            "/android.view.ViewGroup/android.view." +
                            "ViewGroup[not(*)]/following-sibling::android.widget.TextView"));

            // Create a chunk
            List<List<String>> chunkedLists = chunkList(elements);

            for (var el : chunkedLists) {
                if(el.get(0).equals(newName) && el.get(1).equals(NewAge)) {
                    return true;
                }
            }

            return false;

        } catch(Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return  false;
        }

    }

    // Create a chunk
    public List<List<String>> chunkList(List<WebElement> inputList) {
        List<List<String>> chunkedLists = new ArrayList<>();

        // Loop through the list and create pairs
        for (int i = 0; i < inputList.size() - 1; i += 2) {
            List<String> chunk = new ArrayList<>();
            chunk.add(inputList.get(i).getText());
            chunk.add(inputList.get(i + 1).getText());
            chunkedLists.add(chunk);
        }

        return chunkedLists;
    }

    // Click the first delete button
    public void clickFirstDeleteButton() {
        click(firstDeleteButton);
    }

    // Check if element deleted
    public boolean checkIfElementDeleted() {
        // Find the list of names
        List<WebElement> elements = findElements(
                By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                        "/android.view.ViewGroup/android.view." +
                        "ViewGroup[not(*)]/following-sibling::android.widget.TextView"));

        // Create a chunk
        List<List<String>> chunkedLists = chunkList(elements);

        return chunkedLists.size() == 3;
    }

    // Click the first Edit button
    public void clickFirstItemEditButton() {
        click(firstEditButton);
    }

    // Set the first item name field
    public void setFirstItemNameField(String text) {
        WebElement firstItemEditNameField =
                findElements(By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                        "/android.view.ViewGroup/android.view.ViewGroup[not(*)]" +
                        "/following-sibling::android.widget.EditText[1]")).getFirst();
        setText(firstItemEditNameField, text);
    }

    // Set the first item age field
    public void setFirstItemAgeField(String text) {
        WebElement firstItemEditAgeField =
                findElements(By.xpath("//android.widget.ScrollView//android.widget.ScrollView[1]" +
                        "/android.view.ViewGroup/android.view.ViewGroup[not(*)]" +
                        "/following-sibling::android.widget.EditText[2]")).getFirst();
        setText(firstItemEditAgeField, text);
    }

    // Get the first row Name
    public String getFirstItemName() {
        return getText(firstItemNameField);
    }

    // Get the first row Age
    public String getFirstItemAge() {
        return getText(firstItemAgeField);
    }

    // Click the first row Save button
    public void clickFirstItemSaveButton() {
        click(firstItemSaveButton);
    }
}