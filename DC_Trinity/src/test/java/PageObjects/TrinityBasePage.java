package PageObjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import driverFactory.DriverObjectFactory;

public class TrinityBasePage {
	
	@FindBy(xpath=".//*[@id='sidebar']/ul/li/a")
	private List<WebElement> leftnav; //left navigation panel
	
	@FindBy(xpath=".//*[contains(@id,'uiGrid')]//a")
	private List<WebElement> tasklist; //task list
	
	@FindBy(xpath=".//*[contains(@id,'uiGrid')]/Div/Span[1]")
	private List<WebElement> taskdetails;
	
	@FindBy(xpath=".//*[contains(@id,'uiGrid')]//a")
	private List<WebElement> prolist;  //project list
	
	@FindBy(xpath=".//*[contains(@id,'uiGrid')]/Div/Span[1]")
	private List<WebElement> prodetails;  //project list
	
	@FindBy(xpath=".//*[@id='taskGrid']//select")
	private WebElement nrecords;  //Number of records displayed per page.
	
	@FindBy(xpath=".//*[@id='taskGrid']//button//span")
	private List<WebElement> pagebuttons;
	
	@FindBy(id="dialogBody")
	private WebElement dialog;
	
	
	
//Constructor to initialize the web elements
	
	public TrinityBasePage(){
			PageFactory.initElements(DriverObjectFactory.getDriver(), this);
	}
	
	
//Used to navigate to the different tabs available on the left panel.
	
	public void navigatetoTab(String name) {
		boolean b=false;
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.visibilityOf(dialog));
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.invisibilityOf(dialog));
		
		for(WebElement tab : leftnav) {
			
			if(tab.getAttribute("title").equalsIgnoreCase(name)) {
				DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.elementToBeClickable(tab));
				tab.click();
				b=true;
			}
		}
		
		if(b!=true)
			System.out.print("This tab is not present in Application for the logged in user.");	
		 
	}//End navigatetoTab
	
//Used to navigate to particular Issue of a project.
	
	public boolean navigatetoProject(String title, String issue) {
		boolean b=false;
		//shownrecords("100");
		
		for(WebElement pro :prolist) {
			if(pro.getText().equalsIgnoreCase(title)) {	
				int i=prolist.indexOf(pro);
				if (prodetails.get(i*9+1).getText().equals(issue)) {
				pro.click();
			    b=true;
				}
		     }
		}
	   while(navigatetoPage("Next")) {
		   for(WebElement pro :prolist) {
				if(pro.getText().equalsIgnoreCase(title)) {	
					int i=prolist.indexOf(pro);
					if (prodetails.get((i)*9+1).getText().equals(issue)) {
					pro.click();
				    b=true;
					}
					
					else 
						System.out.print("Issue"+issue+"for Title"+title+"is not available");
			     }
				
				else 
					System.out.print("Title"+title+"is not available");		 
			}   
      }   
	   return b;  
	}//End of  navigatetoProject
	
	
//Used to navigate to a task in task list.
	
   public boolean navigatetoTask(String task, String title, String issue) {
		
	   boolean b=false;
		//shownrecords("100");
		
		for(WebElement pro :tasklist) {
			if(pro.getText().equalsIgnoreCase(task)) {	
				int i=tasklist.indexOf(pro);
				if (taskdetails.get(i*10+1).getText().equals(title)&&
					taskdetails.get(i*10+2).getText().equals(issue)) {
				
					pro.click();
			        b=true;
				}
		     }
		}
	   while(navigatetoPage("Next")) {
		   for(WebElement pro :prolist) {
			   if(pro.getText().equalsIgnoreCase(task)) {	
					int i=tasklist.indexOf(pro);
					if (taskdetails.get(i*10+1).getText().equals(title)&&
						taskdetails.get(i*10+2).getText().equals(issue)) {
					
						pro.click();
				        b=true;
					}
					else 
						System.out.print("Issue"+issue+"for Title"+title+"is not available");
			     }
			   else 
					System.out.print("Title"+title+"is not available");	
					
			     }
				
					 
			}  
	   return b;  
	}//End of navigatetoTask
		
		
//privates methods are used by public methods.
   
	private boolean navigatetoPage(String page) {
		boolean b=false;
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.elementToBeClickable(prolist.get(3)));
		for(WebElement button :pagebuttons) {
			if(button.getText().equalsIgnoreCase(page)) {
			if (button.isEnabled()&&button.isDisplayed()) {
				button.click();
				b=true;
		    }
			
			else
				System.out.print("Pagination came to an end or no projects are available");
		  }
		}
		
		return b;
	}
	
	
	private void shownrecords(String n) {
		Select s=new Select(nrecords);
		s.selectByValue(n);				
		}
}
