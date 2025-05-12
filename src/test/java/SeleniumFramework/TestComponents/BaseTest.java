package SeleniumFramework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFramework.PageObjetModel.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public LoginPage login;

	public WebDriver driverInitialiize() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SeleniumFramework\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
		//prop.
		 driver=new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("Firefox")) 
		{	
			 driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) 
		{	
			 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;}
		
		public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
			
			String jsonContent =FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
			ObjectMapper mapper=new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsonContent, 
				    new TypeReference<List<HashMap<String, String>>>() {});

			return data;
	}
		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
			TakesScreenshot ss=(TakesScreenshot)driver;
			File src=ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png"));
			return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
			
		}
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApp() throws IOException {
		 driver=driverInitialiize();
		  login=new LoginPage(driver);
			login.Browserlaunch();
			return login;
	}
	@AfterMethod(alwaysRun=true)
	public void closebrowser() {
		driver.quit();
	}
	@BeforeMethod(enabled =false)
	public void checkmethod() {
		System.out.println("git check");
	}
	@BeforeMethod(enabled =false)
	public void checmatekmethod() {
		System.out.println("git check again");
		System.out.println("git check again");
		
	}
	@AfterMethod(enabled =false)
	public void aftermethod() {
		System.out.println("braching");
		System.out.println("after method");
		
	}
	
}
