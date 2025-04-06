package ebay.DataFlow;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import ebay.BaseClassUtility.BaseClass;
import ebay.objectRepository.BooksPage;
import ebay.objectRepository.ElectronicsPage;
import ebay.objectRepository.HomePage;
import ebay.objectRepository.MyCartPage;
import ebay.objectRepository.PaymentsPage;

public class IntegratedTest extends BaseClass {

	
	@Test(groups = "integration test")
	
	public void CartTest() throws Throwable {
       String book=eu.getDataFromExcel("testdata", 3, 1);
		
		BooksPage bp= new BooksPage(driver);
		HomePage hp= new HomePage(driver);
		PaymentsPage pp=new PaymentsPage(driver);
		MyCartPage mcp=new MyCartPage(driver);
		
		hp.getSeachbar().sendKeys((book),Keys.ENTER);
		wu.scrollbyjavascriptexecutor(driver);
		bp.getCartButton().click();
		wu.handleAlertAccept(driver);
		String expectedprod=book;
		String actualprod=mcp.getProducttextincart().getText();
		Assert.assertEquals(actualprod, expectedprod);
	}
	
	@Test(groups = "integration test")
	public void productFromWishlistTest() throws Throwable {
		HomePage hp= new HomePage(driver);
		MyCartPage mcp=new MyCartPage(driver);
		ElectronicsPage ecp= new ElectronicsPage(driver);
		
		hp.getElectronicslink().click();
		ecp.getMobileaccessorieslink().click();
		wu.scrollbyjavascriptexecutor(driver);
		ecp.getAccessories().click();
		wu.scrollbyjavascriptexecutor(driver);
		ecp.getWishlistIcon().click();
		
		hp.getWishlistmodule().click();
		wu.scrollbyjavascriptexecutor(driver);
		ecp.getCartbtninwishlist().click();
		
		hp.getMycartmodule().click();
		String productname=eu.getDataFromExcel("testdata", 4, 1);
		String actualprod=mcp.getProducttextincart().getText();
		Assert.assertEquals(actualprod, productname);
	}
}
