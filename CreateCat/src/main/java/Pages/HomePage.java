package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
	
	public void click(By ele) {
		driver.findElement(ele).click();		
	}

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By HomeButton = By.xpath("//A[@href='https://KSPJPJ1448.expandcart.com/admin/common/dashboard']");
	private By ProductsTab = By.xpath("//A[@href='https://KSPJPJ1448.expandcart.com/admin/catalog/product']/self::A");
	@FindBy(partialLinkText = "https://kspjpj1448.expandcart.com/admin/catalog/component/collection")
	By CollectionTab;
	private By AllProductTab = By.xpath("//A[@href='https://KSPJPJ1448.expandcart.com/admin/catalog/product'][text()='All Products']");
	
	
	
	public void Steps() {
		//click(ProductsTab);
		driver.get("https://kspjpj1448.expandcart.com/admin/catalog/component/collection");
	}
	
	public void CreatePro() {
		WaitForClick(HomeButton);
		click(HomeButton);
		WaitForClick(ProductsTab);
		click(ProductsTab);
		driver.get("https://kspjpj1448.expandcart.com/admin/catalog/product");
//		WaitForClick(AllProductTab);
//		click(AllProductTab);															
	}
	
}
