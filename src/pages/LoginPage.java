package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {



	public LoginPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getUsername() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getRememberMeCheckBox() {
		return this.driver.findElement(By.name("remember_me"));
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void login (String userName , String password) throws InterruptedException {
		this.getUsername().click();
		this.getUsername().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getUsername().sendKeys(userName);
		Thread.sleep(1500);
		this.getPassword().click();
		this.getPassword().sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		this.getPassword().sendKeys(password);
		this.getLoginButton().click();
	}
	
}
