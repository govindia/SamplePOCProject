package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverObjectFactory;

public class ReviewTaskPage {
	
	@FindBy(id="opRDTitle")
	private WebElement title;
	
	@FindBy(id="opRDIssue")
	private WebElement issue;
	
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
	
	
	public ReviewTaskPage(){
		PageFactory.initElements(DriverObjectFactory.getDriver(), this);
}

}
