
/********************************************************Weekly Ads TESTING************************************************************************************************************************
 * 
 * ================================================================================================================================================================================================
 *                                  Test Cases Covered as part of Weekly Ads Functionality
 * ================================================================================================================================================================================================
 * 
 * TC 1. 'AddingweeklyAdtoSL_authoriseduser'                    =>  Adding Weekly Ads to the Shopping List for Authorized user                                                                                     
 * 
 * TC 2. 'AddingweeklyAdtoSL_Guestuser'                         =>  Adding Weekly Ads to the Shopping List for Guest user
 * 
 * TC 3. 'RemovingweeklyAdtoSL_authoriseduser'                  =>  Removing Weekly Ads from the Shopping List for Authorized user
 * 
 * TC 4. 'LinksValidationinsidepopup_authoriseduser'            =>  Validates the Links present inside the info pop up                                                                   
 * 
 * TC 5. 'LinksValidationonpage_authoriseduser'        		    =>  Validates the Links present on the page
 * 
 * TC 6. 'HelpandFeedback_authoriseduser'                       =>  Validates the help and feedback icons for Authorized user
 * 
 * TC 7. 'FooterLinks_authoriseduser'  						    =>  Validates the Footer links                                                     
 * 
 * TC 8. 'Pagination_authoriseduser'                            =>  Validates the Pagination
 * 
 * TC 9. 'MoreAdsOption_authoriseduser'                         =>  Validates MoreAdsOption icon for Authorized user
 * 
 * ================================================================================================================================================================================================
 */

package com.test.regression.farmfresh.testscripts;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.pages.FindAStorePage;
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.ShoppingListPage;
import com.test.regression.farmfresh.pages.SignUpPage;
import com.test.regression.farmfresh.pages.WeeklyAdsPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;


public class WeeklyAds extends SuiteBase {

	FFHome cubHome;
	SignUpPage signUpPage;
	MyAccountPage MyAccount;
	ShoppingListPage SLpage;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	WeeklyAdsPage weeklyAdspage;

