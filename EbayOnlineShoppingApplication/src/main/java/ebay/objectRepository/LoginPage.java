package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}  

        @FindBy(id = "fullname")
        private WebElement fullnametxtfield;
        
        @FindBy(id = "email")
        private WebElement emailtextfiled;
        
        @FindBy(id = "contactno")
        private WebElement contacttxt;
        
        @FindBy(id = "password")
        private WebElement passwordtxt;
        
        @FindBy(id = "confirmpassword")
        private WebElement confirmpasstxt;
        
        @FindBy(id = "submit")
        private WebElement submitbtn;
        
        
		public WebElement getFullnametxtfield() {
			return fullnametxtfield;
		}

		public WebElement getEmailtextfiled() {
			return emailtextfiled;
		}

		public WebElement getContacttxt() {
			return contacttxt;
		}

		public WebElement getPasswordtxt() {
			return passwordtxt;
		}

		public WebElement getConfirmpasstxt() {
			return confirmpasstxt;
		}

		public WebElement getSubmitbtn() {
			return submitbtn;
		}
        

}
