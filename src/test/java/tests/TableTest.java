package tests;

import base.BaseTest;
import com.qamobiledemo.pages.TablePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TableTest extends BaseTest {

    TablePage tablePage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        tablePage = new TablePage();
    }

    // Check if user can type in the Search field
    public void checkIfUserCanTypeInSearchField() {
        // Navigate to the Table page
        textBoxPage.navigateToTablePage();

        // Set the Search field
        tablePage.setSearchField("Search");

        // Get the Search field
        String fieldText = tablePage.getSearchField();

        // The default text for the Search field is Search by Name or Age
        // Check if the user-entered Search field
        // doesn't equal the Search by Name or Age
        Assert.assertFalse(fieldText.equals("Search by Name or Age"),
                "\n User can't type in Search field \n");
    }

    // Check if user can search
    public void checkIfUserCanSearch() {
        // Set the Search string
        String searchText = "Doe";

        // Set the Search field
        tablePage.setSearchField(searchText);

        // Check if the searched name exists in the list of data
        Assert.assertTrue(tablePage.SearchByNameCheck(searchText),
                "\n The searched string doesn't exist in the data \n");

        // Clear the Search field
        tablePage.clearSearchField();

    }

    // Check if user can type in the New Name field
    public void checkIfUserCanTypeInNewNameField() {
        // Set the New Name field
        tablePage.setNewNameField("John");

        // Get the New Name field
        String fieldText = tablePage.getNewNameField();

        // The default text for the New Name field is New Name
        // Check if the user-entered New Name field
        // doesn't equal the New Name
        Assert.assertFalse(fieldText.equals("New Name"),
                "\n User can't type in the New Name field \n");

    }

    // Check if user can type in the New Age field
    public void checkIfUserCanTypeInNewAgeField() {
        // Set the New Age field
        tablePage.setNewAgeField("25");

        // Get the New Age field
        String fieldText = tablePage.getNewAgeField();

        // The default text for the New Age field is New Age
        // Check if the user-entered New Age field
        // doesn't equal the New Age
        Assert.assertFalse(fieldText.equals("New Age"),
                "\n User can't type in the New Age field \n");

    }

    // Check if the New Name field is required
    public void checkNewNameIsRequired() {
        // Clear the New Name field
        tablePage.clearNewNameField();

        // Set the New Age field
        tablePage.setNewAgeField("25");

        // Click the Add Row Button
        tablePage.clickAddRowButton();

        // Check if modal error text exists
        Assert.assertTrue(tablePage.checkEmptyFieldModalErrorTextExists(),
                "\n The New Name field is empty and an error message isn't shown \n");

        // Click the empty modal Ok button
        tablePage.clickEmptyModalOkButton();
    }

    // Check if the New Age field is required
    public void checkNewAgeIsRequired() {
        // Clear the New Age field
        tablePage.clearNewAgeField();

        // Set the New Name field
        tablePage.setNewNameField("John");

        // Click the Add Row Button
        tablePage.clickAddRowButton();

        // Check if modal error text exists
        Assert.assertTrue(tablePage.checkEmptyFieldModalErrorTextExists(),
                "\n The New Age field is empty and an error message isn't shown \n");

        // Click the empty modal Ok button
        tablePage.clickEmptyModalOkButton();

    }

    // Check if the New Name and New Age field is required
    public void checkNewNameAndNewAgeIsRequired() {
        // Clear the New Name field
        tablePage.clearNewNameField();

        // Clear the New Age field
        tablePage.clearNewAgeField();

        // Click the Add Row Button
        tablePage.clickAddRowButton();

        // Check if modal error text exists
        Assert.assertTrue(tablePage.checkEmptyFieldModalErrorTextExists(),
                "\n The New Name and New Age fields are empty and an " +
                        "error message isn't shown \n");

        // Click the empty modal Ok button
        tablePage.clickEmptyModalOkButton();

    }

    // Check if the new row added
    public void checkIfNewRowAdded() {
        // New Name
        String newName = "Jane";

        // New Age
        String newAge = "25";

        // Set the New Name field
        tablePage.setNewNameField(newName);

        // Set the New Age field
        tablePage.setNewAgeField(newAge);

        // Click the Add Row button
        tablePage.clickAddRowButton();

        // Check if the new row added
        Assert.assertTrue(tablePage.isNewRowAdded(newName, newAge),
                "\n A new row didn't add \n");
    }

    // Check if the row deleted after delete button click
    public void checkIfRowDeleted() {
        // Click the first delete button
        tablePage.clickFirstDeleteButton();

        // Check if the row deleted
        Assert.assertTrue(tablePage.checkIfElementDeleted(),
                "\n First element didn't delete \n");
    }

    // Check the first row Name field edit
    public void checkTableNameEdit() {
        // Set the name variable
        String name = "Jane Doe";

        // Set the age variable
        String age = "20";

        // Click the Edit button
        tablePage.clickFirstItemEditButton();

        // Set the first item Name
        tablePage.setFirstItemNameField(name);

        // Set the first item Age
        tablePage.setFirstItemAgeField(age);

        // Click the first item save button
        tablePage.clickFirstItemSaveButton();

        // Check if the row updated
        Assert.assertTrue(name.equals(tablePage.getFirstItemName())
                && age.equals(tablePage.getFirstItemAge()),
                "\n Name and Age fields didn't change \n");
        

    }
}
