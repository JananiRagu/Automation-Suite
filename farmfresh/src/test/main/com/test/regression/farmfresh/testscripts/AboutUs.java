package com.test.regression.farmfresh.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.test.regression.farmfresh.pages.AboutUsPage;
import com.test.regression.farmfresh.pages.FFHome;
import com.test.regression.farmfresh.utils.Logg;
import com.test.regression.farmfresh.utils.ReadXML;
import com.test.regression.farmfresh.utils.SuiteBase;

public class AboutUs extends SuiteBase{
	AboutUsPage AbtUsHome;
	FFHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
// Navigate to different tabs in About us page 

	@Test(priority=1,enabled=true)
	public void aboutSupervlau()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnAboutSuperValu();
		String title=_driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cub Foods - About SUPERVALU", title);
		log.info("About SUPERVALU in AboutUs page Navigation - Success " );
	}
	
	@Test(priority=2,enabled=true)
	public void investorInformation()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnInvestorInformation();
		String title1=_driver.getTitle();
		System.out.println(title1);
		Assert.assertEquals("Cub Foods - Investor Information", title1);
		log.info("Investor Information in AboutUs page  Navigation - Success " );
	}
	
	@Test(priority=3,enabled=true)
	public void careersJobOpportunities()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCareersJobOpportunities();
		String title2=_driver.getTitle();
		System.out.println(title2);
		Assert.assertEquals("Cub Foods - Careers", title2);
		log.info("Careers in AboutUs page Navigation - Success " );
	}
	
	@Test(priority=4,enabled=true)
	public void inYourCommunity()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnInYourCommunity();
		String title3=_driver.getTitle();
		System.out.println(title3);
		Assert.assertEquals("Cub Foods - In Your Community", title3);
		log.info("In Your Community in AboutUs page Navigation - Success " );
	}	
	
	
	@Test(priority=5,enabled=true)
	public void sustainability()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSustainability();
		String title4=_driver.getTitle();
		System.out.println(title4);
		Assert.assertEquals("Cub Foods - Environmental Affairs", title4);
		log.info("Sustainability in AboutUs page Navigation - Success " );
	}
	
	@Test(priority=6,enabled=true)
	public void vendorInformation()
	{	
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnVendorInformation();
		String title5=_driver.getTitle();
		System.out.println(title5);
		Assert.assertEquals("Cub Foods - Vendor Information", title5);
		log.info(" Vendor Information in AboutUs Page Navigation - Success " );
	}
	
	@Test(priority=7,enabled=true)
	public void productRecalls()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnProductRecalls();
		String title6=_driver.getTitle();
		System.out.println(title6);
		Assert.assertEquals("Cub Foods - Product Recalls", title6);
		log.info("Product Recalls in AboutUs Page Navigation - Success " );
	}
	
	@Test(priority=8,enabled=true)
	public void satisfactionGuarantee()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSatisfactionGuarantee();
		String title7=_driver.getTitle();
		System.out.println(title7);
		Assert.assertEquals("Cub Foods - Satisfaction Guarantee", title7);
		log.info("Satisfaction Guarantee in AboutUs Page Navigation - Success " );
	}
	
	@Test(priority=9,enabled=true)
	public void privacyPolicy()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnPrivacyPolicy();
		String title8=_driver.getTitle();
		System.out.println(title8);
		Assert.assertEquals("Cub Foods - Security Privacy", title8);
		log.info(" Privacy policy in AboutUs Page Navigation - Success " );
	}
	
	@Test(priority=10,enabled=true)
	public void termsofUse()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnTermsofUse();
		String title9=_driver.getTitle();
		System.out.println(title9);
		Assert.assertEquals("Cub Foods - Terms and Conditions", title9);
		log.info("Terms and Conditions in AboutUs Page Navigation - Success " );
	}
	
	@Test(priority=11,enabled=true)
	public void sitemap()
	{		
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSitemap();
		String title16=_driver.getTitle();
		System.out.println(title16);
	   Assert.assertEquals("Cub Foods - Sitemap", title16);
		log.info("Sitemap  in About Us Page Navigation - Success " );
	}
	
	@Test(priority=12,enabled=true)
	public void creditCardChipTechnology()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCreditCardChipTechnology();
		String title17=_driver.getTitle();
		System.out.println(title17);
		Assert.assertEquals("Cub Foods - Credit Card Chip Technology", title17);
		log.info(" Credit Card Chip Technology  in About Us Page Navigation - Success " );
	}
	
	@Test(priority=13,enabled=true)
	public void noticeOfPrivacyPractices()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnNoticeOfPrivacyPractices();
		String title18=_driver.getTitle();
		System.out.println(title18);
		Assert.assertEquals("Cub Foods - Notice of Privacy Practices", title18);
		log.info("Notice of Privacy Practices in About Us page Navigation - Success " );
	}
	
	@Test(priority=14,enabled=true)
	public void customerService()
	{
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCustomerService();
		String title19=_driver.getTitle();
		System.out.println(title19);
		Assert.assertEquals("Cub Foods - Customer Service", title19);
		log.info("Customer Service in About Us page  Navigation - Success " );
	}	

