package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, WebDriverWait waiter) {
		super(driver, waiter);
	}

	public WebElement getMyAcount() {
		return this.driver.findElement(By.xpath("//*[@class=\"my-account-dropdown\"]/ul/li[1]"));
	}
	
	public WebElement getLogout() {
		return this.driver.findElement(By.xpath("//*[@class=\"my-account-dropdown\"]/ul/li[2]"));	
	}

	public void logOut() {
		this.getLogout().click();
	}
	
	
}
