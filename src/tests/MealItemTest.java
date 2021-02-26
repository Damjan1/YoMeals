package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	@Test (priority = 15)
	public void addMealToChartTest() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		this.lpp.getCloseBtn().click();
		this.mp.addMealToCart("10");
		Thread.sleep(2000);
		String message = this.nsp.message();
		sa.assertTrue(message.contains("The Following Errors Occurred:"), "[ERROR] Message didn't apear]");
		sa.assertTrue(message.contains("Please Select Location"), "[ERROR] message didn't apear]");
		
		this.nsp.waitMessageToDisapire();
		this.lpp.openPopup();
		this.lpp.SetLocation("City Center - Albany");
		Thread.sleep(2000);
		this.mp.addToCartButton().click();
		Thread.sleep(2000);
		sa.assertEquals(this.nsp.message(), "Meal Added To Cart" , "[ERROR] Add to kart didn't hapend");
	}
	
	@Test (priority = 20)
	public void addMealToFavorite() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		this.lpp.getCloseBtn().click();
		Thread.sleep(2000);
		this.mp.getAddToFavorite().click();
		String message = this.nsp.message();
		sa.assertTrue(message.contains("Please login first!"), "[ERROR] Message didn't apear]");
		this.nsp.waitMessageToDisapire();
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");
		this.lp.login(this.ussername, this.password);
		this.driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		Thread.sleep(2000);
		this.mp.getAddToFavorite().click();
		sa.assertTrue(message.contains( "Product has been added to your favorites."), "[ERROR] Message didn't apear]");
	}
	
	@Test (priority = 25)
	public void clearCart () throws IOException {
		SoftAssert sa = new SoftAssert();
		this.driver.navigate().to(baseUrl + "/meals");
		this.lpp.SetLocation("City Center - Albany");
		File file = new File("data/Data.xlsx");
		FileInputStream fos = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fos);
		XSSFSheet sheet = wb.getSheet("Meals");
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);

			String mealUrl = row.getCell(0).getStringCellValue();
			String quantity = NumberToTextConverter.toText(row.getCell(1).getNumericCellValue());

			this.driver.navigate().to(mealUrl);
			this.mp.addMealToCart(quantity);
			sa.assertEquals(this.nsp.message(), "Meal Added To Cart" , "[ERROR] Add to kart didn't hapend");
			
		}
		
		this.nsp.waitMessageToDisapire();
		this.csp.ClearChart();
		sa.assertEquals(this.nsp.message(), "All meals removed from Cart successfully" , "[ERROR] Clear cart didd't hapend");
		
	}
	
}
