package kodyorder.pages;

import org.openqa.selenium.By;

public class MenuPage extends BasePage {

	public By STORE_NAME = By.xpath(LOCATORS.getProperty("storename"));
	public By ION_CHIP_IMAGE = By.xpath(LOCATORS.getProperty("ion_chip"));
	public By KODY_MENU_CATEGORIES = By.xpath(LOCATORS.getProperty("kody_menu_categories"));
	public By CHECKOUT_BUTTON = By.xpath(LOCATORS.getProperty("checkout_button"));
	public By KODY_MENU_CATEGORY = null;

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
}
