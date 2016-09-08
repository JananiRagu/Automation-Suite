

/********************************************************Navigation TESTING************************************************************************************************************************ *
 *  
 * ================================================================================================================================================================================================
 *                                  Test Cases Covered as part of Navigation Functionality
 * ================================================================================================================================================================================================
 * 
 * TC 1. 'NavigationtoDepartments_GuestUser'              =>  Validates the Links in Departments page as a guest user                                                                                    
 * 
 * TC 2. 'NavigationtoDepartments_AuthorisedUser'         =>  Validates the Links in Departments page as a authorized user    
 * 
 * TC 3. 'NavigationtoPharmacy_GuestUser'                 =>  Validates the Links in Pharmacy page as a guest user    
 * 
 * TC 4. 'NavigationtoPharmacy_AuthorisedUser'            =>  Validates the Links in Pharmacy page as a authorized user                                                                     
 * 
 * ================================================================================================================================================================================================
 */


package com.test.regression.farmfresh.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.pages.MyAccountPage;
import com.test.regression.farmfresh.pages.NavigationPage;
import com.test.regression.farmfresh.pages.ShoppingListPage;
import com.test.regression.farmfresh.pages.SignUpPage;
import com.test.regression.farmfresh.pages.WeeklyAdsPage;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;

public class Navigation extends SuiteBase {

       FFHome cubHome;
       SignUpPage signUpPage;
       MyAccountPage MyAccount;
       ShoppingListPage SLpage;
       Logger log = Logg.createLogger();
       ReadXML readxml = new ReadXML();
       WeeklyAdsPage weeklyAdspage;
       NavigationPage navigationpage;

       //Guest user Navigate to Departments page
       @Test(priority=1, enabled=true)
       public void NavigatetoDepartments_GuestUser() {
              
              try {
              cubHome = new FFHome(_driver);
       
              navigationpage=new NavigationPage(_driver);
              SoftAssert sa = new SoftAssert();
              
              navigationpage.clickDepartments();
              log.info("Click on Departments");
              Thread.sleep(5000);
              String title=_driver.getCurrentUrl();
              System.out.println(title);
              sa.assertEquals("https://www.cub.com/departments.html", title);
              log.info("Departments page is displayed" );
              
              //Navigate to Meat and Sea Food page
              navigationpage.clickMeat();
              log.info("Click on Meat and SeaFood");
              Thread.sleep(5000);
              String title1=_driver.getCurrentUrl();
              System.out.println(title1);
              sa.assertEquals("https://www.cub.com/departments/meat-seafood.html", title1);
              log.info("Meat and SeaFood page is displayed" );
              
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Deli and Bakery page
              navigationpage.clickBakery();
              log.info("Click on Deli and Bakery");
              Thread.sleep(5000);
              String title2=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/deli-bakery.html", title2);
              log.info("Deli and Bakery page is displayed" );
                           
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Fresh Produce page
              navigationpage.clickFresh();
              log.info("Click on Fresh Produce");
              Thread.sleep(5000);
              String title3=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/produce.html", title3);
              log.info("Fresh Produce page is displayed" );
                                         
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Gift Cards page
              navigationpage.clickGift();
              log.info("Click on Gift Cards");
              Thread.sleep(5000);
              String title4=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/gift-card-floral.html", title4);
              log.info("Gift Cards page is displayed" );
                                         
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Beer and Wine page
              navigationpage.clickBeer();
              log.info("Click on Beer and Wine");
              Thread.sleep(5000);
              String title5=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/liquor.html", title5);
              log.info("Beer and Wine page is displayed" );
                                         
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Pet page
              navigationpage.clickPet();
              log.info("Click on Pet");
              Thread.sleep(5000);
              String title6=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/pet.html", title6);
              log.info("Pet page is displayed" );
                                                       
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              sa.assertAll();
              
       } catch (InterruptedException e) {
              e.printStackTrace();
       }
       }
       
