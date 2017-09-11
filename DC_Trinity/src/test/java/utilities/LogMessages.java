package utilities;

import org.apache.log4j.Logger;

public class LogMessages {
	
	private static Logger log = Logger.getLogger(LogMessages.class.getName());
	
	public static void info(String message){
		log.info(message);
	}
	
	public static void warn(String message){
		log.warn(message);
	}
	

	public static void error(String message){
		log.error(message);
	}
	
	public static void fatal(String message){
		log.fatal(message);
	}
}
