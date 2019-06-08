package GenericUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectDriver.controller;


public class Utilities extends controller
{
	public static WebDriver driver=null;
	public WebDriverWait wait=null;

    static Actions action = new Actions(driver);
    
    
public void toClickElement(WebElement element) throws InterruptedException 
	
	{
		waitForElementToBeClickable(element).click();
	}

    
protected WebElement waitForElementToBeClickable(WebElement element)
{
	
	wait = new WebDriverWait(driver,20);
	return wait.until(ExpectedConditions.elementToBeClickable(element)); 

}

//To check button is enabled
	public boolean toChkBtnEnabled(WebElement element) throws InterruptedException 
	{
		return element.isEnabled();
	}
	
	// To check button is dispalyed
	public boolean toChkBtnDisplayed(WebElement element) throws InterruptedException 
	{
		return element.isDisplayed();
		
	}
	
	// To click button
		public void toChkBtnclicked(WebElement element) throws InterruptedException
		{
			 element.click();
		 }

	
	// Method to select value from any dropdown
		public void selectfromDropdownByVisibleText(WebElement drpdwnElement, String dropdownText) throws InterruptedException 
		{

			Select selectDropdown = new Select(drpdwnElement);
			selectDropdown.selectByVisibleText(dropdownText);
			}
		
		// Method to select value from any dropdown
		public void selectfromDropdownByValue(WebElement drpdwnElement, String dropdownText) throws InterruptedException 
				{

					Select selectDropdown = new Select(drpdwnElement);
					selectDropdown.deselectByValue(dropdownText);
					}
				
		// Method to select value from any dropdown
				public void deSelectfromDropdownByVisibleText(WebElement drpdwnElement, String dropdownText) throws InterruptedException 
				{

					Select selectDropdown = new Select(drpdwnElement);
					selectDropdown.deselectByVisibleText(dropdownText);
					}
				
				
				public String toSelectfromDropdown(By locator, String Data) {
					String retval = null;
					List<WebElement> options = driver.findElements(locator);
					try {
						for (int i = 0; i < options.size(); i++) {
							if (options.get(i).getText().equalsIgnoreCase(Data)) {
								options.get(i).click();
								Thread.sleep(1000);
							}
							retval = options.get(i).getText();
						}

					} catch (Exception e) {

						e.printStackTrace();
					}
					return retval;
				}
				
				
				public boolean tocheckdisplayed(WebElement element) {

					return element.isDisplayed();
				}

				public boolean tocheckdisplayed(By locator) {
					return driver.findElements(locator).size() > 0;
				}

				public void toScrollDown() {
					((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

				}

				public void toScrolltoWebElement(WebElement testElement) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", testElement);
				}

				public void toScrolltoBylocator(By locator) {
					WebElement testElement = driver.findElement(locator);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", testElement);
				}
				
				public void toClickByWebElement(WebElement element)
				{
					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
				}
				
				public void toClickLink(By locator) throws InterruptedException {
					driver.findElement(locator).click();

				}
				public void toGetInnerText(WebElement element,String Xpath ) {
				
					element = driver.findElement(By.xpath(Xpath));
					String value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML",
							element);
				}


				public void toClickWebElement(WebElement element) throws InterruptedException {
					element.click();

				}
				



				public String getWebElementtext(WebElement element) throws InterruptedException {
					String strValue = element.getText();
					return strValue;
				}
				

				// Method to enter the data into text box
				public void toEnterData(By locator, String testValue) {
					driver.findElement(locator).sendKeys(testValue);
				}

				public String DataEntry(WebElement element, String Value) {

					element.sendKeys(Value);
					return Value;
				}

				// Method to clear the data from text box
				public void toClearData(By locator) {
					driver.findElement(locator).clear();
				}
				
				public String getDataFromTextBox(By locator) {
					return driver.findElement(locator).getAttribute("value");
				}
				
