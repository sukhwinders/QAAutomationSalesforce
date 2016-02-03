package utils.common;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import io.github.bonigarcia.wdm.ChromeDriverManager;
import tests.uitests.products.CreateProductUITest;
import utils.pageobject.Homepage.HomePageObject;
import utils.pageobject.productpage.ProductPageObject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.*;

public class TestBase {
		
	protected static WebDriver driver;
	//public WebDriver driver;
	protected String baseUrl; 
	
	private static WebDriver initFirefoxDriver(String appUrl) {
		
		System.out.println("Launching Firefox browser..");
		//WebDriver driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.navigate().to(appUrl);
		return driver;
	}
	
	public void navigateToUrl(){
		driver.navigate().refresh();
		driver.navigate().to(baseUrl);
	}

 @BeforeSuite
   public void setUp() { 
         baseUrl = "https://login.salesforce.com/";      
         initFirefoxDriver(baseUrl);         
   }

@AfterSuite
   public void tearDown() throws Exception {
         driver.quit();
   }
}
