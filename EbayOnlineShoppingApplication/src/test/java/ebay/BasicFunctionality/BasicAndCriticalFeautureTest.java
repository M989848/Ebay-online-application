package ebay.BasicFunctionality;
import org.testng.Assert;
import org.testng.annotations.Test;
import ebay.BaseClassUtility.BaseClass;
import ebay.objectRepository.HomePage;
import ebay.objectRepository.LoginPage;
import ebay.objectRepository.MyAccountPage;

public class BasicAndCriticalFeautureTest extends BaseClass{
	@Test(groups = "smoke test")
	public void createAccountTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		MyAccountPage map= new MyAccountPage(driver);
		hp.getMyaccountbtn().click();
		map.getNametextfield().clear();
		map.getNametextfield().sendKeys(eu.getDataFromExcel("testdata", 1, 0));
		map.getContactnumtext().clear();
		map.getContactnumtext().sendKeys(eu.getDataFromExcel("testdata", 1, 2));
		wu.scrollbyjavascriptexecutor(driver);
		map.getUpdatebutton().click();
		wu.waitTillAlertIsPresent(driver);
		wu.handleAlertAccept(driver);
		String expectedname=eu.getDataFromExcel("testdata", 1, 0);
		String expectedcontact=eu.getDataFromExcel("testdata", 1, 2);
		String actualname=map.getNametextfield().getAttribute("value");
		String actualcontact=map.getContactnumtext().getAttribute("value");
		Assert.assertEquals(actualname, expectedname);
		Assert.assertEquals(actualcontact, expectedcontact);
		}
	
	@Test(groups = "smoke test")
	public void billingUpdateTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		MyAccountPage map= new MyAccountPage(driver);
		hp.getMyaccountbtn().click();
		
		map.getBillingmodule().click();
		map.getBillingtext().clear();
		map.getBillingtext().sendKeys(eu.getDataFromExcel("testdata", 10, 0));
		map.getStatetext().clear();
		map.getStatetext().sendKeys(eu.getDataFromExcel("testdata", 10, 1));
		map.getBillingcitytxt().clear();
		map.getBillingcitytxt().sendKeys(eu.getDataFromExcel("testdata", 10, 2));
		map.getBillingcodetext().clear();
		map.getBillingcodetext().sendKeys(eu.getDataFromExcel("testdata", 10, 3));
		wu.scrollbyjavascriptexecutor(driver);
		map.getUpdatebutton().click();
		wu.waitTillAlertIsPresent(driver);
		wu.handleAlertAccept(driver);
		String actualadd=map.getBillingtext().getAttribute("value");
		String actualstate=map.getStatetext().getAttribute("value");
		String actualcity=map.getBillingcitytxt().getAttribute("value");
		String actualcode=map.getBillingcodetext().getAttribute("value");
		String expectedadd=eu.getDataFromExcel("testdata", 10, 0);
		String expectedstate=eu.getDataFromExcel("testdata", 10, 1);
		String expectedcity=eu.getDataFromExcel("testdata", 10, 2);
		String expectedcode=eu.getDataFromExcel("testdata", 10, 3);
		
		Assert.assertEquals(actualadd, expectedadd);
		Assert.assertEquals(actualstate, expectedstate);
		Assert.assertEquals(actualcity, expectedcity);
		Assert.assertEquals(actualcode, expectedcode);
	
		
		
		
		
	}


}
