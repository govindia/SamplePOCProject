package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCapture {
	
	public static Integer counter=1;
	
	public static void captureScreenShot(){
		File scrnsht =((TakesScreenshot)DriverObjectFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrnsht, new	File(System.getProperty("user.dir")+"\\target\\Screenshots\\Screenshot_"+counter.toString()+".png"));
			counter++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
