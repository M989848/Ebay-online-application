package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage {
 WebDriver driver;
	public BooksPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[contains(@src,'admin/productimages/21/interstellerjpg')]")
	private WebElement bookimg;
	
	@FindBy(xpath="//img[contains(@src,'admin/productimages/21/interstellerjpg')]/../../../..//button[text()='Add to cart']")
	private WebElement cartButton;
	
	@FindBy(xpath="//div[contains(@class,'arrow plus gradient')]")
	private WebElement increasedequantitybtn;
	
	@FindBy(xpath="//div[contains(@class,'arrow minus gradient')]")
	private WebElement decreasedequantitybtn;
	public WebElement getBookimg() {
		return bookimg;
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public WebElement getIncreasedequantitybtn() {
		return increasedequantitybtn;
	}

	public WebElement getDecreasedequantitybtn() {
		return decreasedequantitybtn;
	}
	
	
}
