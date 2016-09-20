package com.test.regression.cub.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
   
     ReadPropertiesFile properties = new ReadPropertiesFile();
     
     
   @BeforeMethod
     public void initialization(Method method) throws InterruptedException, IOException {
	   
	   
	   log.info("***************************************************************");
	   
	   log.info("Starting " + method.getName() + " ................");
	   
	   log.info("***************************************************************");
	   
    	 _driver = InitializeDriver(properties.getPropValue("browser"));
    	 	 _driver.get(properties.getPropValue("testURL"));
    	 
    	 log.info("Launched "+ properties.getPropValue("testURL") + " Successfully!");
         
     }

 	
 	public WebDriver InitializeDriver(String browser) throws InterruptedException {
 		 		 
 		  if(browser.equalsIgnoreCase("firefox")) {
 			 	
 			
 			 //System.setProperty("webdriver.firefox.driver", "./exeFiles/firefox.exe");
 			 _driver = new FirefoxDriver();
 			 System.out.println("Mozilla Launched Successfully!!");
 		 
 		  }else if(browser.equalsIgnoreCase("chrome")){
 			  
 			 ChromeOptions options = new ChromeOptions();
 			options.addArguments("chrome.switches","--disable-extensions");
 			//System.setProperty("webdriver.chrome.driver",(System.getProperty("user.dir") + "//src//test//resources//chromedriver_new.exe"));
 			
 			  
 			  System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver2.23.exe");
 			 
 			  _driver = new ChromeDriver(options);
 			  System.out.println("Chrome Launched Successfully!!");
 		  }
 		  
 		  else if (browser.equalsIgnoreCase("ie")) { 


 				DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
 				  capabilitiesIE.setCapability(
 				      InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
 				      capabilitiesIE.setCapability("nativeEvents", false);
 			     capabilitiesIE.setCapability("ie.ensureCleanSession", true);
 			  
 			 System.setProperty("webdriver.ie.driver","./exeFiles/IEDriverServer.exe");
 				      
 			  Thread.sleep(5000);
 			  
 				  
 				System.setProperty("webdriver.ie.driver","./exeFiles/IEDriverServer.exe");
 				   _driver = new InternetExplorerDriver(capabilitiesIE);

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
	        waitFor(webElement, 60);
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

