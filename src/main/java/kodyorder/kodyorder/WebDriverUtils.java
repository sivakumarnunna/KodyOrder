package kodyorder.kodyorder;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverUtils {
	

	
	public static  Logger logger = LogManager.getLogger(WebDriverUtils.class);

	
	public static WebDriver driver = null;
	//public static String BASE_URL;
	
	static {
		
		switch (ApplicationConstants.BROWSER_TYPE) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");	
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
		
		logger.info("Browser is :: "+ApplicationConstants.BROWSER_TYPE);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	

	public boolean EnterText( By by,String text) {
		try {
			//Thread.sleep(1000);
			driver.findElement(by).clear(); 
			driver.findElement(by).sendKeys(text); 
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean EnterTextWithOutClear( By by,String text) {
		try {
			Thread.sleep(1000);
			driver.findElement(by).sendKeys(text); 
			return true;
		}
		catch(Exception e) {
		}
		return false;
	}
	
	
	public boolean click( By by) {
		try {
			Thread.sleep(1000);
			driver.findElement(by).click();

			return true;
		}
		catch(Exception e) {
		}
		return false;
	}
	
	


	
	

}
