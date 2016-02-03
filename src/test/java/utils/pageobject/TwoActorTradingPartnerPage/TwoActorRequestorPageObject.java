package utils.pageobject.TwoActorTradingPartnerPage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.common.GeneralUtils;
import utils.common.UISelenenum;
import utils.pageobject.Homepage.HomePageObject;

import com.thoughtworks.selenium.Wait;

public class TwoActorRequestorPageObject {
	 public TwoActorRequestorPageObject(WebDriver driver){
		  this.driver=driver;
		 }
		  private WebDriver driver;
		  
		  
		  /// Locator values
		    
		    By 	   Requests     		= By.linkText("Requests");
		    String Requester_Type   	= "//*[@id='p3']";
		    String NewButton   			= ".//*[@title='New']";
		    String Task             	="//a[contains(text(),'Tasks')]";
		    String Requester_name   	= "requestName";
		    String Partner_Name    		= "//input[@placeholder='Select trading partner']";
		    By 	   AutoSelect    		= By.cssSelector("h3.ng-binding");
		    String TypeofReq_dpdwn  	= "requestType";
		    String Typeofdoc_dpdwn  	= "selectDocumentTemplate";
		    String Comments_Field   	= "comments";
		    String Frame     			= "vfFrameId";
		    String resently_viewed   	= "//div[5]/div/div/div/div/div/div[2]/h1/a/div/span";
		    String Related    			= "//span[contains(.,'Related')]";
		    String strRelatedTab        = "a[title=\"Related\"]";
		    String Related1         	= "//span[contains(.,'Related')]";
		    String Decision    			= "Show more actions for this record";
		
		    String Search_field   		= "//input[@class=' default input']";
		    String All    				= "//a[contains(@role,'option')]";
		    String Approve    			= "Approve";
		    String Reject     			= "Reject";
		    String SF_Home_icon 		= "//li[@id='actionCard_MyDay']/a/div/div/div/div/span/img";
		    String DocumentTemplate 	= "selectDocumentTemplate";
		    String Approved_Comment  	="//textarea[@name='j_id0:j_id40:commentBlock:j_id44']";
		    String Reject_comment    	="//textarea[@name='j_id0:j_id7:j_id50']";
		    String Request_commentsubmit="//input[contains(@value,'Submit')]";
		    String ATblAccounts			="/html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[2]/div[1]/div/div[2]/div";
		    String sTblAccounts			="/html/body/div[5]/div[1]/section/div[1]/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/table/tbody";
		    //Button locators
		    public static final String Reques	     	= "Requests";
		    public static final String NewBt			= "div[title='New']";      
		    public static final String Continue_Button 	= ".//*[@id='bottomButtonRow']/input[1]";
		    public static final String Send_Button  	= "(//button[@type='button'])[2]";
		    public static final String Cancle_Button  	= "/html/body/div/div[1]/div/div[3]/button[1]";
		    public static final By     PopClose_Button 	= By.xpath("//button[contains(@ng-click,'redirectToRequestListPage')]");
		    public static final String Partner_Type  	= "tradingpartner";
		    public static final String ApproveFinal_Status  = "//span[contains(.,'Approved')]";
		    public static final String RejectFinal_Status  	= "//span[contains(.,'Rejected')]";
		    WebElement tblAccounts;
			List <WebElement> RowsOfTable;
			WebElement ColOfTable;
		   
		    HomePageObject memberLogin =new HomePageObject(driver);
		    GeneralUtils guitils 	= new GeneralUtils(driver);
			String Partnername		= guitils.getUserName("Partnername"); 
			String RequestType		= guitils.getUserName("RequestType"); 
			String DocumentType		= guitils.getUserName("DocumentType"); 
			String Comment			= guitils.getUserName("Comment"); 
			String Approve_Comment	= guitils.getUserName("Approve_Comment");
			String Reject_Comment	= guitils.getUserName("Rejct_Comment");
			String Total_Requests	=("/html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[1]/div[2]/div/span");	
										
			
			UISelenenum seleniumutils =new UISelenenum();
			String firstwindow;
			
			
		    public void CheckRequest() throws Throwable {
		    seleniumutils.waitForElement(driver,15,Requests);
		        driver.findElement(Requests).click();
		    }   
		    
		    
		    public void Click_Tasks() throws Throwable {
			    seleniumutils.waitForElement(driver,15,By.xpath(Task));
			        driver.findElement(By.xpath(Task)).click();
			        Thread.sleep(3000);
			    }   
		    
		    
		    public void fillRequiredFields(String ReqName) throws Exception {
		     Set<String> window=driver.getWindowHandles();
		     Iterator<String> iter=window.iterator();
		     firstwindow=iter.next(); 
		     seleniumutils.waitForElement(driver,5,By.xpath(NewButton));
		     driver.findElement(By.xpath(NewButton)).click();
		     driver.switchTo().frame(driver.findElement(By.id(Frame)));
		     driver.findElement(By.id(Requester_name)).sendKeys(ReqName);
		     driver.findElement(By.xpath(Partner_Name)).sendKeys(Partnername);
		     Thread.sleep(2000);
		     seleniumutils.waitForElement(driver,10,AutoSelect);
		     driver.findElement(AutoSelect).click();
		     WebElement ReqType = driver.findElement(By.id(TypeofReq_dpdwn));
		     Select Request= new Select(ReqType);
		     Request.selectByVisibleText(RequestType);
		     WebElement Document = driver.findElement(By.id(DocumentTemplate));
		     Select DocumenT = new Select(Document);
		     DocumenT.selectByVisibleText(DocumentType);
		     driver.findElement(By.id(Comments_Field)).sendKeys(Comment);; 
		     driver.findElement(By.xpath(Send_Button)).click();
		     //seleniumutils.waitForElement(driver,10,PopClose_Button);
		     driver.findElement(PopClose_Button).sendKeys(Keys.ENTER);
		     driver.switchTo().window(firstwindow);
		    
		    }
		   public void COMPLETE_Request(String ReqName) throws Throwable{ 
		   
		    driver.findElement(By.linkText(ReqName)).click();
		    }
		   
