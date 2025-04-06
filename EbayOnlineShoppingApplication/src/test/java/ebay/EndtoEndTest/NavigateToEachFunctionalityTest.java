package ebay.EndtoEndTest;



import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import ebay.BaseClassUtility.BaseClass;
import ebay.objectRepository.BooksPage;
import ebay.objectRepository.ElectronicsPage;
import ebay.objectRepository.FashionPage;
import ebay.objectRepository.HomePage;
import ebay.objectRepository.MyAccountPage;
import ebay.objectRepository.MyCartPage;
import ebay.objectRepository.PaymentsPage;

public class NavigateToEachFunctionalityTest extends BaseClass {
	
	@Test(groups = "system test")
	public void addToCartTest() throws Throwable {
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
		mcp.getIncreasequantitybtn().click();
		
		wu.scrollbyjavascriptexecutor(driver);
		mcp.getUpdateshopingbtn().click();
		wu.waitTillAlertIsPresent(driver);
		wu.handleAlertAccept(driver);
		
		wu.scrollbyjavascriptexecutor(driver);
		mcp.getProceedtocheckoutbtn().click();
		pp.getCodradiobtn().click();
		Assert.assertEquals(actualprod, expectedprod);
		
		
	}
		
		@Test(groups = "system test")
		public void wishlistTest() throws Throwable {
		
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
			
			wu.scrollbyjavascriptexecutor(driver);
			mcp.getContinueshoppingbtn().click();
			
			hp.getFurniturelink().click();
			String furnitureprod=eu.getDataFromExcel("testdata", 5, 1);
			hp.getSeachbar().sendKeys((furnitureprod),Keys.ENTER);
			wu.scrollbyjavascriptexecutor(driver);
			ecp.getFurnicartbtn().click();
			wu.waitTillAlertIsPresent(driver);
			wu.handleAlertAccept(driver);
			
			String actualfurnitureprod=mcp.getProducttextincart().getText();
			Assert.assertEquals(actualfurnitureprod, furnitureprod);
			
			}
		
		
		@Test(groups = "system test")
		public void DeletePendingOrderTest() throws Throwable {
			HomePage hp= new HomePage(driver);
			MyAccountPage map= new MyAccountPage(driver);
			MyCartPage mcp=new MyCartPage(driver);
			FashionPage fp= new FashionPage(driver);
			
			hp.getFashionlink().click();
			hp.getSeachbar().sendKeys((eu.getDataFromExcel("testdata", 6, 1)),Keys.ENTER);
			wu.scrollbyjavascriptexecutor(driver);
			fp.getFashioncart().click();
			wu.handleAlertAccept(driver);
			
			mcp.getPricecart().click();
			wu.scrollbyjavascriptexecutor(driver);
			mcp.getMycartbutton().click();
			wu.scrollbyjavascriptexecutor(driver);
			mcp.getProceedtocheckoutbtn().click();
			
			hp.getMyaccountbtn().click();
			wu.scrollbyjavascriptexecutor(driver);
			map.getPendingorder().click();
			wu.scrollbyjavascriptexecutor(driver);
			String actualfashion=fp.getDeletetxt().getText();
			map.getDeletebtn().click();
			
			String Expectedfashion= eu.getDataFromExcel("testdata", 6, 1);
		    boolean flag=actualfashion.contains(Expectedfashion);
			
			Assert.assertTrue(flag, Expectedfashion);
		}
			
			
			
			@Test(groups = "system test")
			public void proceedPendingorderTest() throws Throwable {
				HomePage hp= new HomePage(driver);
				MyAccountPage map= new MyAccountPage(driver);
				MyCartPage mcp=new MyCartPage(driver);
				FashionPage fp= new FashionPage(driver);
				PaymentsPage pp= new PaymentsPage(driver);
				
				hp.getFashionlink().click();
				hp.getSeachbar().sendKeys((eu.getDataFromExcel("testdata", 7, 1)),Keys.ENTER);
				wu.scrollbyjavascriptexecutor(driver);
				fp.getShoescart().click();
				wu.handleAlertAccept(driver);
				
				mcp.getPricecart().click();
				wu.scrollbyjavascriptexecutor(driver);
				mcp.getMycartbutton().click();
				wu.scrollbyjavascriptexecutor(driver);
				mcp.getProceedtocheckoutbtn().click();
				
				hp.getMyaccountbtn().click();
				wu.scrollbyjavascriptexecutor(driver);
				map.getPendingorder().click();
				wu.scrollbyjavascriptexecutor(driver);
				map.getProceedtopaybtn().click();
				wu.scrollbyjavascriptexecutor(driver);
				pp.getCardbtn().click();
				pp.getPaymentsubmitbn().click();
			}
		}
