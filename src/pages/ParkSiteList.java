package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ParkSiteList {
	WebElement WEpicture;
	WebElement WEwaitForPic;
	
	private final WebDriver driver;

	public ParkSiteList(WebDriver driver) {
		super();
		this.driver = driver;
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);
		//
		//
		// bitte noch auf ein allgemeingültiges Element ändern
		//
		WEwaitForPic = driver.findElement(By.xpath(".//*[@alt='seamc']"));
		wait.until(ExpectedConditions.visibilityOf(WEwaitForPic));
	}

	public void takeScreenshot(String pic) throws IOException {
	//	WebElement element = driver.findElement(By.xpath(".//*[@alt='Cradle Park Banner']"));
		WEpicture = driver.findElement(By.xpath(".//*[@alt='" + pic + "']"));
		helper.Screenshot screenshot = new helper.Screenshot(driver);
		screenshot.shoot(WEpicture, pic);
	}

}