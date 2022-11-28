package kodyorder.pages;

import org.openqa.selenium.By;

public class MenuPage extends BasePage {

	public By STORE_NAME = By.xpath(LOCATORS.getProperty("storename"));
	public By ION_CHIP_IMAGE = By.xpath(LOCATORS.getProperty("ion_chip"));
	public By KODY_MENU_CATEGORIES = By.xpath(LOCATORS.getProperty("kody_menu_categories"));
	public By CHECKOUT_BUTTON = By.xpath(LOCATORS.getProperty("checkout_button"));
	public By KODY_MENU_CATEGORY = null;
	//kody-shared-ui-modal/ion-header/ion-toolbar/div[1]
	public By ADDON_PAGE_TITLE = By.xpath(LOCATORS.getProperty("addon_title"));
	public void selectCategory(String category) throws InterruptedException {
		for (int i = 1; i < 10; i++) {
			if (getElementDisplayName(By.xpath(LOCATORS.getProperty("kody_menu_category")+"["+i +"]")).equals(category)) {
			 KODY_MENU_CATEGORY = By.xpath(LOCATORS.getProperty("kody_menu_category")+"["+i +"]");
				click(KODY_MENU_CATEGORY);
				break;
			}
		}
	}

	public void selectMenuItem(String menuitem) throws InterruptedException {

		click(By.xpath("//h2[normalize-space()='" + menuitem + "']"));
	}
	
	public void selectAddon(String addon) throws InterruptedException {
		
		System.out.println("Late started....");
		for (int i = 1; i < 10; i++) {
			System.out.println("Late started...2...");

			System.out.println("Addon is......."+driver.findElement(By.xpath(
					"//kody-consumer-addon-modal/kody-shared-ui-modal/div/div/kody-list-item-action["+i+"]/ion-item/kody-toggle-button")).getAttribute("kp-object"));
			System.out.println("Late ends...2...");

			if (driver.findElement(By.xpath(
					"//kody-consumer-addon-modal/kody-shared-ui-modal/div/div/kody-list-item-action["+i+"]/ion-item/kody-toggle-button")).getAttribute("kp-object").equalsIgnoreCase(addon)){
				click(By.xpath(
					"//kody-consumer-addon-modal/kody-shared-ui-modal/div/div/kody-list-item-action["+i+"]/ion-item/kody-toggle-button"));
				break;
			}
		}
		System.out.println("successfully selected");
		click(KODYPAY_APPLY_BUTTON);
	}
}
