package Tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.CollectionPage;
import Pages.CouponPage;
import Pages.HomePage;
import Pages.ProductPage;

public class CreateNewProduct extends TestBase {

	HomePage object;
	CollectionPage ob1;
	ProductPage ob2;
	CouponPage ob3;

	@DataProvider(name = "test-data")
	public static Object[][] data(){
		return new Object[][]
				{
			{"Noana","FarghaliDescriptionCat1"}
				};	
	}
	
	@DataProvider(name = "test-data2")
	public static Object[][] data2(){
		return new Object[][]
				{
			{"Farghali123", "FarghaliDescription" , "10050", "Far1"}
				};	
	}
	
	@DataProvider(name = "test-data3")
	public static Object[][] data3(){
		return new Object[][]
				{
			{"xxCouponFar", "xxFarghaliDistCode" , "1050"}
				};	
	}
	
	@DataProvider(name = "login-data")
	public static Object[][] loginData(){
		return new Object[][]
				{
			{"mohamed.farghali@expandcart.com","Farghali@20117452011"}
				};	
	}
	
  	@Test(priority = 0,dataProvider = "test-data")
	public void test(String CatName , String CatDesc) {
			object=new HomePage(driver);
			object.Steps();
			ob1= new CollectionPage(driver);
			ob1.CreateCol(CatName ,CatDesc);
			boolean res=ob1.SearchWith(CatName);
			assertTrue(res);
			//object.CreatePro();
	}
  	
  	@Test(priority = 1,dataProvider = "test-data2")
	public void test2(String Name , String Desc, String Price , String CatLink) throws InterruptedException {
  		object=new HomePage(driver);
  		object.CreatePro();
		ob2=new ProductPage(driver);
		ob2.CreateProduct(Name , Desc , Price ,CatLink );
		boolean res=ob2.ProductSearchWith(Name);
		assertTrue(res);
	}
  	
	@Test(priority = 2,dataProvider = "test-data3")
	public void test3(String CouponName , String CouponCode, String DiscountValue) throws InterruptedException {
  		object=new HomePage(driver);
  		object.CouponPage();
		ob3=new CouponPage(driver);
		ob3.CreateCoupon(CouponName ,CouponCode,DiscountValue );
		boolean res=ob3.SearchWith(CouponName);
		assertTrue(res);
		
	}
}
