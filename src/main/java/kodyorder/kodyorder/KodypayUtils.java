package kodyorder.kodyorder;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class KodypayUtils  extends WebDriverUtils{
	
	
	public void selectCategory(String category) {
		for(int i=1;i<10;i++) {
			System.out.println(i);

			System.out.println(category);
			
			System.out.println("xapth "+"//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge["+i+"]");
			if(getElementDisplayName(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge["+i+"]")).equals(category)) 
			{
				System.out.println("i ="+i);
			click(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge["+i+"]"));
			   
			break;
			}
			
		}
		
//		List<WebElement> categories =  driver.findElements(By.xpath("//kody-consumer-menu-page/ion-content/kody-menu-categories/ion-badge[2]"));
//		
//		for(WebElement cat : categories ) {
//			if((cat.getText().equals(category))){
//				try {
//					cat.click();
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
	}
	
public void selectMenuItem(String menuitem) {
		
    click(By.xpath("//h2[normalize-space()='"+menuitem+"']"));

		
	}


}
