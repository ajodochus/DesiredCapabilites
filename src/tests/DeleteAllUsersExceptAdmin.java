package tests;

import java.net.URL;

import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Helper;
import pages.admin.AdminHomePage;
import pages.admin.AdminLoginPage;
import pages.admin.AdminUserManagerPage;

public class DeleteAllUsersExceptAdmin {
	private static RemoteWebDriver driver;
    private  static String host = "http://" + Helper.getUrlLocalhost() + "/administrator/index.php";  
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
   public void testDeleteAllUsersWithoutAdmin(){
	   AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
	   AdminHomePage homePageAdminPage = adminLoginPage.loginAsAdmin("admin", "admin"); 
	   AdminUserManagerPage adminUserManagerPage = homePageAdminPage.linkToUserAccounts();
	   adminUserManagerPage.checkAll();
	   adminUserManagerPage.checkAdmin();
	   adminUserManagerPage.deleteUser();
   }
   

   
}
