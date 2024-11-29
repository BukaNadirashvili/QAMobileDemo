package com.qamobiledemo;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

// Base class for pages
public class BasePage {

    public static AppiumDriver driver;
    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    // Set BasePage driver
    public void setDriver(AppiumDriver driver) {
        BasePage.driver = driver;
    }

    // Find element by locator
    protected WebElement find(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
            return null;
        }
    }

    // Find a list of elements by locator
    protected List<WebElement> findElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
            return null;
        }
    }

    // Set element text by locator
    protected void setText(By locator, String text) {
        try {
            find(locator).clear();
            find(locator).sendKeys(text);
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
    }

    // Set element text by WebElement
    protected void setText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
    }

    // Clear element text by locator
    protected void clearText(By locator) {
        try {
            find(locator).clear();
        } catch(Exception e) {
            logger.error("An error occurred: ", e);
        }
    }

    // Get element text by locator
    protected String getText(By locator) {
        try {
            return find(locator).getText();
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
            return null;
        }
    }

    // Get element text by WebElement
    protected String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
            return null;
        }
    }

    // Click element by locator
    protected void click(By locator) {
        try {
            find(locator).click();
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
    }

    // Click element by WebElement
    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
    }

    // Delay by milliseconds
    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException exc) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", exc);  // Logs the exception with stack trace
        }
    }

    // Scroll to element by text
    protected void scrollToElementByText(String text) {
        try {
            String scrollCommand = "new UiScrollable(new UiSelector()." +
                    "scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
                    ".text(\"" + text + "\"));";
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(scrollCommand));
        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
        }

    }

    // Click back button
    protected void clickBackButton() {
        driver.navigate().back();
    }

    // Scroll to element
    public void scrollToElement(RemoteWebElement element, String direction, double percent) {
        ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", element.getId(),
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "up",
                "percent", percent
        ));
    }

}