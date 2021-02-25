package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait waiter) {
		super(driver, waiter);
	}

	public List<WebElement> getSearchResult() {
		return this.driver.findElements(By.xpath("//*[@class=\"product-name\"]/a"));
	}
	
	public ArrayList<String> resultNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < this.getSearchResult().size(); i++) {
			names.add(this.getSearchResult().get(i).getText());
		}
		return names;
	}
	
	public int getNumberOfResults() {
		int numberOR = this.getSearchResult().size();
		return numberOR;
	}
	
	
}
