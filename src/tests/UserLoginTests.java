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

import pages.HomePage;
import pages.LoginPage;
import pages.Helper;


public class UserLoginTests {  
    
 
	private static RemoteWebDriver driver;
    private  static String host = "http://" + Helper.getUrlLocalhost() + "/index.php/login";  
    
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
	
    
    @BeforeMethod
	public void before() {  
        driver.get(host);  
    }  
  
     @AfterClass public static void afterAllIsSaidAndDone() {  
         driver.quit();  
     }  
  
   @AfterMethod
	public void after() {      
        driver.manage().deleteAllCookies();  
    }  
  

  
    @Test  
    public void testLogin() throws Exception {  
    	LoginPage.waitTillLoaded(driver);
        LoginPage.loginAsUserX("admin", "admin", driver);
        HomePage.waitTillLoaded(driver);
        AssertJUnit.assertEquals("Basic Settings",HomePage.getHomePageWelcomeMessage(driver));  
  
    }  	
  
    @Test  
    public void testFailedLogin() throws Exception {  
  
        LoginPage loginPage = new LoginPage(driver);  
        loginPage.failLoginAs("nobody", "WRONG");  
        AssertJUnit.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match or you do not have an account yet."));  
    }  
    
    @Test
    public void testLogoutViaLink () throws Exception {
    	LoginPage loginPage = new LoginPage(driver);  
        HomePage homePage = loginPage.loginAs("admin", "admin");  
        //AssertJUnit.assertEquals("Basic Settings",homePage.getHomePageWelcomeMessage());
        LoginPage loginPageLoggedOut = homePage.executeLogout();
        AssertJUnit.assertEquals("User Name *", loginPageLoggedOut.getLoginPageTitle());
       
          	
    }

    
    

}  
