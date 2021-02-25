package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartSummaryPage extends BasicPage {

	public CartSummaryPage(WebDriver driver, WebDriverWait waiter) {
		super(driver, waiter);
	}

	public WebElement getClearAllButton() {
		return this.driver.findElement(By.linkText("Clear All"));
	}
	
	public void ClearChart() {
		this.getClearAllButton().click();
	}
	
}