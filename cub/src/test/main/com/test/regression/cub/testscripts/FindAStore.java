package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.pages.FindAStorePage;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class FindAStore extends SuiteBase {

	CubHome cubHome;
	FindAStorePage findastore;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	
	//GUEST USER SELECTING STORE
		/*@Test(priority=1)
		public void ZipCodeUser() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException
		{
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
			
			findastore = new FindAStore(_driver);
			
			log.info("Find a Store page is launched");
			findastore.clickFindAStore();
			findastore.enterZipCode(zipcode);
	
			findastore.clicksearchbutton();
		
			findastore.clickMakemyStore();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Store", title);
			log.info("Store Locations Page-Success" );
			closeDriver(_driver);
			
		}
		@Test(priority=2)
		public void CityName() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException
		{
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String cityname = StoreData.get("CityName");
			String state = StoreData.get("State");
			
			findastore = new FindAStore(_driver);
			
			log.info("Find a Store page is launched");
			findastore.clickFindAStore();
			findastore.entercity(cityname);
			
			findastore.selectstate(state);
			
			findastore.clicksearchbutton();
			
			findastore.clickMakemyStore();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Store", title);
			log.info("Store Locations Page-Success" );	
			
		}
		
		//SIGN IN User with ZIPCODE
		
		@Test(priority=3)
		public void validLogin()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
			
			cubHome = new CubHome(_driver);
			
				log.info("User Name : " + userId);
				log.info("Password : " + password);
				log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
				log.info("SignIn Link Clicked");
			cubHome.enterLoginDetails(userId, password);
				log.info("Entered login Details");
			cubHome.clickSignInButton();
				log.info("SignInButton Clicked");
				log.info("Entered all details and clicked on Sign In Button");
				
				findastore = new FindAStore(_driver);
				Thread.sleep(5000);
				log.info("Find a Store page is launched");
				
				WebElement element = _driver.findElement(By.xpath("//a[text()='Find a Store']"));
				
				element.click();
		
				findastore.clickFindAStore();
				findastore.enterZipCode(zipcode);
		
				findastore.clicksearchbutton();
			
				findastore.clickMakemyStore();
				String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Store", title);
			log.info("Store Locations Page-Success" );
				closeDriver(_driver);
		}
		
		//SIGN IN User with CITY and STATE
		
		@Test(priority=4)
		public void validLoginCity()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String cityname = StoreData.get("CityName");
			String state = StoreData.get("State");
			
			cubHome = new CubHome(_driver);
			
				log.info("User Name : " + userId);
				log.info("Password : " + password);
				log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
				log.info("SignIn Link Clicked");
			cubHome.enterLoginDetails(userId, password);
				log.info("Entered login Details");
			cubHome.clickSignInButton();
				log.info("SignInButton Clicked");
				log.info("Entered all details and clicked on Sign In Button");
				
				findastore = new FindAStore(_driver);
				Thread.sleep(5000);
				log.info("Find a Store page is launched");
				
				WebElement element = _driver.findElement(By.xpath("//a[text()='Find a Store']"));
				
				element.click();
				findastore = new FindAStore(_driver);
				
				log.info("Find a Store page is launched");
				findastore.clickFindAStore();
				findastore.entercity(cityname);
				
				findastore.selectstate(state);
				
				findastore.clicksearchbutton();
				
				findastore.clickMakemyStore();	
				
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Store", title);
			log.info("Store Locations Page-Success" );
			closeDriver(_driver);
	}*/
		
/*	//SIGN IN USER for 20 Miles
		@Test(priority=5)
		public void UserFor20Miles()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String cityname = StoreData.get("CityName");
			String state = StoreData.get("State");
			
			cubHome = new CubHome(_driver);
			
				log.info("User Name : " + userId);
				log.info("Password : " + password);
				log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
				log.info("SignIn Link Clicked");
			cubHome.enterLoginDetails(userId, password);
				log.info("Entered login Details");
			cubHome.clickSignInButton();
				log.info("SignInButton Clicked");
				log.info("Entered all details and clicked on Sign In Button");
				
				findastore = new FindAStore(_driver);
				Thread.sleep(5000);
				log.info("Find a Store page is launched");
				
				WebElement element = _driver.findElement(By.xpath("//a[text()='Find a Store']"));
				element.click();
				
				log.info("Find a Store page is launched");
				findastore.clickFindAStore();
				findastore.entercity(cityname);
				
				findastore.selectstate(state);
				
				Select sel = new Select(_driver.findElement(By.id("find-radius")));
			       sel.selectByVisibleText("20 Miles");
			       
				findastore.clicksearchbutton();
				
				findastore.clickMakemyStore();	
				Thread.sleep(2000);
				String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Store", title);
			log.info("Store Locations Page-Success" );
				closeDriver(_driver);
		}
		
		//SIGN IN USER for 50 Miles
		
		@Test(priority=6)
		public void UserFor50Miles()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String cityname = StoreData.get("CityName");
			String state = StoreData.get("State");
			
			cubHome = new CubHome(_driver);
			
				log.info("User Name : " + userId);
				log.info("Password : " + password);
				log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
				log.info("SignIn Link Clicked");
			cubHome.enterLoginDetails(userId, password);
				log.info("Entered login Details");
			cubHome.clickSignInButton();
				log.info("SignInButton Clicked");
				log.info("Entered all details and clicked on Sign In Button");
				
				findastore = new FindAStore(_driver);
				Thread.sleep(5000);
				log.info("Find a Store page is launched");
				
				WebElement element = _driver.findElement(By.xpath("//a[text()='Find a Store']"));
				element.click();
				
				log.info("Find a Store page is launched");
				findastore.clickFindAStore();
				findastore.entercity(cityname);
				
				findastore.selectstate(state);
				
				Select sel = new Select(_driver.findElement(By.id("find-radius")));
			       sel.selectByVisibleText("50 Miles");
			       
				findastore.clicksearchbutton();
				
				findastore.clickMakemyStore();	
				Thread.sleep(2000);
				String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - View Store", title);
			log.info("Store Locations Page-Success" );
				closeDriver(_driver);
		}
		
		//SIGN IN USER for 100 Miles
		
		@Test(priority=7)
		public void UserFor100Miles()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String cityname = StoreData.get("CityName");
			String state = StoreData.get("State");
			
			cubHome = new CubHome(_driver);
			
				log.info("User Name : " + userId);
				log.info("Password : " + password);
				log.info("Cub Home page is launched");
			cubHome.clickSignInLink();
				log.info("SignIn Link Clicked");
			cubHome.enterLoginDetails(userId, password);
				log.info("Entered login Details");
			cubHome.clickSignInButton();
				log.info("SignInButton Clicked");
				log.info("Entered all details and clicked on Sign In Button");
				
				findastore = new FindAStore(_driver);
				Thread.sleep(5000);
				log.info("Find a Store page is launched");
				
				WebElement element = _driver.findElement(By.xpath("//a[text()='Find a Store']"));
				element.click();
				
				log.info("Find a Store page is launched");
				findastore.clickFindAStore();
				findastore.entercity(cityname);
				
				findastore.selectstate(state);
				
				Select sel = new Select(_driver.findElement(By.id("find-radius")));
			       sel.selectByVisibleText("100 Miles");
			       
				findastore.clicksearchbutton();
				
				findastore.clickMakemyStore();	
				Thread.sleep(2000);
				closeDriver(_driver);
		}*/
		
		//Checking miles
		
		/*@Test(priority=8)
		
		public void Miles20() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException
		{
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
			int results=0;
			findastore = new FindAStore(_driver);
			
			log.info("Find a Store page is launched");
			findastore.clickFindAStore();
			findastore.enterZipCode(zipcode);
			Select sel1 = new Select(_driver.findElement(By.id("find-radius")));
		       sel1.selectByVisibleText("20 Miles");
		       findastore.clicksearchbutton();
		       
		      int H1 = findastore.results(results);
		       Thread.sleep(1000);
		       findastore.clickFindAStore();
		       findastore.enterZipCode(zipcode);
		       Select sel2 = new Select(_driver.findElement(By.id("find-radius")));
		       sel2.selectByVisibleText("50 Miles");
		       findastore.clicksearchbutton();
		     int H2 = findastore.results(results);
		       
		     if(H2 > H1){
		    	 Assert.assertTrue(true);
		    	 System.out.println("Pass");
		     }else{
		    	 Assert.assertTrue(false);
		    	 System.out.println("Fail");
		     }
			//findastore.clickMakemyStore();
			closeDriver(_driver);
			}
		
@Test(priority=9)
		
		public void Miles50() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException
		{
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
			int results=0;
			findastore = new FindAStore(_driver);
			
			log.info("Find a Store page is launched");
			findastore.clickFindAStore();
			findastore.enterZipCode(zipcode);
			Select sel1 = new Select(_driver.findElement(By.id("find-radius")));
		       sel1.selectByVisibleText("50 Miles");
		       findastore.clicksearchbutton();
		       
		      int H1 = findastore.results(results);
		       Thread.sleep(1000);
		       findastore.clickFindAStore();
		       findastore.enterZipCode(zipcode);
		       Select sel2 = new Select(_driver.findElement(By.id("find-radius")));
		       sel2.selectByVisibleText("100 Miles");
		       findastore.clicksearchbutton();
		     int H2 = findastore.results(results);
		       
		     if(H2 > H1){
		    	 Assert.assertTrue(true);
		    	 System.out.println("Pass");
		     }else{
		    	 Assert.assertTrue(false);
		    	 System.out.println("Fail");
		     }
			//findastore.clickMakemyStore();
			closeDriver(_driver);
			}*/

//Check for Change store option present in Savings page for GUEST USER

/*	@Test(priority=10)
	
	public void ChangeStore() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{
		Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
		String zipcode = StoreData.get("ZipCode");
		String Add1=null;
		String Add2=null;
		findastore = new FindAStore(_driver);
		
		log.info("Find a Store page is launched");
		findastore.clickOnSavings();
		Thread.sleep(1000);
		findastore.clickOnChange();
		Thread.sleep(1000);
		findastore.enterzip(zipcode);
		findastore.clickOnSearch();
		Thread.sleep(2000);
		
		findastore.clickOnStore();
		Thread.sleep(5000);		
		String Address1=findastore.AddressSavings(Add1);
		System.out.println(Address1);
		findastore.clickOnusestore();
		Thread.sleep(5000);
		String Address3=findastore.Address2Departments(Add2);
	      findastore.clickOnDepartments();
	      Thread.sleep(5000);
	      String Address2=findastore.Address2Departments(Add2);
	      System.out.println(Address2);
	       
	     Assert.assertTrue(Address1.equals(Address2));
	      System.out.println("pass");
		closeDriver(_driver);
		}*/

//Clicking on View Stores by State
	@Test(priority=11)
	public void StoresbyState() throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException
	{
		findastore = new FindAStorePage(_driver);
		//State1
		log.info("Find a Store page is launched");
		findastore.clickFindAStore();
		findastore.ClickState1();
		 Thread.sleep(2000);
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - View Stores by State", title);
		
		findastore.ClickStore();
		 Thread.sleep(2000);
		String title1=_driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("Cub Foods - View Store", title1);
		log.info("Store Locations Page-Success" );
		 Thread.sleep(2000);
		 
		//State2 
		 log.info("Find a Store page is launched");
		findastore.clickFindAStore();
		findastore.ClickState2();
		Thread.sleep(2000);
		Assert.assertEquals("Cub Foods - View Stores by State", title); 
		findastore.ClickStore();
		Assert.assertEquals("Cub Foods - View Store", title1);
		log.info("Store Locations Page-Success" );
		Thread.sleep(2000);
			
	}
		
	}

