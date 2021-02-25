package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	
	protected JavascriptExecutor js;

	public ProfilePage(WebDriver driver, WebDriverWait waiter) {
		super(driver, waiter);
	}

	public WebElement getProfileFirsName() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getProfileLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getProfileEmail() {
		return this.driver.findElement(By.name("user_email"));
	}
	
	public WebElement getProfileAddress() {
		return this.driver.findElement(By.name("user_address"));
	}
	
	public WebElement getProfilePhone() {
		return this.driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getProfileZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}
	
	public Select getProfileCountry() {
		WebElement selectCountry = this.driver.findElement(By.name("user_country_id"));
		Select country = new Select(selectCountry);
		return country;
	}
	
	public Select getProfileState() {
		WebElement selectState = this.driver.findElement(By.name("user_state_id"));
		Select state = new Select(selectState);
		return state;
	}
	
	public Select getProfileCity() {
		WebElement selectCity = this.driver.findElement(By.name("user_city"));
		Select city = new Select(selectCity);
		return city;
	}
	
	public void setProfileImage() {
		WebElement uploadImage = this.driver.findElement(By.xpath("//*[contains(@class, \"upload\")]"));
		js.executeScript("arguments[0].click();", uploadImage);
		uploadImage.sendKeys("E:\\Projects\\YoMeals\\img\\John Doe.jpg");
	}
	
}
