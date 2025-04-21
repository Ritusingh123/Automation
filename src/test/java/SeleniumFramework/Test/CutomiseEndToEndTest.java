package SeleniumFramework.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.PageObjetModel.CartPage;
import SeleniumFramework.PageObjetModel.CatelougePage;
import SeleniumFramework.PageObjetModel.CheckOutPage;
import SeleniumFramework.PageObjetModel.ConfirmationPage;
import SeleniumFramework.PageObjetModel.OrderPage;
import SeleniumFramework.TestComponents.BaseTest;

public class CutomiseEndToEndTest extends BaseTest{
	
	//static WebDriver driver;
	String product= "IPHONE 13 PRO";

	@Test (dataProvider="getData",groups= {"Purchase"})//invocationCount=3
	public void submitOrder(HashMap<String,String> input ) throws IOException
	
	{
		
		
		//LoginPage login=launchApp();
		///login.Browserlaunch();
	//login.loginApp("ritu@vln.com", "Ritu@123");
		CatelougePage listOfProduct =login.loginApp(input.get("email"),input.get("password"));
		List <WebElement> products=listOfProduct.getProductList();
		listOfProduct.addProductToCart(product);
		CartPage cart=listOfProduct.clickOnCart();
		
		boolean match=cart.verifytCartList(product);
		Assert.assertTrue(match);
		cart.goToCheckout();
		CheckOutPage checkout=new CheckOutPage(driver);
		checkout.selectCountryName("India");
		ConfirmationPage confirmationPage=checkout.submitOrder();
		String confirmmsg=confirmationPage.getConfirmationMsg();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
}
	@Test (dependsOnMethods= "submitOrder")
	public void orderHistory() {
		CatelougePage listOfProduct =login.loginApp("ritu@vln.com", "Ritu@123");
		OrderPage orderpage=listOfProduct.clickOnOrder();
		orderpage.verifytOrdertList(product);
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email","ritu@vln.com");
//		map.put("password","Ritu@123");
//		map.put("product","IPHONE 13 PRO");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email","Abc@gmail.com");
//		map1.put("password","Abc@123"); 
//		map1.put("product","ADIDAS ORIGINAL");
		List<HashMap<String,String>>data=getJsonData(System.getProperty("user.dir") +"\\src\\test\\java\\SeleniumFramework\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	

	
	}
}
