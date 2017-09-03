package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverObjectFactory;

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

	public LoginPage setPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);
		return this;
	}

	 

	
}
