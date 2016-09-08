package com.test.regression.farmfresh.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.farmfresh.utils.SuiteBase;

public class AboutUsPage extends SuiteBase{
	
	WebDriver _driver;
	
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
	
	public void clickOnAbout() 
	{
		 waitFor(_About);
		_About.click();
	}
	
	
//Methods to click tabs in About Us page
	
	public void clickOnAboutSuperValu()
	{
		waitFor(_AboutSuperValu);
		_AboutSuperValu.click();
	}
	
	public void clickOnInvestorInformation()
	{
		waitFor(_InvestorInformation);
		_InvestorInformation.click();
	}
	
	public void clickOnCareersJobOpportunities()
	{
		waitFor(_CareersJobOpportunities);
		_CareersJobOpportunities.click();
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
	
	public void clickOnSatisfactionGuarantee()
	{
		waitFor(_SatisfactionGuarantee);
		_SatisfactionGuarantee.click();
	}
	
	public void clickOnPrivacyPolicy()
	{
		waitFor(_PrivacyPolicy);
		 _PrivacyPolicy.click();
	}
	
	public void clickOnTermsofUse()
	{
		waitFor(_TermsofUse);
		_TermsofUse.click();
	}
	
	public void clickOnSitemap()
	{
		waitFor(_Sitemap);
		_Sitemap.click();
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
	
	public void clickOnCustomerService()
	{
		waitFor(_CustomerService);
		_CustomerService.click();
	}
	
}
