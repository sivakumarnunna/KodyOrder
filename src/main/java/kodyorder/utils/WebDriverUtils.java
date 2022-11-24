package kodyorder.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

	public boolean EnterTextWithOutClear(By by, String text) {
		try {
			Thread.sleep(1000);
			driver.findElement(by).sendKeys(text);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public boolean click(By by) {
		try {
			Thread.sleep(1000);
			driver.findElement(by).click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	public boolean isElementExists(By by) {

		try {
			for(int i=0;i<10;i++) {
				
			Thread.sleep(1000);
			if (driver.findElements(by).size() > 0) {
				logger.info(by + " web element present");
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
	
	
	public boolean compareImage(String actualimage,String expectedimage) throws IOException {
		
		File actual_image_file  = new File(actualimage);
		File exp_image_file  = new File(expectedimage);

		
		BufferedImage act_image = ImageIO.read(actual_image_file);
		BufferedImage exp_image = ImageIO.read(exp_image_file);
		
		ImageDiffer imd = new ImageDiffer();
		
		ImageDiff diff = imd.makeDiff(act_image, exp_image);
		diff.getMarkedImage();
	    BufferedImage diffImage = diff.getDiffImage();
	    ImageIO.write(diffImage, "PNG", new File(System.getProperty("src\\test\\resources\\properties\\diffImage.png")));

		Assert.assertFalse(diff.hasDiff(), "Images are same");

		return false;
		
	}

}
