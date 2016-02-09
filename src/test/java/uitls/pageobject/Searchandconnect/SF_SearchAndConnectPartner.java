package uitls.pageobject.Searchandconnect;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



//import utilis.seleniumUtils;
import org.openqa.selenium.Keys;

import utils.common.GeneralUtils;
import utils.common.UISelenenum;
import utils.pageobject.Homepage.HomePageObject;

public class SF_SearchAndConnectPartner {
	
	public SF_SearchAndConnectPartner(WebDriver driver){
		this.driver=driver;
	}
	
	private WebDriver driver;
	String Applancher 			= "//*[@alt='App Launcher']";
	String Tasks				="//a[contains(text(),'Tasks')]";
	By IcIxLink					=By.linkText("ICIX");
	By lnkAccounts				=By.linkText("Accounts");
	String sTblAccounts			="html/body/div[5]/div[1]/section/div[1]/div[2]/div[4]/div/div[2]/div[1]/div/div[2]/div/div/table/tbody";
								
	String stblAccountsTPAdded	="html/body/div[5]/div[1]/section/div[1]/div[2]/div[5]/div/div[2]/div[1]/div/div[2]/div/div/table/tbody";
	By tdArrow					=By.xpath(".//*[@title='Show More']");
	By lnkDelete				=By.xpath(".//*[@title='Delete']");
	By btnDelete				=By.xpath(".//*[@title='Delete']");
	String strbtnNew			=".//*[@title='New']";
	String AddAccIframeId		="vfFrameId";
	String strTxtCompName		="input[id=\"companyName\"]";
	//String strBtnSearch			=".//*[@class='btn btn-info action']";
	String strBtnSearch			=".//*[@class='slds-button slds-button--brand']";	
	String strBtnConnect		="button[class=\"btn btn-connect ng-scope\"]";
	
	//String strBtnSave			=".//*[@class='slds-button slds-button--brand ng-scope']";
	String strBtnSave			=".//*[@id='btn_UPRelationship_Save']";	
	String strChkAll			="input[type=\"checkbox\"]";
	//String strStsDrp			=".//select[contains(@ng-options,'tradingPartnerRelationshipStatuses')]";
	String strStsDrp			="ddl_UURelationship_Status";	
	String strDivSuccess		="html/body/main/div/div[2]";
	//String strAccountUrl		="https://icixqaorg01-dev-ed.lightning.force.com/one/one.app#/sObject/001/home";
	int Flag=0;
	public static final String btnNew=".//*[@title='New']";
	//public static final String strTypeDrp="html/body/main/div/partner-connect/div[2]/div/div/div[2]/section[1]/form/fieldset/div/div[2]/label/select";
	public static final String strTypeDrp=".//*[@id='ddl_UURelationship_Type']";	
	String firstwindow;
	WebElement tblAccounts;
	List <WebElement> RowsOfTable;
	WebElement ColOfTable;
	
	
	GeneralUtils guitils = new GeneralUtils(driver);	
	String strRelationSts=guitils.getUserName("RelationshipStatus");
	String strRelationTyp=guitils.getUserName("RelationshipType");
	String strTPName=guitils.getUserName("TradingPartnerName");
	String strAccountUrl=guitils.getUserName("strAccountUrl");
	UISelenenum seleniumutils =new UISelenenum();
	
	public void NavigateToAccounts() throws Throwable{		
		driver.findElement(By.xpath(Applancher)).click();
		driver.findElement(IcIxLink).click();
		//sfHome.NavigateToIcix();
		//driver.findElement(By.linkText(strIcIxLink));		
		
		//driver.findElement(By.linkText(strlnkAccounts));
		driver.findElement(lnkAccounts).click();
			
	}
	
	public void DeleteAccount() throws Throwable{
		NavigateToAccounts();
		tblAccounts= driver.findElement(By.xpath(sTblAccounts));		
		RowsOfTable=tblAccounts.findElements(By.tagName("tr"));		
		
		for (int r=0;r<RowsOfTable.size();r++)
		{
			ColOfTable=RowsOfTable.get(r).findElement(By.tagName("td"));
			String tdText=ColOfTable.getText();
			String textToVerify=strTPName;
			
			if(tdText.equals(textToVerify))
			{
				RowsOfTable.get(r).findElement(tdArrow).click();
				driver.findElement(lnkDelete).click();
				driver.findElement(btnDelete).click();				
				break;
			}
		}		
	}
	
	public void SearchAndConnectPartner() throws Throwable{	
		
		
		Set<String> window=driver.getWindowHandles();
	    Iterator<String> iter=window.iterator();
	    firstwindow=iter.next(); 
	    Thread.sleep(3000);
		driver.findElement(By.xpath(btnNew)).click();
		driver.switchTo().frame(driver.findElement(By.id(AddAccIframeId)));
		driver.findElement(By.cssSelector(strTxtCompName)).sendKeys(strTPName);
		driver.findElement(By.xpath(strBtnSearch)).click();
		driver.findElement(By.cssSelector(strBtnConnect)).click();
	}
	
	public void DefineTpRelationship() throws Throwable{
		driver.switchTo().activeElement().equals(driver.findElement(By.xpath(strTypeDrp)));
		driver.findElement(By.xpath(strTypeDrp)).sendKeys(Keys.chord(Keys.ARROW_DOWN));	
		Select drpRelationshipSts=new Select(driver.findElement(By.id(strStsDrp)));
		drpRelationshipSts.selectByVisibleText(strRelationSts);	
		//List <WebElement> chkAll=driver.findElements(By.cssSelector(strChkAll));
		//chkAll.get(1).click();
		//chkAll.get(4).click();
		//chkAll.get(5).click();	
		driver.findElement(By.xpath(strBtnSave)).click();
		System.out.println(driver.findElement(By.xpath(strDivSuccess)).getText());	
		driver.switchTo().window(firstwindow);
	}
	
	public void VerifyAddedAccount() throws Throwable{		
		driver.navigate().refresh();
		driver.navigate().to(strAccountUrl); 	
		//driver.findElement(By.linkText(strTPName)).click();
		
	}
	public void Clickon_Tasks() throws Throwable{	
		driver.findElement(By.xpath(Tasks)).click();
	}
	
}