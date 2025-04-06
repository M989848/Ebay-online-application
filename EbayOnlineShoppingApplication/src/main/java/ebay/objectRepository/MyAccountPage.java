package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Order History']")
	private WebElement orderhistory;
	
	@FindBy(xpath = "//a[@href='pending-orders.php']")
	private WebElement pendingorder;
	
	@FindBy(xpath = "//a[text()='Delete']")
	private WebElement deletebtn;
	
	
	@FindBy(xpath = "//a[contains(text(),'PROCCED To Payment')]")
	private WebElement proceedtopaybtn;
	
	@FindBy(id="name")
	private WebElement nametextfield;
	
	@FindBy(id = "contactno")
	private WebElement contactnumtext;
	
	@FindBy(name = "update")
	private WebElement updatebutton;
	
	@FindBy(xpath = "//h4[contains(text(),'Your Checkout Progress')]/../..//a[text()='Shipping / Billing Address']")
	private WebElement billingmodule;
	
	@FindBy(name = "billingaddress")
	private WebElement billingtext;
	
	@FindBy(id = "bilingstate")
	private WebElement statetext;
	
	@FindBy(id = "billingcity")
	private WebElement billingcitytxt;
	
	
	@FindBy(id = "billingpincode")
	private WebElement billingcodetext;
	
	@FindBy(name = "update")
	private WebElement billingupdatebtn;
	
	public WebElement getNametextfield() {
		return nametextfield;
	}

	public WebElement getContactnumtext() {
		return contactnumtext;
	}

	public WebElement getOrderhistory() {
		return orderhistory;
	}

	public WebElement getPendingorder() {
		return pendingorder;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public WebElement getProceedtopaybtn() {
		return proceedtopaybtn;
	}

	public WebElement getUpdatebutton() {
		return updatebutton;
	}

	public WebElement getBillingmodule() {
		return billingmodule;
	}

	public WebElement getBillingtext() {
		return billingtext;
	}

	public WebElement getStatetext() {
		return statetext;
	}

	public WebElement getBillingcitytxt() {
		return billingcitytxt;
	}

	public WebElement getBillingcodetext() {
		return billingcodetext;
	}

	public WebElement getBillingupdatebtn() {
		return billingupdatebtn;
	}
	
	
}