		   public void NewTab_Request() throws Throwable{
			   
			  if(System.getProperty("os.name").toLowerCase().contains("win")){
				   driver.findElement(By.xpath(memberLogin.Applancher)).sendKeys(Keys.CONTROL + "t");
				   
		    	}
		    	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
		    		driver.findElement(By.xpath(memberLogin.Applancher)).sendKeys(Keys.COMMAND + "t");
			     	}
		      }    
		   
		   /*public void open_request(String Reqname) throws Throwable{
			   
			   Thread.sleep(2000);
			   driver.findElement(By.cssSelector("input[placeholder=\"Search Salesforce\"]")).click();
			
			   driver.findElement(By.cssSelector("input[placeholder=\"Search Salesforce\"]")).sendKeys(Reqname+"d");
			   driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
			   Thread.sleep(5000);
			   driver.findElement(By.linkText(Reqname)).click();
			  
			   
		}*/


		public void Approve_request(String Reqname) throws Throwable{
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector(strRelatedTab)).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText(Reqname)).click();
			Thread.sleep(3000);
			
		   driver.findElement(By.linkText(Decision)).click();
		   Thread.sleep(2000);
		   seleniumutils.waitForElement(driver,10,By.linkText(Approve));
		   //Thread.sleep(2000);
		   driver.findElement(By.linkText(Approve)).click();
		   Thread.sleep(2000);
		   seleniumutils.waitForElement(driver,10,By.id(Frame));
		   driver.switchTo().frame(driver.findElement(By.id(Frame)));
		   driver.findElement(By.xpath(Approved_Comment)).sendKeys(Approve_Comment);
		   Thread.sleep(5000);
		   driver.findElement(By.xpath(Request_commentsubmit)).click();
		   driver.switchTo().window(firstwindow);
		   Thread.sleep(5000);
		   driver.navigate().refresh();

		    }
		public void Reject_Request(String Reqname) throws Throwable{ 
			Thread.sleep(2000);
			
			driver.findElement(By.cssSelector(strRelatedTab)).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText(Reqname)).click();
			Thread.sleep(3000);

			   driver.findElement(By.linkText(Decision)).click();
			   seleniumutils.waitForElement(driver,10,By.linkText(Reject));
			   driver.findElement(By.linkText(Reject)).click();
			   seleniumutils.waitForElement(driver,10,By.id(Frame));
			   driver.switchTo().frame(driver.findElement(By.id(Frame)));
			   driver.findElement(By.xpath(Reject_comment)).sendKeys(Reject_Comment);
			   Thread.sleep(5000);
			   driver.findElement(By.xpath(Request_commentsubmit)).click();
			   //driver.switchTo().window(firstwindow);
			   Thread.sleep(5000);
			   driver.navigate().refresh();
		}
		   public void Reject_request(String Reqname) throws Throwable{  

		   driver.findElement(By.linkText(Decision)).click();
		   seleniumutils.waitForElement(driver,10,By.linkText(Reject));
		   driver.findElement(By.linkText(Reject)).click();
		   seleniumutils.waitForElement(driver,10,By.id(Frame));
		   driver.switchTo().frame(driver.findElement(By.id(Frame)));
		   driver.findElement(By.xpath(Reject_comment)).sendKeys(Reject_Comment);
		   Thread.sleep(5000);
		   driver.findElement(By.xpath(Request_commentsubmit)).click();
		   //driver.switchTo().window(firstwindow);
		   Thread.sleep(5000);
		   driver.navigate().refresh();
		        
		    }
}
