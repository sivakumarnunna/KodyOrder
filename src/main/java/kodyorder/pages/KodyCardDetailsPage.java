package kodyorder.pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KodyCardDetailsPage extends BasePage {

	public By KODYCARD_EMAIL = By.xpath(LOCATORS.getProperty("kodycard_email"));
	public By CARD_NUMBER = By.name(LOCATORS.getProperty("card_number"));
	public By EXP_DATE = By.name(LOCATORS.getProperty("exp_date"));
	public By CVV_NUMBER = By.id(LOCATORS.getProperty("cvv_number"));
	public By CARD_SUBMIT_BUTTON = By.xpath(LOCATORS.getProperty("card_submit_button"));

	
	public void enterEmail(String email) {

		EnterText(KODYCARD_EMAIL, email);

	}
	public void payByCard(String ccnumber) throws InterruptedException {

		driver.switchTo().frame("checkout-frames-form");
		EnterText(CARD_NUMBER, ccnumber);
		EnterText(EXP_DATE, "01/99");
		EnterTextWithOutClear(CVV_NUMBER, "100");
		driver.switchTo().defaultContent();
		click(CARD_SUBMIT_BUTTON);
	}
	public void order_should_be_placed_successfully() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains("order-confirmed"));
		Assert.assertEquals(driver.getCurrentUrl().contains("order-confirmed"), true);

	}


}
