package utils.pageobject.TwoActorProductPage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.common.GeneralUtils;
import utils.common.UISelenenum;
import utils.pageobject.Homepage.HomePageObject;
import utils.pageobject.productpage.ProductPageObject;



public class TwoActorProductApproveRejectPageObject {

	public TwoActorProductApproveRejectPageObject(WebDriver driver){
		this.driver=driver;
	}
	  /// Locator values
    WebDriver driver;
   
    /// Locator values
    By 	   Requests     	= By.linkText("Requests");
    
    String Related    		= "//span[contains(.,'Related')]";
    String Decision    		= "Show more actions for this record";
    String Approve1    		= "Approve";
    String Reject     		= "Reject";
    
    String DocumentTemplate = "selectDocumentTemplate";
    String Approved_Comment  ="//textarea[contains(@rows,'3')]";
    String Request_commentsubmit="//input[@value='Submit']";
  
    //Button locators
    public static final String Reques	     	= "Requests";
    public static final String NewBt			= "div[title='New']";      

    public static final String Partner_Type  	= "tradingpartner";
    public static final String ApproveFinal_Status  	= "//span[contains(.,'Approved')]";
    public static final String RejectFinal_Status  	= "//span[contains(.,'Rejected')]";
    
    
    HomePageObject homepageobject =new HomePageObject(driver);
    GeneralUtils guitils 	= new GeneralUtils(driver);
    String Partnername		= guitils.getUserName("Partnername"); 
	String RequestType		= guitils.getUserName("RequestType"); 
	String DocumentType		= guitils.getUserName("DocumentType"); 
	String Comment			= guitils.getUserName("Comment"); 
	String Approve_Comment	= guitils.getUserName("Approve_Comment");
	String Reject_Comment	= guitils.getUserName("Rejct_Comment");
	
	UISelenenum seleniumutils =new UISelenenum();
	
	By 	   AutoSelect1    	= By.cssSelector("h3.ng-binding");
	String firstwindow;

	String getUpcnumber;
	String RProductName;
	String Task             ="//a[contains(text(),'Tasks')]";
	String UPRelationshiptype = guitils.getRelationshipType("UPRelationshiptype");
	String UPRelationshipstatus = guitils.getRelationshipType("UPRelationshipstatus");
	String TradePartner 		=".slds-q-multi-select";
	String Frame     			= "vfFrameId";
	String Requester_Type   	= "//*[@id='p3']";
    String Requester_name   	= "requestName";
    String Partner_Name    		= "//input[contains(@placeholder,'Enter Product')]";
    String AutoSelect   	 	= "h3.ng-binding";
    String AutoPartnerName		=".slds-list__item.ng-binding.ng-scope";
    String TypeofReq_dpdwn   	= "requestType";
    String Typeofdoc_dpdwn   	= "selectDocumentTemplate";
    String Comments_Field   	= "comments";
    String Applancher           ="//*[@alt='App Launcher']";
    public static final String NewButton   = "div[title='New']";
    public static final String Continue_Button = ".//*[@id='bottomButtonRow']/input[1]";
    public static final String Send_Button  = "(//button[@type='button'])[2]";
    public static final String Cancle_Button  = "/html/body/div/div[1]/div/div[3]/button[1]";
    public static final String PopClose_Button = "div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand";
    public static final String Partner_Type_Product  = "product";
    public static final By     PopClose_Button1 	= By.cssSelector("div.slds-x-small-buttons--horizontal > button.slds-button.slds-button--brand");
		
	//String RelationFrameId = "html/body/div[1]/product-connect/div[2]/div/div";
	 String Products_ICIX_Search = "Product Search";
	 String txtProduct= "//input[contains(@id,'txtIdValue0')]";
	 String SF_Home_icon = "//li[@id='actionCard_MyDay']/a/div/div/div/div/span/img";
	 String btnConnectToproduct = "//button[text()='Connect to Product']";
	 
	 String UP_Relationship_Type = "html/body/div/product-connect/div[2]/div/div/div[2]/section[1]/form/fieldset/div/div[2]/label/select";
	 String UP_Relationship_Status = "html/body/div[1]/product-connect/div[2]/div/div/div[2]/section[1]/form/fieldset/div/div[3]/label/select";
	 String btn_UP_Relationship = "html/body/div/product-connect/div[2]/div/div/div[3]/button[2]";
	 String btn_close_Relationship = "html/body/div/message-dialog/div[2]/div/div/div[3]/button";
	 ProductPageObject sf_Create_Product_page = new ProductPageObject(driver);
	 
	 
	 public void clickHomeIcon(){
			driver.findElement(By.xpath(SF_Home_icon)).click();
			}
	 	
	public void connectToProduct() throws Throwable{
		getUpcnumber = sf_Create_Product_page.UPCproduct;
		System.out.println(getUpcnumber);
		Set<String> window=driver.getWindowHandles();
	     Iterator<String> iter=window.iterator();
	     String firstwindow=iter.next();
	     driver.findElement(By.linkText(Products_ICIX_Search)).click();
		driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
		driver.findElement(By.xpath(txtProduct)).sendKeys(getUpcnumber);
		Thread.sleep(5000);
		driver.findElement(By.xpath(sf_Create_Product_page.New_Products_Search_Button)).click();
		driver.findElement(By.xpath(btnConnectToproduct)).click();
		System.out.println("User is switched to the frame");
		 Select drpUPRelTyp = new Select(driver.findElement(By.xpath(UP_Relationship_Type)));
		 drpUPRelTyp.selectByVisibleText(UPRelationshiptype);
		 //dropdown.selectByVisibleText("Sell");
	        //To select value in "Relationship Status" drop down.
	        Select Statusdropdown = new Select(driver.findElement(By.xpath(UP_Relationship_Status)));
	       Statusdropdown.selectByVisibleText(UPRelationshipstatus);
	        // Statusdropdown.selectByVisibleText("Active");
	        driver.findElement(By.xpath(btn_UP_Relationship)).click();
	        driver.findElement(By.xpath(btn_close_Relationship)).click();
	        driver.switchTo().window(firstwindow);    
	        Thread.sleep(5000);
	}
	
