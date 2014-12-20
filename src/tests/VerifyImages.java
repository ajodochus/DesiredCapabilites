package tests;

import helper.ScreenshotCompare;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
//import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ArticleCategories;
import pages.Helper;
import pages.IndexPage;
import pages.ParkSiteList;
import pages.SingleArticle;

public class VerifyImages {
	private static RemoteWebDriver driver;
	private static String host = "http://" + Helper.getUrlLocalhost();

	@Parameters({ "browser" })
	@BeforeClass
	public static void setUpBeforeClass(String browser) throws Exception {
		if (browser.equalsIgnoreCase("android")) {
			driver = new AndroidDriver();
		} else {
			DesiredCapabilities capability = Helper
					.getDesiredCapabilities(browser);
			driver = new RemoteWebDriver(
					new URL("http://localhost:4444/wd/hub"), capability);
			driver.manage().window().maximize();
		}
	}

	@BeforeMethod
	public void before() {
		driver.get(host);
		IndexPage indexPage = new IndexPage(driver);
		indexPage.gotoArticleCategories();
		ArticleCategories articleCategories = new ArticleCategories(driver);
		articleCategories.gotoParkSite();
		
	}

	@AfterClass
	public static void afterAllIsSaidAndDone() {
		driver.quit();
	}

	@AfterMethod
	public void after() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void verifyImageSeamc() throws IOException {
		
		//SingleArticle singleArticle = new SingleArticle(driver);
		//singleArticle.takeScreenshotOfBanner();
		ParkSiteList parkSiteList = new ParkSiteList(driver);
		parkSiteList.takeScreenshot("seamc");
		ScreenshotCompare imageCompare = new ScreenshotCompare();
		AssertJUnit.assertEquals("match screenshot", imageCompare.useExample("seamc"));
		//
		
	}
	@Test
	public void verifyImageSeahorse() throws IOException{
		ParkSiteList parkSiteList = new ParkSiteList(driver);
		parkSiteList.takeScreenshot("seahorse");
		ScreenshotCompare imageCompare = new ScreenshotCompare();
		AssertJUnit.assertEquals("match screenshot", imageCompare.useExample("seahorse"));
	}
}