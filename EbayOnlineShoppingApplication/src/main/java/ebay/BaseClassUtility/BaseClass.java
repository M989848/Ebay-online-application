package ebay.BaseClassUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import ebay.GenericUtility.PropertyFileUtility;
import ebay.WebDriverUtility.UtilityClass;
import ebay.WebDriverUtility.WebDriverUtility;
import ebay.GenericUtility.ExcelUtility;
import ebay.objectRepository.HomePage;

public class BaseClass {
	public PropertyFileUtility fu = new PropertyFileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	
	public WebDriver driver = null;
	public static WebDriver sdriver=null;

	@BeforeSuite(alwaysRun = true)
	public void configBSTest() {
		System.out.println("connection to db ");
	}
	
    @Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBCTest( @Optional("chrome")String browser ) throws Throwable {
    	 String BROWSER=null;
    	 try {
    		 BROWSER=browser;
    	 } catch (Exception E) {
		 BROWSER= fu.getDataFromPropertyFile("Browser");
    	 }
    	 System.out.println("N:"+BROWSER);
    	// String BROWSER= System.getProperty("browser",fu.getDataFromPropertyFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		UtilityClass.setDriver(sdriver);
     }

	@BeforeMethod(alwaysRun = true)
	public void configBMTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		String USERNAME = fu.getDataFromPropertyFile("username");
		String PASSWORD = fu.getDataFromPropertyFile("password");
		String URL = fu.getDataFromPropertyFile("Url");
		/*String USERNAME=System.getProperty("username",fu.getDataFromPropertyFile("username"));
		String PASSWORD=System.getProperty("password",fu.getDataFromPropertyFile("password"));
		String URL=System.getProperty("URL",fu.getDataFromPropertyFile("URL"));*/
		hp.LoginPage( URL,USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void configAMTest() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(alwaysRun = true)
	public void configAcTest() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAsTest() {
		System.out.println("close DB");
	}
}



