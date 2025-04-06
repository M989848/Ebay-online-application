package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ebay.WebDriverUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Login")
	private WebElement loginlink;
	
	@FindBy(xpath = "//a[@href='my-account.php']/descendant::i")
	private WebElement myaccountbtn;

	@FindBy(xpath = "//a[text()=' Books']")
	private WebElement bookslink;

	@FindBy(xpath = "//a[text()=' Electronics']")
	private WebElement electronicslink;

	@FindBy(xpath = "//a[text()=' Furniture']")
	private WebElement furniturelink;

	@FindBy(xpath = "//a[text()=' Fashion']")
	private WebElement fashionlink;
	
	
	@FindBy(name = "product")
	private WebElement searchbar;
	
	@FindBy(xpath = "//a[text()='Wishlist']")
	private WebElement wishlistmodule;
	
	@FindBy(xpath="//a[text()='My Cart']")
	private WebElement mycartmodule;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutbtn;
	
	@FindBy(name="email")
	private WebElement emailtextfiled;
	
	@FindBy(name="password")
	private WebElement passwordtextfiled;
	
	@FindBy(name="login")
	private WebElement loginbtn;
	
	@FindBy(name = "search")
	private WebElement searchbtn;

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getLoginlink() {
		return loginlink;
	}

	public WebElement getBookslink() {
		return bookslink;
	}

	public WebElement getElectronicslink() {
		return electronicslink;
	}

	public WebElement getFurniturelink() {
		return furniturelink;
	}

	public WebElement getFashionlink() {
		return fashionlink;
	}
	
	

	public WebElement getSeachbar() {
		return searchbar;
	}

	public WebElement getMycartmodule() {
		return mycartmodule;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	public WebElement getEmailtextfiled() {
		return emailtextfiled;
	}

	public WebElement getPasswordtextfiled() {
		return passwordtextfiled;
	}
	
	
	public WebElement getSearchBtn() {
		return searchbtn;
	}
	public WebElement getWishlistmodule() {
		return wishlistmodule;
	}

	
	public WebElement getMyaccountbtn() {
		return myaccountbtn;
	}

	public void LoginPage(String url,String username,String password) {
		driver.get(url);
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		loginlink.click();
		emailtextfiled.sendKeys(username);
		passwordtextfiled.sendKeys(password);
		loginbtn.click();	
	}

	public void logout() {
		logoutbtn.click();
		
	}
}

