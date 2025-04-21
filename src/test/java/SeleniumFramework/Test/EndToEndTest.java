package SeleniumFramework.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFramework.PageObjetModel.LoginPage;

public class EndToEndTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String product= "IPHONE 13 PRO";
		//List P1=Arrays.asList(product);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/client");
		LoginPage LP=new LoginPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("ritu@vln.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ritu@123");
		driver.findElement(By.id("login")).click();
		
		//public static void clickM (WebDriver driver,List P1)
		List <WebElement> item=driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement itemName=item.stream().filter(i->i.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);
		itemName.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> cartproduct=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match=	cartproduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Actions ac=new Actions(driver);
		ac.sendKeys(driver.findElement(By.cssSelector(".form-group input")), "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		ac.sendKeys(Keys.PAGE_DOWN).build().perform();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript(window.scrollBy);
//		
//		driver.findElement(By.className(".form-group input")).sendKeys("ind");
//		List <WebElement> country=driver.findElements(By.cssSelector(".ta-results.list-group.ng-star-inserted button"));
//		country.stream().anyMatch(s->s.getText().equalsIgnoreCase("India"));
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmmsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}
}

