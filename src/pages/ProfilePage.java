package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	public void removeProfileImage() {
		WebElement removeImage = this.driver.findElement(By.className("remove"));
		js.executeScript("arguments[0].click();", removeImage);
	}
	
	public void changePersonalImformation (String firsName , String lastName , String email , String address , String phone , String zipCode , String country , String state , String city) {
		this.getProfileFirsName().click();
		this.getProfileFirsName().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getProfileFirsName().sendKeys(firsName);
		
		this.getProfileLastName().click();
		this.getProfileLastName().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getProfileLastName().sendKeys(lastName);
		
		this.getProfileEmail().click();
		this.getProfileEmail().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getProfileEmail().sendKeys(email);
		
		this.getProfileAddress().click();
		this.getProfileAddress().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getProfileAddress().sendKeys(address);
		
		this.getProfilePhone().click();
		this.getProfilePhone().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getProfilePhone().sendKeys(phone);
		
		this.getProfileZipCode().click();
		this.getProfileZipCode().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getProfileZipCode().sendKeys(zipCode);
		
		this.getProfileCountry().selectByValue(country);
		
		this.getProfileState().selectByValue(state);
		
		this.getProfileCity().selectByValue(city);
	}
	
}
