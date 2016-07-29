package com.test.regression.cub.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.SuiteBase;

public class SiteMapPage extends SuiteBase{
	
	WebDriver _driver;
	
	public SiteMapPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
//About us header tab
	@FindBy(xpath = "//ul[@id='nav-primary']/li[5]/a")
	private WebElement _About;
	
//About Us - Site Map Link
	@FindBy(xpath = "//*[@id='nav-secondary']/li[11]/a")
	private WebElement _SiteMap;	
	
// Links in Site Map Page
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/a")
	private WebElement _Savings;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[1]/a")
	private WebElement _WeeklyAdSpecial;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[1]/ul/li/a")
	private WebElement _WeeklyAd;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[2]/a")
	private WebElement _Coupons;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[3]/a")
	private WebElement _MobileApp;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[3]/ul/li/a")
	private WebElement _FAQs;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[4]/a")
	private WebElement _MyCubRewards;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[4]/ul/li[1]/a")
	private WebElement _MyCubRewards_FAQs;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[4]/ul/li[2]/a")
	private WebElement _SummerTravel;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[5]/a")
	private WebElement _PromotinsSweepstakes;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[6]/a")
	private WebElement _DiscountedTickets;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[1]/ul/li[7]/a")
	private WebElement _FridayFreebieProgram;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[2]/a")
	private WebElement _Recipes;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[2]/ul/li/a")
	private WebElement _SearchRecipes;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/a")
	private WebElement _Departments;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/ul/li[1]/a")
	private WebElement _MeatAndSeafood;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/ul/li[2]/a")
	private WebElement _DeliAndBakery;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/ul/li[3]/a")
	private WebElement _FreshProduce;	
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/ul/li[4]/a")
	private WebElement _GiftCardsAndFloral;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/ul/li[5]/a")
	private WebElement _BeerAndWine;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[3]/ul/li[6]/a")
	private WebElement _Pet;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[4]/a")
	private WebElement _Pharmacy;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[4]/ul/li[1]/a")
	private WebElement _Pharmacy_Departments;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[4]/ul/li[2]/a")
	private WebElement _OurServices;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[4]/ul/li[3]/a")
	private WebElement _InStoreHealthPrograms;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[4]/ul/li[3]/ul/li/a")
	private WebElement _DiabetesCoach;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/a")
	private WebElement _AboutLink;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[1]/a")
	private WebElement _AboutSUPERVALU;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[2]/a")
	private WebElement _InvestorInformation;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[3]/a")
	private WebElement _CarrersOrJobInformation;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[3]/ul/li/a")
	private WebElement _RetailJobs;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[4]/a")
	private WebElement _InYourCommunity;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[5]/a")
	private WebElement _Sustainability;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[6]/a")
	private WebElement _VendorInformation;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[7]/a")
	private WebElement _ProductRecalls;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[8]/a")
	private WebElement _SatisfactionGaurantee;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[9]/a")
	private WebElement _PrivacyPolicy;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[10]/a")
	private WebElement _TermsOfUse;
	
	@FindBy(xpath = "//*[@id='nav-secondary']/li[11]/a")
	private WebElement _SiteMapLink;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[12]/a")
	private WebElement _CreditCardChipTechnology;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[13]/a")
	private WebElement _NoticeOfPrivacyPractices;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[13]/ul/li[1]/a")
	private WebElement _WhatIsHIPPA;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[13]/ul/li[2]/a")
	private WebElement _HIPPA_Minnesota;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[13]/ul/li[3]/a")
	private WebElement _HIPPA_Missouri;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[13]/ul/li[4]/a")
	private WebElement _HIPPA_NorthCarolina;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[5]/ul/li[14]/a")
	private WebElement _CustomerService;
	
	@FindBy(xpath = "//*[@id='content-primary']/div/div[3]/div/ul/li[6]/a")
	private WebElement _GroceryDelivery;
	
	
//Methods to click ABOUT Header tab
	
	public void clickOnAbout() 
	{
		 waitFor(_About);
		_About.click();
	}
	
//Methods to click tabs in links in Site Map page
	
	public void clickOnSiteMap()
	{
		waitFor(_SiteMap);
		_SiteMap.click();
	}
	
	public void clickOnSavings()
	{
		waitFor(_Savings);
		_Savings.click();
	}
	
	public void clickOnWeeklyAdSpecial()
	{
		waitFor(_WeeklyAdSpecial);
		_WeeklyAdSpecial.click();
	}
	
	public void ClickOnWeeklyAd()
	{
		waitFor(_WeeklyAd);
		_WeeklyAd.click();
	}
	
	public void clickOnCoupons()
	{
		waitFor(_Coupons);
		_Coupons.click();
	}
	
	public void clickOnMobileApp()
	{
		waitFor(_MobileApp);
		_MobileApp.click();
	}
	
	public void clickOnFAQs()
	{
		waitFor(_FAQs);
		_FAQs.click();
	}
	
	public void clickOnMyCubRewards()
	{
		waitFor(_MyCubRewards);
		_MyCubRewards.click();
	}
	
	public void clickOnMyCubRewards_FAQs()
	{
		waitFor(_MyCubRewards_FAQs);
		_MyCubRewards_FAQs.click();
	}
	
	public void clickOnSummerTravel()
	{
		waitFor(_SummerTravel);
		_SummerTravel.click();
	}
	
