package SeleniumFramework.PageObjetModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.ReusableComponent;

public class ConfirmationPage extends ReusableComponent {
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css=".hero-primary")
	WebElement message;
	
	public String getConfirmationMsg() {
		return	message.getText();
		 
	}
	

}
