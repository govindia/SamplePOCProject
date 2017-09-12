package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadTestDataConfig{
	
	static FileInputStream fileInput = null;
	static String value;
	
	public static String getTestData(String data) {
		
		File file = new File(System.getProperty("user.dir") +"//test-data.config");
	
		try {
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration<Object> KeyValues = prop.keys();
		while (KeyValues.hasMoreElements()) {
			String key = (String) KeyValues.nextElement();
		   if(key.equalsIgnoreCase(data)) 
			value = prop.getProperty(key);
	    }
		return value;
      }
	}
