package SeleniumFramework.PageObjetModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponent.ReusableComponent;

import SeleniumFramework.AbstractComponent.ReusableComponent;

public class LoginPage extends ReusableComponent{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement loginbtn;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMsg;
		
		public CatelougePage loginApp(String email,String password) 
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			loginbtn.click();
			return new CatelougePage(driver);	
		}
		public String getErrorMsg() {
			waitForWebElementToAppear(errorMsg);
			return errorMsg.getText();
		}
		public void Browserlaunch() {
			driver.get("https://rahulshettyacademy.com/client");
		}
	}

