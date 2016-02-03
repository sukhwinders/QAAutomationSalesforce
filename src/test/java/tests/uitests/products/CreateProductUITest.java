package tests.uitests.products;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.common.GeneralUtils;
import utils.common.TestBase;
import utils.pageobject.Homepage.HomePageObject;
import utils.pageobject.productpage.ProductPageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateProductUITest extends TestBase{ 
	
	/*
	 * This test will create a new product in the specific org ID.
	 */	    
 @Test()
 public void CreateProduct() throws Throwable {	
	 
	 GeneralUtils guitils = new GeneralUtils(driver);
	 HomePageObject homepageobject = new HomePageObject(driver);	
	 ProductPageObject productpageobject = new ProductPageObject(driver);
	 String userName1 = guitils.getUserName("RequestorUsername");
	 String password1 = guitils.getPassword("RequestorPassword");
	 
	 homepageobject.LoginSF(userName1, password1);
	 //Assert.assertTrue(driver.findElement(By.xpath(homepageobject.Username)).isDisplayed(), "UserName field is not available");
     
     Assert.assertTrue(driver.findElement(By.xpath(homepageobject.Applancher)).isDisplayed(), "Applancher is not available");
     homepageobject.NavigateToIcix();
     productpageobject.sf_clickIcIxProductsLink();
     Assert.assertTrue(driver.findElement(By.xpath(productpageobject.New_Products_Button)).isDisplayed(), "New Button  is not available");
     productpageobject.sf_CreateNewProduct();
     homepageobject.NavigateToIcix();
     productpageobject.sf_SearchProduct();    
     //Assert.assertTrue(driver.findElement(By.xpath(productpageobject.product)).isDisplayed(), "New Product is not Created");
     productpageobject.Switchto_Mainwindow();
     homepageobject.logout();
	 	 
 	}
 }