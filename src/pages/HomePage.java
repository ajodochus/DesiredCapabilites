package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePage {

	private final WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("Home"));
		
	}


	public void gotoArticleCategories() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, SECONDS).pollingEvery(2, SECONDS);
		WebElement moduleCategory = driver.findElement(By.xpath(".//*[@id='AllFrontEndViews']"));
		wait.until(ExpectedConditions.visibilityOf(moduleCategory));
		 driver.findElement(By.xpath(".//*[@id='AllFrontEndViews']/*/a[contains(text(),'Article Categories')]")).click();
			
	}
	public static void waitTillLoaded(WebDriver driver){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, SECONDS).pollingEvery(2, SECONDS);
		wait.until(ExpectedConditions.titleIs("Home"));
	}



	public String getErrorMessage() {

		return driver.findElement(By.xpath(".//*[@id='system-message']/div/div/p")).getText();
	}



}