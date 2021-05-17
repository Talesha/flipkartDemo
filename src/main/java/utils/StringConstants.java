package utils;

public class StringConstants {
	private static String SYSTEM_USER_DIR = System.getProperty("user.dir");
	private static String CONFIG_FILE_NAME ="config.properties";
	private static String CHROME_DRIVER_PATH = SYSTEM_USER_DIR + "\\src\\main\\resources\\driver\\drivers\\chromedriver.exe";
	private static String FIREFOX_DRIVER_PATH = SYSTEM_USER_DIR + "\\src\\main\\resources\\driver\\drivers\\geckodriver.exe";
	private static String IE_DRIVER_PATH = SYSTEM_USER_DIR + "\\src\\main\\resources\\driver\\drivers\\IEDriverServer.exe";
	
	public static String getSystemUserDir() {
		return SYSTEM_USER_DIR;
	}
	public static String getConfigFileName() {
		return CONFIG_FILE_NAME;
	}
	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}
	public static String getFirefoxDriverPath() {
		return FIREFOX_DRIVER_PATH;
	}
	public static String getIeDriverPath() {
		return IE_DRIVER_PATH;
	}	
	
	
}
