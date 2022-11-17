package kodyorder.kodyorder;

import java.awt.AWTException;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
public class KodyorderTest extends WebDriverUtils{
	
	
 
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
	  driver.get(ApplicationConstants.BASE_URL);
	    
	    
	    click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]"));
	    driver.findElement(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[1]")).click();

	    click(By.xpath("//kody-menu-item[1]//ion-item//ion-label"));

	    click(By.xpath("//kody-menu-item[2]/ion-item/ion-label"));

  }

  @When("Click on checkout")
  public void click_on_checkout() throws InterruptedException {

	    click(By.xpath("//kody-menu-checkout-button/ion-fab-button/img"));
	    
	    
	    
	    click(By.xpath("//kody-payment-discount/ion-item/kodypay-payment-list-button/ion-button"));
	    Thread.sleep(5000);
	    EnterText(By.xpath("//kody-shared-ui-modal/div/div/form/ion-input/input"),"12345");  
	    click(By.xpath("//kody-shared-ui-modal/ion-footer/div/ion-button"));
	    ////kody-shared-ui-modal/ion-footer/div/ion-button
	    
	   // Thread.sleep(10000);
	 //   new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//kody-discount-modal/kody-shared-ui-modal/div/div/form/ion-input"))).sendKeys("12345");


	    click(By.xpath("//kodypay-payment-page-footer/ion-footer/ion-toolbar/p/a"));
	    Thread.sleep(5000);

	    EnterText(By.xpath("//kody-card-details-form/form/div[1]/ion-input/input"), "siva.nunna@kodypay.com");  }

  @When("pay the Amount By using card")
  public void pay_the_amount_by_using_card() {
	  driver.switchTo().frame("checkout-frames-form");
	    
	    EnterText(By.name("cardnumber"), "4485040371536584");
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
  
//  @Test
//  public void test123() throws InterruptedException {
//	  driver.get("https://pay-staging.kodypay.com/store/945e1c8c-0258-42d6-a850-2026c9507945/order-confirmed/5e23210b-eabe-40c1-8cad-e3dce42b9b53");
//Thread.sleep(10000);
//System.out.println(driver.findElement(By.xpath("//p[contains(.,\'The wait is over, your order is collected from SIVA HOTEL - please, enjoy!\')]")).getText());
//
//  }

}
