package SeleniumFramework.PageObjetModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFramework.AbstractComponent.ReusableComponent;

public class CheckOutPage extends ReusableComponent{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector(".totalRow button")).click();
	
	@FindBy (css=".form-group input")
	WebElement country;
	
	@FindBy (xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry; 
	
	@FindBy (css=".action__submit")
	WebElement submit;
	
	By result=By.cssSelector(".ta-results.list-group.ng-star-inserted");
	
	public void selectCountryName(String countryName) {
		Actions ac=new Actions(driver);
		ac.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
		ac.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	public ConfirmationPage submitOrder() {
		submit.click();
		 return new ConfirmationPage(driver);
	}
}


