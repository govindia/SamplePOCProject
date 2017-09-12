package DC_Comics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import PageObjects.ReviewTaskPage;
import PageObjects.TrinityBasePage;
import utilities.ReadTestDataConfig;

public class LoginTest extends BaseTest {
	
	LoginPage lp;
	TrinityBasePage tbp;
	ReviewTaskPage rtp;
 
	@Test(priority=1,dataProvider="approvers")
	public void reviewFlow(String user,String password,String role,String decision) {
		lp= new LoginPage();
		tbp= lp.setUsername(user).setPassword(password);
		tbp.closeMFTDialog();
		tbp.navigatetoTab(role+" "+"Tasks");
		rtp=tbp.navigatetoTask(ReadTestDataConfig.getTestData("task"),
				               ReadTestDataConfig.getTestData("title"),
				               ReadTestDataConfig.getTestData("issue"));
		if(decision.equalsIgnoreCase("approve"))
		rtp.approveAll();	
		else 
		rtp.rejectAll();	
	}
	
	@DataProvider(name="approvers")
	public Object[][] provideData() {
		 return new Object[][]{
			{ "sarah.moore@trinitytest.com","Test1234","Asst Editor","Approve"},
			{ "mary.scott@trinitytest.com","Test1234","Editor","Approve" },
			{"emma.lepeut@trinitytest.com","Test1234","HOD","Approve"},
		};
		
	}
	
	/*@Test(priority=2)
	public void approvalFlow(String user ,String password,String task ,String title, String issue) {
		
		lp= new LoginPage();
		
		tbp= lp.setUsername(user).setPassword(password);
		tbp.navigatetoTask(task,title,issue);
		
	}*/
	
	
}
