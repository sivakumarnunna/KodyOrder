package kodyorder.pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BasePage {

	public By CHECKOUT_PAGE_TITLE = By.xpath(LOCATORS.getProperty("checkout_page_title"));
	public By KODYPAY_DISCOUNT_BUTTON = By.xpath(LOCATORS.getProperty("kodypay_discount_button"));
	public By KODYPAY_DISCOUNT_TEXTFIELD = By.xpath(LOCATORS.getProperty("kodypay_discount_textfield"));
	public By PAY_BY_CARD_LINK = By.xpath(LOCATORS.getProperty("pay_by_card_link"));


	public void openDiscountPage() throws InterruptedException {

		scrollToDisplayElement(KODYPAY_DISCOUNT_BUTTON);
		click(KODYPAY_DISCOUNT_BUTTON);
		logger.info("*********Opened the discount page**********");
	}
	
	public void applyDiscountCode(String code) throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(KODYPAY_DISCOUNT_TEXTFIELD));
		EnterTextWithOutClear(KODYPAY_DISCOUNT_TEXTFIELD,code);
		click(KODYPAY_APPLY_BUTTON);
		scrollToDisplayElement(CHECKOUT_PAGE_TITLE);
		Thread.sleep(3000);
	}
	
	public void openPaymentPage() throws InterruptedException, AWTException {
		click(PAY_BY_CARD_LINK);
		Thread.sleep(5000);

	}

}
