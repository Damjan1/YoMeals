package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {
	
	protected JavascriptExecutor js;

	public LocationPopupPage(WebDriver driver, WebDriverWait waiter) {
		super(driver, waiter);
	}
	
	public WebElement getHederSelectLocation() {
		return this.driver.findElement(By.xpath("//*[@class=\"location-selector\"]/a"));
	}
	
	public WebElement getCloseBtn() {
		return this.driver.findElement(By.className("close-btn"));
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.name("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id=\"location_id\"]"));
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void openPopup() {
		getHederSelectLocation().click();
	}
	
	public void insertLocation (String locationName) {
		getKeyword().click();
		String location = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("agruments[0].value = arguments[1]", this.getLocationInput() , location);
		js.executeScript("arguments[0].click();", this.getSubmit());
	}
	
}
