package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CouponPage extends PageBase {
	public CouponPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By CouponBtn = By.xpath("//SPAN[@id='add_coupon']");	
	private By DiscountCodeBtn = By.xpath("//A[@href='https://KSPJPJ1448.expandcart.com/admin/sale/coupon/insert']");
	private By CouponNameField = By.xpath("//INPUT[@id='name']");
	private By DiscountCodeField = By.xpath("//INPUT[@id='code']");
	private By DiscountValueField = By.xpath("//INPUT[@id='discount']");
	private By SaveBtn = By.xpath("//BUTTON[@type='button']");
	
	private By SearchField = By.xpath("//INPUT[@type='search']");
	private By CouponCol = By.xpath("//td[@class='sorting_1']");
	
	
	public void CreateCoupon(String CouponName , String CouponCode, String DiscountValue) {
		click(CouponBtn);
		click(DiscountCodeBtn);
		SendValues(CouponNameField,CouponName);
		SendValues(DiscountCodeField,CouponCode);
		SendValues(DiscountValueField,DiscountValue);
		click(SaveBtn);
	}
	
	public Boolean SearchWith(String CouponName) {
		WaitForClick(SearchField);
		SendValues(SearchField,CouponName);
		Wait5s();
		List<WebElement> elementsName = driver.findElements(CouponCol);
		for (WebElement elementName: elementsName) {
			//System.out.println(elementName.getText());
		    if(elementName.getText().equals(CouponName)) 
		        return true;
		}return false;
	}
	
	
}
