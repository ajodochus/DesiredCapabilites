package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ArticleCategories {

	/*
	 * private final static Logger logger = LoggerFactory
	 * .getLogger(HomePage.class);
	 */

	private final WebDriver driver;
	public WebElement parkSite;
	public ArticleCategories(WebDriver driver) {
		super();
		this.driver = driver;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		 parkSite = driver.findElement(By.xpath(".//*[@id='content']/div[2]/div[2]/h3/a[contains(text(), 'Park Site')]"));
		wait.until(ExpectedConditions.visibilityOf(parkSite));
		

	}
	

	public void gotoParkSite() {
		parkSite.click();
	}	


}
