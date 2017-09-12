package DC_Comics;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.DriverObjectFactory;
import utilities.ScreenshotCapture;

public class BaseTest{
	
	@BeforeMethod
	public void beforeTest() {
		DriverObjectFactory.instantiateDriverObject();
		DriverObjectFactory.getDriver().get("https://otbpm.sta.pub.dcentertainment.com/home/warnerbros/psa/index.html#");
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.urlContains("https://wbid.oktapreview.com/app/"));
		
    }
	
	@AfterMethod
	public void afterTest() {
		ScreenshotCapture.captureScreenShot();
		DriverObjectFactory.getDriver().quit();
    }

}
