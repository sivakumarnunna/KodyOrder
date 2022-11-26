package kodyorder.kodyorder;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kodyorder.pages.CheckOutPage;
import kodyorder.pages.KodyCardDetailsPage;
import kodyorder.pages.MenuPage;
import kodyorder.utils.ApplicationConstants;
import kodyorder.utils.KodypayUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KodyorderTest extends KodypayUtils {
	
	MenuPage menupage = new MenuPage();
	CheckOutPage checkoutpage = new CheckOutPage();
	KodyCardDetailsPage kodycarddetailspage= new KodyCardDetailsPage();

	@When("I open the kodyorder URL {string}")
	public void i_opne_kodyorder_url(String url) {
		driver.get(url);
		logger.info("*********opened the kody order page "+url +"**********");
	}

	@Then("validate store name {string}")
	public void validate_storename(String storename) throws IOException {
		Assert.assertEquals(isElementExists(menupage.STORE_NAME), true);
		Assert.assertEquals(getElementDisplayName(menupage.STORE_NAME), storename);
		logger.info("*********verified the storename "+storename +"**********");
	}

	@Then("validate the screen {string}")
	public void validate_screen(String screenname) throws IOException {
		takeScreenShot(screenname);
		compareImage(screenname);
		logger.info("*********verified the screenshot for page :  "+screenname +"**********");
	}

	@Then("validate category names {string}")
	public void validate_category_names(String categories) {
		Assert.assertEquals(isElementExists(menupage.KODY_MENU_CATEGORIES),true);
		Assert.assertEquals(getElementDisplayName(menupage.KODY_MENU_CATEGORIES).replaceAll("\n", ","),categories);
		logger.info("*********verified the categories present in the store :  "+categories +"**********");
	}

	@When("I selected the category {string}")
	public void i_selected_the_category(String category) throws InterruptedException {
		menupage.selectCategory(category);
		logger.info("*********Selected the category :  "+category +"**********");
	}

	@When("I selected the menu item {string}")
	public void i_selected_the_menu_item(String menuitem) throws InterruptedException {
		menupage.selectMenuItem(menuitem);
		isElementExists(menupage.ION_CHIP_IMAGE);
		logger.info("*********Selected the menu item :  "+menuitem +"**********");
	}
	
	@When("I selected the addon {string}")
	public void i_selected_the_addon(String addon) throws InterruptedException {
		menupage.selectAddon(addon);
		logger.info("*********Selected the addon :  "+addon +"**********");
	}
	
	
	
	//I selected the addon
	

	@When("Click on checkout")
	public void click_on_checkout() throws InterruptedException {
		click(menupage.CHECKOUT_BUTTON);
		logger.info("*********clicked on checkout button in menu page**********");
		Assert.assertEquals(isElementExists(checkoutpage.CHECKOUT_PAGE_TITLE), true);
		Thread.sleep(3000);
		logger.info("*********checkout page opened successfully**********");
	}

	@When("I click discount button")
	public void click_discount_button() throws InterruptedException, AWTException {
		checkoutpage.openDiscountPage();
	}

	@When("applied the discount code {string}")
	public void apply_discount_code(String code) throws InterruptedException, AWTException {
		checkoutpage.applyDiscountCode(code);
	}

	@When("click on paybycard")
	public void click_pay_by_card() throws InterruptedException, AWTException {
		checkoutpage.openPaymentPage();
	}

	@When("I enter email {string}")
	public void enter_email_id(String email) {
		kodycarddetailspage.enterEmail(email);
	}

	@When("pay the Amount By using card {string}")
	public void pay_the_amount_by_using_card(String ccnumber) throws InterruptedException {
		kodycarddetailspage.payByCard(ccnumber);
	}

	@Then("order should be placed successfully")
	public void order_should_be_placed_successfully() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains("order-confirmed"));
		Assert.assertEquals(driver.getCurrentUrl().contains("order-confirmed"), true);
	}

	
	

}
