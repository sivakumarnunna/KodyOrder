package kodyorder.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import kodyorder.utils.WebDriverUtils;


public class BasePage extends WebDriverUtils{
	
	static Properties LOCATORS = new Properties();
	static Logger logger = LogManager.getLogger(BasePage.class);
	
	public By KODYPAY_APPLY_BUTTON = By.xpath(LOCATORS.getProperty("kodypay_apply_discount_button"));


	static {
	try {
		LOCATORS.load(new FileInputStream("src/test/resources/properties/elementlocators.properties"));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

}
	
}
