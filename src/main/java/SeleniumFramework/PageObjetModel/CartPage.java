package SeleniumFramework.PageObjetModel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.ReusableComponent;

public class CartPage extends ReusableComponent {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(css=".cartSection h3")
	private List <WebElement> cartList;
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public  boolean verifytCartList(String ProductName) {

		boolean match=	cartList.stream().anyMatch(s->s.getText().equalsIgnoreCase(ProductName));
		return match;
		
	}
	public void goToCheckout() {
		Actions ac=new Actions(driver);
		ac.sendKeys(Keys.PAGE_DOWN).build().perform();
		checkout.click();
	}

}
