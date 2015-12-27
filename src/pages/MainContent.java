package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MainContent {

	/*
	 * private final static Logger logger = LoggerFactory
	 * .getLogger(HomePage.class);
	 */

	private final WebDriver driver;
	
	public MainContent(WebDriver driver){
		super();
		this.driver = driver;
	}
	

	
	public static String getMainMenu_Headline(WebDriver driver) throws Exception {

		//return driver.findElement(By.className("page-header")).getAttribute("href");
		return driver.findElement(By.xpath("//div[@id='asideSidebar']/div/H3")).getText();
		
	}
}