// Navigate to different tabs in About us page for SIGNED IN User
		
		@Test(priority=15,enabled=true)
		public void aboutSupervlauSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnAboutSuperValu();
			String title=_driver.getTitle();
			System.out.println(title);
			Assert.assertEquals("Cub Foods - About SUPERVALU", title);
			log.info("About SUPERVALU in AboutUs page Navigation - Success " );
			//this.aboutSupervlau();
			cubHome.clickOnLogOutLink();		
		}
		
		@Test(priority=16,enabled=true)
		public void investorInformationSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnInvestorInformation();
			String title1=_driver.getTitle();
			System.out.println(title1);
			Assert.assertEquals("Cub Foods - Investor Information", title1);
			log.info("Investor Information in AboutUs page  Navigation - Success " );
		}
	
		@Test(priority=17,enabled=true)
		public void careersJobOpportunitiesSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnCareersJobOpportunities();
			String title2=_driver.getTitle();
			System.out.println(title2);
			Assert.assertEquals("Cub Foods - Careers", title2);
			log.info("Careers in AboutUs page Navigation - Success " );
		}
		
		@Test(priority=18,enabled=true)
		public void inYourCommunitySignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnInYourCommunity();
			String title3=_driver.getTitle();
			System.out.println(title3);
			Assert.assertEquals("Cub Foods - In Your Community", title3);
			log.info("In Your Community in AboutUs page Navigation - Success " );
		}	
		
		
		@Test(priority=19,enabled=true)
		public void sustainabilitySignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnSustainability();
			String title4=_driver.getTitle();
			System.out.println(title4);
			Assert.assertEquals("Cub Foods - Environmental Affairs", title4);
			log.info("Sustainability in AboutUs page Navigation - Success " );
		}
		
		@Test(priority=20,enabled=true)
		public void vendorInformationSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnVendorInformation();
			String title5=_driver.getTitle();
			System.out.println(title5);
			Assert.assertEquals("Cub Foods - Vendor Information", title5);
			log.info(" Vendor Information in AboutUs Page Navigation - Success " );
		}
		
		@Test(priority=21,enabled=true)
		public void productRecallsSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnProductRecalls();
			String title6=_driver.getTitle();
			System.out.println(title6);
			Assert.assertEquals("Cub Foods - Product Recalls", title6);
			log.info("Product Recalls in AboutUs Page Navigation - Success " );
		}
		
		@Test(priority=22,enabled=true)
		public void satisfactionGuaranteeSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnSatisfactionGuarantee();
			String title7=_driver.getTitle();
			System.out.println(title7);
			Assert.assertEquals("Cub Foods - Satisfaction Guarantee", title7);
			log.info("Satisfaction Guarantee in AboutUs Page Navigation - Success " );
		}
		
		@Test(priority=23,enabled=true)
		public void privacyPolicySignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnPrivacyPolicy();
			String title8=_driver.getTitle();
			System.out.println(title8);
			Assert.assertEquals("Cub Foods - Security Privacy", title8);
			log.info(" Privacy policy in AboutUs Page Navigation - Success " );
		}
		
		@Test(priority=24,enabled=true)
		public void termsofUseSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnTermsofUse();
			String title9=_driver.getTitle();
			System.out.println(title9);
			Assert.assertEquals("Cub Foods - Terms and Conditions", title9);
			log.info("Terms and Conditions in AboutUs Page Navigation - Success " );
		}
		
		@Test(priority=25,enabled=true)
		public void sitemapSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnSitemap();
			String title16=_driver.getTitle();
			System.out.println(title16);
		   Assert.assertEquals("Cub Foods - Sitemap", title16);
			log.info("Sitemap  in About Us Page Navigation - Success " );
		}
		
		@Test(priority=26,enabled=true)
		public void creditCardChipTechnologySignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnCreditCardChipTechnology();
			String title17=_driver.getTitle();
			System.out.println(title17);
			Assert.assertEquals("Cub Foods - Credit Card Chip Technology", title17);
			log.info(" Credit Card Chip Technology  in About Us Page Navigation - Success " );
		}
		
		@Test(priority=27,enabled=true)
		public void noticeOfPrivacyPracticesSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnNoticeOfPrivacyPractices();
			String title18=_driver.getTitle();
			System.out.println(title18);
			Assert.assertEquals("Cub Foods - Notice of Privacy Practices", title18);
			log.info("Notice of Privacy Practices in About Us page Navigation - Success " );
		}
		
		@Test(priority=28,enabled=true)
		public void customerServiceSignedIn()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException {
			
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
			log.info("Click on About Header tab ");
			
			AbtUsHome = new AboutUsPage(_driver);
			Thread.sleep(5000);
			AbtUsHome.clickOnAbout();
			AbtUsHome.clickOnCustomerService();
			String title19=_driver.getTitle();
			System.out.println(title19);
			Assert.assertEquals("Cub Foods - Customer Service", title19);
			log.info("Customer Service in About Us page  Navigation - Success " );
		}
		
		
}
	
	
	

