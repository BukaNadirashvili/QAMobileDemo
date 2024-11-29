package com.qamobiledemo.pages;

import com.qamobiledemo.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    private By firstAccordionOpenButton =
            By.xpath("(//android.widget.TextView[@text=\"\uEB33\"])[1]");
    private By secondAccorionOpenButton =
            By.xpath("(//android.widget.TextView[@text=\"\uEB33\"])[2]");
    private By thirdAccordionOpenButton =
            By.xpath("(//android.widget.TextView[@text=\"\uEB33\"])[3]");
    private By accordionCloseBUtton =
            By.xpath("(//android.widget.TextView[@text=\"\uEB42\"])");
    private By firstAccordionText =
            By.xpath("//android.widget.TextView[@text=\"This is the content" +
                    " of the first accordion item. Here you can put some test text.\"]");
    private By secondAccordionText =
            By.xpath("//android.widget.TextView[@text=\"This is the content" +
                    " of the second accordion item. You can put more test content here.\"]");
    private By thirdAccordionText =
            By.xpath("//android.widget.TextView[@text=\"And this is the content" +
                    " for the third accordion item. Feel free to edit the text.\"]");

    // Click the first accordion open button
    public void clickFirstAccordionOpenButton() {
        click(firstAccordionOpenButton);
    }

    // Click the second accordion open button
    public void clickSecondAccordionOpenButton() {
        click(secondAccorionOpenButton);
    }

    // Click the third accordion open button
    public void clickThirdAccordionOpenButton() {
        click(thirdAccordionOpenButton);
    }

    // Check if the first accordion text is visible
    public boolean isFirstAccordionTextVisible() {
        return !findElements(firstAccordionText).isEmpty();
    }

    // Check if the second accordion text is visible
    public boolean isSecondAccordionTextVisible() {
        return !findElements(secondAccordionText).isEmpty();
    }

    // Check if the third accordion text is visible
    public boolean isThirdAccordionTextVisible() {
        return !findElements(thirdAccordionText).isEmpty();
    }

    // Click the accordion close button
    public void clickAccordionCloseButton() {
        click(accordionCloseBUtton);
    }

}
