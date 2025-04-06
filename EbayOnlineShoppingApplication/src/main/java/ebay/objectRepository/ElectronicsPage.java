package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicsPage {
	WebDriver driver;
	public ElectronicsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//a[contains(text(),'Mobile Accessories')]")
		private WebElement mobileaccessorieslink;
	
	@FindBy(xpath = "//a[text()='SliverAnklet']")
	private WebElement accessories;
	
	@FindBy(xpath = "//a[contains(@data-original-title,'Wishlist')]")
     private WebElement wishlistIcon;
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	private WebElement cartbtninwishlist;
	
	@FindBy(xpath = "//div[contains(@class,'product-info text-left')]/descendant::a[text()='yellow queen']/../../..//button[text()='Add to cart']")
	private WebElement furnicartbtn;
	
	
	public WebElement getMobileaccessorieslink() {
		return mobileaccessorieslink;
	}

	public WebElement getAccessories() {
		return accessories;
	}

	public WebElement getWishlistIcon() {
		return wishlistIcon;
	}

	public WebElement getCartbtninwishlist() {
		return cartbtninwishlist;
	}

	public WebElement getFurnicartbtn() {
		return furnicartbtn;
	}
	
}