	public void clickOnPromotinsSweepstakes()
	{
		waitFor(_PromotinsSweepstakes);
		_PromotinsSweepstakes.click();
	}
	
	
	public void clickOnDiscountedTickets()
	{
		waitFor(_DiscountedTickets);
		_DiscountedTickets.click();
	}
	
	public void clickOnFridayFreebieProgram()
	{
		waitFor(_FridayFreebieProgram);
		_FridayFreebieProgram.click();
	}
	
	public void clickOnRecipes()
	{
		waitFor(_Recipes);
		_Recipes.click();
	}
	
	public void clickOnSearchRecipes()
	{
		waitFor(_SearchRecipes);
		_SearchRecipes.click();
	}
	
	public void clickOnDepartments()
	{
		waitFor(_Departments);
		_Departments.click();
	}
	
	public void clickOnMeatAndSeafood()
	{
		waitFor(_MeatAndSeafood);
		_MeatAndSeafood.click();
	}
	
	public void clickOnDeliAndBakery()
	{
		waitFor(_DeliAndBakery);
		_DeliAndBakery.click();
	}
	
	public void clickOnFreshProduce()
	{
		waitFor(_FreshProduce);
		_FreshProduce.click();
	}
	
	public void clickOnGiftCardsAndFloral()
	{
		waitFor(_GiftCardsAndFloral);
		_GiftCardsAndFloral.click();
	}
	
	public void clickOnBeerAndWine()
	{
		waitFor(_BeerAndWine);
		_BeerAndWine.click();
	}
	
	public void clickOnPet()
	{
		waitFor(_Pet);
		_Pet.click();
	}
	
	public void clickOnPharmacy()
	{
		waitFor(_Pharmacy);
		_Pharmacy.click();
	}
	
	public void clickOnPharmacy_Departments()
	{
		waitFor(_Pharmacy_Departments);
		_Pharmacy_Departments.click();
	}
	
	public void clickOnOurServices()
	{
		waitFor(_OurServices);
		_OurServices.click();
	}
	
	public void clickOnInStoreHealthPrograms()
	{
		waitFor(_InStoreHealthPrograms);
		_InStoreHealthPrograms.click();
	}
	
	public void clickOnDiabetesCoach()
	{
		waitFor(_DiabetesCoach);
		_DiabetesCoach.click();
	}
	
	public void clickOnAboutLink()
	{
		waitFor(_AboutLink);
		_AboutLink.click();
	}
	
	public void clickOnAboutSUPERVALU()
	{
		waitFor(_AboutSUPERVALU);
		_AboutSUPERVALU.click();
	}
	
	public void clickOnInvestorInformation()
	{
		waitFor(_InvestorInformation);
		_InvestorInformation.click();
	}
	
	public void clickOnCarrersOrJobInformation()
	{
		waitFor(_CarrersOrJobInformation);
		_CarrersOrJobInformation.click();
	}
	
	public void clickOnRetailJobs()
	{
		waitFor(_RetailJobs);
		_RetailJobs.click();
	}
	
	public void clickOnInYourCommunity()
	{
		waitFor(_InYourCommunity);
		_InYourCommunity.click();
	}
	
	public void clickOnSustainability()
	{
		waitFor(_Sustainability);
		_Sustainability.click();
	}
	
	public void clickOnVendorInformation()
	{
		waitFor(_VendorInformation);
		_VendorInformation.click();
	}
	
	public void clickOnProductRecalls()
	{
		waitFor(_ProductRecalls);
		_ProductRecalls.click();
	}
	
	public void clickOnSatisfactionGaurantee()
	{
		waitFor(_SatisfactionGaurantee);
		_SatisfactionGaurantee.click();
	}
	
	public void clickOnPrivacyPolicy()
	{
		waitFor(_PrivacyPolicy);
		_PrivacyPolicy.click();
	}
	
	public void clickOnTermsOfUse()
	{
		waitFor(_TermsOfUse);
		_TermsOfUse.click();
	}
	
	public void clickOnSiteMapHyperLink()
	{
		waitFor(_SiteMapLink);
		_SiteMapLink.click();
	}
	
	public void clickOnCreditCardChipTechnology()
	{
		waitFor(_CreditCardChipTechnology);
		_CreditCardChipTechnology.click();
	}
	
	public void clickOnNoticeOfPrivacyPractices()
	{
		waitFor(_NoticeOfPrivacyPractices);
		_NoticeOfPrivacyPractices.click();
	}
	
	public void clickOnWhatIsHIPPA()
	{
		waitFor(_WhatIsHIPPA);
		_WhatIsHIPPA.click();
	}
	
	public void clickOnHIPPA_Minnesota()
	{
		waitFor(_HIPPA_Minnesota);
		_HIPPA_Minnesota.click();
	}
	
	public void clickOnHIPPA_Missouri()
	{
		waitFor(_HIPPA_Missouri);
		_HIPPA_Missouri.click();
	}
	
	public void clickOnHIPPA_NorthCarolina()
	{
		waitFor(_HIPPA_NorthCarolina);
		_HIPPA_NorthCarolina.click();
	}
	
	public void clickOnCustomerService()
	{
		waitFor(_CustomerService);
		_CustomerService.click();
	}
	
	public void clickOnGroceryDelivery()
	{
		waitFor(_GroceryDelivery);
		_GroceryDelivery.click();
	}
	

	
	
}
