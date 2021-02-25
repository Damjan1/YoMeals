package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, WebDriverWait waiter) {
		super(driver, waiter);
	}

	public WebElement loginMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public String message() {
		return this.loginMessage().getText();
//		return this.driver.findElement(By.xpath("//*[@class=\"div_msg\"]/ul/li")).getText();
	}

	public boolean loginMessageDisapire() {
		boolean messageDisapire;
		WebElement message = this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]")); 
		try {
			this.waiter.until(ExpectedConditions.attributeContains(message, "style", "display: none;"));
			messageDisapire = true;
		} catch (Exception e) {
			messageDisapire = false;
		}
		return messageDisapire;
	}
	
}
