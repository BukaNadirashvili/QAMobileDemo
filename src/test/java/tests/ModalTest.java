package tests;

import base.BaseTest;
import com.qamobiledemo.pages.ModalPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ModalTest extends BaseTest {

    ModalPage modalPage;

    @BeforeMethod
    public void loadApplication() {
        super.loadApplication();
        modalPage = new ModalPage();
    }

    // Check the modal open button
    public void checkModalOpen() {
        // Navigate to the Modal page
        textBoxPage.navigateToModalPage();

        // Click the open button
        modalPage.clickModalButton();

        // Check if the modal title exists
        Assert.assertTrue(modalPage.getModalTitle().equals("Modal"),
                "\n The modal didn't open \n");
    }

    // Check the modal cancel button
    public void checkModalClose() {
        // Click the open button
        modalPage.clickModalButton();

        // Click the close button
        modalPage.clickCancelButton();

        // Check if the modal button exists
        Assert.assertTrue(modalPage.checkModalBUttonExists(),
                "\n The modal cancel button not working \n");
    }


}
