package kodyorder.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class WebDriverUtils {

	public static Logger logger = LogManager.getLogger(WebDriverUtils.class);

	public static WebDriver driver = null;
	// public static String BASE_URL;

	static {

		switch (ApplicationConstants.BROWSER_TYPE) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",ApplicationConstants.DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "msedge":
			System.setProperty("webdriver.edge.driver", "Driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("No driver found");

			break;
		}

		logger.info("Browser is :: " + ApplicationConstants.BROWSER_TYPE);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public void EnterText(By by, String text) {
	
			// Thread.sleep(1000);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(text);
			//return true;
		
	}

	public void EnterTextWithOutClear(By by, String text) throws InterruptedException {
		
			Thread.sleep(1000);
			driver.findElement(by).sendKeys(text);
		
	}

	public void click(By by) throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(by).click();
	}

	public boolean isElementExists(By by) {

		try {
			for(int i=0;i<30;i++) {
				
			Thread.sleep(1000);
			if (driver.findElements(by).size() > 0) {
				return true;
			}
		} 
		}
			catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}
	
	public String getElementDisplayName(By by) {

		try {
			Thread.sleep(1000);
			
			return driver.findElement(by).getText();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "No text is dispaying for the element in UI";
	}
	
	
	public boolean compareImage(String image) throws IOException {
		
		BufferedImage act_image = ImageIO.read(new File(ApplicationConstants.ACTUAL_SCREENSHOTS_PATH+"/"+image));
		BufferedImage exp_image = ImageIO.read(new File(ApplicationConstants.SOT_SCREENSHOTS_PATH+"/"+image));
		ImageDiffer imd = new ImageDiffer();
		ImageDiff diff = imd.makeDiff(act_image, exp_image);
	    BufferedImage diffImage = diff.getDiffImage();
	    if(diff.getDiffSize() > 0) {
	    ImageIO.write(diffImage, "PNG", new File(ApplicationConstants.ERROR_SCREENSHOTS_PATH+"/"+image));
	    }
		Assert.assertFalse(diff.hasDiff(), "Images are same");

		return false;
		
	}
	public void takeScreenShot(String filename) throws IOException {
		  TakesScreenshot scrShot =((TakesScreenshot)driver); 
		  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE); 
		  File DestFile=new File(ApplicationConstants.ACTUAL_SCREENSHOTS_PATH+"/"+filename);
		  FileUtils.copyFile(SrcFile, DestFile);

	}
	
	public void validateScreenShots(String sotfileimage,String actualimage) {
		
	}
	
	public void scrollToDisplayElement(By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(element));

	}
	
}
