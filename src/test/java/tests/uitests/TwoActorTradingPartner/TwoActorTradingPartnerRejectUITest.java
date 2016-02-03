package tests.uitests.TwoActorTradingPartner;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.common.GeneralUtils;
import utils.common.TestBase;
import utils.pageobject.Homepage.HomePageObject;
import utils.pageobject.TwoActorTradingPartnerPage.TwoActorRequestorPageObject;
import utils.pageobject.TwoActorTradingPartnerPage.TwoActorResponderPageObject;



public class TwoActorTradingPartnerRejectUITest extends TestBase {
	Date d = new Date(System.currentTimeMillis());
	String Reqname			="AutoTest"+d;
	//Global variables
	
	/*
	 * This script will be creating new relationship.Then a new trading partner relationship will be set up with different Org. 
	 * Then trading partner relationship Acception process will be happened.
	 */
	
	@Test
	public void TwoActor_workflow_Reject() throws Throwable{
		GeneralUtils guitils 	= new GeneralUtils(driver);
		String RequserName 		= guitils.getUserName("RequestorUsername");
		String Reqpassword 		= guitils.getPassword("RequestorPassword");
		String RespUName 		= guitils.getUserName("ResponderUsername");
		String RespPwd 			= guitils.getPassword("ResponderPassword");
		
		HomePageObject memberLogin=new HomePageObject(driver);
		TwoActorRequestorPageObject Request =new TwoActorRequestorPageObject(driver);
		TwoActorResponderPageObject Responder= new TwoActorResponderPageObject(driver);
	
		//Assert.assertTrue(driver.findElement(By.xpath(memberLogin.Username)).isDisplayed(), "UserName field is not available");
		memberLogin.LoginSF(RequserName,Reqpassword);
		memberLogin.NavigateToIcix();
		Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
		//Goto Requests
		Request.CheckRequest();
		//Enter values in popup
		Request.fillRequiredFields(Reqname);
		Assert.assertTrue(driver.findElement(By.linkText(Reqname)).isDisplayed(), "Requests is not Created");
		Request.COMPLETE_Request(Reqname);
		Request.NewTab_Request();
		Responder.login_Responder();
		Assert.assertTrue(driver.findElement(By.xpath(memberLogin.Username)).isDisplayed(), "UserName field is not available");
		memberLogin.LoginSF(RespUName,RespPwd);
		memberLogin.NavigateToIcix();
		Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
		//verify the request
		Responder.CheckRequest();
		Responder.open_request(Reqname);
		Assert.assertTrue(driver.findElement(By.linkText(Responder.form)).isDisplayed(), "Form is not Created");
		Responder.fillingform(Reqname);
		//close the popup window now
		memberLogin.logout();
		//switch back to the main tab.
		Responder.Close_Tab();
		//memberLogin.NavigateToIcix();
		
		//Request.open_request(Reqname);
		//Requester verify the request & Reject  the request 
		Request.Reject_Request(Reqname);
		System.out.println("Rejected 1st time");
		/*
		 * *Second Rejecting the Request
		 */
		Request.NewTab_Request();
		Responder.login_Responder();
		Assert.assertTrue(driver.findElement(By.xpath(memberLogin.Username)).isDisplayed(), "UserName field is not available");
		memberLogin.LoginSF(RespUName,RespPwd);
		memberLogin.NavigateToIcix();
		Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
		//verify the request
		Responder.CheckRequest();
		Responder.open_Request(Reqname);
		Responder.fillingform(Reqname);
		//close the popup window now
		memberLogin.logout();
		//switch back to the main tab.
		Responder.Close_Tab();
		//Requester verify the request & Reject  the request 
		Request.Reject_request(Reqname);
		System.out.println("Rejected 2nd time");
		
	   /*
		*    Third time rejecting the request
		*/
		Request.NewTab_Request();
		Responder.login_Responder();
		Assert.assertTrue(driver.findElement(By.xpath(memberLogin.Username)).isDisplayed(), "UserName field is not available");
		memberLogin.LoginSF(RespUName,RespPwd);
		memberLogin.NavigateToIcix();
		Assert.assertTrue(driver.findElement(By.linkText(Request.Reques)).isDisplayed(), "Requests is not available");
		//verify the request
		Responder.CheckRequest();
		Responder.open_Request(Reqname);
		Responder.fillingform(Reqname);
		//close the popup window now
		memberLogin.logout();
		//switch back to the main tab.
		Responder.Close_Tab();
		//Requester verify the request & Reject  the request 
		Request.Reject_request(Reqname);
		Assert.assertTrue(driver.findElement(By.xpath(Request.RejectFinal_Status)).isDisplayed(), "Status is not getting Changed");
	}
}