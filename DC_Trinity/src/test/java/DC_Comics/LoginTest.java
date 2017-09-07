package DC_Comics;

import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.TrinityBasePage;

public class LoginTest extends BaseTest {
	
	LoginPage lp;
	TrinityBasePage tbp;
 
	@Test(priority=1)
	public void loginAs() {
		
		lp= new LoginPage();
		
		tbp= lp.setUsername("mary.scott@trinitytest.com").setPassword("Test1234");
				
	}

	@Test(priority=2)
	public void navigation() {
		tbp.navigatetoTab("Projects");
		tbp.navigatetoProject("Joe's PP Project","2");
	}
}
