package utils.common;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UISelenenum {
	
	 String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	    String DATE_FORMAT_DATE = "yyyy-MM-dd";
	    String DATE_FORMAT_TODAY_DATE = "M/d/yyyy";
	    String DATE_FORMAT_TODAY_DATE_TIME = "M/dd/yyyy hh:mm a";
	    String DATE_FORMAT_TODAY_DATE_TIME2 = "M/d/yyyy hh:mm a";
	    
	    private WebDriver driver1;
	    
		//WebDriverWait wait = new WebDriverWait(driver1, 15);

	///    public String testRunAt;
	    
	 /*   public UISikuliSelenium() {
		testRunAt = getTestRunStartTime();
	    }
	*/
	    public String findLastWindowOpenedAndReturnParent(WebDriver driver) {
		String parentWindowHandle = driver.getWindowHandle(); // save the current window handle.
		WebDriver popup = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windowIterator = handles.iterator();
		while (windowIterator.hasNext()) {
		    String windowHandle = windowIterator.next();
		    popup = driver.switchTo().window(windowHandle);
		    /*
		     * if (popup.getTitle().contains("Search")) { break; }
		     */
		}
		return parentWindowHandle;
	    }

	    public void waitForElement(WebDriver driver, int numberOfSeconds, By elementLocator) throws Exception
	    {
	    	WebDriverWait waiting = new WebDriverWait(driver, numberOfSeconds);
	    	waiting.until(ExpectedConditions.presenceOfElementLocated(elementLocator));		
	    }

	    public boolean isElementPresentID(WebDriver driver, String elementID) {
		boolean elementExist;
		elementExist = false;
		if (driver.findElements(By.id(elementID)).size() != 0) {
		    elementExist = true;
		}
		return elementExist;
	    }

	    public boolean isElementPresentXPATH(WebDriver driver, String elementXPATH) {
		boolean elementExist;
		elementExist = false;
		if (driver.findElements(By.xpath(elementXPATH)).size() != 0) {
		    elementExist = true;
		}
		return elementExist;
	    }

	    public String getIdFromURL(WebDriver driver) {
		String id = "";
		String url = driver.getCurrentUrl();
		System.out.println(" ");
	///	int index = globalConf.getSfdcUrl().length();
	///	id = url.substring(index + 3, url.length());

		return id;
	    }

	    public boolean isPresent(String text, By by, WebDriver driver) throws Exception {
		WebElement element2 = driver.findElement(by);
		String foundText = element2.getText();

		return text == foundText;
	    }

	    public String isCheckboxChecked(By by, WebDriver driver) throws Exception {
		WebElement elem = driver.findElement(by);
		String checkboxVal = elem.getAttribute("title");

		return checkboxVal;

	    }

	    public void checkForErrors(WebDriver driver) {
		System.out.println("Xpath size" + driver.findElements(By.xpath("//div[@class='pbError']")).size());
		System.out.println(driver.findElements(By.xpath("//div[@class='pbError']")).listIterator().toString());
	    }

	    public String getText(By by, WebDriver driver) throws Exception {
		WebElement elem = driver.findElement(by);
		String textVal = elem.getText();

		return textVal;
	    }

	    public boolean isElementPresent(By by, WebDriver driver) throws Exception {
		WebElement element = driver.findElement(by);

		return element == null;
	    }

	    public boolean isElementPresentID1(WebDriver driver, String elementID) {
		boolean elementExist;
		elementExist = false;
		if (driver.findElements(By.id(elementID)).size() != 0) {
		    elementExist = true;
		}
		return elementExist;
	    }

	    public boolean isElementPresentXPATH1(WebDriver driver, String elementXPATH) {
		boolean elementExist;
		elementExist = false;
		if (driver.findElements(By.xpath(elementXPATH)).size() != 0) {
		    elementExist = true;
		}
		return elementExist;
	    }

	    public String getElementLocatorIdByLabelTextUsingForAttribute(WebDriver driver, String labelText) {
	    	/// sample call
	    	/// locatorId = getElementLocatorIdByLabelTextUsingForAttribute(driver, "Type");
	    	/// locator ID in locators file will look like "Type"
	    	String locatorId;
	     	locatorId = driver.findElement(By.xpath("//label[text()='" + labelText + "']")).getAttribute("for");  
	     	return locatorId;
	    }
	    
	   /* public void ZoomIn() throws Throwable{
	    	
	    	if(System.getProperty("os.name").toLowerCase().contains("win")){
	    		for(int i=0; i<2; i++){
	                driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	            }
	    	}
	    	else if(System.getProperty("os.name").toLowerCase().contains("mac")){
	    		for(int i=0; i<2; i++){
	                driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
	            }
	    	}	    	
	    }*/

}
