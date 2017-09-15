package pageobjects;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.DriverObjectFactory;
import utilities.ScreenshotCapture;

public class ReviewTaskPage {
	
	@FindBy(id="opRDTitle")
	private WebElement title;
	
	@FindBy(id="opRDIssue")
	private WebElement issue;
	
	@FindBy(id="opRDTNumber")
	private WebElement tnum;

	@FindBy(id="opRDType")
	private WebElement type;
	
	@FindBy(id="opRDService")
	private WebElement service;
	
	@FindBy(id="txtNotesRUDetailID")
	private WebElement notes;
	
	@FindBy(id="opRDDigitalOkDate")
	private WebElement digitalok;
	
	@FindBy(id="opRInStoreDate")
	private WebElement instore;
	
	@FindBy(id="opRTaskCreationDate")
	private WebElement creation;
	
	@FindBy(xpath="	.//*[@id='gridDetailsContainer']//button")
	private List<WebElement> buttons;
	
	@FindBy(xpath=".//*[contains(@id,'MasterReviewerComment') or contains(@id,'ReviewerComment')]")
	private WebElement reviewercomment;
	
	@FindBy(xpath=".//*[contains(@id,'masterRejection') or contains(@id,'masterApproval')]//button")
	private List<WebElement> reviewbtn;
	
	public ReviewTaskPage(){
		PageFactory.initElements(DriverObjectFactory.getDriver(), this);
}

	
	//Used to approve all the assets uploaded by Talent.
	public boolean approveAll() {
		selectAll();
		ScreenshotCapture.captureScreenShot();
		approve();	
	return true;
	}//End approveAll
	
	
//Used to reject all the assets uploaded by Talent.
	public boolean rejectAll() {	
		selectAll();
		reject();	
	return true;
	}//End rejectAll
	
	
//Used to select all the assets uploaded by Talent.
	private void selectAll() {
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.visibilityOf(title));
		for(WebElement button :buttons) {
			if(button.getText().equalsIgnoreCase("Select All")) {
			button.click();
			break;
	    	}
		}	
	}//End SelectAll
	
//Used to select all the assets uploaded by Talent.
	private void approve() {
		//DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.visibilityOf(buttons.get(0)));
		for(WebElement button :buttons) {
			if(button.getText().equalsIgnoreCase("Approve Selected")) {
			button.click();
			break; 
			}
		}
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.elementToBeClickable(reviewercomment));
		reviewercomment.sendKeys("Approved");
		ScreenshotCapture.captureScreenShot();
		
		for(WebElement btn :reviewbtn) {
			if(btn.getText().equalsIgnoreCase("Yes")) {
			btn.click();
			break; 
			}
		}		
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.visibilityOf(title));
	}//End approve
	
//Used to reject selected assets uploaded by Talent.
	private void reject() {
		//DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.visibilityOf(buttons.get(1)));
		for(WebElement button :buttons) {
			if(button.getText().equalsIgnoreCase("Resubmit Selected")) {
			button.click();
			break; 
			}
		}
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.elementToBeClickable(reviewercomment));
		reviewercomment.sendKeys("Rejected");
		ScreenshotCapture.captureScreenShot();
		for(WebElement btn :reviewbtn) {
			if(btn.getText().equalsIgnoreCase("Yes")) {
			btn.click();
			break; 
			}
		}
		DriverObjectFactory.getDefaultWebDriverWait().until(ExpectedConditions.visibilityOf(title));
	}//End reject
	
	
}