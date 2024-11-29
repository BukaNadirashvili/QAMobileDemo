package tests;

import base.BaseTest;
import com.qamobiledemo.pages.SelectPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;;

@Test
public class SelectTest extends BaseTest {

    SelectPage selectPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        selectPage = new SelectPage();
    }

    // Check single select options selection
    public void checkSingleSelectFirstOptionSelection() {
        // Click the single select
        selectPage.clickSingleSelect();

        // Click the options
        boolean isOptionsSelectedCorrect =  selectPage.checkSingleSelectOptions();

        // Check if the options selected
        Assert.assertTrue(isOptionsSelectedCorrect,
                "\n Single select options didn't selected \n");
    }

    // Check multi select options selection
    public void checkMultiSelectFirstOptionSelection() {
        // Navigate to the Select page
        textBoxPage.navigateToSelectPage();

        // Click the multi select dropdown
        selectPage.clickMultiSelect();

        // Create the array of the options
        String[] inputArray = {
                "Option 1",
                "Option 2",
                "Option 3"
        };

        // Check if the selected element is in the result
        boolean isOptionsSelectedCorrect =  selectPage.checkMultiSelectOptions(inputArray);

        // Check if the options selected
        Assert.assertTrue(isOptionsSelectedCorrect,
                "\n Multi select options didn't selected \n");
    }
}
