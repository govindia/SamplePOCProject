package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverObjectFactory;
import utilities.ScreenshotCapture;


public class LoginPage{

	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	public LoginPage(){
			PageFactory.initElements(DriverObjectFactory.getDriver(), this);
	}

	public LoginPage setUsername(String user) {
		username.clear();
		username.sendKeys(user);
		return this;
	}

	public TrinityBasePage setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);
		ScreenshotCapture.captureScreenShot();
		return new TrinityBasePage();
	}

	 

	
}
