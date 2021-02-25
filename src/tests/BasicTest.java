package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import pages.LocationPopupPage;
import pages.LoginPage;
import pages.ProfilePage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected LocationPopupPage lpp;
	protected ProfilePage pp;
	protected LoginPage lp;
	
	protected String baseUrl;
	
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"driver_lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.lpp = new LocationPopupPage(driver, waiter);
		this.pp = new ProfilePage(driver, waiter);
		this.lp = new LoginPage(driver, waiter);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		this.baseUrl = new String("http://demo.yo-meals.com");
		this.driver.navigate().to(baseUrl);
	
	}
	
}
