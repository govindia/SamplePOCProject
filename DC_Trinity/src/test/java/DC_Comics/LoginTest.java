package DC_Comics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.ReviewTaskPage;
import PageObjects.TrinityBasePage;

public class LoginTest extends BaseTest {
	
	LoginPage lp;
	TrinityBasePage tbp;
	ReviewTaskPage rtp;
 
	@Test(priority=1,dataProvider="approvers")
	public void asignmentFlow(String user,String password,String role,String decision) {
		
		
		lp= new LoginPage();
		tbp= lp.setUsername(user).setPassword(password);
		tbp.navigatetoTab(role+" "+"Tasks");
		rtp=tbp.navigatetoTask("Review Cover Sketches","TMO_DF_ST_Vani1","1");
		if(decision.equalsIgnoreCase("approve"))
		rtp.approveAll();	
		else 
		rtp.rejectAll();	
	}
	
	@DataProvider(name="approvers")
	public Object[][] provideData() {
		 return new Object[][]{
			{ "sarah.moore@trinitytest.com","Test1234","Asst Editor","Approve"},
			{ "mary.scott@trinitytest.com","Test1234","Editor","Reject" }
		};
		
	}
	
	/*@Test(priority=2)
	public void approvalFlow(String user ,String password,String task ,String title, String issue) {
		
		lp= new LoginPage();
		
		tbp= lp.setUsername(user).setPassword(password);
		tbp.navigatetoTask(task,title,issue);
		
	}*/
	
	
}
