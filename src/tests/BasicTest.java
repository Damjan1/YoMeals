package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;
import pages.SearchResultPage;

public abstract class BasicTest {

	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected LocationPopupPage lpp;
	protected ProfilePage pp;
	protected LoginPage lp;
	protected AuthPage ap;
	protected CartSummaryPage csp;
	protected MealPage mp;
	protected NotificationSistemPage nsp;
	protected SearchResultPage srp;
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String ussername = "customer@dummyid.com";
	protected String password = "12345678a";
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"driver_lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		
		this.lpp = new LocationPopupPage(driver, waiter , js);
		this.pp = new ProfilePage(driver, waiter , js);
		this.lp = new LoginPage(driver, waiter , js);
		this.ap = new AuthPage(driver, waiter , js);
		this.csp = new CartSummaryPage(driver, waiter , js);
		this.mp = new MealPage(driver, waiter , js);
		this.nsp = new NotificationSistemPage(driver, waiter , js);
		this.srp = new SearchResultPage(driver, waiter , js);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
	}
	                                        
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileHandler.copy(scrFile, new File("screenshots"));
//			System.out.println("Neuspesan Test");
//		} else {
//			System.out.println("Uspesan Test!");
//		}
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public void quit() {
		this.driver.quit();
	}
}
