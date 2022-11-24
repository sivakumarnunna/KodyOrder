package kodyorder.kodyorder;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;
public class KodyorderTest extends KodypayUtils{
	
	
 
  public void kodyorder() throws InterruptedException, AWTException {

    driver.get(ApplicationConstants.BASE_URL);
    
    
    click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]"));
    driver.findElement(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]")).click();

    click(By.xpath("//kody-menu-item[1]//ion-item//ion-label"));

    click(By.xpath("//kody-menu-item[2]/ion-item/ion-label"));

    click(By.xpath("//kody-menu-checkout-button/ion-fab-button/img"));

    click(By.xpath("//kodypay-payment-page-footer/ion-footer/ion-toolbar/p/a"));
    
    EnterText(By.xpath("//kody-card-details-form/form/div[1]/ion-input/input"), "siva.nunna@kodypay.com");
    
    driver.switchTo().frame("checkout-frames-form");
    
    EnterText(By.name("cardnumber"), "4485040371536584");
    EnterText(By.name("exp-date"), "01/99");
    EnterTextWithOutClear(By.id("checkout-frames-cvv"), "100");
   
    driver.switchTo().defaultContent();
    click(By.xpath("//kody-pay-by-card-btn/ion-button"));
    driver.close();
    
  }
  
  
  @When("I selected the food")
  public void i_selected_the_food() {
	    
	    
	    click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]"));
	    click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]"));

	    click(By.xpath("//kody-menu-item[1]//ion-item//ion-label"));

	    click(By.xpath("//kody-menu-item[2]/ion-item/ion-label"));

  }
  
  @When("I selected the menu item {string}")
  public void i_selected_the_menu_item(String menuitem) {
	    
	    //click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]"));

	   // click(By.xpath("//h2[normalize-space()='"+menuitem+"']"));
	  selectMenuItem(menuitem);


  }
  
  @When("I selected the category {string}")
  public void i_selected_the_category(String category) {
	    
	  selectCategory(category);


  }
  
  
  @When("I open the kodyorder URL {string}")
  public void i_opne_kodyorder_url(String url) {
	  	  driver.get(url);

  }
  @Then("validate store name {string}")
  public void validate_storename(String storename) {
	  
	  
	  Assert.assertEquals(isElementExists(By.xpath("//*[@id='menu-header']/ion-toolbar/div")),true);	  
	  Assert.assertEquals(getElementDisplayName(By.xpath("//*[@id='menu-header']/ion-toolbar/div")), "SIVA HOTEL");

  }
  
  @Then("validate category names {string}")
  public void validate_category_names(String storename) {
	  
	  Assert.assertEquals(isElementExists(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories")),true);	
	    Assert.assertEquals(getElementDisplayName(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories")).replaceAll("\n", ","), "Biryani,Soups,Curries");

  }
  

  @When("Click on checkout")
  public void click_on_checkout() throws InterruptedException {

	    click(By.xpath("//kody-menu-checkout-button/ion-fab-button/img"));
		  Assert.assertEquals(isElementExists(By.xpath("//ion-header/ion-toolbar/ion-title/span")),true);	
	    Assert.assertEquals(driver.findElement(By.xpath("//ion-header/ion-toolbar/ion-title/span")).getText(),"Checkout");
  
  }
  
  @When("applied the discount code {string}")
  public void apply_discount_code(String code) throws InterruptedException {

		// apply discount code
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView();", driver
		 * .findElement(By.xpath(
		 * "//kody-payment-discount/ion-item/kodypay-payment-list-button/ion-button")));
		 * 
		 * click(By.xpath(
		 * "//kody-payment-discount/ion-item/kodypay-payment-list-button/ion-button"));
		 * Assert.assertEquals( isElementExists(By.xpath(
		 * "//kody-discount-modal/kody-shared-ui-modal/div/div/form/ion-input")), true);
		 * Thread.sleep(5000); EnterText(By.xpath(
		 * "//kody-discount-modal/kody-shared-ui-modal/div/div/form/ion-input"), code);
		 * click(By.xpath("//kody-shared-ui-modal/ion-footer/div/ion-button"));
		 */
	   //enter the order notes
	   // click(By.xpath("//kodypay-payment-order-notes/ion-item/kodypay-payment-list-button/ion-button"));
	   // EnterText(By.xpath("//kody-order-notes-modal/kody-shared-ui-modal/div/div/ion-textarea"),"test automation");  
	 //   click(By.xpath("//kody-shared-ui-modal/ion-footer/div/ion-button"));
	  //kodypay-payment-order-notes

	    click(By.xpath("//kodypay-payment-page-footer/ion-footer/ion-toolbar/p/a"));
	    Thread.sleep(5000);

	    EnterText(By.xpath("//kody-card-details-form/form/div[1]/ion-input/input"), "siva.nunna@kodypay.com");  }


  @When("pay the Amount By using card {string}")
  public void pay_the_amount_by_using_card(String ccnumber) {
	  driver.switchTo().frame("checkout-frames-form");
	    
	    EnterText(By.name("cardnumber"), ccnumber);
	    EnterText(By.name("exp-date"), "01/99");
	    EnterTextWithOutClear(By.id("checkout-frames-cvv"), "100");
  }

  @Then("order should be placed successfully.")
  public void order_should_be_placed_successfully() throws InterruptedException {
	  driver.switchTo().defaultContent();
	    click(By.xpath("//kody-pay-by-card-btn/ion-button"));
	  
	   
	    Thread.sleep(10000);
	    System.out.println("Current URL is "+driver.getCurrentUrl());
     Assert.assertEquals(driver.getCurrentUrl().contains("order-confirmed"),true);

      driver.close();
  }
	
	  @Test 
	  public void test123() throws InterruptedException, IOException {
	  driver.get("https://pay-staging.kodypay.com/store/945e1c8c-0258-42d6-a850-2026c9507945/table?table=1"); 
	  TakesScreenshot scrShot =((TakesScreenshot)driver); 
	  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new
	  File("src\\test\\resources\\properties\\kodyorderscreen1.png");
	  
	  //Copy file at destination
	  
	  FileUtils.copyFile(SrcFile, DestFile);
	  compareImage("src\\test\\resources\\properties\\kodyorderscreen.png","src\\test\\resources\\properties\\kodyorderscreen1.png");
	  
	  
	  
	  }
	 
  

  
}
