package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SingleArticle {

	/*
	 * private final static Logger logger = LoggerFactory
	 * .getLogger(HomePage.class);
	 */

	private final WebDriver driver;

	public SingleArticle(WebDriver driver) {
		super();
		this.driver = driver;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("Single Article"));

	}
	

	
	public void takeScreenshotOfBanner() throws IOException {
		WebElement element = driver.findElement(By.xpath(".//*[@alt='Cradle Park Banner']"));
		String imageName = "banner";
		helper.Screenshot screenshot = new helper.Screenshot(driver);
		screenshot.shoot(element, imageName);
	}

}
