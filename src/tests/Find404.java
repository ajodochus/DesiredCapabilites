package tests;

import java.awt.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Helper;

public class Find404 {

	private static RemoteWebDriver driver;
    private  static String host = "http://" + Helper.getUrlLocalhost() + "/index.php";  
    
    
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
    
    @Test
    public void checkForDeadLinks(){
    	
    }
    	

    	
  
    
}



