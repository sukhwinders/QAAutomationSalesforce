package tests.uitests.SearchAndConnectPartner;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import uitls.pageobject.Searchandconnect.SF_SearchAndConnectPartner;
import utils.common.GeneralUtils;
import utils.common.TestBase;
import utils.pageobject.Homepage.HomePageObject;
import utils.pageobject.TwoActorTradingPartnerPage.TwoActorRequestorPageObject;
import utils.pageobject.TwoActorTradingPartnerPage.TwoActorResponderPageObject;

public class SearchAndConnectPartnerUITest extends TestBase {
	
	/* This script will first delete the account anf then add a new one by searching the trading partner company name.
	 * Finally it verifies that trading partner has been added successfully
	 */
	
	@Test
	public void SearchAndConnectPartner() throws Throwable{
		GeneralUtils guitils    = new GeneralUtils(driver);
		String RequserName      = guitils.getUserName("RequestorUsername");
		String Reqpassword      = guitils.getPassword("RequestorPassword");
		String RespUName 		= guitils.getUserName("TradingPartnerUName");
		String RespPwd 			= guitils.getPassword("TradingPartnerPword");
		String strTPName=guitils.getUserName("TradingPartnerName");
		TwoActorRequestorPageObject Request =new TwoActorRequestorPageObject(driver);
		TwoActorResponderPageObject Responder= new TwoActorResponderPageObject(driver);
		SF_SearchAndConnectPartner partnerSrcCnt=new SF_SearchAndConnectPartner(driver);	
		HomePageObject memberLogin=new HomePageObject(driver);
		
		memberLogin.LoginSF(RequserName,Reqpassword);
		//Assert.assertTrue(driver.findElement(By.xpath(memberLogin.Username)).isDisplayed(), "UserName field is not available");
		partnerSrcCnt.DeleteAccount();
		Assert.assertTrue(driver.findElement(By.xpath(partnerSrcCnt.btnNew)).isDisplayed(), "New Button  is not available");
		partnerSrcCnt.SearchAndConnectPartner();
		Assert.assertTrue(driver.findElement(By.xpath(partnerSrcCnt.strTypeDrp)).isDisplayed(), "popup is not available");
		partnerSrcCnt.DefineTpRelationship();
		partnerSrcCnt.VerifyAddedAccount();
		Assert.assertTrue(driver.findElement(By.linkText(strTPName)).isDisplayed(), "Account is not added successfully");
		//close the browser
		tearDown();
	}
}
