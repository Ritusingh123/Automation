package SeleniumFramework.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework.PageObjetModel.CartPage;
import SeleniumFramework.PageObjetModel.OrderPage;

public class ReusableComponent {
	
	WebDriver driver;

	public ReusableComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement orderButton;

	public void waitForElementToAppear(By FindBy) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitForWebElementToAppear(WebElement FindBy) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));	
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public CartPage clickOnCart() {
		cartButton.click();
		return new CartPage(driver);
	}
	public OrderPage clickOnOrder() {
		orderButton.click();
		return new OrderPage(driver);
	}
}
