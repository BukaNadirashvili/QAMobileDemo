package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;

public class CheckboxPage extends BasePage {

    private By firstCheckBox = By.xpath("//android.widget.CheckBox[1]");
    private By secondCheckBox = By.xpath("//android.widget.CheckBox[2]");
    private By thirdCheckBox = By.xpath("//android.widget.CheckBox[3]");
    private By checkBoxesResultText =
            By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox 1 is')]");

    // Check the first checkbox
    public void checkFirstCheckBox() {
        click(firstCheckBox);
    }

    // Uncheck the first checkbox
    public void uncheckFirstCheckBox() {
        click(firstCheckBox);
    }

    // Check the second checkbox
    public void checkSecondCheckBox() {
        click(secondCheckBox);
    }

    // Uncheck the second checkbox
    public void uncheckSecondCheckBox() {
        click(secondCheckBox);
    }

    // Check the third checkbox
    public void checkThirdCheckBox() {
        click(thirdCheckBox);
    }

    // Uncheck the third checkbox
    public void uncheckThirdCheckBox() {
        click(thirdCheckBox);
    }

    // Check if the first checkbox is checked
    public boolean isFirstCheckBoxChecked() {
        return getText(checkBoxesResultText).contains("Checkbox 1 is checked");
    }

    // Check if the second checkbox is checked
    public boolean isSecondCheckBoxChecked() {
        return getText(checkBoxesResultText).contains("Checkbox 2 is checked");
    }

    // Check if the third checkbox is checked
    public boolean isThirdCheckBoxChecked() {
        return getText(checkBoxesResultText).contains("Checkbox 3 is checked");
    }

}
