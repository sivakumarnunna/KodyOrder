package kodyorder.utils;


import org.openqa.selenium.By;

public class KodypayUtils  extends WebDriverUtils{
	
	public void selectCategory(String category) {
		for (int i = 1; i < 10; i++) {
			if (getElementDisplayName(
					By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[" + i + "]"))
					.equals(category)) {
				click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[" + i + "]"));
				break;
			}
		}
	}

public void selectMenuItem(String menuitem) {
		
    click(By.xpath("//h2[normalize-space()='"+menuitem+"']"));	
	}
}
