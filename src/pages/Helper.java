package pages;



import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Helper {
	
	static RemoteWebDriver	rwd = null;
	static DesiredCapabilities capability = null;
	
	public static RemoteWebDriver driver(String browserPlattform) throws Exception{		
		try {
			rwd = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getDesiredCapabilities(browserPlattform));
		} catch (Exception e) {
			System.out.println("konnte remoteWebdriver nicht aufbauen");
		}
		return rwd;
		
		
	}
	
	
	public static DesiredCapabilities getDesiredCapabilities (String environment) {	
		
		if (environment.equalsIgnoreCase("FF_LocalHost_W7")){
			capability = DesiredCapabilities.firefox();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("firefox");
			capability.setVersion("FF_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);	
			
		}
		else if (environment.equalsIgnoreCase("CHROME_LocalHost_W7")){
			
			capability = DesiredCapabilities.chrome();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("chrome");
			capability.setVersion("CHROME_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);	
			
		}
		else if (environment.equalsIgnoreCase("IE_LocalHost_W7")){
			
			capability = DesiredCapabilities.internetExplorer();
			capability.setJavascriptEnabled(true);
			capability.setBrowserName("internet explorer");
			capability.setVersion("IE_LocalHost_W7");
			capability.setPlatform(Platform.WINDOWS);	
			
			
		}
		
		
		return capability;
		
	}
	
	public static String getUrlLocalhost(){
		 String getOwnIp = null;
		  try{
			  InetAddress ownIP=InetAddress.getLocalHost();
			  getOwnIp = ownIP.getHostAddress();
			  System.out.println("IP of my system is := "+ownIP.getHostAddress());
			  }catch (Exception e){
			  System.out.println("Exception caught ="+e.getMessage());
			 
			  }
		  return "http://" + getOwnIp + "/joomla";
	}

public static void beforeClass(RemoteWebDriver driver){
	driver.manage().window().maximize();
}

	

}
