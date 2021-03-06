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

import com.test.regression.cub.pages.SiteMapPage;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class SiteMap extends SuiteBase{
	SiteMapPage SiteMap;
	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	SoftAssert softAssert = new SoftAssert();
	
// Navigate to different links in Site Map page 

	@Test(priority=1,enabled=true)
	public void GuestUserSiteMap() throws InterruptedException
	
	{	
		System.out.println("Inside Site Map page");
		SiteMap = new SiteMapPage(_driver);
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		System.out.println("Clicked on Site Map link in About Us page");
		String title=_driver.getTitle();
		System.out.println(title);
		softAssert.assertEquals(title, "Cub Foods - Sitemap", "Failed to load the Site Map page");
		log.info("Site Map in AboutUs page  Navigation - Success ");
		
		//Checking Savings link
		SiteMap.clickOnSavings();
		Thread.sleep(5000);
		String title0=_driver.getTitle();
		System.out.println(title0);
		softAssert.assertEquals(title0, "Cub Foods - Savings | MN & IL Grocery Store | Cub Foods", "Failed to load the Site Map page");
		
		//Checking WeeklyAdSpecial link
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnWeeklyAdSpecial();
		Thread.sleep(5000);
		String title1=_driver.getTitle();
		System.out.println(title1);
		softAssert.assertEquals(title1, "Cub Foods - View Ads", "Failed to load the Weekly Ad Special page");
		
		//Checking WeeklyAdSpecial link
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.ClickOnWeeklyAd();
		Thread.sleep(5000);
		String title2=_driver.getTitle();
		System.out.println(title2);
		softAssert.assertEquals(title2, "Cub Foods - View Ads", "Failed to load the Weekly Ad page");

		//Checking Coupons link
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnCoupons();
		Thread.sleep(5000);
		String title3=_driver.getTitle();
		System.out.println(title3);
		softAssert.assertEquals(title3, "Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", "Failed to load the Coupons page");

		//Checking Mobile link
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnMobileApp();
		Thread.sleep(5000);
		String title4=_driver.getTitle();
		System.out.println(title4);
		softAssert.assertEquals(title4, "Cub Foods - Mobile App", "Failed to load the Mobile App page");

		//Checking FAQs
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnFAQs();
		Thread.sleep(5000);
		String title5=_driver.getTitle();
		System.out.println(title5);
		softAssert.assertEquals(title5, "Cub Foods - FAQs", "Failed to load the FAQs page");

		//Checking My Cub Rewards
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnMyCubRewards();
		Thread.sleep(5000);
		String title6=_driver.getTitle();
		System.out.println(title6);
		softAssert.assertEquals(title6,"Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", "Failed to load the  My Cub Rewards page");

		//Checking My Cub Rewards FAQs
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnMyCubRewards_FAQs();
		Thread.sleep(5000);
		String title7=_driver.getTitle();
		System.out.println(title7);
		softAssert.assertEquals(title7,"Cub Foods - FAQs","Failed to load the Mobile App page" );

		//Checking Summer travel
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnSummerTravel();
		Thread.sleep(5000);
		String title8=_driver.getTitle();
		System.out.println(title8);
		softAssert.assertEquals(title8,"Cub Foods - Summer Travel", "Failed to load the Summer Travel page");

		//Checking Promotins Sweep stakes
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnPromotinsSweepstakes();
		Thread.sleep(5000);
		String title9=_driver.getTitle();
		System.out.println(title9);
		softAssert.assertEquals(title9,"Cub Foods - Promotions & Sweepstakes | MN & IL Grocery Store | Cub Foods", "Failed to load the Promotins Sweep stakes page");
	
		//Checking Discounted Tickets
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnDiscountedTickets();
		Thread.sleep(5000);
		String title10=_driver.getTitle();
		System.out.println(title10);
		softAssert.assertEquals(title10,"Cub Foods - Discounted Tickets", "Failed to load the Discounted Tickets page");

		//Checking Friday Freebie Program
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnFridayFreebieProgram();
		Thread.sleep(5000);
		String title11=_driver.getTitle();
		System.out.println(title11);
		softAssert.assertEquals(title11,"Cub Foods - Friday Freebie Program", "Failed to load the  Friday Freebie Program page" );
	
		//Checking Recipes
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnRecipes();
		Thread.sleep(7000);
		String title12=_driver.getTitle();
		System.out.println(title12);
		softAssert.assertEquals(title12,"Cub Foods - Recipes | MN & IL Grocery Store | Cub Foods", "Failed to load the Recipes page" );
	
		//Checking Search Recipes
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnSearchRecipes();
		Thread.sleep(7000);
		String title13=_driver.getTitle();
		System.out.println(title13);
		softAssert.assertEquals(title13,"Cub Foods - Search Recipes | MN & IL Grocery Store | Cub Foods", "Failed to load the search recipes page" );
		
		//Checking Deaprtments
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnDepartments();
		Thread.sleep(7000);
		String title14=_driver.getTitle();
		System.out.println(title14);
		softAssert.assertEquals(title14,"Cub Foods - Departments | MN & IL Grocery Store | Cub Foods", "Failed to load the departments page" );
		
	
		//Checking Meat And Sea food
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnMeatAndSeafood();
		Thread.sleep(7000);
		String title15=_driver.getTitle();
		System.out.println(title15);
		softAssert.assertEquals(title15,"Cub Foods - Meat & Seafood | MN & IL Grocery Store | Cub Foods", "Failed to load the Meat And Sea food page");

		//Checking Deli And Bakery	
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnDeliAndBakery();
		Thread.sleep(9000);
		String title16=_driver.getTitle();
		System.out.println(title16);
		softAssert.assertEquals(title16,"Cub Foods - Deli & Bakery | MN & IL Grocery Store | Cub Foods", "Failed to load the Meat And Sea food page");
		
		//Checking Fresh Produce	
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnFreshProduce();
		Thread.sleep(9000);
		String title17=_driver.getTitle();
		System.out.println(title17);
		softAssert.assertEquals(title17,"Cub Foods - Fresh Produce | MN & IL Grocery Store | Cub Foods", "Failed to load the Fresh Produce page");
	
		//Checking Cards And Floral
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnGiftCardsAndFloral();
		Thread.sleep(5000);
		String title18=_driver.getTitle();
		System.out.println(title18);
		softAssert.assertEquals(title18,"Cub Foods - Gift & Floral | MN & IL Grocery Store | Cub Foods", "Failed to load the Cards And Floral page");

		//Checking Beer And Wine
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnBeerAndWine();
		Thread.sleep(5000);
		String title19=_driver.getTitle();
		System.out.println(title19);
		softAssert.assertEquals(title19,"Cub Foods - Beer & Wine | MN & IL Grocery Store | Cub Foods", "Failed to load the Beer And Wine page");

		//Checking Site Map Link
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnPet();
		Thread.sleep(5000);
		String title20=_driver.getTitle();
		System.out.println(title20);
		softAssert.assertEquals(title20,"Cub Foods - Pet | MN & IL Grocery Store | Cub Foods", "Failed to load the Site Map Link page");


		//Checking Pharmacy
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnPharmacy();
		Thread.sleep(5000);
		String title21=_driver.getTitle();
		System.out.println(title21);
		softAssert.assertEquals(title21,"Cub Foods - Pharmacy | MN & IL Grocery Store | Cub Foods",  "Failed to load the Pharmacy page");

		//Checking Pharmacy_Departments
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnPharmacy_Departments();
		Thread.sleep(5000);
		String title22=_driver.getTitle();
		System.out.println(title22);
		softAssert.assertEquals(title22,"Cub Foods - Departments", "Failed to load the Pharmacy_Departments page");

		//Checking Our Services
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnOurServices();
		Thread.sleep(5000);
		String title23=_driver.getTitle();
		System.out.println(title23);
		softAssert.assertEquals(title23,"Cub Foods - Our Services", "Failed to load the Our Services page");

		//Checking InStore Health Programs
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnInStoreHealthPrograms();
		Thread.sleep(5000);
		String title24=_driver.getTitle();
		System.out.println(title24);
		softAssert.assertEquals(title24,"Cub Foods - In Store Health Programs",  "Failed to load the InStore Health Programs page");
	
		//Checking Diabetes Coach
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnDiabetesCoach();
		Thread.sleep(5000);
		String title25=_driver.getTitle();
		System.out.println(title25);
		softAssert.assertEquals(title25,"Cub Foods - Diabetes Coach", "Failed to load the Diabetes Coach page");
	
		//Checking About Link
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnAboutLink();
		Thread.sleep(5000);
		String title26=_driver.getTitle();
		System.out.println(title26);
		softAssert.assertEquals(title26,"Cub Foods - About | MN & IL Grocery Store | Cub Foods", "Failed to load the About Link page");

		//Checking About SUPERVALU
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnAboutSUPERVALU();
		Thread.sleep(5000);
		String title27=_driver.getTitle();
		System.out.println(title27);
		softAssert.assertEquals(title27,"Cub Foods - About SUPERVALU", "Failed to load the About SUPERVALU page");

		//Checking Investor Information
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnInvestorInformation();
		Thread.sleep(5000);
		String title28=_driver.getTitle();
		System.out.println(title28);
		softAssert.assertEquals(title28,"Cub Foods - Investor Information",  "Failed to load the Investor Information page");

		//Checking Carrers Or JobInformation
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnCarrersOrJobInformation();
		Thread.sleep(5000);
		String title29=_driver.getTitle();
		System.out.println(title29);
		softAssert.assertEquals(title29,"Cub Foods - Careers", "Failed to load the  Carrers Or JobInformation page");

		//Checking RetailJobs
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnRetailJobs();
		Thread.sleep(5000);
		String title30=_driver.getTitle();
		System.out.println(title30);
		softAssert.assertEquals(title30,"Cub Foods - Retail Jobs", "Failed to load the  RetailJobs page");

		//Checking In Your Community
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnInYourCommunity();
		Thread.sleep(5000);
		String title31=_driver.getTitle();
		System.out.println(title31);
		softAssert.assertEquals(title31,"Cub Foods - In Your Community", "Failed to load the  In Your Community page");

		//Checking Sustainability
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnSustainability();
		Thread.sleep(5000);
		String title32=_driver.getTitle();
		System.out.println(title32);
		softAssert.assertEquals(title32,"Cub Foods - Environmental Affairs", "Failed to load the Sustainability page");

		//Checking Vendor Information
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnVendorInformation();
		Thread.sleep(5000);
		String title33=_driver.getTitle();
		System.out.println(title33);
		softAssert.assertEquals(title33,"Cub Foods - Vendor Information",  "Failed to load the Vendor Information page");

		//Checking Product Recalls
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnProductRecalls();
		Thread.sleep(5000);
		String title331=_driver.getTitle();
		System.out.println(title331);
		softAssert.assertEquals(title331,"Cub Foods - Product Recalls", "Failed to load the Product Recalls page");

		//Checking Satisfaction Gaurantee
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnSatisfactionGaurantee();
		Thread.sleep(5000);
		String title34=_driver.getTitle();
		System.out.println(title34);
		softAssert.assertEquals(title34,"Cub Foods - Satisfaction Guarantee", "Failed to load the Satisfaction Gaurantee page");

		//Checking Privacy Policy
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnPrivacyPolicy();
		Thread.sleep(5000);
		String title35=_driver.getTitle();
		System.out.println(title35);
		softAssert.assertEquals(title35,"Cub Foods - Security Privacy", "Failed to load the Privacy Policy page");

		//Checking Terms Of Use
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnTermsOfUse();
		Thread.sleep(5000);
		String title36=_driver.getTitle();
		System.out.println(title36);
		softAssert.assertEquals(title36,"Cub Foods - Terms and Conditions", "Failed to load the Terms Of Use page"); 

		//Checking Site Map hyperlink
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnSiteMapHyperLink();
		Thread.sleep(5000);
		String title37=_driver.getTitle();
		System.out.println(title37);
		softAssert.assertEquals(title37,"Cub Foods - Sitemap", "Failed to load the Site Map page");

		//Checking Credit Card ChipTechnology
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnCreditCardChipTechnology();
		Thread.sleep(5000);
		String title38=_driver.getTitle();
		System.out.println(title38);
		softAssert.assertEquals(title38,"Cub Foods - Credit Card Chip Technology", "Failed to load the Credit Card ChipTechnology page");

		//Checking Notice Of Privacy Practices
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnNoticeOfPrivacyPractices();
		Thread.sleep(5000);
		String title39=_driver.getTitle();
		System.out.println(title39);
		softAssert.assertEquals(title39,"Cub Foods - Notice of Privacy Practices", "Failed to load the Notice Of Privacy Practices page");

		//Checking What Is HIPPA
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnWhatIsHIPPA();
		Thread.sleep(5000);
		String title40=_driver.getTitle();
		System.out.println(title40);
		softAssert.assertEquals(title40,"Cub Foods - What is HIPAA?", "Failed to load the 'What Is HIPPA' page");

		//Checking HIPPA_Minnesota
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnHIPPA_Minnesota();
		Thread.sleep(5000);
		String title41=_driver.getTitle();
		System.out.println(title41);
		softAssert.assertEquals(title41,"Cub Foods - HIPAA Minnesota", "Failed to load the HIPPA_Minnesota page");

		//Checking HIPPA_Missouri
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnHIPPA_Missouri();
		Thread.sleep(5000);
		String title42=_driver.getTitle();
		System.out.println(title42);
		softAssert.assertEquals(title42,"Cub Foods - HIPAA Missouri", "Failed to load the HIPPA_Missouri page");

		//Checking HIPPA_NorthCarolina
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnHIPPA_NorthCarolina();
		Thread.sleep(5000);
		String title43=_driver.getTitle();
		System.out.println(title43);
		softAssert.assertEquals(title43,"Cub Foods - HIPAA North Carolina", "Failed to load the HIPPA_NorthCarolina page");

		//Checking Customer Service
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnCustomerService();
		String title44=_driver.getTitle();
		System.out.println(title44);
		softAssert.assertEquals(title44,"Cub Foods - Customer Service", "Failed to load the Customer Service page");

		//Checking Grocery Delivery
		SiteMap = new SiteMapPage(_driver);
		SiteMap.clickOnAbout();
		SiteMap.clickOnSiteMap();
		SiteMap.clickOnGroceryDelivery();
		String title45=_driver.getTitle();
		System.out.println(title45);
		softAssert.assertEquals(title45,"Cub Grocery Delivery - Instacart", "Failed to load the Grocery Delivery page");
		softAssert.assertAll();
	}

// Navigate to different links in SiteMap page for SIGNED IN User
		
		@Test(priority=2,enabled=true)
		public void SignedUserSiteMap()throws InterruptedException, IOException, XPathExpressionException, ParserConfigurationException, SAXException 
		{
			
			// Retrieving test data for valid login
			Map<String, String> validLogin = readxml.getUserData("TestData.xml", "authorized-user-1");
			String userId = validLogin.get("UserName");
			String password = validLogin.get("password");
			
			cubHome = new CubHome(_driver);
			
			log.info("Cub Home page is launched");
		cubHome.clickSignInLink();
		cubHome.enterLoginDetails(userId, password);
		cubHome.clickSignInButton();
			
			Thread.sleep(5000);
			
			System.out.println("Inside Site Map page");
			SiteMap = new SiteMapPage(_driver);
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			System.out.println("Clicked on Site Map link in About Us page");
			String title=_driver.getTitle();
			System.out.println(title);
			softAssert.assertEquals(title, "Cub Foods - Sitemap", "Failed to load the Site Map page");
		
			
			//Checking Savings link
			SiteMap.clickOnSavings();
			Thread.sleep(5000);
			String title0=_driver.getTitle();
			System.out.println(title0);
			softAssert.assertEquals(title0, "Cub Foods - Savings | MN & IL Grocery Store | Cub Foods", "Failed to load the Site Map page");
			
			//Checking WeeklyAdSpecial link
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnWeeklyAdSpecial();
			Thread.sleep(5000);
			String title1=_driver.getTitle();
			System.out.println(title1);
			softAssert.assertEquals(title1, "Cub Foods - View Ads", "Failed to load the Weekly Ad Special page");
			
			//Checking WeeklyAdSpecial link
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.ClickOnWeeklyAd();
			Thread.sleep(5000);
			String title2=_driver.getTitle();
			System.out.println(title2);
			softAssert.assertEquals(title2, "Cub Foods - View Ads", "Failed to load the Weekly Ad page");

			//Checking Coupons link
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnCoupons();
			Thread.sleep(5000);
			String title3=_driver.getTitle();
			System.out.println(title3);
			softAssert.assertEquals(title3, "Cub Foods - View Coupons | MN & IL Grocery Store | Cub Foods", "Failed to load the Coupons page");

			//Checking Mobile link
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnMobileApp();
			Thread.sleep(5000);
			String title4=_driver.getTitle();
			System.out.println(title4);
			softAssert.assertEquals(title4, "Cub Foods - Mobile App", "Failed to load the Mobile App page");

			//Checking FAQs
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnFAQs();
			Thread.sleep(5000);
			String title5=_driver.getTitle();
			System.out.println(title5);
			softAssert.assertEquals(title5, "Cub Foods - FAQs", "Failed to load the FAQs page");

			//Checking My Cub Rewards
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnMyCubRewards();
			Thread.sleep(5000);
			String title6=_driver.getTitle();
			System.out.println(title6);
			softAssert.assertEquals(title6,"Cub Foods - My Cub Rewards | MN & IL Grocery Store | Cub Foods", "Failed to load the  My Cub Rewards page");

			//Checking My Cub Rewards FAQs
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnMyCubRewards_FAQs();
			Thread.sleep(5000);
			String title7=_driver.getTitle();
			System.out.println(title7);
			softAssert.assertEquals(title7,"Cub Foods - FAQs","Failed to load the Mobile App page" );

			//Checking Summer travel
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnSummerTravel();
			Thread.sleep(5000);
			String title8=_driver.getTitle();
			System.out.println(title8);
			softAssert.assertEquals(title8,"Cub Foods - Summer Travel", "Failed to load the Summer Travel page");

			//Checking Promotins Sweep stakes
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnPromotinsSweepstakes();
			Thread.sleep(5000);
			String title9=_driver.getTitle();
			System.out.println(title9);
			softAssert.assertEquals(title9,"Cub Foods - Promotions & Sweepstakes | MN & IL Grocery Store | Cub Foods", "Failed to load the Promotins Sweep stakes page");
		
			//Checking Discounted Tickets
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnDiscountedTickets();
			Thread.sleep(5000);
			String title10=_driver.getTitle();
			System.out.println(title10);
			softAssert.assertEquals(title10,"Cub Foods - Discounted Tickets", "Failed to load the Discounted Tickets page");

			//Checking Friday Freebie Program
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnFridayFreebieProgram();
			Thread.sleep(5000);
			String title11=_driver.getTitle();
			System.out.println(title11);
			softAssert.assertEquals(title11,"Cub Foods - Friday Freebie Program", "Failed to load the  Friday Freebie Program page" );
		
			//Checking Recipes
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnRecipes();
			Thread.sleep(5000);
			String title12=_driver.getTitle();
			System.out.println(title12);
			softAssert.assertEquals(title12,"Cub Foods - Sitemap", "Failed to load the Recipes page" );
		
			//Checking Search Recipes
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnSearchRecipes();
			Thread.sleep(5000);
			String title13=_driver.getTitle();
			System.out.println(title13);
			softAssert.assertEquals(title13,"Cub Foods - Sitemap", "Failed to load the search recipes page" );
			
			//Checking Deaprtments
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnDepartments();
			Thread.sleep(5000);
			String title14=_driver.getTitle();
			System.out.println(title14);
			softAssert.assertEquals(title14,"Cub Foods - Sitemap", "Failed to load the departments page" );
			
		
			//Checking Meat And Sea food
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnMeatAndSeafood();
			Thread.sleep(5000);
			String title15=_driver.getTitle();
			System.out.println(title15);
			softAssert.assertEquals(title15,"Cub Foods - Sitemap", "Failed to load the Meat And Sea food page");

			//Checking Deli And Bakery	
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnDeliAndBakery();
			Thread.sleep(5000);
			String title16=_driver.getTitle();
			System.out.println(title16);
			softAssert.assertEquals(title16,"Cub Foods - Deli & Bakery | MN & IL Grocery Store | Cub Foods", "Failed to load the Meat And Sea food page");
			
			//Checking Fresh Produce	
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnFreshProduce();
			Thread.sleep(5000);
			String title17=_driver.getTitle();
			System.out.println(title17);
			softAssert.assertEquals(title17,"Cub Foods - Fresh Produce | MN & IL Grocery Store | Cub Foods", "Failed to load the Fresh Produce page");
		
			//Checking Cards And Floral
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnGiftCardsAndFloral();
			Thread.sleep(5000);
			String title18=_driver.getTitle();
			System.out.println(title18);
			softAssert.assertEquals(title18,"Cub Foods - Gift & Floral | MN & IL Grocery Store | Cub Foods", "Failed to load the Cards And Floral page");

			//Checking Beer And Wine
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnBeerAndWine();
			Thread.sleep(5000);
			String title19=_driver.getTitle();
			System.out.println(title19);
			softAssert.assertEquals(title19,"Cub Foods - Beer & Wine | MN & IL Grocery Store | Cub Foods", "Failed to load the Beer And Wine page");

			//Checking Site Map Link
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnPet();
			Thread.sleep(5000);
			String title20=_driver.getTitle();
			System.out.println(title20);
			softAssert.assertEquals(title20,"Cub Foods - Pet | MN & IL Grocery Store | Cub Foods", "Failed to load the Site Map Link page");


			//Checking Pharmacy
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnPharmacy();
			Thread.sleep(5000);
			String title21=_driver.getTitle();
			System.out.println(title21);
			softAssert.assertEquals(title21,"Cub Foods - Pharmacy | MN & IL Grocery Store | Cub Foods",  "Failed to load the Pharmacy page");

			//Checking Pharmacy_Departments
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnPharmacy_Departments();
			Thread.sleep(5000);
			String title22=_driver.getTitle();
			System.out.println(title22);
			softAssert.assertEquals(title22,"Cub Foods - Departments", "Failed to load the Pharmacy_Departments page");

			//Checking Our Services
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnOurServices();
			Thread.sleep(5000);
			String title23=_driver.getTitle();
			System.out.println(title23);
			softAssert.assertEquals(title23,"Cub Foods - Our Services", "Failed to load the Our Services page");

			//Checking InStore Health Programs
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnInStoreHealthPrograms();
			Thread.sleep(5000);
			String title24=_driver.getTitle();
			System.out.println(title24);
			softAssert.assertEquals(title24,"Cub Foods - In Store Health Programs",  "Failed to load the InStore Health Programs page");
		
			//Checking Diabetes Coach
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnDiabetesCoach();
			Thread.sleep(5000);
			String title25=_driver.getTitle();
			System.out.println(title25);
			softAssert.assertEquals(title25,"Cub Foods - Diabetes Coach", "Failed to load the Diabetes Coach page");
		
			//Checking About Link
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnAboutLink();
			Thread.sleep(5000);
			String title26=_driver.getTitle();
			System.out.println(title26);
			softAssert.assertEquals(title26,"Cub Foods - About | MN & IL Grocery Store | Cub Foods", "Failed to load the About Link page");

			//Checking About SUPERVALU
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnAboutSUPERVALU();
			Thread.sleep(5000);
			String title27=_driver.getTitle();
			System.out.println(title27);
			softAssert.assertEquals(title27,"Cub Foods - About SUPERVALU", "Failed to load the About SUPERVALU page");

			//Checking Investor Information
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnInvestorInformation();
			Thread.sleep(5000);
			String title28=_driver.getTitle();
			System.out.println(title28);
			softAssert.assertEquals(title28,"Cub Foods - Investor Information",  "Failed to load the Investor Information page");

			//Checking Carrers Or JobInformation
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnCarrersOrJobInformation();
			Thread.sleep(5000);
			String title29=_driver.getTitle();
			System.out.println(title29);
			softAssert.assertEquals(title29,"Cub Foods - Careers", "Failed to load the  Carrers Or JobInformation page");

			//Checking RetailJobs
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnRetailJobs();
			Thread.sleep(5000);
			String title30=_driver.getTitle();
			System.out.println(title30);
			softAssert.assertEquals(title30,"Cub Foods - Retail Jobs", "Failed to load the  RetailJobs page");

			//Checking In Your Community
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnInYourCommunity();
			Thread.sleep(5000);
			String title31=_driver.getTitle();
			System.out.println(title31);
			softAssert.assertEquals(title31,"Cub Foods - In Your Community", "Failed to load the  In Your Community page");

			//Checking Sustainability
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnSustainability();
			Thread.sleep(5000);
			String title32=_driver.getTitle();
			System.out.println(title32);
			softAssert.assertEquals(title32,"Cub Foods - Environmental Affairs", "Failed to load the Sustainability page");

			//Checking Vendor Information
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnVendorInformation();
			Thread.sleep(5000);
			String title33=_driver.getTitle();
			System.out.println(title33);
			softAssert.assertEquals(title33,"Cub Foods - Vendor Information",  "Failed to load the Vendor Information page");

			//Checking Product Recalls
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnProductRecalls();
			Thread.sleep(5000);
			String title331=_driver.getTitle();
			System.out.println(title331);
			softAssert.assertEquals(title331,"Cub Foods - Product Recalls", "Failed to load the Product Recalls page");

			//Checking Satisfaction Gaurantee
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnSatisfactionGaurantee();
			Thread.sleep(5000);
			String title34=_driver.getTitle();
			System.out.println(title34);
			softAssert.assertEquals(title34,"Cub Foods - Satisfaction Guarantee", "Failed to load the Satisfaction Gaurantee page");

			//Checking Privacy Policy
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnPrivacyPolicy();
			Thread.sleep(5000);
			String title35=_driver.getTitle();
			System.out.println(title35);
			softAssert.assertEquals(title35,"Cub Foods - Security Privacy", "Failed to load the Privacy Policy page");

			//Checking Terms Of Use
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnTermsOfUse();
			Thread.sleep(5000);
			String title36=_driver.getTitle();
			System.out.println(title36);
			softAssert.assertEquals(title36,"Cub Foods - Terms and Conditions", "Failed to load the Terms Of Use page");

			//Checking Site Map hyperlink
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnSiteMapHyperLink();
			Thread.sleep(5000);
			String title37=_driver.getTitle();
			System.out.println(title37);
			softAssert.assertEquals(title37,"Cub Foods - Sitemap", "Failed to load the Site Map page");

			//Checking Credit Card ChipTechnology
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnCreditCardChipTechnology();
			Thread.sleep(5000);
			String title38=_driver.getTitle();
			System.out.println(title38);
			softAssert.assertEquals(title38,"Cub Foods - Credit Card Chip Technology", "Failed to load the Credit Card ChipTechnology page");

			//Checking Notice Of Privacy Practices
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnNoticeOfPrivacyPractices();
			Thread.sleep(5000);
			String title39=_driver.getTitle();
			System.out.println(title39);
			softAssert.assertEquals(title39,"Cub Foods - Notice of Privacy Practices", "Failed to load the Notice Of Privacy Practices page");

			//Checking What Is HIPPA
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnWhatIsHIPPA();
			Thread.sleep(5000);
			String title40=_driver.getTitle();
			System.out.println(title40);
			softAssert.assertEquals(title40,"Cub Foods - What is HIPAA?", "Failed to load the 'What Is HIPPA' page");

			//Checking HIPPA_Minnesota
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnHIPPA_Minnesota();
			Thread.sleep(5000);
			String title41=_driver.getTitle();
			System.out.println(title41);
			softAssert.assertEquals(title41,"Cub Foods - HIPAA Minnesota", "Failed to load the HIPPA_Minnesota page");

			//Checking HIPPA_Missouri
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnHIPPA_Missouri();
			Thread.sleep(5000);
			String title42=_driver.getTitle();
			System.out.println(title42);
			softAssert.assertEquals(title42,"Cub Foods - HIPAA Missouri", "Failed to load the HIPPA_Missouri page");

			//Checking HIPPA_NorthCarolina
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnHIPPA_NorthCarolina();
			Thread.sleep(5000);
			String title43=_driver.getTitle();
			System.out.println(title43);
			softAssert.assertEquals(title43,"Cub Foods - HIPAA North Carolina", "Failed to load the HIPPA_NorthCarolina page");

			//Checking Customer Service
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnCustomerService();
			String title44=_driver.getTitle();
			System.out.println(title44);
			softAssert.assertEquals(title44,"Cub Foods - Customer Service", "Failed to load the Customer Service page");

			//Checking Customer Service
			SiteMap = new SiteMapPage(_driver);
			SiteMap.clickOnAbout();
			SiteMap.clickOnSiteMap();
			SiteMap.clickOnGroceryDelivery();
			String title45=_driver.getTitle();
			System.out.println(title45);
			softAssert.assertEquals(title45,"Cub Grocery Delivery - Instacart", "Failed to load the Customer Service page");
			softAssert.assertAll();
		}
		

}
	
	
	

