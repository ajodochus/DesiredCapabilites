package tests;

import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.internal.seleniumemulation.GetLocation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver; 





import pages.Helper;
import pages.HomePage;
import pages.MainContent;



public class SimpleLogin {  
    
	static RemoteWebDriver driver = new RemoteWebDriver(Helper.getDesiredCapabilities("FF_localHost_W7"));
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Helper.beforeClass(driver);						
	}
	
    
    @BeforeMethod
	public void before() {  
        driver.get(Helper.getUrlLocalhost());  
    }  
  /*
     @AfterClass public static void afterAllIsSaidAndDone() {  
         driver.quit();  
     }  
  */
   @AfterMethod
	public void after() {      
        driver.manage().deleteAllCookies();  
    }  

    @Test  
    public void testLogin() throws Exception {  
    	HomePage.waitTillLoaded(driver);    	
    	MainContent.getMainMenu_Headline(driver).compareTo("Main Menu");
    	AssertJUnit.assertEquals("Main Menu", MainContent.getMainMenu_Headline(driver));

    }


}  
