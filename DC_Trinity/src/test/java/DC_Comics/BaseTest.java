package DC_Comics;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import driverFactory.DriverObjectFactory;

public class BaseTest{
	
	
	protected  static WebDriverWait wait;
	
	@BeforeTest
	public void beforeTest() {
		
		DriverObjectFactory.getDriver().get("https://otbpm.sta.pub.dcentertainment.com/home/warnerbros/psa/index.html#");
		wait=new WebDriverWait(DriverObjectFactory.getDriver(), 360,1000);
		wait.until(ExpectedConditions.urlContains("https://wbid.oktapreview.com/app/"));
    }

}