				public void controlToChildWindow() throws Exception {
					String winHandleBefore = driver.getWindowHandle();
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						System.out.println(driver.switchTo().window(winHandle));

					}
					driver.switchTo().window(winHandleBefore);
				}
				

				public void toScroll(int value,int value2)
				   {
				   ((JavascriptExecutor) driver).executeScript("scroll+("+value+"," +value2+");"); 
				   }
				
				
				
				public void sendValues(WebElement name, String Values) {

					name.sendKeys(Values);

				}
				 public static void mouseHover(WebDriver driver, String MousehoverElement, String ClickElementPath) {

		              
					 action.moveToElement(driver.findElement(By.xpath(MousehoverElement))).build().perform();
		               driver.findElement(By.xpath(ClickElementPath)).click();

		        }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	// function to generate a random string of length n 
    public String getAlphaNumericString(String name,int n) 
    { 
    	
    	int stringLength = name.length();
    	n = n-stringLength;
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return name + "_" + sb.toString(); 
    } 
    
    public String getRandomString(String name,int n){
    	
    	int stringLength = name.length();
    	n = n-stringLength;
        // chose a Character random from this String 
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(randomString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(randomString 
                          .charAt(index)); 
        } 
  
        return name + "_" + sb.toString(); 
    	
    }
    
    
    //Not wroking need to check
    public int getRandomNumber(int n){
    	
        // chose a Character random from this String 
        String randomString = "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
        
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(randomString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
          sb.append(randomString 
                          .charAt(index)); 
        } 
   
        int randomNumber = Integer.parseInt( sb.toString());
        int numb2 = Integer.parseUnsignedInt(sb.toString());
        System.out.println(numb2);
        return randomNumber; 
    		
    	
    }
    
    
    
    public void switchWindow(){
    	
    	// It will return the parent window name as a String
    	 String mainWindow=_driver.getWindowHandle();
    	 // It returns no. of windows opened by WebDriver and will return Set of Strings
    	 Set<String> set =_driver.getWindowHandles();
    	 // Using Iterator to iterate with in windows
    	 Iterator<String> itr= set.iterator();
    	 while(itr.hasNext()){
    	 String childWindow=itr.next();
    	    // Compare whether the main windows is not equal to child window. If not equal, we will close.
    	 if(!mainWindow.equals(childWindow)){
    		 _driver.switchTo().window(childWindow);
    	 System.out.println(_driver.switchTo().window(childWindow).getTitle());
    	 }
    	 }
    	
    }
    
    public void switchToMainWindow(String mainWindow){
    	// This is to switch to the main window
   	 _driver.switchTo().window(mainWindow);
    }
    
    public void closeChildWindow(){
    	
    	 _driver.close();
    	
    }
    
    
     public void dragAndDrop(By locatorToBeDragged,By locatorToBeDropped ){
    	 
    	 
    	//Element(BANK) which need to drag.		
         WebElement From=_driver.findElement(locatorToBeDragged);	
         
	
         WebElement To = _driver.findElement(locatorToBeDropped);
       
         //Using Action class for drag and drop.							
       
         //Drag and Drop by Pixel.		
         action.dragAndDrop(From,To).build().perform();	 	 
    	 
     }
    
    
    
 	public boolean compareDates(String dos,String doi) throws ParseException, FilloException, IOException, InterruptedException
 	{
 		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

 		Date ddos = format.parse(dos);
 		System.out.println("DDOS--->"+ddos);
 		Date ddoi = format.parse(doi);
 		System.out.println("DDOI--->"+ddoi);

 		return ddos.compareTo(ddoi) < 0;

 	}
    
    
 // To get the system date
 	public String GetDateFromSystem(String replaced) {
 		Date myDate = new Date();
 		String convertLocDate = new SimpleDateFormat("MM-dd-yyyy").format(myDate);
 		replaced = convertLocDate.replace("-", "/");
 		System.out.println(replaced);
 		return replaced;
 	}

 	public String systemDate(String replaced)
 	{
 		Date myDate = new Date();
 		String convertLocDate = new SimpleDateFormat("M-d-yyyy").format(myDate);
 		replaced = convertLocDate.replace("-", "/");
 		System.out.println(replaced);
 		return replaced;
 	}

 	public String getnextDayDate()
 	{
 		int MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
 		Date date = new Date();
 		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
 		String prevDate = dateFormat.format(date.getTime() - MILLIS_IN_DAY);
 		String currDate = dateFormat.format(date.getTime());
 		String nextDate = dateFormat.format(date.getTime() + MILLIS_IN_DAY);
 		System.out.println("Previous date: " + prevDate);
 		System.out.println("Currnent date: " + currDate);
 		System.out.println("Next date: " + nextDate);
 		return nextDate;
 	}
    
    
    
 	public static  void waitForLoad()
	{
		/*ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>()
	        {
	                   @Override
						public Boolean apply(WebDriver driver) {

							return ((JavascriptExecutor)_driver).executeScript("return document.readyState").equals("complete");
						}
	                };
	        WebDriverWait wait = new WebDriverWait(_driver, 50);
	        wait.until(pageLoadCondition);*/


		WebDriverWait wait = new WebDriverWait(_driver, 120);

		wait.until(new ExpectedCondition<Boolean>() 
		{
			public Boolean apply(WebDriver wdriver) 
			{
				return ((JavascriptExecutor)_driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	// wait to handle alert window
	public static void alerthandle()
	{

		try {
			
			//wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = _driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println(alertText);
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();	 
		}

	}



	// fluent wait in generic method
	public static WebElement waitFluent(By locator) 
	{

		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(_driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class); // declare wait

		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver anydriver)
			{
				return anydriver.findElement(locator); // find that element
			}

		});

		return element; // return webElement instance

	}

	public static void pageload()
	{
		_driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}


	public static WebElement Waitclick(By locator,int time)
	{

		WebElement ele = null;

		for(int i=0;i<time;i++)

		{
			try{
				ele=_driver.findElement(locator);
				break;
			}
			catch(Exception e)
			{
				try 
				{
					Thread.sleep(1000);
				} catch (InterruptedException e1) 
				{
					System.out.println("Waiting for element to appear on DOM");
				}
			}


		}
		return ele;

	}

	public static void handleAlert()
	{
		
			WebDriverWait wait = new WebDriverWait(_driver,10);
			if(wait.until(ExpectedConditions.alertIsPresent())!=null)
			{
			//Alert alert= _driver.switchTo().alert();
			_driver.switchTo().alert().accept();
			}
			else
			{
				System.out.println("Alert is not present");
			}
							
		} 
	
	public  void handleAlerts(ExtentTest HndleAlert) throws InterruptedException
	{		
		
		
		if(alert()==true)
		{
			Thread.sleep(2000);
			Alert alert = _driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println(alertText);
			HndleAlert.log(LogStatus.PASS, "Alert Text is ' <b>"+alertText+"</b> '");
			alert.accept();
		}
		else
		{
			System.out.println("Alert is not present");
			//HndleAlert.log(LogStatus.INFO, "Alert is not Present");
		}
		

	} 
	
	public  boolean alert() 
	{
	boolean result= false;
	try {
		_driver.switchTo().alert();		
		result=true;
		return result;
	}
		catch(Exception e) 
	{
			return result;
		}
	} 
 	
 	
 	
 	
 	
	public static String getDatafrompropfile(String Key)  
	{

		String value = null;
		File file = new File(System.getProperty("user.dir") + "\\src\\pageObjectData\\contantData.properties");

		try 
		{
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			value = properties.getProperty(Key);

			if(Key.equalsIgnoreCase("url"))
			{
				value = properties.getProperty(Key);
			}
			else				
			{
				value = System.getProperty("user.dir") + "\\src\\pageObjectData\\" + properties.getProperty(Key);
			}

		} 
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		return value;
	}

 	
 	
 	
 	
 	
 	
 	
 	
 	
	
}
