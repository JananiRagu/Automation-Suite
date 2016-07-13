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
	
	
	//Guest User setting a Store with Zipcode
	
		@Test(priority=14, enabled=true)
		public void setStoreGuestZipCode() 
		{
			try{
			
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
			
			findastore = new FindAStorePage(_driver);
		
			findastore.clickFindAStore();
			findastore.enterZipCode(zipcode);
	
			findastore.clicksearchbutton();
		
			findastore.clickMakemyStore();
				String title=_driver.getTitle();
				System.out.println(title);
			
			Assert.assertEquals("Cub Foods - View Store", title);
			
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
		
		
		@Test(priority=15 , enabled=true)
		public void setStoreGuestCityState() 
		{
			try{
				
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String cityname = StoreData.get("CityName");
			String state = StoreData.get("State");
			
			findastore = new FindAStorePage(_driver);
			
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
		
		//SIGN IN User with ZIPCODE
		
		@Test(priority=16, enabled=true)
		public void setStoreAuthorizedZipcode() {

		try{
				
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
			
		cubHome.enterLoginDetails(userId, password);
		
		cubHome.clickSignInButton();
			Thread.sleep(5000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");

		findastore = new FindAStorePage(_driver);
			Thread.sleep(5000);
			log.info("Find a Store page is launched");

		findastore.clickFAS();
			log.info("Entered Zip Code details");
		findastore.enterZipCode(zipcode);
			log.info("Search button is CLicked");
		findastore.clicksearchbutton();
			log.info("Store Locations page is displayed");
			Thread.sleep(5000);
		findastore.ClickStore1();

			Thread.sleep(5000);
		findastore.clickMakemyStore();
			log.info("My Store is set");
		
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
		Assert.assertEquals("Cub Foods - View Store", title);
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

		
		//SIGN IN User with CITY and 11:16 AM 
		@Test(priority=17,enabled=true)
		public void setStoreAuthorizedCityState() {

			try{
				
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
		
		cubHome.enterLoginDetails(userId, password);
		
		cubHome.clickSignInButton();

		findastore = new FindAStorePage(_driver);
			Thread.sleep(10000);
			log.info("Find a Store page is launched");
			Thread.sleep(5000);

		findastore.clickFAS();

			log.info("Find a Store page is launched");

		findastore.entercity(cityname);
			log.info("Entered City name details");

		findastore.selectstate(state);
			log.info("Entered State name details");

		findastore.clicksearchbutton();
			log.info("Search button is CLicked");
			log.info("Store Locations page is displayed");

			Thread.sleep(5000);
		findastore.ClickStore2();
		
		Thread.sleep(5000);
			log.info("My Store is set");
		
		Thread.sleep(5000);

			String title=_driver.getTitle();
			System.out.println(title);
		Assert.assertEquals("Cub Foods - View Store", title);
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


		//Checking miles
		
		@Test(priority=18, enabled=true)
		
		public void Miles20() 
		{
			try{
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
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
		
		@Test(priority=19, enabled=true)
		
		public void Miles50()
		{
			try{
				
			Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
			String zipcode = StoreData.get("ZipCode");
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

	@Test(priority=20, enabled=true)
	
	public void changeStoreFromDifferentPages() 
	{
		try{
			
		Map<String, String> StoreData = readxml.getUserData("TestData.xml", "new-user-4");
		String zipcode = StoreData.get("ZipCode");
		String Add1=null;
		String Add2=null;
		findastore = new FindAStorePage(_driver);
		
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
	@Test(priority=21, enabled=true)
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
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());
			Assert.fail("Caught Interrupted Exception");
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
		
	}

