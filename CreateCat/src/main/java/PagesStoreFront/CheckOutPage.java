package PagesStoreFront;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends Pages.PageBase {

	public CheckOutPage (WebDriver driver) {
		this.driver=driver;
	}
	
	private By CouponText = By.xpath("(//INPUT[@type='text'])[5]");
	private By ApplyCouponBtn = By.xpath("//BUTTON[@id='button-addon2']");
	private By SummaryTotalPrice = By.xpath("//P[@id='summary_total']");
	//P[@id='summary_total']


	
	public boolean CheckCouponValidation(String CouponCode ,String DiscountValue) {
		String OldPrice=GetText(SummaryTotalPrice);
		SendValues(CouponText, CouponCode);
		click(ApplyCouponBtn);
		Wait5s();
		String NewPrice=GetText(SummaryTotalPrice);	
	//Check the total price after apply an coupon
		OldPrice = OldPrice.replaceAll("[^0-9]", "");  //.replaceAll("[^0-9?!\\.]","")
		int OldPriceNum = Integer.parseInt(OldPrice);OldPriceNum=OldPriceNum/100;
		NewPrice = NewPrice.replaceAll("[^0-9]", "");
		int NewPriceNum = Integer.parseInt(NewPrice);NewPriceNum=NewPriceNum/100;
		int DiscountValueNum = Integer.parseInt(DiscountValue);
		int AcualNewPrice = OldPriceNum - DiscountValueNum ;
		if(AcualNewPrice == NewPriceNum) {return true;}
		else {return false;}
	}
	
}
