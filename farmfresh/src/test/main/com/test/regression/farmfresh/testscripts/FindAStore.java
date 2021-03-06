
/********************************************************FAS TESTING*******************************************************************************************************************************
 * 
 * ================================================================================================================================================================================================
 *                                  Test Cases Covered as part of FAS Functionality
 * ================================================================================================================================================================================================
 * 
 * TC 1. 'setStoreGuestZipCode'                       =>   Sets the Store for a guest user having zipcode                                                                                      
 * 
 * TC 2. 'setStoreGuestCityState'                     =>   Sets the Store for a guest user having city and state name
 * 
 * TC 3. 'setStoreGueststreetname'                    =>   Sets the store for a guest user having Street name
 * 
 * TC 4. 'setStoreAuthorizedZipCode'                  =>   Sets the store for a authorized user having ZipCode                                                                   
 * 
 * TC 5. 'setStoreAuthorizedCityState'        		  =>   Sets the store for a authorized user having City and State                                                
 * 
 * TC 6. 'Miles20'                                    =>   Sets the store for a authorized user having ZipCode and setting the Miles as 20                                                          
 * 
 * TC 7. 'Miles50'  								  =>   Sets the store for a authorized user having ZipCode and setting the Miles as 50                                                             
 * 
 * TC 8. 'changeStoreFromDifferentPages'              =>   Sets the store for a authorized user from one page and validating the changed store in other page                                                                                       *
 * 
 * TC 9. 'StoresbyState'                              =>   Validates stores by the given states
 * 
 * TC 10. 'mapanddriving'							  =>   Validates Maps and the driving directions of selected store
 * 
 * TC 11. 'invalidzipcode'							  =>   Validate for invalid ZipCodes
 * 
 * TC 12. 'Pagination'                                =>   Validates Pagination of FAS page
 * 
 * TC 13. 'validSignUpandsetstore'	                  =>   Sets the store during Sign Up
 * 
 * TC 14. 'invalidCityStreet'                         =>   Validate for invalid city and street name
 * 
 * TC 15. 'pharmacyFASwidget'                         =>   Validate for FAS widget in Pharmacy page
 * 
 * ================================================================================================================================================================================================
 */

package com.test.regression.farmfresh.testscripts;

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
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.pages.FindAStorePage;
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.SignUpPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;

public class FindAStore extends SuiteBase {

	FFHome cubHome;
	FindAStorePage findastore;
	SignUpPage signUpPage;
	MyAccountPage MyAccount;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	
	//Guest User setting a Store with Zipcode using See store details link
	
