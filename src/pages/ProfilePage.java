package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	
	public ProfilePage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
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
	
	public WebElement getSaveButton() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public WebElement getUploadImageButton() throws InterruptedException {
		return this.driver.findElement(By.xpath("//*[@id='profileInfo']/div/div[1]/div/a"));
		
	}
	
	public WebElement getPhotoInput() {
		return this.driver.findElement(By.xpath("//*[@type='file']"));
		
	}
	
	public void uploadImg(String imgPath) throws InterruptedException {
		js.executeScript("arguments[0].click();", getUploadImageButton());
		this.getPhotoInput().sendKeys(imgPath);
	}
	
	public void removeProfileImage() {
		WebElement removeImage = this.driver.findElement(By.xpath("//*[@title='Remove']"));
		js.executeScript("arguments[0].click();", removeImage);
	}
	
	public void changePersonalImformation (String firsName , String lastName , String address , String phone , String zipCode , String country , String state , String city) throws InterruptedException {
		this.getProfileFirsName().clear();
		this.getProfileFirsName().sendKeys(firsName);
		
		this.getProfileLastName().clear();
		this.getProfileLastName().sendKeys(lastName);
		
		
		this.getProfileAddress().clear();
		this.getProfileAddress().sendKeys(address);
		
		
		this.getProfilePhone().clear();
		this.getProfilePhone().sendKeys(phone);
		
		this.getProfileZipCode().clear();
		this.getProfileZipCode().sendKeys(zipCode);
		
		this.getProfileCountry().selectByVisibleText(country);
		Thread.sleep(1000);
		this.getProfileState().selectByVisibleText(state);
		
		this.getProfileCity().selectByVisibleText(city);
		
		this.getSaveButton().click();
	}
	
}
