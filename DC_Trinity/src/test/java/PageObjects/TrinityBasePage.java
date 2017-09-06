package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverObjectFactory;

public class TrinityBasePage {
	
	@FindBy(xpath=".//*[@id='sidebar']/ul/li/a")
	private List<WebElement> leftnav; //left navigation panel
	
	@FindBy(xpath=".//*[contains(@id,'uiGrid')]/div")
	private List<WebElement> tasklist; //task list
	
	@FindBy(xpath=".//*[contains(@id,'uiGrid')]//a")
	private List<WebElement> prolist;  //project list
	
	@FindBy(name=".//*[@id='taskGrid']//select")
	private WebElement nrecords;  //Number of records displayed per page.
	
	@FindBy(name=".//*[@id='taskGrid']//button//span")
	private List<WebElement> pagebuttons;
	
	
	//Constructor to initialize the web elements
	public TrinityBasePage(){
			PageFactory.initElements(DriverObjectFactory.getDriver(), this);
	}
	
	//Used to navigate to the different tabs available on the left panel.
	public void navigatetoTab(String name) {
		
		WebDriverWait wait=new WebDriverWait(DriverObjectFactory.getDriver(), 360,1000);
		wait.until(ExpectedConditions.elementToBeClickable(nrecords));
		
		for(WebElement tab : leftnav) {
			
			if(tab.getAttribute("title").equalsIgnoreCase(name))
				wait.until(ExpectedConditions.elementToBeClickable(tab));
				tab.click();
			}
		
		 System.out.print("This tab is not present in Application for the logged in user.");
		 
	}//End navigatetoTab
	
	public void navigatetoProject(String title, int issue) {
		
		for(WebElement pro :prolist) {
			if(pro.getText().equalsIgnoreCase(title))
				pro.click();
		}
	}
	
   public void navigatetoTask(String task, String title, int issue) {
		
	   for(WebElement pro :tasklist) {
			if(pro.getText().equalsIgnoreCase(title))
				pro.click();
		}
	}
		
		
	
	//privates methods are used by public methods.
	private void navigatetoPage(String page) {
		for(WebElement button :pagebuttons) {
			if(button.getText().equalsIgnoreCase(page))
			button.click();
		}
	}
	
	private void shownrecords(String n) {
		Select s=new Select(nrecords);
		s.selectByValue(n);				
		}
}
