package pages;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.awt.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WeblinkPage {

	private final WebDriver driver;
	
	public WeblinkPage(WebDriver driver){
		super();
		this.driver = driver;
	}
	
	
	public static void waitTillLoaded (WebDriver driver){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("dead Weblink"));
	}
	
	// checking links on "http://docs.seleniumhq.org/download"
	//driver.navigate().to("http://docs.seleniumhq.org/download");

	// The "A" tag is a hyperlink tag need to find all these tags on page
	public static void checkForDeadLinks(WebDriver driver){
		
		java.util.List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
	}
}
