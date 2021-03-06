package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.DriverObjectFactory;
import utilities.ScreenshotCapture;

public class BaseTest{
	
	@BeforeMethod
	public void beforeTest() {
		DriverObjectFactory.instantiateDriverObject();
		DriverObjectFactory.getDriver().get("URL");
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.urlContains("Fwd:URL"));
		
    }
	
	@AfterMethod
	public void afterTest() {
		ScreenshotCapture.captureScreenShot();
		DriverObjectFactory.getDriver().quit();
    }

}
