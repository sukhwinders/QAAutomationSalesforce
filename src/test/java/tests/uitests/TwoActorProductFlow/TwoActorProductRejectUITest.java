package tests.uitests.TwoActorProductFlow;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.common.GeneralUtils;
import utils.common.TestBase;
import utils.pageobject.Homepage.HomePageObject;
import utils.pageobject.TwoActorProductPage.TwoActorProductApproveRejectPageObject;

import utils.pageobject.TwoActorTradingPartnerPage.TwoActorRequestorPageObject;
import utils.pageobject.TwoActorTradingPartnerPage.TwoActorResponderPageObject;
import utils.pageobject.productpage.ProductPageObject;


public class TwoActorProductRejectUITest extends TestBase{
	Date d = new Date(System.currentTimeMillis());
	String Reqname			="0AutoTest"+d;
	
	@Test()
	 public void CreateProduct() throws Throwable {	
		
		GeneralUtils guitils 	= new GeneralUtils(driver);
		String RequserName 		= guitils.getUserName("RequestorUsername");
		String Reqpassword 		= guitils.getPassword("RequestorPassword");
		String RespUName 		= guitils.getUserName("ResponderUsername");
		String RespPwd 			= guitils.getPassword("ResponderPassword");
		
		
	    HomePageObject homepageobject = new HomePageObject(driver);	
		ProductPageObject productpageobject = new ProductPageObject(driver);
		TwoActorRequestorPageObject Request =new TwoActorRequestorPageObject(driver);
		TwoActorResponderPageObject Responder= new TwoActorResponderPageObject(driver);
		TwoActorProductApproveRejectPageObject ProductApprove_Reject = new TwoActorProductApproveRejectPageObject(driver);
		
	
		 //Assert.assertTrue(driver.findElement(By.xpath(homepageobject.Username)).isDisplayed(), "UserName field is not available");
	     homepageobject.LoginSF(RespUName, RespPwd);
	     Assert.assertTrue(driver.findElement(By.xpath(homepageobject.Applancher)).isDisplayed(), "Applancher is not available");
	     homepageobject.NavigateToIcix();
	     productpageobject.sf_clickIcIxProductsLink();
	     Assert.assertTrue(driver.findElement(By.xpath(productpageobject.New_Products_Button)).isDisplayed(), "New Button  is not available");
	     productpageobject.sf_CreateNewProduct();
	     homepageobject.NavigateToIcix();
	     productpageobject.sf_SearchProduct();    
	     Assert.assertTrue(driver.findElement(By.xpath(productpageobject.product)).isDisplayed(), "New Product is not Created");
	     productpageobject.Switchto_Mainwindow();
	  
	     Request.NewTab_Request();
	     Responder.login_Responder();
	     homepageobject.LoginSF(RequserName, Reqpassword);
	     homepageobject.NavigateToIcix();
	     ProductApprove_Reject.connectToProduct();
	     homepageobject.NavigateToIcix();
	     Request.CheckRequest();
	 	//Enter values in popup
	    ProductApprove_Reject.fillProductRequiredFields(Reqname);
	 	Assert.assertTrue(driver.findElement(By.linkText(Reqname)).isDisplayed(), "Requests is not Created");
	 	Request.COMPLETE_Request(Reqname);
	 	homepageobject.logout();
	 	//switch back to the main tab.
	 	Responder.Close_Tab();
	 	homepageobject.NavigateToIcix();
	 	Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
	 	//verify the request
	 	Responder.CheckRequest();
	 	Responder.open_request(Reqname);
	 	Assert.assertTrue(driver.findElement(By.linkText(Responder.form)).isDisplayed(), "Form is not Created");
	 	Responder.fillingform(Reqname);
	 	//switch back to the main tab.
	 	Request.NewTab_Request();
	    Responder.login_Responder();
	    homepageobject.LoginSF(RequserName, Reqpassword);
	 	homepageobject.NavigateToIcix();
	 	Request.Click_Tasks();
	 	Request.Reject_request(Reqname);
	 	homepageobject.logout();
	 	//switch back to the main tab.
	 	Responder.Close_Tab();
	 	/*
	 	 * *Secondtime Rejecting the request
	 	 * *
	 	 * 
	 	 */
	 	homepageobject.NavigateToIcix();
	 	Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
	 	//verify the request
	 	Responder.CheckRequest();
	 	Responder.open_request(Reqname);
	 	Assert.assertTrue(driver.findElement(By.linkText(Responder.form)).isDisplayed(), "Form is not Created");
	 	Responder.fillingform2(Reqname);
	 	//switch back to the main tab.
	 	Request.NewTab_Request();
	    Responder.login_Responder();
	    homepageobject.LoginSF(RequserName, Reqpassword);
	 	homepageobject.NavigateToIcix();
	 	Request.Click_Tasks();
	 	Request.Reject_request(Reqname);
	 	homepageobject.logout();
	 	//switch back to the main tab.
	 	Responder.Close_Tab();
	/*
	 * *
	 * *Third Time rejecting the request    
	 */
	 	homepageobject.NavigateToIcix();
	 	Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
	 	//verify the request
	 	Responder.CheckRequest();
	 	Responder.open_request(Reqname);
	 	Assert.assertTrue(driver.findElement(By.linkText(Responder.form)).isDisplayed(), "Form is not Created");
	 	Responder.fillingform2(Reqname);
	 	//switch back to the main tab.
	 	Request.NewTab_Request();
	    Responder.login_Responder();
	    homepageobject.LoginSF(RequserName, Reqpassword);
	 	homepageobject.NavigateToIcix();
	 	Request.Click_Tasks();
	 	Request.Reject_request(Reqname);
	 	Assert.assertTrue(driver.findElement(By.xpath(Request.RejectFinal_Status)).isDisplayed(), "Status is not getting Changed");
	 	
	}
}
