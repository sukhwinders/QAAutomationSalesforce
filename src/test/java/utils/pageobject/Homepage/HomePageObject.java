package utils.pageobject.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject{
	
	private WebDriver driver;
	public HomePageObject(WebDriver driver){
		this.driver=driver;
	}
	
	public static final String Username   	= ".//*[@id='username']";
		          String password   		= ".//*[@id='password']";
		          String loginButton  		= ".//*[@id='Login']";
		          String myaccount    		= "//img[@alt='View Profile']";
		          String logout   			= "Log Out";
		          String icix       		= "ICIX";
   public static final String Applancher  	= "//a[contains(@alt,'App Launcher')]";
		          
		    //Function to enter valid credentials to the app.
		    public void LoginSF(String uname,String passwd) throws Throwable  {
		    	
		    	driver.navigate().refresh();
		    	Thread.sleep(2000);
		    	driver.navigate().to("https://login.salesforce.com/");
		    	driver.navigate().refresh();   	
		   
			    driver.findElement(By.xpath(Username)).sendKeys(uname);
			    driver.findElement(By.xpath(password)).sendKeys(passwd);
			    driver.findElement(By.xpath(loginButton)).click();
		    }
		    
		    public void NavigateToIcix() throws Throwable { 
		     driver.findElement(By.xpath(Applancher)).click();
		     Thread.sleep(5000);
		     driver.findElement(By.linkText(icix)).click();   
		     
		    }
		    
		    
		  public void logout()
		  {
		   driver.findElement(By.xpath(myaccount)).click();
		   driver.findElement(By.linkText(logout)).click();
		  }
	}

