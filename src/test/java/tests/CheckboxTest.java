package tests;

import base.BaseTest;
import com.qamobiledemo.pages.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class CheckboxTest extends BaseTest {

    CheckboxPage checkBoxPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        checkBoxPage = new CheckboxPage();
    }

    // Check if the first checkbox is checked
    public void checkFirstCheckboxCheck() {
        // Navigate to the Checkbox page
        textBoxPage.navigateToCheckboxPage();

        // Check the first checkbox
        checkBoxPage.checkFirstCheckBox();

        // Check the text to see if the first checkbox is checked and others aren't
        Assert.assertTrue(checkBoxPage.isFirstCheckBoxChecked() &&
                        !checkBoxPage.isSecondCheckBoxChecked()
                        && !checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if the first checkbox is unchecked
    public void checkFirstCheckboxUncheck() {
        // Uncheck the first checkbox
        checkBoxPage.uncheckFirstCheckBox();

        // Check the text to see if all checkboxes unchecked
        Assert.assertTrue(!checkBoxPage.isFirstCheckBoxChecked() &&
                        !checkBoxPage.isSecondCheckBoxChecked()
                        && !checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if the second checkbox is checked
    public void checkSecondCheckboxCheck() {
        // Check the second checkbox
        checkBoxPage.checkSecondCheckBox();

        // Check the text to see if the second checkbox is checked and others aren't
        Assert.assertTrue(!checkBoxPage.isFirstCheckBoxChecked() &&
                        checkBoxPage.isSecondCheckBoxChecked()
                        && !checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if the second checkbox is unchecked
    public void checkSecondCheckboxUncheck() {
        // Uncheck the first checkbox
        checkBoxPage.uncheckSecondCheckBox();

        // Check the text to see if all checkboxes unchecked
        Assert.assertTrue(!checkBoxPage.isFirstCheckBoxChecked() &&
                        !checkBoxPage.isSecondCheckBoxChecked()
                        && !checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if the third checkbox is checked
    public void checkThirdCheckboxCheck() {
        // Check the third checkbox
        checkBoxPage.checkThirdCheckBox();

        // Check the text to see if the third checkbox is checked and others aren't
        Assert.assertTrue(!checkBoxPage.isFirstCheckBoxChecked() &&
                        !checkBoxPage.isSecondCheckBoxChecked()
                        && checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if the third checkbox is unchecked
    public void checkThirdCheckboxUncheck() {
        // Uncheck the third checkbox
        checkBoxPage.uncheckThirdCheckBox();

        // Check the text to see if all checkboxes unchecked
        Assert.assertTrue(!checkBoxPage.isFirstCheckBoxChecked() &&
                        !checkBoxPage.isSecondCheckBoxChecked()
                        && !checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if all checkboxes are unchecked
    public void checkAllCheckboxesUnchecked() {
        // Check the text to see if all checkboxes are unchecked
        Assert.assertTrue(!checkBoxPage.isFirstCheckBoxChecked() &&
                        !checkBoxPage.isSecondCheckBoxChecked() &&
                        !checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

    // Check if all checkboxes are checked
    public void checkAllCheckboxesChecked() {
        // Check the first checkbox
        checkBoxPage.checkFirstCheckBox();

        // Check the second checkbox
        checkBoxPage.checkSecondCheckBox();

        // Check the third checkbox
        checkBoxPage.checkThirdCheckBox();

        // Check the text to see if all checkboxes are checked
        Assert.assertTrue(checkBoxPage.isFirstCheckBoxChecked() &&
                        checkBoxPage.isSecondCheckBoxChecked()
                        && checkBoxPage.isThirdCheckBoxChecked(),
                "\n Incorrect checkbox result text \n");
    }

}
