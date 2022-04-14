package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By User = By.xpath("//input[@name=\"username\"]");
	private By Pass = By.xpath("//input[@type=\"password\"]");
	private By LoginBtn = By.xpath("//Button[@type=\"submit\"]");
	
	public void LoginSteps() {
		SendValues(User,"mohamed.farghali@expandcart.com");
		SendValues(Pass,"Farghali@20117452011");
		click(LoginBtn);
	}
	
}
