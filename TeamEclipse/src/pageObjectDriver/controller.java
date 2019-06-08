package pageObjectDriver;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import GenericUtils.Utilities;
import pageObjectReports.Reports;

public class controller  {

	public static WebDriver _driver = null;
	public static ExtentReports _extent=null;
	//Utilities utils = new Utilities();
	


	@BeforeSuite
	//@Parameters("browser")
	public void before() throws IOException, InterruptedException 
	{
		String browserName = Utilities.getDatafrompropfile("BrowserName");
		System.out.println("user.dir: " + System.getProperty("user.dir"));
		
		System.out.println("Browser selected"+browserName);
		this.launchBrowser(browserName);		
		
		//TimeUnit.SECONDS.sleep(1);
		_driver.manage().window().maximize();

		_driver.get(Utilities.getDatafrompropfile("url"));
		_extent = Reports.startReport();
	}

	@AfterTest
	public void after() 
	{
		_extent.close();

		if(_driver!=null)
			_driver.close();
	}
	
	public void launchBrowser(String browserName)
	{

		if(browserName.contains("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//driver//chromedriver_win32//chromedriver.exe");
			_driver = new ChromeDriver();
		}
		else if(browserName.contains("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//driver//geckodriver//geckodriver.exe");
			_driver = new FirefoxDriver();
		}
		else if(browserName.contains("InternetExplorer")) 
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "//driver//IEDriverServer//IEDriverServer.exe");
			_driver = new InternetExplorerDriver();
		}
		else
		{
			System.err.print("Browser is Null");
		}
	}
}
