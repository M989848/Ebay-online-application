package ebay.WebDriverUtility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
    public void waitForTheElementToLoad(WebDriver driver,WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void elementToBeClickable(WebDriver driver,WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	
    }
    
    public void moveToElement(WebElement element, WebDriver driver) {
    	Actions action = new Actions(driver);
    	action.moveToElement(element).build().perform();
    }
    
     public void scrollTillElementVisible(WebDriver driver,WebElement element) {
    	 Actions action = new Actions(driver);
    	 action.scrollToElement(element).build().perform();     
    	 }
     public void handleAlertAccept(WebDriver driver) {
    	 driver.switchTo().alert().accept();
     }
     public void rejectTheAlert(WebDriver driver) {
    	 driver.switchTo().alert().dismiss();
     }
     public void scrollbyjavascriptexecutor(WebDriver driver) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500);");
     }
     public void waitTillAlertIsPresent(WebDriver driver) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.alertIsPresent());
     }
     public void scrollToView(WebDriver driver,WebElement element) {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 
    	js.executeAsyncScript("arguments[300].scrollIntoView(true);", element);
    	 
     }
}
