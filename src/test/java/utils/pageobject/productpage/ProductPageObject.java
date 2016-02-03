package utils.pageobject.productpage;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.common.GeneralUtils;
import utils.common.UISelenenum;

public class ProductPageObject {

 private WebDriver driver;
 
 public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }
 
 String upcname;
 String productcreatewindow;
 public static String randomNumbers ;
 public static String UPCproduct ;
 public static String ProductName;
 
 Date d = new Date(System.currentTimeMillis());
 String Products_ICIX_Select                      = "//a[contains(@href, 'a0N/o')]"; 
 public static final String New_Products_Button      = "//div[contains(@title,'New')]";
    String New_Products_Name_Textfield           = "//input[@id='txtProductName']";
    String New_Products_UPC_Textfield       = "//input[@ng-model='id.value']";
    By txtProductsUPC                          = By.xpath("html/body/div[1]/div/form/fieldset[2]/div/div[2]/label[2]/input");
    public static final String New_Products_Search_Button  = "//button[contains(.,'Search')]";
    String New_Products_Create_Button           = "//button[@id='btnCreateProduct']";
    String Product_Search        ="Product Search";
   //Define your Product Relationship on pop up
    String New_Products_Relationship_Type       = "//select[@ng-options='type for type in vm.main.relationshipTypes']";
    String New_Products_Relationship_Status     = "//select[@ng-options='status for status in vm.main.relationshipStatuses']";
    String Next           ="btn_UPRelationship_Next";
    String New_Products_Create_pop_Button      = "btn_UPRelationshipPermission_Save";
    public static final String New_Success_Close_button = "html/body/div/message-dialog/div[2]/div/div/div[3]/button";
    String Error          ="ng-binding";
    //To click the product related tab.
    String ProductRelated             = "html/body/div[5]/div[1]/section/div[1]/div[2]/div[5]/div/div[2]/div[1]/div/div/ul/li[1]/a/span[2]";
    public static final String product                  ="/html/body/div/div/div[3]/span/label";
    GeneralUtils guitils                                = new GeneralUtils(driver);
    String RelationType                                 = guitils.getUserName("UPRelationshiptype");
 String RelationStatus                               = guitils.getUserName("UPRelationshipstatus");
 //String RelationType                                 = "sell";
 //String RelationStatus                               = "active";
 UISelenenum seleniumutils                           = new UISelenenum();
 String ProductCreateWindow;
 String getUpcnumber;
    
    //To click on specfic ICIX products link on list page.
    public void sf_clickIcIxProductsLink() {    
     driver.findElement(By.xpath(Products_ICIX_Select)).click();  
    
      }   
    
    
    public void sf_SearchProduct() throws Exception {  
     driver.findElement(By.linkText(Product_Search)).click();  
     driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
     //to enter random numbers in the UPC field      
     driver.findElement(By.xpath(New_Products_UPC_Textfield)).sendKeys(UPCproduct);
     //seleniumutils.waitForElement(driver,30,txtProductsUPC);
     Thread.sleep(5000);
     driver.findElement(By.xpath(New_Products_Search_Button)).click();     
      }   
    
    
    //To enter value in product text field and click on search Button on final screen.
    public void sf_CreateNewProduct() throws Exception
    {
     Set<String> Currentwindow=driver.getWindowHandles();
     Iterator<String> iter=Currentwindow.iterator();
     ProductCreateWindow =iter.next();
     
     //To click on Create New Button on Products page.
     driver.findElement(By.xpath(New_Products_Button)).click();
     System.out.println("This is method to enter details");
     driver.switchTo().frame(driver.findElement(By.id("vfFrameId")));
     //to enter random numbers in the UPC field
     productnamegenerate();
     System.out.println("Product name is stored");
     //Enter value in Product name field with unique time:
     System.out.println("User has entered value in the text field");
     //Enter value in UPC textfield.
     UPCproduct=guitils.generaterandomupc();
     WebElement UPCName = driver.findElement(By.xpath(New_Products_UPC_Textfield));
     UPCName.sendKeys(UPCproduct);
     
     //seleniumutils.waitForElement(driver,30,txtProductsUPC);
     Thread.sleep(4000);
     driver.findElement(By.xpath(New_Products_Search_Button)).click();    
     
        driver.findElement(By.xpath(New_Products_Create_Button)).click();
        // Switch to Select relationship window:
        //To enter value in "Relationship Type" drop down.
        Select drpRelTyp = new Select(driver.findElement(By.xpath(New_Products_Relationship_Type)));
        drpRelTyp.selectByVisibleText(RelationType);
        //To select value in "Relationship Status" drop down.
        Select drpRelSts = new Select(driver.findElement(By.xpath(New_Products_Relationship_Status)));
        drpRelSts.selectByVisibleText(RelationStatus);
        //To click on Submit Button to add new Product page.
        driver.findElement(By.id(Next)).click();
        driver.findElement(By.id(New_Products_Create_pop_Button)).click();
        Thread.sleep(4000);
        //To click on Create Button on final screen.
        driver.findElement(By.xpath(New_Success_Close_button)).click();
        Switchto_Mainwindow();
      }
        
        public void Switchto_Mainwindow() throws InterruptedException{
         driver.switchTo().window(ProductCreateWindow);         
        }
        
        public void productnamegenerate(){
      ProductName= "Automationtest"+d;
      WebElement xProductname = driver.findElement(By.xpath(New_Products_Name_Textfield));
      xProductname.sendKeys(ProductName);
     }  

     public void GenerateAndEnterUPC(){
      guitils.generaterandomupc();
         WebElement UPCName = driver.findElement(By.xpath(New_Products_UPC_Textfield));
         UPCName.sendKeys(UPCproduct);
         //driver.findElement(By.xpath(New_Products_Search_Button)).click();
      
     }
}