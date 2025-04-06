package ebay.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FashionPage {
	WebDriver driver;
	public FashionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//img[@src='admin/productimages/19/1.jpeg']/../../../..//button[text()='Add to cart']")
	private WebElement fashioncart;
	
	@FindBy(xpath="//img[@src='admin/productimages//1.jpeg']/../../..//a[contains(text(), 'Asian Casuals')]")
	private WebElement deletetxt;
	
	@FindBy(xpath="//img[contains(@src,'admin/productimages/20/')]/../../../..//button[contains(text(),'Add to cart')]")
	private WebElement shoescart;
	
	
	public WebElement getFashioncart() {
		return fashioncart;
	}


	public WebElement getDeletetxt() {
		return deletetxt;
	}


	public WebElement getShoescart() {
		return shoescart;
	}
	
	
	

}
