package DC_Comics;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;

import driverFactory.DriverObjectFactory;

public class BaseTest{
	
	@BeforeTest
	public void beforeTest() {
		
		DriverObjectFactory.getDriver().get("https://otbpm.sta.pub.dcentertainment.com/home/warnerbros/psa/index.html#");
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.urlContains("https://wbid.oktapreview.com/app/"));
		
    }

}
