package PagesStoreFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.PageBase;

public class StoreFrontHomePage extends Pages.PageBase {

	public StoreFrontHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By AddFirstElementsToCart = By.xpath("(//A[@class='AddToCart'])[1]");
	private By OpenCartButton = By.xpath("//li[@class=\"CartMenu\"]");
	private By CheckOutBytton = By.xpath("//a[@class=\"CheckOut\"]");

	
	public void OpenCheckoutWithFirstItem() {
		click(AddFirstElementsToCart);
		click(OpenCartButton);
		click(CheckOutBytton);
	}
	
		
}