		@Test(priority=14, enabled=false)
		public void setStoreGuestZipCode() 
		{
			try{
			
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
			String zipcode = StoreData.get("zipcode");
			
			findastore = new FindAStorePage(_driver);
		
			findastore.clickFindAStore();
			findastore.enterZipCode(zipcode);
	
			findastore.clicksearchbutton();
			findastore.clickseestoredetails();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
			findastore.clickmakemystoreAtseestore();
			String title1=_driver.getTitle();
			System.out.println(title1);
			Assert.assertEquals("Farm Fresh Supermarkets - View Store", title1);
			
			log.info("Store Locations Page-Success" );
			
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
			
		}
		
		//Guest User setting a Store with City and State name
		@Test(priority=15 , enabled=false)
		public void setStoreGuestCityState() 
		{
			try{
				
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
			String cityname = StoreData.get("city");
			String state = StoreData.get("state");
			
			findastore = new FindAStorePage(_driver);
			
				log.info("Find a Store page is launched");
			findastore.clickFindAStore();
			findastore.entercity(cityname);
			
			findastore.selectstate(state);
			
			findastore.clicksearchbutton();
			
			findastore.clickMakemyStore();
				String title=_driver.getTitle();
				System.out.println(title);
			Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
				log.info("Store Locations Page-Success" );	
			
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
		}
		
		//Guest User setting a Store with Street Name,City and State
		@Test(priority=16, enabled=false)
		public void setStoreGueststreetname() 
		{
			try{
			
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
			String street = StoreData.get("StreetAddress");
			String cityname = StoreData.get("city");
			String state = StoreData.get("state");
			String zipcode = StoreData.get("zipcode");
			
			findastore = new FindAStorePage(_driver);
		
			findastore.clickFindAStore();
			//Enter Street address, city and state
			findastore.enterstreetname(street);
			findastore.entercity(cityname);		
			findastore.selectstate(state);
			findastore.clicksearchbutton();
		
			findastore.clickMakemyStore();
			String title=_driver.getTitle();
			System.out.println(title);
			
			Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
			log.info("Store Locations Page-Success" );
				
				//Enter Zipcode and Street Address
			findastore.clickFindAStore();
				
			findastore.enterstreetname(street);
			findastore.enterZipCode(zipcode);
			findastore.clicksearchbutton();
			
			WebElement element = _driver.findElement(By.xpath("//a[text()='Make This My Store']"));
			element.click();
			String title1=_driver.getTitle();
			System.out.println(title1);
				
			Assert.assertEquals("Farm Fresh Supermarkets - View Store", title1);
			
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
			
		}
		//SIGN IN User with ZIPCODE and change store from view store page
		
		@Test(priority=17, enabled=false)
		public void setStoreAuthorizedZipcode() {

		try{
				
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
		String zipcode = StoreData.get("zipcode");

		cubHome = new FFHome(_driver);

			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
		
		cubHome.clickSignInButton();
			Thread.sleep(5000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");

		findastore = new FindAStorePage(_driver);
			Thread.sleep(5000);
			log.info("Find a Store page is launched");

		findastore.clickFAS();
		findastore.enterZipCode(zipcode);
		findastore.clicksearchbutton();
			Thread.sleep(5000);
			WebElement element = _driver.findElement(By.xpath("//a[text()='Make This My Store']"));
			
			element.click();
			Thread.sleep(5000);
			log.info("My Store is set");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
		Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
			log.info("Store Locations Page-Success" );
			
			//Change My Store link in View Store page
			findastore.clickchangemystore();
			Thread.sleep(5000);
			String title1=_driver.getTitle();
			System.out.println(title1);
		Assert.assertEquals("Farm Fresh Supermarkets - Search Stores", title1);
		log.info("Search store page-Success" );

		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
		
	}

		
		//SIGN IN User with CITY 
		@Test(priority=18,enabled=false)
		public void setStoreAuthorizedCityState() {

			try{
				
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
		String cityname = StoreData.get("city");
		String state = StoreData.get("state");


		cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		
		cubHome.enterLoginDetails(userId, password);
		
		cubHome.clickSignInButton();

		findastore = new FindAStorePage(_driver);
			Thread.sleep(10000);
			log.info("Find a Store page is launched");
			Thread.sleep(5000);

		findastore.clickFAS();
		findastore.entercity(cityname);
		findastore.selectstate(state);
		findastore.clicksearchbutton();
			Thread.sleep(5000);		
		WebElement element = _driver.findElement(By.xpath("//a[text()='Make This My Store']"));
		element.click();
		Thread.sleep(5000);
			log.info("My Store is set");	
		Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
		Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
			log.info("Store Locations Page-Success" );

			} catch (InterruptedException ie) {
				log.info(ie.getMessage());
				Assert.fail("Caught Interrupted Exception");
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
		}


		//Checking miles for 20 miles
		
		@Test(priority=19, enabled=false)
		
		public void Miles20() 
		{
			try{
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
			String zipcode = StoreData.get("zipcode");
			int results=0;
			findastore = new FindAStorePage(_driver);
			
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
		     
			} catch (InterruptedException ie) {
				log.info(ie.getMessage());
				Assert.fail("Caught Interrupted Exception");
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
			
			}
		
		//Checking miles for 50 miles
		@Test(priority=20, enabled=false)
		
		public void Miles50()
		{
			try{
				
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
			String zipcode = StoreData.get("zipcode");
			int results=0;
			findastore = new FindAStorePage(_driver);
			
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
			} catch (InterruptedException ie) {
				log.info(ie.getMessage());
				Assert.fail("Caught Interrupted Exception");
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
		
			}

//Check for Change store option present in Savings page for GUEST USER

	@Test(priority=21, enabled=false)
	
	public void changeStoreFromDifferentPages() 
	{
		try{
			
		Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
		String zipcode = StoreData.get("zipcode");
		String Add1=null;
		String Add2=null;
		findastore = new FindAStorePage(_driver);
		
		log.info("Find a Store page is launched");
		findastore.clickOnSavings();
		Thread.sleep(1000);
		findastore.clickOnChange();
		Thread.sleep(1000);
		//Testing for Closepopup
		cubHome = new FFHome(_driver);
		cubHome.clickOnClosePopUp();
		
		findastore.clickOnChange();
		Thread.sleep(3000);
		findastore.enterzip(zipcode);
		Thread.sleep(5000);
		findastore.clickOnSearch();
		Thread.sleep(5000);
		
		findastore.clickOnStore();
		Thread.sleep(50000);		
		String Address1=findastore.SelectAddressSavings(Add1);
		System.out.println(Address1);
		findastore.clickOnusestore();
		Thread.sleep(50000);
		//Store address from Savings page
		String Address3=findastore.Address2Departments(Add2);
		System.out.println(Address3);
	      findastore.clickOnDepartments();
	      Thread.sleep(50000);
	      String Address2=findastore.Address2Departments(Add2);
	      System.out.println(Address2);
	       
	      if(Address3.equals(Address2))
	      {
	     Assert.assertTrue(true);
	      System.out.println("pass");
	      }else{
	    	  Assert.assertTrue(false);
	    	  System.out.println("fail");
	      }
	      
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}

	//Clicking on View Stores by State
	@Test(priority=22, enabled=false)
	public void StoresbyState() 
	{
		try{
			
		findastore = new FindAStorePage(_driver);
		//State1
		log.info("Find a Store page is launched");
		findastore.clickFindAStore();
		findastore.ClickState1();
		 Thread.sleep(2000);
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Farm Fresh Supermarkets - View Stores by State", title);
		
		findastore.ClickStore();
		 Thread.sleep(2000);
		String title1=_driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("Farm Fresh Supermarkets - View Store", title1);
		log.info("Store Locations Page-Success" );
		 Thread.sleep(2000);
		 
		//State2 
		 log.info("Find a Store page is launched");
		findastore.clickFindAStore();
		findastore.ClickState2();
		Thread.sleep(2000);
		Assert.assertEquals("Farm Fresh Supermarkets - View Stores by State", title); 
		findastore.ClickStore();
		Assert.assertEquals("Farm Fresh Supermarkets - View Store", title1);
		log.info("Store Locations Page-Success" );
		Thread.sleep(2000);
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
		
		//Maps and driving directions
	
	@Test(priority=23, enabled=false)
	public void mapanddriving() {

	try{
			
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");
	Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
	String zipcode = StoreData.get("zipcode");
	String startpoint=StoreData.get("Start");

	cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, password);
	
	cubHome.clickSignInButton();
		Thread.sleep(5000);
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");

	findastore = new FindAStorePage(_driver);
		Thread.sleep(5000);
		log.info("Find a Store page is launched");

	findastore.clickFAS();
	findastore.enterZipCode(zipcode);
	findastore.clicksearchbutton();
	Thread.sleep(5000);
	
	WebElement element = _driver.findElement(By.xpath("//a[text()='Make This My Store']"));
		
	element.click();
	Thread.sleep(5000);
	
	log.info("My Store is set");
	
	Thread.sleep(5000);
	String title=_driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
		log.info("Store Locations Page-Success" );
		Thread.sleep(2000);
		findastore.clickmap();
		String title1=_driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
		Thread.sleep(5000);
		
		findastore.clickdriving();
		String title2=_driver.getTitle();
		System.out.println(title2);
		Assert.assertEquals("Farm Fresh Supermarkets - View Store", title);
		log.info("Driving Directions page is displayed");
		Thread.sleep(5000);
		
		findastore.enterlocation(startpoint);
		Thread.sleep(2000);
		findastore.clicksearchlocation();
		Thread.sleep(5000);
		String title3=_driver.getTitle();
		System.out.println(title3);
		Assert.assertEquals("Farm Fresh Supermarkets - Driving Directions", title3);
		log.info("Driving Directions are displayed");
		Thread.sleep(4000);
		
		/*findastore.clickprint();
		Thread.sleep(6000);
		String title4=_driver.getTitle();
		System.out.println(title4);
		Assert.assertEquals("Farm Fresh Supermarkets - Driving Directions", title4);*/

	} catch (InterruptedException ie) {
		log.info(ie.getMessage());
		Assert.fail("Caught Interrupted Exception");
	} catch (IOException ioe) {
		log.info(ioe.getMessage());	
		Assert.fail("Caught IOException Exception");
	} catch (XPathExpressionException xee) {
		log.info(xee.getMessage());	
		Assert.fail("Caught XPathExpressionException Exception");
	} catch (ParserConfigurationException pce) {
		log.info(pce.getMessage());
		Assert.fail("Caught ParserConfigurationException Exception");
	} catch (SAXException saxe) {
		log.info(saxe.getMessage());
		Assert.fail("Caught SAXException Exception");
	} catch (Exception e) {
		log.info(e.getMessage());
		Assert.fail(e.getLocalizedMessage());
	}
	
}
	//Invalid ZipCode
	
	@Test(priority=24, enabled=false)
	public void invalidzipcode() {

	try{
			
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");
	Map<String, String> Data = readxml.getUserData("TestData.xml", "fas-user-1");
	String invalidzipcode1 = Data.get("IncorrectZipCode1");
	String invalidzipcode2=Data.get("IncorrectZipCode2");
	String invalidzipcode3=Data.get("IncorrectZipCode3");

	cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, password);
	
	cubHome.clickSignInButton();
		Thread.sleep(5000);
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");

	findastore = new FindAStorePage(_driver);
		Thread.sleep(5000);
		log.info("Find a Store page is launched");
		
		SoftAssert sa = new SoftAssert();
		
		findastore.clickFAS();
		//Alphanumeric characters
		findastore.enterZipCode(invalidzipcode1);
		findastore.clicksearchbutton();
		log.info("Error Message is displayed");
		Thread.sleep(5000);
		
		boolean result1=findastore.isIncorrectZipcode();
		sa.assertTrue(result1, "Zipcode contains alphabets-numeric");
		
		//Alphabets
		findastore.clickFAS();
		findastore.enterZipCode(invalidzipcode2);
		findastore.clicksearchbutton();
		log.info("Error Message is displayed");
		Thread.sleep(5000);
		
		boolean result2=findastore.isIncorrectZipcode();
		sa.assertTrue(result2, "Zipcode contains alphabets");
		
		//Special Characters
		findastore.clickFAS();
		findastore.enterZipCode(invalidzipcode3);
		findastore.clicksearchbutton();
		log.info("Error Message is displayed");
		Thread.sleep(5000);
		
		boolean result3=findastore.isIncorrectZipcode();
		sa.assertTrue(result3, "Zipcode contains special characters");
			
		sa.assertAll();	

	} catch (InterruptedException ie) {
		log.info(ie.getMessage());
		Assert.fail("Caught Interrupted Exception");
	} catch (IOException ioe) {
		log.info(ioe.getMessage());	
		Assert.fail("Caught IOException Exception");
	} catch (XPathExpressionException xee) {
		log.info(xee.getMessage());	
		Assert.fail("Caught XPathExpressionException Exception");
	} catch (ParserConfigurationException pce) {
		log.info(pce.getMessage());
		Assert.fail("Caught ParserConfigurationException Exception");
	} catch (SAXException saxe) {
		log.info(saxe.getMessage());
		Assert.fail("Caught SAXException Exception");
	} catch (Exception e) {
		log.info(e.getMessage());
		Assert.fail(e.getLocalizedMessage());
	}
	
}
	
	//Pagination
	@Test(priority=25, enabled=false)
	public void Pagination() {

	try{
			
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");
	
	cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, password);
	
	cubHome.clickSignInButton();
		Thread.sleep(5000);
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");

	findastore = new FindAStorePage(_driver);
		Thread.sleep(5000);
		log.info("Find a Store page is launched");

	findastore.clickFAS();
	findastore.ClickState2();
	Thread.sleep(2000);
	String title=_driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("Farm Fresh Supermarkets - View Stores by State",title); 
	
	Thread.sleep(5000);
	int result=0;
	int r=findastore.results(result);
	System.out.println(r);
	WebElement check5=_driver.findElement(By.xpath("//*[@id='content-primary']/div/div[2]/div[3]/ul/li[1]"));//Previous
	
	int p=0;
	int R1=findastore.page(p);
	System.out.println(p);
	Thread.sleep(5000);
	int v=0;
	int v1=0; 
	int v2=0;
	int v3=0;
	Thread.sleep(5000);
	if(check5.getAttribute("disabled")=="disabled" || R1==1){
			Assert.assertTrue(true);
			System.out.println("Pagination for Previous link");
			}else{
				Assert.assertTrue(false);
			}
	
	if(r>10){
		WebElement check=_driver.findElement(By.xpath("//*[@id='store-search-result']/tbody/tr[14]/td[1]/div/div"));//last table of the page 10
		String val=check.getText();
		v=Integer.parseInt(val);
		System.out.println(val);
		if(v==10){
			Assert.assertTrue(true);
			System.out.println("Pass");
		}
	}else{
		Assert.assertTrue(false);
	}
	findastore.clickshow25();
	Thread.sleep(3000);
	if(r>25){
		WebElement check1=_driver.findElement(By.xpath("//*[@id='store-search-result']/tbody/tr[36]/td[1]/div/div"));//last table of the page 25
		String val1=check1.getText();
		v1=Integer.parseInt(val1);
		System.out.println(val1);
		if(v1==10){
			Assert.assertTrue(true);
			System.out.println("Pass");
		}
	}else{
		Assert.assertTrue(false);
	}
	findastore.clickshow50();
	Thread.sleep(3000);
	if(r>50){
		WebElement check2=_driver.findElement(By.xpath("//*[@id='store-search-result']/tbody/tr[56]/td[1]/div/div"));//last table of the page 50
		String val2=check2.getText();
		v2=Integer.parseInt(val2);
		System.out.println(val2);
		if(v2==50){
			Assert.assertTrue(true);
			System.out.println("Pass");
			
		}
	}
	
	WebElement lastnumber=_driver.findElement(By.xpath("//*[@id='store-search-result']/tbody/tr[56]/td[1]/div/div"));
	String val3=lastnumber.getText();
	System.out.println(val3);
	v3=Integer.parseInt(val3);
	
	int sum=v2+v3;
	System.out.println(sum);
	
	if(r==sum){
		System.out.println("Total number of results displayed is correct");
	}
	Thread.sleep(3000);
	if(r<50){
	findastore.clickshow25();
	Thread.sleep(5000);
	WebElement check3=_driver.findElement(By.xpath("//*[@id='content-primary']/div/div[2]/div[3]/ul/li[2]/a"));//Next
		
	if(check3.getAttribute("disabled")!="disabled"){
		Assert.assertTrue(true);
		System.out.println("Pagination for Next link");
	}else{
		Assert.assertTrue(false);
	}
	}else{
		findastore.clicknext();
		Thread.sleep(5000);
		WebElement check4=_driver.findElement(By.xpath("//*[@id='content-primary']/div/div[2]/div[3]/ul/li[1]/a"));//Previous
		
		if(check4.getAttribute("disabled")!="disabled"){
			Assert.assertTrue(true);
			System.out.println("Pagination for Previous link");
		}else{
			Assert.assertTrue(false);
		}
		}
	
	} catch (InterruptedException ie) {
		log.info(ie.getMessage());
		Assert.fail("Caught Interrupted Exception");
	} catch (IOException ioe) {
		log.info(ioe.getMessage());	
		Assert.fail("Caught IOException Exception");
	} catch (XPathExpressionException xee) {
		log.info(xee.getMessage());	
		Assert.fail("Caught XPathExpressionException Exception");
	} catch (ParserConfigurationException pce) {
		log.info(pce.getMessage());
		Assert.fail("Caught ParserConfigurationException Exception");
	} catch (SAXException saxe) {
		log.info(saxe.getMessage());
		Assert.fail("Caught SAXException Exception");
	} 
	
}
	//Setting store from My Account page.
	@Test(priority=26, enabled=false)
	public void validSignUpandsetstore(){
		try{
		// Retrieving test data for valid sign up no card
			Map<String, String> validSignUpNoCard = readxml.getUserData("TestData.xml", "new-user-16");
				String userId = validSignUpNoCard.get("UserName");
				String password = validSignUpNoCard.get("password");
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
				String zipcode = StoreData.get("zipcode");
		
		signUpPage = new SignUpPage(_driver);
		
		log.info("Test Data Used >>>>>>>");
		log.info("User Name : " + userId);
		log.info("Password : " + password);
		
		signUpPage.clickSignUpLink();
		
		signUpPage.enterSignUpDetails(userId,password);
		Thread.sleep(10000);
		
		findastore = new FindAStorePage(_driver);
		
		findastore.enterzip(zipcode);
		Thread.sleep(5000);
		findastore.clickOnSearch();
		Thread.sleep(5000);
		
		findastore.clickOnStore();
		Thread.sleep(50000);
		
		MyAccount = new MyAccountPage(_driver);
		MyAccount.clickOnMyAccountUnderMyTools(_driver);
		log.info("Click on My Accounts link");
		Thread.sleep(50000);
		
		//getting the default address 
		WebElement ele = _driver.findElement(By.xpath("//div[@class='myaccount parbase section']/div[5]/div/div"));
		String result=ele.getText().split("\n")[1];
		//String result=ele.getText();
	    System.out.println(result);
	    Thread.sleep(5000);
	    String r="Farm Fresh - Cedar Road";
	    SoftAssert sa = new SoftAssert();
	    if(result.equals(r)){	    	
	    	sa.assertTrue(true,"Default store is displayed");
	    	System.out.println("Pass");
	    }
	    
	    MyAccount.clickeditonmystore();
	    
	    Thread.sleep(5000);
	    
	    findastore = new FindAStorePage(_driver);
	  
	    findastore.enterzip(zipcode);
	    Thread.sleep(2000);
	    findastore.clickOnSearch();
	    Thread.sleep(5000);
	    findastore.clickOnStore();
	    Thread.sleep(5000);
	    WebElement ad=_driver.findElement(By.xpath("//*[@class='ss-selected-store']/ul/li[1]"));
	    String result1=ad.getText();
	    System.out.println(result1);
	    
		Thread.sleep(5000);
		
		findastore.clickOnusestore();
		Thread.sleep(50000);
		//Verify the selected store is displayed in My Account page
		WebElement ele1 = _driver.findElement(By.xpath("//*[@id='_content_svubanners_master_en_tools_view-account_jcr_content_centerpar_start_101a']/div[2]/div[5]/div/div"));
		String result2=ele1.getText().split("\n")[1];
	    System.out.println(result2);
	    Thread.sleep(2000);
	    if(result2.equals(result1)){
	    	sa.assertTrue(true,"selected store is displayed in my account page");
	    	System.out.println("selected store is displayed in my account page");
	    }
	    
	    //Check in My Store page
	    Thread.sleep(8000);
	    findastore.clickOnMyStoreUnderMyTools();
	    Thread.sleep(10000);
	    WebElement ele2 = _driver.findElement(By.xpath("//*[@id='store-details']/p[1]"));
		String result3=ele2.getText().split("\n")[0];
	    System.out.println(result3);
	    Thread.sleep(10000);
	    if(result3.equals(result2)){
	    	sa.assertTrue(true, "Same address displayed in My Store page");
	    	System.out.println("Same address displayed in My Store page");
	    }
		
		//Assert.assertTrue(signUpPage.isLogOutButtonPresent());	
		sa.assertAll();
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		}		
	}
	
	//Invalid City Street and State
	
		@Test(priority=27, enabled=false)
		public void invalidCityStreet() {

		try{
				
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
		String cityname = StoreData.get("city");
		String state = StoreData.get("state");
		
		String invalidstreet = StoreData.get("IncorrectStreet");
		String invalidcity=StoreData.get("IncorrectCity");
		//String invalidzipcode3=StoreData.get("IncorrectZipCode3");

		cubHome = new FFHome(_driver);

			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
		
		cubHome.clickSignInButton();
			Thread.sleep(5000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");

		findastore = new FindAStorePage(_driver);
			Thread.sleep(5000);
			log.info("Find a Store page is launched");
			
			SoftAssert sa = new SoftAssert();
			
			findastore.clickFAS();
			//Invalid Street
			findastore.enterstreetname(invalidstreet);
			findastore.clicksearchbutton();
			Thread.sleep(5000);
			boolean result1=findastore.isIncorrectZipcode();
			sa.assertTrue(result1, "Invalid street name");
			//Invalid City Name
			findastore.clickFAS();
			findastore.entercity(invalidcity);
			findastore.enterstreetname(invalidstreet);
			findastore.clicksearchbutton();
			log.info("Error Message is displayed");
			Thread.sleep(5000);
			boolean result2=findastore.isIncorrectZipcode();
			sa.assertTrue(result2, "Invalid city name");
			
			//Enter invalid street and valid city and State
			/*findastore.clickFAS();
			log.info("Entered incorrect street details");
			findastore.enterstreetname(invalidstreet);
			findastore.entercity(cityname);
			log.info("Entered correct city details");
			findastore.selectstate(state);
			Thread.sleep(5000);
			log.info("Entered correct state details");
			findastore.clicksearchbutton();
			log.info("Search button is CLicked");
		
		boolean result3=findastore.isIncorrectCityStreet();
		sa.assertTrue(result3, "Zipcode contains alphabets");
			log.info("View store is displayed with no results");
			Thread.sleep(5000);*/
			//bug raised
				
			sa.assertAll();	

		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (IOException ioe) {
			log.info(ioe.getMessage());	
			Assert.fail("Caught IOException Exception");
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());	
			Assert.fail("Caught XPathExpressionException Exception");
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());
			Assert.fail("Caught ParserConfigurationException Exception");
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());
			Assert.fail("Caught SAXException Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
		
		}
		
	//Pharmacy FAS widget	
		@Test(priority=28, enabled=false)
		public void pharmacyFASwidget() 
		{
			try{
			
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "fas-user-1");
			String zipcode = StoreData.get("zipcode");
			String cityname = StoreData.get("city");
			String state = StoreData.get("state");
			
			SoftAssert sa = new SoftAssert();
			
			cubHome=new FFHome(_driver);
			//ZipCode
			cubHome.clickOnPharmacy();
			
			findastore = new FindAStorePage(_driver);
		
			findastore.enterZippharma(zipcode);
	
			findastore.clicksearchpharmacy();
			Thread.sleep(3000);
			String title=_driver.getTitle();
			System.out.println(title);
			
			sa.assertEquals("Farm Fresh Supermarkets - Store Search Results", title, "\n Failed: Search page is not displayed when user clicks on SEARCH in FAS widget in Pharmacy page");	
			
			findastore.clickMakemyStore();
			Thread.sleep(3000);
			String title1=_driver.getTitle();
			System.out.println(title1);
			Assert.assertEquals("Farm Fresh Supermarkets - View Store", title1);
			log.info("Store Locations Page-Success" );
			
			//City and State
			cubHome.clickOnPharmacy();
			findastore.enterCitypharma(cityname);;
			findastore.selectStatepharma(state);
			
			findastore.clicksearchpharmacy();
			Thread.sleep(3000);
			String title2=_driver.getTitle();
			System.out.println(title2);
			sa.assertEquals("Farm Fresh Supermarkets - Store Search Results", title2, "\n Failed: Search page is not displayed when user clicks on SEARCH in FAS widget in Pharmacy page");	
			
			findastore.clickMakemyStore();
			Thread.sleep(3000);
			String title3=_driver.getTitle();
			System.out.println(title3);
			sa.assertEquals("Farm Fresh Supermarkets - View Store", title3, "\n Failed: Store details are not displayed when user Searches store through FAS widget in Pharmacy page");	
			
			sa.assertAll();
			
			} catch (IOException ioe) {
				log.info(ioe.getMessage());	
				Assert.fail("Caught IOException Exception");
			} catch (XPathExpressionException xee) {
				log.info(xee.getMessage());	
				Assert.fail("Caught XPathExpressionException Exception");
			} catch (ParserConfigurationException pce) {
				log.info(pce.getMessage());
				Assert.fail("Caught ParserConfigurationException Exception");
			} catch (SAXException saxe) {
				log.info(saxe.getMessage());
				Assert.fail("Caught SAXException Exception");
			} catch (Exception e) {
				log.info(e.getMessage());
				Assert.fail(e.getLocalizedMessage());
			}
			
		}
}