       @Test(priority=2, enabled=true)
       public void NavigatetoDepartments_SignedInuser() {
              
              try {
                     
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
                     Thread.sleep(8000);
                     log.info("SignInButton Clicked");
                     log.info("Entered all details and clicked on Sign In Button");
              
       
              navigationpage=new NavigationPage(_driver);
              SoftAssert sa = new SoftAssert();
              
              navigationpage.clickDepartments();
              log.info("Click on Departments");
              Thread.sleep(5000);
              String title=_driver.getCurrentUrl();
              System.out.println(title);
              sa.assertEquals("https://www.cub.com/departments.html", title);
              log.info("Departments page is displayed" );
              
              //Navigate to Meat and Sea Food page
              navigationpage.clickMeat();
              log.info("Click on Meat and SeaFood");
              Thread.sleep(5000);
              String title1=_driver.getCurrentUrl();
              System.out.println(title1);
              sa.assertEquals("https://www.cub.com/departments/meat-seafood.html", title1);
              log.info("Meat and SeaFood page is displayed" );
              
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Deli and Bakery page
              navigationpage.clickBakery();
              log.info("Click on Deli and Bakery");
              Thread.sleep(5000);
              String title2=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/deli-bakery.html", title2);
              log.info("Deli and Bakery page is displayed" );
                           
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Fresh Produce page
              navigationpage.clickFresh();
              log.info("Click on Fresh Produce");
              Thread.sleep(5000);
              String title3=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/produce.html", title3);
              log.info("Fresh Produce page is displayed" );
                                         
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Gift Cards page
              navigationpage.clickGift();
              log.info("Click on Gift Cards");
              Thread.sleep(5000);
              String title4=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/gift-card-floral.html", title4);
              log.info("Gift Cards page is displayed" );
                                         
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Beer and Wine page
              navigationpage.clickBeer();
              log.info("Click on Beer and Wine");
              Thread.sleep(5000);
              String title5=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/liquor.html", title5);
              log.info("Beer and Wine page is displayed" );
                                         
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
              //Navigate to Pet page
              navigationpage.clickPet();
              log.info("Click on Pet");
              Thread.sleep(5000);
              String title6=_driver.getCurrentUrl();
              sa.assertEquals("https://www.cub.com/departments/pet.html", title6);
              log.info("Pet page is displayed" );
                                                       
              navigationpage.clickbacktoDept();
              Thread.sleep(3000);
              log.info("Navigate back to Departments page");
              sa.assertEquals("https://www.cub.com/departments.html", title);
              
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
       
       //Guest User Navigate to pharmacy page
       @Test(priority=3, enabled=true)
       public void NavigatetoPharmacy_GuestUser() {
              
              try {
              cubHome = new FFHome(_driver);
       
              
              SoftAssert sa = new SoftAssert();
              navigationpage=new NavigationPage(_driver);
              navigationpage.clickpharmacy();
              log.info("Click on Pharmacy");
              Thread.sleep(5000);
              String title=_driver.getCurrentUrl();
              System.out.println(title);
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              log.info("Pharmacy page is displayed" );
              
              //Navigate to Pharmacy Departments page
              navigationpage.clickDeptpharma();
              log.info("Click on Pharmacy Departments");
              Thread.sleep(5000);
              String title1=_driver.getCurrentUrl();
              System.out.println(title1);
              sa.assertEquals("https://www.cub.com/pharmacy/home.html", title1);
              log.info("Pharmacy Departments page is displayed" );
              
              navigationpage.clickbacktopharma();
              Thread.sleep(3000);
              log.info("Navigate back to Pharmacy page");
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              
              //Navigate to Our Services page
              navigationpage.clickServices();
              log.info("Click on Our services");
              Thread.sleep(5000);
              String title2=_driver.getCurrentUrl();
              System.out.println(title2);
              sa.assertEquals("https://www.cub.com/pharmacy/our-services.html", title2);
              log.info("Our services page is displayed" );
                           
              navigationpage.clickbacktopharma();
              Thread.sleep(3000);
              log.info("Navigate back to Pharmacy page");
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              
              //Navigate to Store Health page
              navigationpage.clickstorehealth();
              log.info("Click on Store Health");
              Thread.sleep(5000);
              String title3=_driver.getCurrentUrl();
              System.out.println(title3);
              sa.assertEquals("https://www.cub.com/pharmacy/instore-health.html", title3);
              log.info("Store Health page is displayed" );
                                         
              //Navigate to Diabetes page
              navigationpage.clickdiabetes();
              log.info("Click on Diabetes");
              Thread.sleep(5000);
              String title4=_driver.getCurrentUrl();
              System.out.println(title4);
              sa.assertEquals("https://www.cub.com/pharmacy/instore-health/diabetes-coach.html", title4);
              log.info("Diabetes page is displayed" );
                                         
              navigationpage.clickbacktopharma();
              Thread.sleep(3000);
              log.info("Navigate back to Pharmacy page");
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              
              sa.assertAll();
              
       } catch (InterruptedException e) {
              e.printStackTrace();
       }
       }
       
       //Signed In User Navigate to Pharmacy
       @Test(priority=4, enabled=true)
       public void NavigatetoPharmacy_SignedInUser() {
              
              try {
                     
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
                     Thread.sleep(8000);
                     log.info("SignInButton Clicked");
                     log.info("Entered all details and clicked on Sign In Button");
                                  
              SoftAssert sa = new SoftAssert();
              navigationpage=new NavigationPage(_driver);
              navigationpage.clickpharmacy();
              log.info("Click on Pharmacy");
              Thread.sleep(5000);
              String title=_driver.getCurrentUrl();
              System.out.println(title);
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              log.info("Pharmacy page is displayed" );
              
              //Navigate to Pharmacy Departments page
              navigationpage.clickDeptpharma();
              log.info("Click on Pharmacy Departments");
              Thread.sleep(5000);
              String title1=_driver.getCurrentUrl();
              System.out.println(title1);
              sa.assertEquals("https://www.cub.com/pharmacy/home.html", title1);
              log.info("Pharmacy Departments page is displayed" );
              
              navigationpage.clickbacktopharma();
              Thread.sleep(3000);
              log.info("Navigate back to Pharmacy page");
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              
              //Navigate to Our Services page
              navigationpage.clickServices();
              log.info("Click on Our services");
              Thread.sleep(5000);
              String title2=_driver.getCurrentUrl();
              System.out.println(title2);
              sa.assertEquals("https://www.cub.com/pharmacy/our-services.html", title2);
              log.info("Our services page is displayed" );
                           
              navigationpage.clickbacktopharma();
              Thread.sleep(3000);
              log.info("Navigate back to Pharmacy page");
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              
              //Navigate to Store Health page
              navigationpage.clickstorehealth();
              log.info("Click on Store Health");
              Thread.sleep(5000);
              String title3=_driver.getCurrentUrl();
              System.out.println(title3);
              sa.assertEquals("https://www.cub.com/pharmacy/instore-health.html", title3);
              log.info("Store Health page is displayed" );
                                         
              //Navigate to Diabetes page
              navigationpage.clickdiabetes();
              log.info("Click on Diabetes");
              Thread.sleep(5000);
              String title4=_driver.getCurrentUrl();
              System.out.println(title4);
              sa.assertEquals("https://www.cub.com/pharmacy/instore-health/diabetes-coach.html", title4);
              log.info("Diabetes page is displayed" );
                                         
              navigationpage.clickbacktopharma();
              Thread.sleep(3000);
              log.info("Navigate back to Pharmacy page");
              sa.assertEquals("https://www.cub.com/pharmacy.html", title);
              
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
       
       /* ---------------------------- Guest User ------------------------*/
   	// Search functionality without any search criteria

   	@Test(priority=1,enabled=true)
   	public void Guest_Savings_Navigation() throws InterruptedException
   	
   	{	
   		
   		NavigationPage NavigationPage;
      	SoftAssert softAssert = new SoftAssert();
   		
   		NavigationPage = new NavigationPage(_driver);
   		System.out.println("At Cub home page");
   		Thread.sleep(5000);
   		NavigationPage.ClickOnSavings();
   		Thread.sleep(2000);
   		
   		NavigationPage.ClickOnWeeklyAddSpecials();
   		Thread.sleep(2000);
   		String WeeklyAd = NavigationPage.GetCurrentURL();
   		softAssert.assertEquals(WeeklyAd.trim(),"https://www.cub.com/savings/view-ads.html", "Weekly ads special Page is not displayed");
   		
   		NavigationPage.ClickOnWeeklyAd();
   		Thread.sleep(2000);
   		softAssert.assertEquals(WeeklyAd.trim(),"https://www.cub.com/savings/view-ads.html", "Weekly ad page is not displayed");
   		
   		NavigationPage.ClickOnCoupons();
   		Thread.sleep(2000);
   		String strCoupons = NavigationPage.GetCouponsText();
   		softAssert.assertEquals(strCoupons.trim(),"Digital Coupons", "Coupons Page is not displayed ");
   		
   		NavigationPage.ClickOnMobileApp();
   		Thread.sleep(2000);
   		String strMobileApp = NavigationPage.GetMobileAppText();
   		softAssert.assertEquals(strMobileApp.trim(),"More savings with the Cub app.", "Mobile Page is not displayed ");
   		
   		NavigationPage.ClickOnMobileFAQs();
   		Thread.sleep(2000);
   		String strMobileFAQs = NavigationPage.GetCurrentURL();
   		softAssert.assertEquals(strMobileFAQs.trim(),"https://www.cub.com/savings/mobile/faqs.html", "Mobile FAQs Page is not displayed");
   		
   		NavigationPage.ClickOnMyCubRewards();
   		Thread.sleep(2000);
   		String strCubRewards = NavigationPage.GetMyRewardsText();
   		softAssert.assertEquals(strCubRewards.trim(),"My Cub Rewards", "My cub Rewards Page is not displayed");
   		
   		NavigationPage.ClickOnMyCubRewardsFAQs();
   		Thread.sleep(2000);
   		String strRewardsFAQs= NavigationPage.GetCurrentURL();
   		softAssert.assertEquals(strRewardsFAQs.trim(),"https://www.cub.com/savings/my-cub-rewards/faqs.html", "My Cub rewards FAQs Page is not displayed");
   		
   		NavigationPage.ClickOnMyCubRewardsSummerTravel();
   		Thread.sleep(2000);
   		String strRewardsSummerTravel= NavigationPage.GetCurrentURL();
   		softAssert.assertEquals(strRewardsSummerTravel.trim(),"https://www.cub.com/savings/my-cub-rewards/summer-travel.html", "My Cub rewards summer travel Page is not displayed");
   		
   		NavigationPage.ClickOnPromotionsAndSweepstakes();
   		Thread.sleep(2000);
   		String strPS = NavigationPage.GetPromotionsAndSweepstakesText();
   		softAssert.assertEquals(strPS.trim(),"Promotions and Sweepstakes", "Promotions and Sweepstakes Page is not displayed");
   		
   		NavigationPage.ClickOnDiscountedTickets();
   		Thread.sleep(2000);
   		String strDicounted = NavigationPage.GetDiscountedTicketsText();
   		softAssert.assertEquals(strDicounted.trim(),"Discounted Tickets", "Discounted Tickets Page is not displayed");
   		
   		NavigationPage.ClickOnFridayFreebieProgram();
   		Thread.sleep(2000);
   		String strFFP = NavigationPage.GetFridayFreebieText();
   		softAssert.assertEquals(strFFP.trim(),"Get a new Free item every week!", "Friday Freebie Program Page is not displayed");
   		
    	}
   	
   	@Test(priority=2,enabled=true)
   	public void Signed_Savings_Navigation()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException 
   	{
   		
   		// Retrieving test data for valid login
   		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
   		String userId = validLogin.get("UserName");
   		String password = validLogin.get("password");
   		
   		cubHome = new FFHome(_driver);
   		
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
   		this.Guest_Savings_Navigation();
   	}
}

