package tests;

import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver; 

import pages.UserLoginLandingPage;
import pages.LoginPage;
import pages.Helper;


public class UserLoginTests {  
    

	private static RemoteWebDriver driver;
    private  static String host = Helper.getUrlLocalhost() + "/index.php/login";  
   
    
    //
    // Setup
    //
    
    @BeforeMethod
    public void beforeMethod() {  
         driver.get(host);  
     }  
   
    @AfterClass 
    public static void afterClass() {  
         driver.quit();  
      }  
   
    @AfterMethod
    public void afterMethod() {      
         driver.manage().deleteAllCookies();  
    } 
    
    
   // ToDo
    // parallel testing
    // datadriven testing (Excel)
    // email on end
    
    
   // 
   // Login Tests
   //
    
   @Test  
   public void testFailedLogin() throws Exception {  
 
       LoginPage.waitTillLoaded(driver);
       LoginPage.loginAsUserX("admin", "Wrong password", driver);
       LoginPage.errorMessageOnFailedLogout("Username and password do not match or you do not have an account yet.", driver);         
   }  
    
   @Test  
   public void testLogin() throws Exception {  
    	LoginPage.waitTillLoaded(driver);
        LoginPage.loginAsUserX("admin", "admin", driver);
        UserLoginLandingPage.waitTillLoaded(driver);
        AssertJUnit.assertEquals("Basic Settings",UserLoginLandingPage.getHomePageWelcomeMessage(driver));       
    }  	         
     
   @Test
   public void testLogoutViaLink () throws Exception {
    	LoginPage.waitTillLoaded(driver);
        LoginPage.loginAsUserX("admin", "admin", driver);
    	UserLoginLandingPage.waitTillLoaded(driver);
    	UserLoginLandingPage.logoutViaButton(driver);
    	LoginPage.waitTillLoaded(driver);         	
    }
  
   @Parameters({"browser"})
   @BeforeClass
   public static void setUpBeforeClass(String browser) throws Exception {
		if (browser.equalsIgnoreCase("android")){
			driver = new AndroidDriver();	
		} else {
			DesiredCapabilities capability = Helper.getDesiredCapabilities(browser);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);	
			driver.manage().window().maximize();
		}					
	}
	
   
 

}  
