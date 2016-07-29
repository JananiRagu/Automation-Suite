package com.test.regression.cub.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.test.regression.cub.utils.Constant;

public class SuiteBase {	
	
	Logger log = Logg.createLogger();
	protected static WebDriver _driver;
	
	@BeforeSuite(alwaysRun = true)
	public void DataSetUp(){
		UpdateXML dataUpdateObj = new UpdateXML();
		dataUpdateObj.updateTestData();
	}
 
	@AfterMethod
	public void closeDriver(Method method)
	{
		
		_driver.quit();
		
		log.info(method.getName() + " execution Complete.............");
		
	}
	
    
     @AfterMethod
 	public void breakDown(ITestResult result)
 	{
 		if(result.getStatus()==ITestResult.FAILURE)
 		{
 			CaptureScreenShot(_driver, result.getName());
 			
 	}
 	}
   
       
   @BeforeMethod
     public void initialization(Method method) {
	   
	   
	   log.info("***************************************************************");
	   
	   log.info("Starting " + method.getName() + " ................");
	   
	   log.info("***************************************************************");
	   
    	 _driver = InitializeDriver(Constant.browser_name);
    	 _driver.get(Constant.URL);
    	 
    	 log.info("Launched "+ Constant.URL + " Successfully!");
         
     }

 	
 	public WebDriver InitializeDriver(String browser) {
 		 		 
 		  if(browser.equalsIgnoreCase("firefox")) {
 			 		  
 			
 			 //System.setProperty("webdriver.firefox.driver", "./exeFiles/firefox.exe");
 			  _driver = new FirefoxDriver(); 
 			 //System.out.println("Firefox properties ::: " +System.getProperty("webdriver.firefox.driver")); */
 		 
 		  }else if(browser.equalsIgnoreCase("chrome")){
 			  
 			  System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");
 			 
 			  _driver = new ChromeDriver();
 			  System.out.println("Chrome Launched Successfully!!");
 		  }
 		  else if (browser.equalsIgnoreCase("ie")) { 
 		 
 			  // Here I am setting up the path for my IEDriver
 			  //File file = new File("C:\\Program Files\\Internet Explorer\\iexplore.exe");
 			 
 			 DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
 			  capabilitiesIE.setCapability(
 			      InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
 			      capabilitiesIE.setCapability("nativeEvents", false);
 			      capabilitiesIE.setCapability("initialBrowserUrl", "https://www.google.com");
 			      System.setProperty("webdriver.ie.driver","./exeFiles/IE11.exe");
 			      System.out.println(System.getProperty("webdriver.ie.driver"));
 			      System.out.println("ie abt to initialize.....");
 			   _driver = new InternetExplorerDriver(capabilitiesIE);
 		 
 			  /*System.setProperty("webdriver.ie.driver", "./exe/iexplore.exe");*/
 			  
 			  //_driver = new InternetExplorerDriver();
 			  System.out.println("Initialized IE!!!");
 			  
 		 
 		  } 
 		_driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
 		_driver.manage().window().maximize();
 		return _driver;
 		
 }
     // Method to capture screenshot
     public static void CaptureScreenShot(WebDriver driver,String screenshotName)
		{
					try 
			{
				TakesScreenshot tsc=(TakesScreenshot)driver;
				File source = tsc.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./screenShot/"+screenshotName+".png") );
			
			}
			catch (Exception e) {
				e.printStackTrace();
			} 
			
		}  
     
     
 	public void waitFor(WebElement webElement, int sec){
		WebDriverWait wait = new WebDriverWait(getDriver(), sec);
        wait.until(ExpectedConditions.visibilityOf(webElement));
     
	}
	 public void waitFor(WebElement webElement){
	        waitFor(webElement, 30);
	 }
	 
	  public void setDriver(WebDriver driver) {
          _driver = driver;
	  }

/**
* Retrieve the current WebDriver for this page.
*
* @return The selenium WebDriver instance for this page.
*/
	  public WebDriver getDriver() {
          return _driver;
	  }
 }

