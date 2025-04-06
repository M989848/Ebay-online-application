package ebay.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage {
WebDriver driver;
public PaymentsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//input[@value='COD']")
private WebElement codradiobtn;


@FindBy(xpath = "//input[@value='Internet Banking']")
private WebElement InternetbankingBtn;

@FindBy(xpath="//input[@value='Debit / Credit card']")
private WebElement cardbtn;

@FindBy(name ="submit")
private WebElement paymentsubmitbn;


public WebElement getCodradiobtn() {
	return codradiobtn;
}

public WebElement getInternetbankingBtn() {
	return InternetbankingBtn;
}

public WebElement getCardbtn() {
	return cardbtn;
}

public WebElement getPaymentsubmitbn() {
	return paymentsubmitbn;
}

}
