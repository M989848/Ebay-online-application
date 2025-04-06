package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {
	WebDriver driver;
	public MyCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'cart -')]")
	private WebElement pricecart;
	
	@FindBy(xpath = "//div[@class='clearfix']/following-sibling::a")
	private WebElement mycartbutton;

	
	@ FindBy(name="submit")
	private WebElement updateshopingbtn;
	
	@FindBy(xpath = "//a[text()='Continue Shopping']")
	private WebElement continueshoppingbtn;
	
	@FindBy(name="ordersubmit")
	private WebElement proceedtocheckoutbtn;
	
	@FindBy(name="shipupdate")
	private WebElement billingupdatebtn;
	
	@FindBy(name="update")
	private WebElement shippingupdatebtn;
	
	@FindBy(xpath = "//h4[contains(@class,'cart-product-description')]/descendant::a")
	private WebElement producttextincart;
	
	@FindBy(xpath = "//div[@class='arrow plus gradient']")
	private WebElement increasequantitybtn;
	
	
	
	public WebElement getUpdateshopingbtn() {
		return updateshopingbtn;
	}

	public WebElement getContinueshoppingbtn() {
		return continueshoppingbtn;
	}



	public WebElement getProceedtocheckoutbtn() {
		return proceedtocheckoutbtn;
	}

	public WebElement getBillingupdatebtn() {
		return billingupdatebtn;
	}

	public WebElement getShippingupdaten() {
		return shippingupdatebtn;
	}

	public WebElement getProducttextincart() {
		return producttextincart;
	}

	public WebElement getIncreasequantitybtn() {
		return increasequantitybtn;
	}

	public WebElement getPricecart() {
		return pricecart;
	}

	public WebElement getMycartbutton() {
		return mycartbutton;
	}
	
	
	
}
