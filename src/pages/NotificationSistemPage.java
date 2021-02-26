package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	

	public NotificationSistemPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public List<WebElement> getNotificationMessage() {
		return this.driver.findElements(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public String message() {
		String mesage = "";
		for (int i = 0; i < getNotificationMessage().size(); i++) {
			mesage = this.getNotificationMessage().get(i).getText();
		}
		return mesage;
	}

	public void waitMessageToDisapire() {
		this.waiter.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'system_message')]"), "style", "display: none;"));
	}
	
}
