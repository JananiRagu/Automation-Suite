package com.test.regression.cub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class AboutUsPage extends SuiteBase{
	
	WebDriver _driver;
	Logger log = Logg.createLogger();
	
	public AboutUsPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
//About us header tab
	@FindBy(xpath = "//ul[@id='nav-primary']/li[5]/a")
	private WebElement _About;
	
// Tabs in About us Page
	
	@FindBy(xpath = "(//a[text()='About SUPERVALU'])[2]")
	private WebElement _AboutSuperValu;
	
	@FindBy(xpath = "(//a[text()='Investor Information'])[2]")
	private WebElement _InvestorInformation;
	
	@FindBy(xpath = "(//a[text()='Careers/Job Opportunities'])[2]")
	private WebElement _CareersJobOpportunities;
	
	@FindBy(xpath = "(//a[text()='In Your Community'])[2]")
	private WebElement _InYourCommunity;
	
	@FindBy(xpath = "(//a[text()='Sustainability'])[2]")
	private WebElement _Sustainability;
	
	@FindBy(xpath = "(//a[text()='Vendor Information'])[2]")
	private WebElement _VendorInformation;
	
	@FindBy(xpath = "(//a[text()='Product Recalls'])[2]")
	private WebElement _ProductRecalls;
	
	@FindBy(xpath = "(//a[text()='Satisfaction Guarantee'])[2]")
	private WebElement _SatisfactionGuarantee;
	
	@FindBy(xpath = "(//a[text()='Privacy Policy'])[2]")
	private WebElement _PrivacyPolicy;
	
	@FindBy(xpath = "(//a[text()='Terms of Use'])[2]")
	private WebElement _TermsofUse;
	
	@FindBy(xpath = "(//a[text()='Sitemap'])[2]")
	private WebElement _Sitemap;
	
	@FindBy(xpath = "(//a[text()='Credit Card Chip Technology'])[2]")
	private WebElement _CreditCardChipTechnology;
	
	@FindBy(xpath = "(//a[text()='Notice of Privacy Practices'])[2]")
	private WebElement _NoticeOfPrivacyPractices;
	
	@FindBy(xpath = "(//a[text()='Customer Service'])[2]")
	private WebElement _CustomerService;
	
	
//Methods to click ABOUT Header tab
	
	public void clickOnAbout() throws InterruptedException 
	{
		 waitFor(_About);
		_About.click();
		log.info(" Clicked About Tab");
		Thread.sleep(5000);
	}
	
	
//Methods to click tabs in About Us page
	
	public void clickOnAboutSuperValu()
	{
		waitFor(_AboutSuperValu);
		_AboutSuperValu.click();
		log.info(" Clicked About SuperValu Tab in About Us page");
	}
	
	public void clickOnInvestorInformation()
	{
		waitFor(_InvestorInformation);
		_InvestorInformation.click();
		log.info(" Clicked Investor Information Tab in About Us page");
	}
	
	public void clickOnCareersJobOpportunities()
	{
		waitFor(_CareersJobOpportunities);
		_CareersJobOpportunities.click();
		log.info(" Clicked Careers Job Opportunities Tab in About Us page");
	}
	
	public void clickOnInYourCommunity()
	{
		waitFor(_InYourCommunity);
		_InYourCommunity.click();
		log.info(" Clicked In Your Community Tab in About Us page");
	}
	
	public void clickOnSustainability()
	{
		waitFor(_Sustainability);
		_Sustainability.click();
		log.info(" Clicked Sustainability Tab in About Us page");
	}
	
	public void clickOnVendorInformation()
	{
		waitFor(_VendorInformation);
		_VendorInformation.click();
		log.info(" Clicked Vendor Information Tab in About Us page");
	}
	
	public void clickOnProductRecalls()
	{
		waitFor(_ProductRecalls);
		_ProductRecalls.click();
		log.info(" Clicked Product Recalls Tab in About Us page");
	}
	
	public void clickOnSatisfactionGuarantee()
	{
		waitFor(_SatisfactionGuarantee);
		_SatisfactionGuarantee.click();
		log.info(" Clicked Satisfaction Guarantee Tab in About Us page");
	}
	
	public void clickOnPrivacyPolicy()
	{
		waitFor(_PrivacyPolicy);
		 _PrivacyPolicy.click();
		 log.info(" Clicked PrivacyPolicy Tab in About Us page");
	}
	
	public void clickOnTermsofUse()
	{
		waitFor(_TermsofUse);
		_TermsofUse.click();
		log.info(" Clicked Terms of Use Tab in About Us page");
	}
	
	public void clickOnSitemap()
	{
		waitFor(_Sitemap);
		_Sitemap.click();
		log.info(" Clicked Sitemap Tab in About Us page");
	}
	
	
	public void clickOnCreditCardChipTechnology()
	{
		waitFor(_CreditCardChipTechnology);
		_CreditCardChipTechnology.click();
		log.info(" Clicked Credit Card Chip Technology Tab in About Us page");
	}
	
	public void clickOnNoticeOfPrivacyPractices()
	{
		waitFor(_NoticeOfPrivacyPractices);
		_NoticeOfPrivacyPractices.click();
		log.info(" Clicked Notice Of Privacy Practices Tab in About Us page");
	}
	
	public void clickOnCustomerService()
	{
		waitFor(_CustomerService);
		_CustomerService.click();
		log.info(" Clicked Customer Service Tab in About Us page");
	}
	
}
