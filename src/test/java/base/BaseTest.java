package base;


import com.qamobiledemo.pages.TextBoxPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import com.qamobiledemo.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseTest {

    AppiumDriver driver;
    protected BasePage basePage;
    protected TextBoxPage textBoxPage;

    // Create a logger instance for this class
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    protected void setUp() {
        try{

            // Step 1: Load capabilities from the external JSON file
            File jsonFile = new File("appium_config.json");
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> capabilitiesMap = objectMapper.readValue(jsonFile, Map.class);

            // Step 2: Convert the Map to Options
            var options = new BaseOptions();
            capabilitiesMap.forEach((key, value) -> options.setCapability(key, value));

            // Create an instance of AndroidDriver
            driver = new AndroidDriver(this.getUrl(), options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        } catch (Exception e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
        }

    }

    @BeforeMethod
    protected void loadApplication() {
        // Create a BasePage object and set the driver
        basePage = new BasePage();
        basePage.setDriver(driver);
        textBoxPage = new TextBoxPage();
    }

    // Get Appium server Url
    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            // Log the exception message and stack trace as an ERROR
            logger.error("An error occurred: ", e);  // Logs the exception with stack trace
            return  null;
        }
    }

    // Create screenshot for failed test results
    @AfterMethod
    protected void takeFailedResultScreenshot(ITestResult testResult) {
        if(ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (Exception e) {
                logger.error("An error occurred: ", e);
            }

            System.out.println("Screenshot Located At " + destination);

        }

    }

    @AfterClass
    public void tearDown() {
//        delay(3000);
        driver.quit();
    }

}