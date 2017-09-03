package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverObjectFactory {

   public static WebDriver driver;
   public static WebDriverWait dwait;
   public   WebDriverWait wait;

    @BeforeSuite
    public static void instantiateDriverObject() {
    	System.out.println("executing BeforeSuite");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\govinda.gupta\\eclipse-workspace\\DC_Trinity\\drivers\\chromedriver.exe");
        driver =new ChromeDriver(); 
        dwait=new WebDriverWait(driver,360,500);
    }

    public static WebDriver getDriver() {
    	  
        return driver;
    }
    
    public static WebDriverWait getDefaultWebDriverWait() {
  	  
        return dwait;
    }

    public  WebDriverWait getWebDriverWait(int sec) {
    	wait=new WebDriverWait(driver,sec,500);
        return wait;
    }
   @AfterMethod
    public static void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public static void closeDriverObjects() {
        driver.quit();
        }
    
    }
