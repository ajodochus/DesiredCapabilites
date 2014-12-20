package helper;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;

public class Screenshot {
	private final String screenshotFolder = "D:\\Selenium\\toolsAndStuff\\imagecompare\\";
	protected WebDriver driver;

	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public void shoot(WebElement element, String imageName) throws IOException {
		try {
			driver = new Augmenter().augment(driver);
			
		} catch (Exception ignored) {
			
		}
		
		File screen = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		Point p = element.getLocation();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		Rectangle rect = new Rectangle(width, height);
		BufferedImage img = null;
		img = ImageIO.read(screen);
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,rect.height);
		ImageIO.write(dest, "jpg", screen);
		try{
		//FileUtils.copyFile(screen,new File(screenshotFolder + System.nanoTime() + ".jpg"));
		FileUtils.copyFile(screen,new File(screenshotFolder + imageName + "_screenshot.jpg"));
		}catch (Exception ignored){
			//
		}
	}
	
	
}
