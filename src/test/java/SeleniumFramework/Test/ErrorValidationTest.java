package SeleniumFramework.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import SeleniumFramework.PageObjetModel.CartPage;
import SeleniumFramework.PageObjetModel.CatelougePage;
import SeleniumFramework.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest{
	
	//static WebDriver driver;

	@Test (groups = {"Errorhandling"})//, retryAnalyzer = SeleniumFramework.TestComponents.Retry.class
	public void loginErrorValidation() throws IOException
	
	{
		String product= "IPHONE 13 PRO";
		login.loginApp("ritu@vln.com", "Ritu@124");
		AssertJUnit.assertEquals("Incorrect email password.", login.getErrorMsg());
	}
	@Test
	public void productErrorValidation() throws IOException
	
	{
		String product= "IPHONE 13 PRO";
		
		CatelougePage listOfProduct =login.loginApp("Abc@gmail.com", "Abc@123");
		List <WebElement> products=listOfProduct.getProductList();
		listOfProduct.addProductToCart(product);
		CartPage cart=listOfProduct.clickOnCart();
		boolean match=cart.verifytCartList(product);
		AssertJUnit.assertTrue(match);
	}
}
