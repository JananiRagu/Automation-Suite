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

import com.test.regression.cub.pages.AboutUsPage;
import com.test.regression.cub.pages.CubHome;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class AboutUs extends SuiteBase {
	AboutUsPage AbtUsHome;
	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
// Navigate to different tabs in About us page 
// dfhds
	@Test(priority=1,enabled=false)
	public void AboutUsNavigationGuestUser() throws InterruptedException
	{
		AbtUsHome = new AboutUsPage(_driver);
		SoftAssert sa = new SoftAssert();
		AbtUsHome.clickOnAbout();
		 
		AbtUsHome.clickOnAboutSuperValu();
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals(title, "Cub Foods - About SUPERVALU", "\n About SUPERVALU in AboutUs page Navigation - Failed ");
			
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnInvestorInformation();
		String title1=_driver.getTitle();
		System.out.println(title1);
		sa.assertEquals(title1, "Cub Foods - Investor Information", "\n Investor Information in AboutUs page  Navigation - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCareersJobOpportunities();
		String title2=_driver.getTitle();
		System.out.println(title2);
		sa.assertEquals(title2, "Cub Foods - Careers", "\n Careers in AboutUs page Navigation - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnInYourCommunity();
		String title3=_driver.getTitle();
		System.out.println(title3);
		sa.assertEquals(title3, "Cub Foods - In Your Community", "\n In Your Community in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSustainability();
		String title4=_driver.getTitle();
		System.out.println(title4);
		sa.assertEquals(title4, "Cub Foods - Environmental Affairs", "\nSustainability in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnVendorInformation();
		String title5=_driver.getTitle();
		System.out.println(title5);
		sa.assertEquals(title5, "Cub Foods - Vendor Information", "\n Vendor Information in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnProductRecalls();
		String title6=_driver.getTitle();
		System.out.println(title6);
		sa.assertEquals(title6, "Cub Foods - Product Recalls", "\n Product Recalls  in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSatisfactionGuarantee();
		String title7=_driver.getTitle();
		System.out.println(title7);
		sa.assertEquals(title7, "Cub Foods - Satisfaction Guarantee", "\n Satisfaction Guarantee in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnPrivacyPolicy();
		String title8=_driver.getTitle();
		System.out.println(title8);
		sa.assertEquals(title8, "Cub Foods - Security Privacy", "\n Privacy policy  in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnTermsofUse();
		String title9=_driver.getTitle();
		System.out.println(title9);
		sa.assertEquals(title9, "Cub Foods - Terms and Conditions", "\n Terms and Conditions in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSitemap();
		String title16=_driver.getTitle();
		System.out.println(title16);
		sa.assertEquals(title16, "Cub Foods - Sitemap", "\n Sitemap in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCreditCardChipTechnology();
		String title17=_driver.getTitle();
		System.out.println(title17);
		sa.assertEquals(title17, "Cub Foods - Credit Card Chip Technology", "\n Credit Card Chip Technology in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnNoticeOfPrivacyPractices();
		String title18=_driver.getTitle();
		System.out.println(title18);
		sa.assertEquals(title18, "Cub Foods - Notice of Privacy Practices", "\n Notice of Privacy Practices in AboutUs page Navigation  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCustomerService();
		String title19=_driver.getTitle();
		System.out.println(title19);
		sa.assertEquals(title19, "Cub Foods - Customer Service", "\n Customer Service  in AboutUs page Navigation  - Failed ");
		
		 sa.assertAll();
	}	
	

// Navigate to different tabs in About us page for SIGNED IN User
	

	@Test(priority=2,enabled=true)
	public void AboutUsNavigationSignedInUser()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException 
	{
		
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		
		cubHome = new CubHome(_driver);
		SoftAssert sa = new SoftAssert();

		log.info("Cub Home page is launched");
	cubHome.clickSignInLink();
	cubHome.enterLoginDetails(userId, password);
	cubHome.clickSignInButton();
	 	Thread.sleep(5000);		
		AbtUsHome = new AboutUsPage(_driver);
		AbtUsHome.clickOnAbout();
		 
		AbtUsHome.clickOnAboutSuperValu();
		String title=_driver.getTitle();
		System.out.println(title);
		sa.assertEquals(title, "Cub Foods - About SUPERVALU", "\n About SUPERVALU in AboutUs page Navigation  for SIGNED IN User - Failed ");
			
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnInvestorInformation();
		String title1=_driver.getTitle();
		System.out.println(title1);
		sa.assertEquals(title1, "Cub Foods - Investor Information", "\n Investor Information in AboutUs page  Navigation for SIGNED IN User - Failed ");
		log.info("Investor Information in AboutUs page  Navigation - Success " );
	
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCareersJobOpportunities();
		String title2=_driver.getTitle();
		System.out.println(title2);
		sa.assertEquals(title2, "Cub Foods - Careers", "\n Careers in AboutUs page Navigation for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnInYourCommunity();
		String title3=_driver.getTitle();
		System.out.println(title3);
		sa.assertEquals(title3, "Cub Foods - In Your Community", "\n In Your Community in AboutUs page Navigation for SIGNED IN User  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSustainability();
		String title4=_driver.getTitle();
		System.out.println(title4);
		sa.assertEquals(title4, "Cub Foods - Environmental Affairs", "\n Sustainability in AboutUs page Navigation  for SIGNED IN User - Failed ");
		log.info("Sustainability in AboutUs page Navigation - Success " );
	
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnVendorInformation();
		String title5=_driver.getTitle();
		System.out.println(title5);
		sa.assertEquals(title5, "Cub Foods - Vendor Information", "\n Vendor Information in AboutUs page Navigation  for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnProductRecalls();
		String title6=_driver.getTitle();
		System.out.println(title6);
		sa.assertEquals(title6, "Cub Foods - Product Recalls", "\n Product Recalls  in AboutUs page Navigation  for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSatisfactionGuarantee();
		String title7=_driver.getTitle();
		System.out.println(title7);
		sa.assertEquals(title7, "Cub Foods - Satisfaction Guarantee", "\n Satisfaction Guarantee in AboutUs page Navigation for SIGNED IN User  - Failed ");
		log.info("Satisfaction Guarantee in AboutUs Page Navigation - Success " );
	
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnPrivacyPolicy();
		String title8=_driver.getTitle();
		System.out.println(title8);
		sa.assertEquals(title8, "Cub Foods - Security Privacy", "\n Privacy policy  in AboutUs page Navigation  for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnTermsofUse();
		String title9=_driver.getTitle();
		System.out.println(title9);
		sa.assertEquals(title9, "Cub Foods - Terms and Conditions", "\n Terms and Conditions in AboutUs page Navigation  for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnSitemap();
		String title16=_driver.getTitle();
		System.out.println(title16);
		sa.assertEquals(title16, "Cub Foods - Sitemap", "\n Sitemap in AboutUs page Navigation for SIGNED IN User  - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCreditCardChipTechnology();
		String title17=_driver.getTitle();
		System.out.println(title17);
		sa.assertEquals(title17, "Cub Foods - Credit Card Chip Technology", "\n Credit Card Chip Technology in AboutUs page Navigation  for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnNoticeOfPrivacyPractices();
		String title18=_driver.getTitle();
		System.out.println(title18);
		sa.assertEquals(title18, "Cub Foods - Notice of Privacy Practices", "\n Notice of Privacy Practices in AboutUs page Navigation  for SIGNED IN User - Failed ");
		
		AbtUsHome.clickOnAbout();
		AbtUsHome.clickOnCustomerService();
		String title19=_driver.getTitle();
		System.out.println(title19);
		sa.assertEquals(title19, "Cub Foods - Customer Service", "\n Customer Service  in AboutUs page Navigation  for SIGNED IN User - Failed ");
	
		
		 sa.assertAll();
	}	
}
	