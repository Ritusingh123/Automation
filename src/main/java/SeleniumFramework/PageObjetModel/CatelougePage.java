package SeleniumFramework.PageObjetModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.ReusableComponent;

public class CatelougePage extends ReusableComponent {
	
	WebDriver driver;
	public CatelougePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	List <WebElement> item=driver.findElements(By.cssSelector(".col-lg-4"));
//	WebElement itemName=item.stream().filter(i->i.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);
//	itemName.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	//List <WebElement> cartproduct=driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".col-lg-4")
	List <WebElement> item;
	
	@FindBy (css=".ng-animating")
	WebElement spinner;
	
	
	
	
	
	By Product=By.cssSelector(".col-lg-4");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	
	public  List<WebElement> getProductList() {
		waitForElementToAppear(Product);
		return item;
		
	}
	public WebElement getProductName(String ProductName) {
		WebElement itemName=getProductList().stream().filter(i->i.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		 return itemName;
	}
	public void addProductToCart(String ProductName) {
		WebElement prod=getProductName(ProductName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	
	
}
