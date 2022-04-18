package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends PageBase{

	public ProductPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By CreateProductBut = By.xpath("//SPAN[@id='add_product']");
	private By ProductName = By.xpath("//INPUT[@id='name_1']");
	private By SaveBtn = By.xpath("(//BUTTON[@type='button'])[1]");
	private By ProductDescription = By.xpath("(//DIV[@class='note-editable'])[1]");
	private By PriceField = By.xpath("//INPUT[@id='price']");
	private By CostPriceField = By.xpath("//INPUT[@id='cost_price']");
	private By AdvancedOptions = By.xpath("//label[@class='theme-btn secondary-btn no-margin']");
	private By CatLinkField = By.xpath("(//INPUT[@class='select2-search__field'])[3]");
	//private By Image = By.xpath("//DIV[@id='product-dropzone']");
	private By SaveConfirmDuplicate = By.xpath("//button[@class='theme-btn primary-btn s-bold']");
	private By CancelBtn = By.xpath("//A[text()=' Cancel']");
	
	private By SearchField = By.xpath("(//INPUT[@type='search'])[1]");
	private By ProductCol = By.xpath("//td[@class='product-name-column sorting_1']");
	
	
	public void CreateProduct(String Name , String Desc , String Price ,String CatLink) {
		click(CreateProductBut);
		SendValues(ProductName,Name);
		SendValues(ProductDescription,Desc);
		SendValues(PriceField,Price);
		//SendValues(Image, "C:/Users/EXPAND/x.png"); 
		click(AdvancedOptions);
		SendValues(CatLinkField,CatLink);	
		PressEnter(CatLinkField);
		SendValues(CostPriceField,Price);
		click(SaveBtn);
		click(SaveConfirmDuplicate);
		WaitTill(SaveConfirmDuplicate);
		click(CancelBtn);
	}
	
	public Boolean ProductSearchWith(String PordName) {
		WaitForClick(SearchField);
		SendValues(SearchField,PordName);
		Wait5s();
		List<WebElement> elementsName = driver.findElements(ProductCol);
		for (WebElement elementName: elementsName) {
			//System.out.println(elementName.getText());
		    if(elementName.getText().equals(PordName)) 
		        return true;
		}return false;
	}
}
