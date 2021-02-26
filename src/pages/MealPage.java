package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	
	
	public MealPage(WebDriver driver, WebDriverWait waiter, JavascriptExecutor js) {
		super(driver, waiter, js);
	}

	public WebElement getMealPage() {
		return this.driver.findElement(By.linkText("Meals"));
	}
	
	public WebElement getMealSearch() {
		return this.driver.findElement(By.name("keywords"));
	}

	public WebElement getRemoveButton() {
		return this.driver.findElement(By.linkText("Reset All"));
	}
	
	public Select getSortBy () {
		WebElement sort = this.driver.findElement(By.xpath("//*[@class=\"sort-toggle is-active\"]/a"));
		Select sortBy = new Select(sort);
		return sortBy;
	}
	
	public WebElement getFilters() {
		return this.driver.findElement(By.xpath("//*[contains(@class, \"filter-switch\"]"));
	}
	
	public Select selectChef() {
		WebElement chef = this.driver.findElement(By.name("filter-switch"));
		Select selctChef = new Select(chef);
		return selctChef;
	}
	
	public WebElement getMinPrice() {
		return this.driver.findElement(By.name("priceFilterMinValue"));
	}
	
	public WebElement getMaxPrice() {
		return this.driver.findElement(By.name("priceFilterMaxValue"));
	}
	
	public WebElement getResetPrice() {
		return this.driver.findElement(By.linkText("Reset Price"));
	}
	
	public WebElement getType(String type) {
		WebElement foodType = driver.findElement(By.xpath("//*[@veg-name='" + type + "']"));
		return foodType;
	}
	
	public WebElement resetType() {
		return driver.findElement(By.linkText("Reset Type"));
	}
	
	public WebElement getMealType(String mealType) {
		WebElement meal = driver.findElement(By.xpath("//*[@meal-name='" + mealType + "']"));
		return meal;
	}
	
	public WebElement resetMealType() {
		return driver.findElement(By.linkText("Reset Meal Type"));
	}
	
	public WebElement getCouisineType(String cuisineType) {
		WebElement typeCuisine = driver.findElement(By.xpath("//*[@cuisine-name='" + cuisineType + "']"));
		return typeCuisine;
	}

	public WebElement resetCuisineType() {
		return driver.findElement(By.linkText("Resest Cuisine Type"));
	}
	
	public WebElement addProduct (String mealName) {
		return this.driver.findElement(By.linkText(mealName + "..."));
	}
	public WebElement getAddToFavorite () {
		return this.driver.findElement(By.xpath("//*[@title=\"Favorite\"]"));
	}
	
	public WebElement addToCartButton() {
		return driver.findElement(By.linkText("Add To Cart"));
	}
	
	public void addMealToCart(String quantity) {
		WebElement quan = this.driver.findElement(By.name("product_qty"));
		quan.click();
		quan.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		quan.sendKeys(quantity);
		this.addToCartButton().click();
	}
}
