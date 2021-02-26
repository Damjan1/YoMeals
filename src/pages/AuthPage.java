package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	

	public AuthPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getpersonalButton() {
		return this.driver.findElement(By.className("after-arrow"));
	}
	
	public WebElement getMyAccount() {
		return this.driver.findElement(By.linkText("My Account"));
	}
	
	public WebElement getLogout() {
		return this.driver.findElement(By.linkText("Logout"));	
	}

	public void logOut() {
		this.getpersonalButton().click();
		this.getLogout().click();
	}
	
	
}
