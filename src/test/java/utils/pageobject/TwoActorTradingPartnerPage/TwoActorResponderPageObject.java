package utils.pageobject.TwoActorTradingPartnerPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thoughtworks.selenium.condition.Condition;
import com.thoughtworks.selenium.condition.ConditionRunner.Context;

import utils.common.GeneralUtils;
import utils.common.UISelenenum;
import utils.pageobject.Homepage.HomePageObject;

public class TwoActorResponderPageObject {
 public TwoActorResponderPageObject(WebDriver driver){
  this.driver=driver;
 }
  private WebDriver driver;
  /// Locator values
  String Search_field   		= "//input[@placeholder='Find list']";
  String All    				= "//a[contains(@role,'option')]";
  String request         		= "/html/body/div[5]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]";
  String Related    			= "//span[contains(.,'Related')]";
  String resently_viewed   		= "div.forceIcon.downIcon";
  public static final String form	= "California Transparency of Supply Chain Act";
  
  // form locators
  By 	 filling_form  			= By.linkText("California Transparency of Supply Chain Act");
  String open_form     			= "//div[contains(@title,'Open Form')]";
  String Rdo_Yes                =".//label[starts-with(@for,'Yes')]";
  String Rdo_No					=".//label[starts-with(@for,'No')]";
  String signacture       		= "//div[@id='origin-main']/div/div/form/div/section/ng-form/div[15]/div/div/input";
  String Submit_form      		= "//div[@id='origin-main']/div/div[2]/button";
  String sTblAccounts			="/html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[2]/div[1]/div/div[2]/div/div/table/tbody";
  String Total_Requests 		="/html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[2]/div/span";
  //Submit the Request
  String strRelatedTab        = "a[title=\"Related\"]";
  String Submit      			= "//div[5]/div/div/header/div[2]/div/div/div[2]/ul/li[2]/a/div";
  String Applancher    			= "//*[@alt='App Launcher']";
  String icix      				= "ICIX";
  String myaccount  		    = "//*[@id='oneHeader']/div[2]/div[3]/a[3]";
  String Requests     			= "Requests";
  String loginButton   			= ".//*[@id='Login']";
  String Frame  				= "vfFrameId";
  WebElement tblAccounts;
  List <WebElement> RowsOfTable;
  WebElement ColOfTable;
  
  
  
  UISelenenum seleniumutils 	=new UISelenenum();
  GeneralUtils guitils 			= new GeneralUtils(driver);
  public String DocumentType	= guitils.getUserName("DocumentType"); 
  public static final By NewButton  = By.cssSelector("div[title='New']");
  String Comment					= guitils.getUserName("Comment"); 
  HomePageObject memberLogin		=new HomePageObject(driver);

  
  public void login_Responder() throws Throwable {   
   driver.get("https://login.salesforce.com/");    
   }
  public void CheckRequest() throws Throwable {
   driver.findElement(By.linkText(Requests)).click(); 
  }
  
