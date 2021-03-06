package modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ModAllFrontEndViews {

	/*
	 * private final static Logger logger = LoggerFactory
	 * .getLogger(HomePage.class);
	 */

	private final WebDriver driver;

	public ModAllFrontEndViews(WebDriver driver) {
		super();
		this.driver = driver;

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("Single Article"));
		WebElement moduleCategory = driver.findElement(By.xpath(".//*[@id='AllFrontEndViews']"));
		wait.until(ExpectedConditions.visibilityOf(moduleCategory));

	}
	

	
	public void takeScreenshotOfBanner() throws IOException {
		// Find the text input element by its name

		WebElement element = driver.findElement(By.xpath(".//*[@alt='Cradle Park Banner']"));
		String imageName = "banner";
		// takescreenshot of element
		helper.Screenshot screenshot = new helper.Screenshot(driver);
		screenshot.shoot(element, imageName);


	}

}
