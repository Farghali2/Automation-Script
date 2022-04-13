package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionPage extends PageBase{
	
	public CollectionPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By CreateColBut = By.xpath("//div[@class=\"btns\"]");
	private By CategoryName = By.xpath("//input[@type=\"text\"]");
	//private By SaveBtn = By.xpath("//BUTTON[@class=\"btn btn-primary btn-ladda btn-ladda-spinner top-save-button ladda-button\"]");
	private By Description = By.xpath("(//DIV[@class='note-editable'])[1]");
	private By SaveBtn = By.xpath("(//BUTTON[@type='button'])[2]");

	private By SearchField = By.xpath("//INPUT[@type='search']");
	private By CustomerCol = By.xpath("//TD[@class='sorting_1']");

	
	//Method to enter UserName
	public void CreateCol(String CatName ,String CatDesc) {
		click(CreateColBut);
		SendValues(CategoryName,CatName);
		SendValues(Description,CatDesc);
		click(SaveBtn);
	}
	
	public Boolean SearchWith(String CatName) {
		
		WaitForClick(SearchField);
		SendValues(SearchField,CatName);
		//wait for getting search result
		Wait5s();
		List<WebElement> elementsName = driver.findElements(CustomerCol);
		for (WebElement elementName: elementsName) {
		//	System.out.println(elementName.getText());
		    if(elementName.getText().equals(CatName)) 
		        return true;
		}return false;	
	}
}
