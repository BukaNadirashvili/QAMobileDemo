package tests;

import base.BaseTest;
import com.qamobiledemo.pages.AlertPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class AlertTest extends BaseTest {

    AlertPage alertPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        alertPage = new AlertPage();
    }

    // Check the first alert open
    public void checkFirstAlertOpen() {
        // Navigate to the Alert page
        textBoxPage.navigateToAlertPage();

        // Click the first alert button
        alertPage.clickFirstAlertButton();

        // Check if the first alert is open
        Assert.assertTrue(alertPage.getAlertTitle().equals("First Alert"),
                "\n First alert didn't open \n");
    }

    // Check the Ok button click on the first alert
    public void checkOkButtonClickOnFirstAlert() {
        // Click the Ok button
        alertPage.clickOkButton();

        // Check if alert closed after the button click
        Assert.assertTrue(alertPage.getAlertPageTitle().equals("Alerts"),
                "\n Alert didn't close after the button click \n");
    }

    // Check the second alert open
    public void checkSecondAlertOpen() {
        // Click the second alert button
        alertPage.clickSecondAlertButton();

        // Check if the second alert is open
        Assert.assertTrue(alertPage.getAlertTitle().equals("Second Alert"),
                "\n Second alert didn't open \n");
    }

    // Check the Ok button click on the second alert
    public void checkOkButtonClickOnSecondAlert() {
        // Click the Ok button
        alertPage.clickOkButton();

        // Check if alert closed after the button click
        Assert.assertTrue(alertPage.getAlertPageTitle().equals("Alerts"),
                "\n Alert didn't close after the button click \n");
    }

    // Check the confirm box open
    public void checkConfirmBoxOpen() {
        // Click the confirm box button
        alertPage.clickConfirmBoxButton();

        // Check if the confirm box is open
        Assert.assertTrue(alertPage.getAlertTitle().equals("Confirm"),
                "\n Confirm box didn't open \n");
    }

    // Check the Cancel button on the confirm box
    public void checkCancelButtonOnConfirmBox() {
        // Click the Cancel button
        alertPage.clickCancelButton();

        // Check if the confirm box closed after the button click
        Assert.assertTrue(alertPage.getAlertPageTitle().equals("Alerts"),
                "\n Confirm box didn't close after the button click \n");
    }

    // Check the Ok button click on the confirm box
    public void checkOkButtonClickOnConfirmBox() {
        // Click the confirm box button
        alertPage.clickConfirmBoxButton();

        // Click the Ok button
        alertPage.clickOkButton();

        // Check if confirm box closed after the button click
        Assert.assertTrue(alertPage.getAlertPageTitle().equals("Alerts"),
                "\n Confirm box didn't close after the button click \n");
    }

    // Check the prompt alert open
    public void checkPromptOpen() {
        // Click the prompt button
        alertPage.clickPromptButton();

        // Check if the prompt is open
        Assert.assertTrue(alertPage.getPromptTitle().equals("Enter Text"),
                "\n Prompt box didn't open \n");

    }

    // Check if user can type in the prompt input field
    public void checkIfUserCanTypeInPromptInputField() {
        // Set the prompt input field
        alertPage.setPromptInputField("Prompt text example");

        // Get the prompt input field
        String fieldText = alertPage.getPromptInputField();

        // The default text for the prompt input field is Please enter something...
        // Check if the user-entered prompt input field
        // doesn't equal the Please enter something...
        Assert.assertFalse(fieldText.equals("Please enter something..."),
                "\n User can't type in the prompt input field \n");
    }

    // Check if user can delete the prompt input field
    public void checkIfUserCanDeletePromptInputField() {
        // prompt text string
        String text = "Prompt text example";

        // Set the prompt input field
        alertPage.setPromptInputField(text);

        // Delete the prompt input Field
        alertPage.deletePromptInputText();

        // Get length of the field
        int fieldLength = alertPage.getPromptInputField().length();

        // Check if the text's initial length is more than the current length
        Assert.assertTrue(text.length() > fieldLength,
                "\n User can't delete prompt input field  \n");
    }

    // Check the Cancel button on the prompt box
    public void checkCancelButtonOnPromptBox() {
        // Click the Cancel button
        alertPage.clickPromptCancelButton();

        // Check if the prompt box closed after the button click
        Assert.assertTrue(alertPage.getAlertPageTitle().equals("Alerts"),
                "\n Prompt box didn't close after the button click \n");
    }

    // Check the Ok button click on the prompt box
    public void checkOkButtonClickOnPromptBox() {
        // Click the prompt box button
        alertPage.clickPromptButton();

        // Click the Ok button
        alertPage.clickPromptOkButton();

        // Check if alert closed after the button click
        Assert.assertTrue(alertPage.getAlertPageTitle().equals("Alerts"),
                "\n Prompt box didn't close after the button click \n");
    }

}
