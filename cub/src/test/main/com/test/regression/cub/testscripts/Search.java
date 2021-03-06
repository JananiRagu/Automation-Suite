package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.cub.pages.SearchPage;
import com.test.regression.cub.pages.SiteMapPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;


public class Search extends SuiteBase{
	SearchPage Others;
	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	SoftAssert softAssert = new SoftAssert();

	/* ---------------------------- Guest User ------------------------*/
	// Search functionality without any search criteria

	@Test(priority=1,enabled=true)
	public void GuestSearch_Blank() throws InterruptedException
	
	{	
		Others = new SearchPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		Others.clickSearchArrow();
		Thread.sleep(5000);
		System.out.println("Inside search page");
		String Message = Others.GetSearchMessage();
		System.out.println("Error message displayed is :  " + Message);
		softAssert.assertEquals(Message,"We apologize, we couldn't find any results matching your search term(s).", "Failed to load the page or message displayed is not matching with expected");
		softAssert.assertAll();
	}

	// Search functionality with proper search data
	@Test(priority=2,enabled=true)
	public void GuestSearch_withData() throws InterruptedException
	
	{	
		Others = new SearchPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		//String Cub = "Cub";
		//Others.enterSearchDetails(Cub);
		//Thread.sleep(5000);
		Others.clickSearchArrow();
		Thread.sleep(5000);
		System.out.println("Inside search page");
		String Cub = "Cub";
		Others.enterSearchText(Cub);
		Others.clickSearchButon();
		Thread.sleep(5000);
		String CurrentURL_Ten = Others.GetCurrentURL();
		System.out.println("URL displayed is  : " +CurrentURL_Ten);
	
		//Click on pagination link 3
		System.out.println("After clicking on pagination link 3");
		Others.clickOn_PaginationLinkNumber_3();
		Thread.sleep(5000);
		String CurrentURL_Ten_Three = Others.GetCurrentURL();
		String[] arrCurrentURLTenThree = CurrentURL_Ten_Three.split("=");
		String[] arrCurrentURLTenThreeSearch = arrCurrentURLTenThree[1].split("&");
		softAssert.assertEquals(arrCurrentURLTenThreeSearch[0],"Cub", "Text 'Cub' displayed is not matching with expected");	
		System.out.println("Searched criteria is " + arrCurrentURLTenThreeSearch[0]);
		
		String[] arrCurrentURLTenThreeSearch_Page = arrCurrentURLTenThree[2].split("&");
		softAssert.assertEquals(arrCurrentURLTenThreeSearch_Page[0],"10", "Count displayed '10' is not matching with expected");		
		System.out.println("Display count is " + arrCurrentURLTenThreeSearch_Page[0]);
		
		softAssert.assertEquals(arrCurrentURLTenThree[3],"3", "Page number displayed '3' is not matching with expected");		
		System.out.println("Page count is " + arrCurrentURLTenThree[3]);
		
		//Click on last pagination 
		System.out.println("After clicking on last pagination link");	
		Others.clickOn_LastPaginationLink();
		Thread.sleep(10000);
		String CurrentURL_Ten_Last= Others.GetCurrentURL();
		String[] arrCurrentURLTenLast = CurrentURL_Ten_Last.split("=");
		String[] arrCurrentURLTenLastSearch = arrCurrentURLTenLast[1].split("&");
		softAssert.assertEquals(arrCurrentURLTenLastSearch[0],"Cub", "Text 'Cub' displayed is not matching with expected");	
		System.out.println("Searched criteria is " + arrCurrentURLTenLastSearch[0]);
		
		String[] arrCurrentURLTenLastSearch_Last = arrCurrentURLTenLast[2].split("&");
		softAssert.assertEquals(arrCurrentURLTenLastSearch_Last[0],"10", "Count displayed '10' is not matching with expected");		
		System.out.println("Display count is " + arrCurrentURLTenLastSearch_Last[0]);
		
		softAssert.assertEquals(arrCurrentURLTenLast[3],"53", "Page number displayed '53' is not matching with expected");		
		System.out.println("Page count is " + arrCurrentURLTenLast[3]);
		
		//Checking on next link is enabled or not
		//String LinkStatus = Others.Link_Next();
		//softAssert.assertEquals(LinkStatus,"true", "Next link is enabled after clicking on last page link");
		
		//String Previous = Others.Link_Previous();
		//softAssert.assertEquals(Previous,"false", "Previous link is disabled after clicking on last page link");
		softAssert.assertAll();
	}
		
	
	// Search functionality with in valid data	
	@Test(priority=3,enabled=true)
	public void GuestSearch_InvalidData() throws InterruptedException
	
	{	
		Others = new SearchPage(_driver);
		System.out.println("At Cub home page");
		Thread.sleep(5000);
		System.out.println("Searched string is 'jhfgjdgfjgjhfgfjhfgjsdgjfgsd' ");
		Others.enterSearchDetails("jhfgjdgfjgjhfgfjhfgjsdgjfgsd");
		Others.clickSearchArrow();
		Thread.sleep(5000);
		System.out.println("Inside search page");
		String Message = Others.GetSearchMessage();
		System.out.println(Message);
		softAssert.assertEquals(Message,"We apologize, we couldn't find any results matching your search term(s).", "Failed to load the page or message displayed is not matching with expected");
		softAssert.assertAll();
	}
	

	/* ---------------------------- Signed User ------------------------*/
	// Search functionality without any search criteria
		
		@Test(priority=4,enabled=true)
		public void SignedSearch_Blank()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException 
		{
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
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
			log.info("User Signed In");
			Thread.sleep(5000);
			this.GuestSearch_Blank();
		}
		
		@Test(priority=5,enabled=true)
		public void SignedSearch_withData()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException 
		{
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
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
			log.info("User Signed In");
			Thread.sleep(5000);
			this.GuestSearch_withData();
		}
		
		@Test(priority=6,enabled=true)
		public void SignedSearch_InvalidData()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException 
		{
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
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
			log.info("User Signed In");
			Thread.sleep(5000);
			this.GuestSearch_InvalidData();
		}

}
	
	
	