	public void CheckRequest() throws Throwable {
	    seleniumutils.waitForElement(driver,15,Requests);
	        driver.findElement(Requests).click();
	    }   
	    
	    
	    public void Click_Tasks() throws Throwable {
		    seleniumutils.waitForElement(driver,15,By.xpath(Task));
		        driver.findElement(By.xpath(Task)).click();
		    }   
	    
	    
	    public void fillProductRequiredFields(String Reqname) throws Exception {
			RProductName = sf_Create_Product_page.ProductName;
			System.out.println(RProductName);
		     Set<String> window=driver.getWindowHandles();
		     Iterator<String> iter=window.iterator();
		     String firstwindow=iter.next(); 
		     seleniumutils.waitForElement(driver,15,By.cssSelector(NewButton));
		     driver.findElement(By.cssSelector(NewButton)).click();
		     driver.switchTo().frame(driver.findElement(By.id(Frame)));
		     driver.findElement(By.id(Requester_name)).sendKeys(Reqname);
		     driver.findElement(By.id(Partner_Type_Product)).click();
		   
		     seleniumutils.waitForElement(driver,15,By.xpath(Partner_Name));
		     driver.findElement(By.xpath(Partner_Name)).sendKeys(RProductName);
		     seleniumutils.waitForElement(driver,15,By.cssSelector(AutoSelect));
 
		     driver.findElement(By.cssSelector(AutoSelect)).click();
		     driver.findElement(By.cssSelector(TradePartner)).click();
		     seleniumutils.waitForElement(driver,15,By.cssSelector(AutoPartnerName));
		     driver.findElement(By.cssSelector(AutoPartnerName)).click();
		     WebElement eleGetReqTypDrp = driver.findElement(By.id(TypeofReq_dpdwn));
		     Select drpReqTyp = new Select(eleGetReqTypDrp);
		     drpReqTyp.selectByVisibleText(RequestType);
		     WebElement eleSelDocTmp = driver.findElement(By.id(Typeofdoc_dpdwn));
		     Select drpDocTmp = new Select(eleSelDocTmp);
		     drpDocTmp.selectByVisibleText(DocumentType);
		     driver.findElement(By.id(Comments_Field)).sendKeys(Comment);; 
		     driver.findElement(By.xpath(Send_Button)).click();
		     seleniumutils.waitForElement(driver,15,By.cssSelector(PopClose_Button));
		     driver.findElement(By.cssSelector(PopClose_Button)).click();
		     driver.switchTo().window(firstwindow);
		    }

	   public void COMPLETE_Request(String ReqName) throws Throwable{ 
	   
	    driver.findElement(By.linkText(ReqName)).click();
	    Actions c =new Actions(driver);
	    c.moveToElement(driver.findElement(By.xpath(Related))).click().build().perform();
	    driver.findElement(By.linkText(ReqName)).click();
	    }
	   public void NewTab_Request() throws Throwable{
	    //driver.findElement(By.xpath(memberLogin.Applancher)).sendKeys(Keys.CONTROL + "t");
		driver.findElement(By.xpath(homepageobject.Applancher)).sendKeys(Keys.chord(Keys.COMMAND + "t"));
	    }   
	   
	   public void Approve_request(String Reqname) throws Throwable{
		   driver.findElement(By.linkText(Reqname)).click();
		   driver.findElement(By.linkText(Decision)).click();
		   seleniumutils.waitForElement(driver,10,By.linkText(Approve1));
		   driver.findElement(By.linkText(Approve1)).click();
		   seleniumutils.waitForElement(driver,10,By.id(Frame));
		   driver.switchTo().frame(driver.findElement(By.id(Frame)));
		   driver.findElement(By.xpath(Approved_Comment)).sendKeys(Approve_Comment);
		   Thread.sleep(5000);
		   driver.findElement(By.xpath(Request_commentsubmit)).click();
		   driver.switchTo().window(firstwindow);
		   Thread.sleep(5000);
		   driver.navigate().refresh();

		    }
		   
		   public void Reject_request(String Reqname) throws Throwable{  
		   driver.findElement(By.linkText(Reqname)).click();
		   driver.findElement(By.linkText(Decision)).click();
		   seleniumutils.waitForElement(driver,10,By.linkText(Reject));
		   driver.findElement(By.linkText(Reject)).click();
		   seleniumutils.waitForElement(driver,10,By.id(Frame));
		   driver.switchTo().frame(driver.findElement(By.id(Frame)));
		   driver.findElement(By.xpath(Approved_Comment)).sendKeys(Reject_Comment);
		   driver.findElement(By.xpath(Request_commentsubmit)).click();
		   driver.switchTo().window(firstwindow);
		   driver.navigate().refresh();
		        
		    }
}