	//Sign In User Adding Weekly Ads to SL
	@Test(priority=1, enabled=false)
	public void AddingweeklyAdtoSL_authoriseduser() {

	try{
			
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");

	cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("FarmFresh Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, password);
	
	cubHome.clickSignInButton();
		Thread.sleep(8000);
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		
		cubHome.clickWeeklyAdTile();
		log.info("Weekly Ads page is displayed");
		Thread.sleep(5000);
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title);
		log.info("Weekly Ads page-Success" );
		weeklyAdspage=new WeeklyAdsPage(_driver);
		
		weeklyAdspage.clickWeeklysavings(_driver);
		Thread.sleep(8000);
		
		WebElement img= _driver.findElement(By.xpath("//*[@class='wishabi-scrollview']"));
		waitFor(img);
		Actions act = new Actions(_driver);
		   act.moveToElement(img).perform();
		   Thread.sleep(8000);
		   
		   System.out.println("click on image1");
		        
		   WebElement info= _driver.findElement(By.xpath("//*[@class='wishabi-itemdetaillayer has-item']/div[3]"));
		   info.click();
		   log.info("Click on information icon");
		   Thread.sleep(7000);
		   
		   WebElement Adname= _driver.findElement(By.xpath("//*[@class='v2_item_info_details']/div[1]"));
		   String name=Adname.getText();
		   System.out.println(name);
		   Thread.sleep(3000);
		   weeklyAdspage.clickadditem();
		   log.info("Click on Add item button");
		   Thread.sleep(6000);
		   weeklyAdspage.clickcloseicon();
		   log.info("Close the information icon pop up");
		   Thread.sleep(3000);
		   
		   //Navigate to shopping list page
		   weeklyAdspage.clickOnMylistUnderMyTools(_driver);
		   Thread.sleep(5000);
		   WebElement AdnameSL=_driver.findElement(By.xpath("//*[@id='listitem-itemText_0']"));
		   String name1=AdnameSL.getText();
		   Thread.sleep(5000);
		   if(name.equals(name1)){
			   Assert.assertTrue(true);
			   System.out.println("Item is present in Shopping list");
		   }else{
			   Assert.assertTrue(false);
			   System.out.println("Item is not present in Shopping list");
		   }
		   
	}	 catch (InterruptedException ie) {
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
	
	//GUEST User adding weekly Ad to Shopping List
	@Test(priority=2 , enabled=false)
	public void AddingweeklyAdtoSL_Guestuser() 
	{
		try{
			cubHome = new FFHome(_driver);
			cubHome.clickWeeklyAdTile();
			log.info("Weekly Ads page is displayed");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title);
			log.info("Weekly Ads page-Success" );
			weeklyAdspage=new WeeklyAdsPage(_driver);
			
			weeklyAdspage.clickWeeklysavings(_driver);
			Thread.sleep(8000);
			   
			System.out.println("click on image1");
			
			 WebElement img= _driver.findElement(By.xpath("//*[@class='wishabi-scrollview']"));
				Actions act = new Actions(_driver);
					act.moveToElement(img).perform();
				Thread.sleep(6000);
			 WebElement info= _driver.findElement(By.xpath("//*[@class='wishabi-itemdetaillayer-groceryicon groceryicon']"));
			 info.click();
			 log.info("Click on information icon pop up");
			 Thread.sleep(5000);
			 WebElement Adname= _driver.findElement(By.xpath("//*[@class='v2_item_info_details']/div[1]"));
			 String name=Adname.getText();
			 System.out.println(name);
			 weeklyAdspage.clickadditem();
			 log.info("Click on Add item button in the information icon");
			 Thread.sleep(6000);
			 weeklyAdspage.clickcloseicon();
			 log.info("Close the information pop up");
			 Thread.sleep(5000);
			   //Navigate to shopping list page
			 weeklyAdspage.clickviewFullList(_driver);
			 log.info("Click on View full list button to navigate to SL");
			 Thread.sleep(5000);
			 WebElement AdnameSL=_driver.findElement(By.xpath("//*[@id='listitem-itemText_0']"));
			 String name1=AdnameSL.getText();
			 Thread.sleep(5000);
			 System.out.println(name1);
			 if(name.equals(name1)){
				 Assert.assertTrue(true);
				 System.out.println("Weekly Ad present in the shopping list");
			 }else{
				 Assert.assertTrue(false);
				 System.out.println("Weekly Ad is not present in the Shopping List");
			 }
			 
		} catch (Exception e) {
			log.info(e.getMessage());
			Assert.fail(e.getLocalizedMessage());
		}
	}
	
	//Remove the Weekly Ad
	@Test(priority=3, enabled=false)
	public void RemovingweeklyAdtoSL_authoriseduser() {

	try{
			
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");

	cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("FarmFresh Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, password);
	
	cubHome.clickSignInButton();
		Thread.sleep(8000);
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		
		cubHome.clickWeeklyAdTile();
		log.info("Weekly Ads page is displayed");
		Thread.sleep(5000);
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title);
		log.info("Weekly Ads page-Success" );
		weeklyAdspage=new WeeklyAdsPage(_driver);
		
		weeklyAdspage.clickWeeklysavings(_driver);
		Thread.sleep(8000);
		
		WebElement img= _driver.findElement(By.xpath("//*[@class='wishabi-scrollview']"));
		Actions act = new Actions(_driver);
		   act.moveToElement(img).perform();
		   Thread.sleep(6000);
		   
		   System.out.println("click on image1");
		        
		   WebElement info= _driver.findElement(By.xpath("//*[@class='wishabi-scrollview']/div[3]/div[3]"));
		   info.click();
		   System.out.println("click on information icon");
		   Thread.sleep(5000);
		   
		   WebElement Adname= _driver.findElement(By.xpath("//*[@class='v2_item_info_details']/div[1]"));
		   String name=Adname.getText();
		   System.out.println(name);
		   weeklyAdspage.clickadditem();
		   log.info("Add an item to Shopping list");
		   Thread.sleep(6000);
		   weeklyAdspage.clickremoveitem();
		   log.info("Remove an item to Shopping list");
		   Thread.sleep(3000);
		   weeklyAdspage.clickcloseicon();
		   log.info("Close the information icon pop up");
		   Thread.sleep(3000);
		   //Navigate to shopping list page
		   weeklyAdspage.clickOnMylistUnderMyTools(_driver);
		  
		   Thread.sleep(5000);
		   SLpage=new ShoppingListPage(_driver);
		   int SL=SLpage.SLSize();
		   Assert.assertTrue(SL==0);
		   System.out.println("Item is not present in Shopping list");
		   
	}	 catch (InterruptedException ie) {
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
	
	//Validating the links inside information pop up
	@Test(priority=4, enabled=false)
	public void LinksValidationinsidepopup_authoriseduser() {

	try{
			
	// Retrieving test data for valid login
	Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
	String userId = validLogin.get("UserName");
	String password = validLogin.get("password");

	cubHome = new FFHome(_driver);

		log.info("User Name : " + userId);
		log.info("Password : " + password);
		log.info("FarmFresh Home page is launched");
	cubHome.clickSignInLink();
		
	cubHome.enterLoginDetails(userId, password);
	
	cubHome.clickSignInButton();
		Thread.sleep(8000);
		log.info("SignInButton Clicked");
		log.info("Entered all details and clicked on Sign In Button");
		SoftAssert sa = new SoftAssert();
		cubHome.clickWeeklyAdTile();
		log.info("Weekly Ads page is displayed");
		Thread.sleep(5000);
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh SupermarketsCub Foods - View Ads", title);
		log.info("Weekly Ads page-Success" );
		weeklyAdspage=new WeeklyAdsPage(_driver);
		
		weeklyAdspage.clickWeeklysavings(_driver);
		Thread.sleep(8000);
		
		WebElement img= _driver.findElement(By.xpath("//*[@class='wishabi-scrollview']"));
		Actions act = new Actions(_driver);
		   act.moveToElement(img).perform();
		   Thread.sleep(6000);
		   
		   System.out.println("click on image1");
		        
		   WebElement info= _driver.findElement(By.xpath("//*[@class='wishabi-scrollview']/div[3]/div[3]"));
		   info.click();
		   System.out.println("click on information icon");
		   Thread.sleep(5000);
		   
		   String parentHandle = _driver.getWindowHandle(); // get the current window handle                 
		    weeklyAdspage.clickfacebook();
		    Thread.sleep(3000);
		    System.out.println("Facebook opened");
		    Thread.sleep(3000);
		    int noOfWindowsOpen = _driver.getWindowHandles().size();
		    System.out.println(noOfWindowsOpen+ " windows are open now");
		    
		    for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
		    String t=_driver.getTitle();
		    System.out.println(t);
		    sa.assertEquals("Facebook", t);
		   _driver.close();  
		   log.info("Close the child browser");
			Thread.sleep(5000);
			_driver.switchTo().window(parentHandle);
			 log.info("switch to parent browser");  
		    Thread.sleep(8000);
		    String title1=_driver.getTitle();
		    _driver.switchTo().frame("flipp-iframe");
			System.out.println(title1);
			
			//Twitter
			weeklyAdspage.clicktwitter();
		    Thread.sleep(5000);
		    System.out.println("twitter opened");
		    Thread.sleep(3000);
		    int noOfWindowsOpen1 = _driver.getWindowHandles().size();
		    System.out.println(noOfWindowsOpen1+ " windows are open now");
		    
		    for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
		    String t1=_driver.getTitle();
		    System.out.println(t1);
		    sa.assertEquals("Share a link on Twitter", t1);
		   _driver.close();  
		   log.info("Close the child browser");
			Thread.sleep(5000);
			_driver.switchTo().window(parentHandle);
			 log.info("switch to parent browser"); 
		    Thread.sleep(8000);
		    String title2=_driver.getTitle();
		    _driver.switchTo().frame("flipp-iframe");
			System.out.println(title2);
			
			//Google+
			weeklyAdspage.clickgoogle();
			Thread.sleep(5000);
			System.out.println("Google+ opened");
		    Thread.sleep(3000);
		    int noOfWindowsOpen2 = _driver.getWindowHandles().size();
		    System.out.println(noOfWindowsOpen2+ " windows are open now");
		    
		    for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
		    String t2=_driver.getTitle();
		    System.out.println(t2);
		    sa.assertEquals("Google+", t2);
		    _driver.close();  
		    log.info("Close the child browser");
			Thread.sleep(5000);
			_driver.switchTo().window(parentHandle);
			 log.info("switch to parent browser");  
		    Thread.sleep(8000);
		    String title3=_driver.getTitle();
		    _driver.switchTo().frame("flipp-iframe");
			System.out.println(title3);
			
			//Pinterest
			weeklyAdspage.clickpinterest();
			Thread.sleep(5000);
			System.out.println("Pinterest opened");
		    Thread.sleep(3000);
		    int noOfWindowsOpen3 = _driver.getWindowHandles().size();
		    System.out.println(noOfWindowsOpen3+ " windows are open now");
		    
		    for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
		    String t3=_driver.getTitle();
		    System.out.println(t3);
		    sa.assertEquals("Pinterest • The world’s catalog of ideas", t3);
		    _driver.close();  
		    log.info("Close the child browser");
			Thread.sleep(5000);
			_driver.switchTo().window(parentHandle);
			 log.info("switch to parent browser");  
		    Thread.sleep(8000);
		    String title4=_driver.getTitle();
		    _driver.switchTo().frame("flipp-iframe");
			System.out.println(title4);
			
		   weeklyAdspage.clickcloseicon();
		   Thread.sleep(5000);
		   sa.assertAll();
		    
	}	 catch (InterruptedException ie) {
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
	
	//Validating the links outside information pop up(facebook and twitter)
		@Test(priority=5, enabled=false)
		public void LinksValidationonpage_authoriseduser() {

		try{
				
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		cubHome = new FFHome(_driver);

			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("FarmFresh Home page is launched");
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
		
		cubHome.clickSignInButton();
			Thread.sleep(8000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			SoftAssert sa = new SoftAssert();
			cubHome.clickWeeklyAdTile();
			log.info("Weekly Ads page is displayed");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
			sa.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh SupermarketsCub Foods - View AdsCub Foods - View Ads", title);
			log.info("Weekly Ads page-Success" );
			weeklyAdspage=new WeeklyAdsPage(_driver);
			
			weeklyAdspage.clickWeeklysavings(_driver);
			Thread.sleep(8000);
			
			String parentHandle = _driver.getWindowHandle(); // get the current window handle                 
			//Facebook
			weeklyAdspage.clickfb();
			Thread.sleep(5000);
		    System.out.println("Facebook opened");
		    Thread.sleep(3000);
		    int noOfWindowsOpen = _driver.getWindowHandles().size();
		    System.out.println(noOfWindowsOpen+ " windows are open now"); 
		    for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
		    String t=_driver.getTitle();
		    System.out.println(t);
		    sa.assertEquals("Facebook", t);
		   _driver.close();  
		    Thread.sleep(5000);
		    _driver.switchTo().window(parentHandle);  
		    Thread.sleep(8000);
		    _driver.switchTo().frame("flipp-iframe");
		    String title1=_driver.getTitle();
		    System.out.println(title1);
		    
		    //Twitter
			weeklyAdspage.clicktw();
			Thread.sleep(5000);
			System.out.println("twitter opened");
		    Thread.sleep(3000);
		    int noOfWindowsOpen1 = _driver.getWindowHandles().size();
		    System.out.println(noOfWindowsOpen1+ " windows are open now"); 
		    for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
		    String t1=_driver.getTitle();
		    System.out.println(t1);
		    sa.assertEquals("Share a link on Twitter", t1);
		   _driver.close();  
		    Thread.sleep(5000);
		    _driver.switchTo().window(parentHandle);  
		    Thread.sleep(8000);
		    System.out.println("Facebook and twitter links are opening");
			
		}	 catch (InterruptedException ie) {
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
		
	//Validating the links outside information pop up(facebook and twitter)
	@Test(priority=6, enabled=false)
	public void HelpandFeedback_authoriseduser() {

		try{
						
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");

			cubHome = new FFHome(_driver);

			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("FarmFresh Home page is launched");
			cubHome.clickSignInLink();
					
			cubHome.enterLoginDetails(userId, password);
			SoftAssert sa = new SoftAssert();
			cubHome.clickSignInButton();
			Thread.sleep(8000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			cubHome = new FFHome(_driver);		
			cubHome.clickWeeklyAdTile();
			log.info("Weekly Ads page is displayed");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
			sa.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh SupermarketsCub Foods - View Ads", title);
			log.info("Weekly Ads page-Success" );
			weeklyAdspage=new WeeklyAdsPage(_driver);
			
			weeklyAdspage.clickWeeklysavings(_driver);
			Thread.sleep(8000);
			weeklyAdspage.clickhelp();
			log.info("Help pop up opened");
			Thread.sleep(8000);
			String text=_driver.findElement(By.xpath("html/body/div[2]/h1")).getText();
			System.out.println(text);
			if(text.equals("Reading circulars")){
				sa.assertTrue(true,"Correct pop up");
			}
			weeklyAdspage.clickclosehelp();
			Thread.sleep(3000);
			weeklyAdspage.clickfeedback();
			log.info("feedback pop up opened");
			Thread.sleep(10000);
			String text1=_driver.findElement(By.xpath("//*[@id='feedback_dialog']/div/div[1]/div[1]")).getText();
			System.out.println(text1);
			if(text1.equals("Add Your Feedback")){
				sa.assertTrue(true,"Correct pop up");
			}
			weeklyAdspage.clickclosefeedback();
			Thread.sleep(10000);
			String title1=_driver.getTitle();
			//System.out.println(title1);
			sa.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title1);
			
			sa.assertAll();
					
		}catch (InterruptedException ie) {
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
	
	//Footer Links
	@Test(priority=7, enabled=false)
	public void FooterLinks_authoriseduser() {

		try{
						
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");

			cubHome = new FFHome(_driver);
			
			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("FarmFresh Home page is launched");
			cubHome.clickSignInLink();
			SoftAssert sa = new SoftAssert();
			cubHome.enterLoginDetails(userId, password);
			
			cubHome.clickSignInButton();
			Thread.sleep(8000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			cubHome = new FFHome(_driver);		
			cubHome.clickWeeklyAdTile();
			log.info("Weekly Ads page is displayed");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
			sa.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title);
			log.info("Weekly Ads page-Success" );
			weeklyAdspage=new WeeklyAdsPage(_driver);
					
			weeklyAdspage.clickWeeklysavings(_driver);
			Thread.sleep(8000);
			String currentWindowHandle = _driver.getWindowHandle();
				
			//Powered By Flipp
			weeklyAdspage.clickpoweredbyflipp();
			log.info("Powered by Flipp link opened");
			Thread.sleep(8000);
			for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
		        System.out.println("Want to swtich to window "+ winHandle);
		    	_driver.switchTo().window(winHandle);              
		    }
			Thread.sleep(8000);
			String text=_driver.getTitle();
			System.out.println(text);
			Thread.sleep(8000);
			sa.assertEquals("Flipp - Your Local Weekly Ads & Coupons", text);
			 _driver.close();  
			 log.info("Close the child browser");
			 Thread.sleep(5000);
			 _driver.switchTo().window(currentWindowHandle);
			 log.info("switch to parent browser");  
			 Thread.sleep(8000);
			 _driver.switchTo().frame("flipp-iframe");
			 Thread.sleep(2000);
			 
			 //Patent
			 weeklyAdspage.clickpatent();
			 log.info("Patent link opened");
			 Thread.sleep(5000);
			 for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
			       _driver.switchTo().window(winHandle);              
			   }
			 Thread.sleep(8000);
			String text1=_driver.getTitle();
			System.out.println(text1);
			sa.assertEquals("Flipp - Reimagine the Weekly Shopping Experience", text1);
			_driver.close();  
			log.info("Close the child browser");
			Thread.sleep(5000);
			 _driver.switchTo().window(currentWindowHandle);
			 log.info("switch to parent browser");
			Thread.sleep(8000);
			_driver.switchTo().frame("flipp-iframe");
			Thread.sleep(3000);
			
			//Privacy
			 weeklyAdspage.clickprivacy();
			 log.info("Privacy link opened");
			 Thread.sleep(5000);
			 for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
			       _driver.switchTo().window(winHandle);              
			   }
			 Thread.sleep(8000);
			String text2=_driver.getTitle();
			System.out.println(text2);
			sa.assertEquals("Flipp - Reimagine the Weekly Shopping Experience", text2);
			_driver.close();  
			log.info("Close the child browser");
			Thread.sleep(5000);
			 _driver.switchTo().window(currentWindowHandle);
			 log.info("switch to parent browser");
			Thread.sleep(8000);
			_driver.switchTo().frame("flipp-iframe");
			Thread.sleep(3000);
			
			//Terms of use
			weeklyAdspage.clicktermsofuse();
			 log.info("Terms of use link opened");
			 Thread.sleep(5000);
			 for (String winHandle : _driver.getWindowHandles()) { //Gets the new window handle
			       _driver.switchTo().window(winHandle);              
			   }
			 Thread.sleep(8000);
			String text3=_driver.getCurrentUrl();
			System.out.println(text3);
			sa.assertEquals("https://corp.flipp.com/flipp/terms_of_use", text3);
			_driver.close();  
			log.info("Close the child browser");
			Thread.sleep(5000);
			 _driver.switchTo().window(currentWindowHandle);
			 log.info("switch to parent browser"); 
			Thread.sleep(8000);
			_driver.switchTo().frame("flipp-iframe");
			Thread.sleep(8000);
			
			System.out.println("all are true");
			sa.assertAll();
			System.out.println("All footer links are opening");
								
		}catch (InterruptedException ie) {
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
	
	@Test(priority=8, enabled=false)
	public void Pagination_authoriseduser() {

		try{
						
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");

			cubHome = new FFHome(_driver);

			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("FarmFresh Home page is launched");
			cubHome.clickSignInLink();
					
			cubHome.enterLoginDetails(userId, password);
			
			cubHome.clickSignInButton();
			Thread.sleep(8000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			cubHome = new FFHome(_driver);		
			cubHome.clickWeeklyAdTile();
			log.info("Weekly Ads page is displayed");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title);
			log.info("Weekly Ads page-Success" );
			weeklyAdspage=new WeeklyAdsPage(_driver);
			
			SoftAssert sa = new SoftAssert();	
			weeklyAdspage.clickWeeklysavings(_driver);
			Thread.sleep(8000);
			String initialpagenotop=weeklyAdspage.toppageno();
			log.info("Intial page number");
			System.out.println(initialpagenotop);
			String initialpagenodown=weeklyAdspage.downpageno();
			System.out.println(initialpagenodown);
			sa.assertEquals(initialpagenotop, initialpagenodown);
			weeklyAdspage.clickrightscroll();
			log.info("Click on right scroll-success");
			Thread.sleep(3000);
			
			//2nd Page
			String initialpagenotop1=weeklyAdspage.toppageno();
			System.out.println(initialpagenotop1);
			String initialpagenodown1=weeklyAdspage.downpageno();
			System.out.println(initialpagenodown1);
			sa.assertEquals(initialpagenotop1, initialpagenodown1);
			weeklyAdspage.clickrightscroll();
			log.info("Click on right scroll for next page-success");
			Thread.sleep(3000);
			
			//3rd Page
			String initialpagenotop2=weeklyAdspage.toppageno();
			System.out.println(initialpagenotop2);
			String initialpagenodown2=weeklyAdspage.downpageno();
			System.out.println(initialpagenodown2);
			sa.assertEquals(initialpagenotop2, initialpagenodown2);
			weeklyAdspage.clickrightscroll();
			Thread.sleep(3000);
			
			//Click on Left scroll
			weeklyAdspage.clickleftscroll();
			log.info("CLick on left scroll-success");
			Thread.sleep(3000);
			String initialpagenotop3=weeklyAdspage.toppageno();
			System.out.println(initialpagenotop3);
			String initialpagenodown3=weeklyAdspage.downpageno();
			System.out.println(initialpagenodown3);
			sa.assertEquals(initialpagenotop3, initialpagenodown3);
			
			//previous page
			weeklyAdspage.clickleftscroll();
			log.info("CLick on left scroll for previous page-success");
			Thread.sleep(3000);
			String initialpagenotop4=weeklyAdspage.toppageno();
			System.out.println(initialpagenotop4);
			String initialpagenodown4=weeklyAdspage.downpageno();
			System.out.println(initialpagenodown4);
			sa.assertEquals(initialpagenotop4, initialpagenodown4);
			Thread.sleep(3000);
			
			sa.assertAll();
			
		}catch (InterruptedException ie) {
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
	
	//More Ads option functionality
	@Test(priority=9, enabled=true)
	public void MoreAdsOption_authoriseduser() {

		try{
						
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");

			cubHome = new FFHome(_driver);

			log.info("User Name : " + userId);
			log.info("Password : " + password);
			log.info("FarmFresh Home page is launched");
			cubHome.clickSignInLink();
					
			cubHome.enterLoginDetails(userId, password);
			
			cubHome.clickSignInButton();
			Thread.sleep(8000);
			log.info("SignInButton Clicked");
			log.info("Entered all details and clicked on Sign In Button");
			cubHome = new FFHome(_driver);		
			cubHome.clickWeeklyAdTile();
			log.info("Weekly Ads page is displayed");
			Thread.sleep(5000);
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Farm Fresh Supermarkets - View Ads | NC & VA Grocery Store | Farm Fresh Supermarkets", title);
			log.info("Weekly Ads page-Success" );
			weeklyAdspage=new WeeklyAdsPage(_driver);
			SoftAssert sa = new SoftAssert();		
			weeklyAdspage.clickWeeklysavings(_driver);
			Thread.sleep(6000);
			int NoofAds=Integer.parseInt(weeklyAdspage.MoreAds());
			
			Thread.sleep(5000);
			System.out.println(NoofAds);
						
			String heading=weeklyAdspage.heading(_driver);
			String h="Select Circulars from Cub";
			
			if(heading.equalsIgnoreCase(h)){
				sa.assertTrue(true, "Redirecting to Correct page");
				System.out.println("pass");
			}
			
			int number=weeklyAdspage.noOfAdsInWeeklyAdPage();
			System.out.println(number);
			if(number==NoofAds){
				sa.assertTrue(true, "Number of Ads displayed are correct");
				System.out.println("pass");
			}	
			sa.assertAll();
			
		}catch (InterruptedException ie) {
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
	}
