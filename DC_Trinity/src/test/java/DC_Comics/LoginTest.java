package DC_Comics;

import org.testng.annotations.Test;
import PageObjects.LoginPage;

public class LoginTest extends BaseTest {
	
	LoginPage lp;
 
	@Test
	public void aloginAs() {
		
		lp= new LoginPage();
		
		lp.setUsername("marry.scott@trinitytest.com").setPassword("Trinity1234");
		
		
		
			
	}

}