  //@SuppressWarnings("deprecation")
  public void open_request(String Reqname) throws Throwable{
	 
	  driver.findElement(By.cssSelector(resently_viewed)).click();
	  driver.findElement(By.xpath(Search_field)).sendKeys("All");
	   driver.findElement(By.xpath(Search_field)).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath(Search_field)).click();
	   Thread.sleep(7000);
	   driver.findElement(By.xpath(All)).click();
	   seleniumutils.waitForElement(driver,20,By.xpath(Total_Requests));
	   Thread.sleep(7000);
	   while(true){
		   String Total_requests=driver.findElement(By.xpath(Total_Requests)).getText();
		   if (Total_requests.indexOf("+") > -1 ) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
	   			jse.executeScript("scrollContent = document.evaluate('/html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[2]/div[1]/div/div[2]/div', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;scrollContent.scrollTop = scrollContent.scrollHeight;");
	   			} else {
		   break;
		   }
	   }
	   
	   tblAccounts= driver.findElement(By.xpath(sTblAccounts));		
  		RowsOfTable=tblAccounts.findElements(By.tagName("tr"));		
  		
  		for (int r=0;r<RowsOfTable.size();r++)
  		{
  			ColOfTable=RowsOfTable.get(r).findElement(By.tagName("td"));
  			String tdText=ColOfTable.getText();
  			String textToVerify=Reqname;
  			
  			if(tdText.equals(textToVerify))
  			{
  				RowsOfTable.get(r).findElement(By.linkText(Reqname)).sendKeys(Keys.ENTER);
  				break;
  			}
  		}
	   driver.findElement(By.xpath(Related)).click();
   }    
  public void open_Request(String Reqname) throws Throwable{
	    
	  driver.findElement(By.linkText(Reqname)).click();
	  driver.findElement(By.cssSelector(strRelatedTab)).click();
	  
	  
	  
  }
  
   public void fillingform(String Reqname) throws Throwable{
	 
	   seleniumutils.waitForElement(driver,10,By.linkText(DocumentType));
	   driver.findElement(By.linkText(DocumentType)).click();
	   Set<String> window=driver.getWindowHandles();
	   Iterator<String> iter=window.iterator();
	   String Responderwindow=iter.next();
	   driver.findElement(By.xpath(open_form)).click();
	   driver.switchTo().frame(driver.findElement(By.id(Frame)));
	   
	   List <WebElement> RdoYes=driver.findElements(By.xpath(Rdo_Yes));
	   List <WebElement> RdoNo=driver.findElements(By.xpath(Rdo_No));
	   
	   RdoNo.get(0).click(); 
	   RdoYes.get(1).click();
	   
	   RdoNo.get(2).click();
	   RdoYes.get(3).click();
	   
	   RdoNo.get(4).click();
	   RdoYes.get(5).click();
	   RdoNo.get(6).click();
	   
	   driver.findElement(By.xpath(signacture)).sendKeys(Comment);
	   driver.findElement(By.xpath(Submit_form)).click();
	   driver.findElement(By.xpath(Related)).click();
	   driver.findElement(By.linkText(Reqname)).click();
	   driver.findElement(By.xpath(Submit)).click();
	   Thread.sleep(1000);
   }
   
   public void Submit_request() throws Throwable{
	   driver.findElement(By.xpath(Submit)).click();
   }
   
   public void Close_Tab() throws Throwable {
	  
	  if(System.getProperty("os.name").toLowerCase().contains("win")){
		  driver.findElement(By.xpath(loginButton)).sendKeys(Keys.CONTROL + "w");
   	}
   	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
   		driver.findElement(By.xpath(loginButton)).sendKeys(Keys.COMMAND + "w");
   	}	

  }
  
  public void fillingform2(String Reqname) throws Throwable{
		 
	   seleniumutils.waitForElement(driver,10,filling_form);
	   driver.findElement(filling_form).click();
	   Set<String> window=driver.getWindowHandles();
	   Iterator<String> iter=window.iterator();
	   String Responderwindow2=iter.next();
	   driver.findElement(By.cssSelector(open_form)).click();
	   driver.switchTo().frame(driver.findElement(By.id(Frame)));
	   
	   List <WebElement> RdoYes=driver.findElements(By.xpath(Rdo_Yes));
	   List <WebElement> RdoNo=driver.findElements(By.xpath(Rdo_No));
	    
	   RdoNo.get(0).click(); 
	   RdoYes.get(1).click();
	   
	   RdoNo.get(2).click();
	   RdoYes.get(3).click();
	   
	   RdoNo.get(4).click();
	   RdoYes.get(5).click();
	   RdoNo.get(6).click();
	   driver.findElement(By.id(signacture)).clear();
	   driver.findElement(By.id(signacture)).sendKeys(Comment);
	   driver.findElement(By.xpath(Submit_form)).click();
	   driver.findElement(By.xpath(Related)).click();
	   driver.findElement(By.linkText(Reqname)).click();
	   //driver.switchTo().window(Responderwindow2);
	   Thread.sleep(3000);
	   driver.findElement(By.xpath(Submit)).click(); 
	   driver.navigate().refresh();
	   Thread.sleep(3000);
 }
  
  
  
}























