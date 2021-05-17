package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.dashboardPage;
import utils.LoadProperties;
import utils.StringConstants;

public class TestBase {

	public static WebDriver driver;

	public static dashboardPage dashboard;

	public static final String USERNAME = LoadProperties.getProperties("BROWSERSTACK_USERNAME");
	public static final String AUTOMATE_KEY = LoadProperties.getProperties("BROWSERSTACK_ACCESS_KEY");
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws Exception {
		LoadProperties.loadProperties();
		if (LoadProperties.getProperties("Environment").equals("Local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", StringConstants.getFirefoxDriverPath());
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", StringConstants.getChromeDriverPath());
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", StringConstants.getIeDriverPath());
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Browser is not correct");
			}
		} else {
			if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Firefox");
				caps.setCapability("browser_version", "latest");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.10.0");
				driver=new RemoteWebDriver(new java.net.URL(URL), caps);
			} else if (browser.equalsIgnoreCase("chrome")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "Chrome");
				caps.setCapability("browser_version", "latest");
				driver=new RemoteWebDriver(new java.net.URL(URL), caps);
			} else if (browser.equalsIgnoreCase("IE")) {
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("os", "Windows");
				caps.setCapability("os_version", "10");
				caps.setCapability("browser", "IE");
				caps.setCapability("browser_version", "11.0");
				caps.setCapability("browserstack.local", "false");
				caps.setCapability("browserstack.selenium_version", "3.5.2");
				driver=new RemoteWebDriver(new java.net.URL(URL), caps);
			} else {
				throw new Exception("Browser is not correct");
			}

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(LoadProperties.getProperties("applicationURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

	/*
	 * String browserName = LoadProperties.getProperties("browserName");
	 * if(browserName.equalsIgnoreCase("Firefox")) {
	 * System.setProperty("webdriver.gecko.driver",StringConstants.
	 * getFirefoxDriverPath()); driver = new FirefoxDriver(); }else
	 * if(browserName.equalsIgnoreCase("IE")){
	 * System.setProperty("webdriver.ie.driver",StringConstants.getIeDriverPath());
	 * driver = new InternetExplorerDriver(); }else if
	 * (browserName.equalsIgnoreCase("Chrome")) {
	 * 
	 * System.setProperty("webdriver.chrome.driver",StringConstants.
	 * getChromeDriverPath()); ChromeOptions chromeOptions= new ChromeOptions();
	 * chromeOptions.
	 * setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	 * 
	 * 
	 * driver = new ChromeDriver();
	 * 
	 * 
	 * 
	 * 
	 * DesiredCapabilities caps = new DesiredCapabilities();
	 * caps.setCapability("os", "Windows"); caps.setCapability("os_version", "10");
	 * caps.setCapability("browser", "Chrome");
	 * caps.setCapability("browser_version", "latest");
	 * 
	 * try { driver = new RemoteWebDriver(new java.net.URL(URL), caps); } catch
	 * (MalformedURLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * }
	 * 
	 */

}
