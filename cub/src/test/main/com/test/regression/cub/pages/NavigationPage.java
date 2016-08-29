package com.test.regression.cub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class NavigationPage extends SuiteBase{
       
       WebDriver _driver;
       Logger log = Logg.createLogger();
       
       public NavigationPage(WebDriver driver) {
              super();
              _driver=driver;
              PageFactory.initElements(_driver, this);
       }
       
       @FindBy(xpath="//*[@id='nav-pri-departments']/a")
       public WebElement _Departments;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[1]/a")
       public WebElement _MeatandSeafood;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[2]/a")
       public WebElement _DeliandBakery;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[3]/a")
       public WebElement _FreshProduce;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[4]/a")
       public WebElement _GiftCards;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[5]/a")
       public WebElement _BeerandWine;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[6]/a")
       public WebElement _Pet;
       
       @FindBy(xpath="//*[@id='nav-breadcrumb']/li[2]/a")
       public WebElement _backtoDept;
       
       @FindBy(xpath="//*[@id='nav-pri-pharmacy']/a")
       public WebElement _pharmacy;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[1]/a")
       public WebElement _Deptpharmacy;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[2]/a")
       public WebElement _Servicespharmacy;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[3]/a")
       public WebElement _Storehealthpharmacy;
       
       @FindBy(xpath="//*[@id='nav-secondary']/li[3]/ul/li/a")
       public WebElement _diabetespharmacy;
       
       @FindBy(xpath="//*[@id='nav-breadcrumb']/li[2]/a")
       public WebElement _backtoPharma;
       

   	
   	// Search text box in home page 
   	
   	@FindBy(xpath = "//*[@id='nav-pri-savings']/a")
   	public WebElement _Savings;
   	
   	//Inside savings page
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[1]/a")
   	public WebElement _WeeklyAdsSpecials;
   	
   		//Inside weekly ads specials page
   		@FindBy(xpath = "//*[@id='wrapper']/div[6]/div/div[1]/h1")
   		public WebElement _WeeklyAdsText;
   		
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[1]/ul/li/a")
   	public WebElement _WeeklyAd;
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[2]/a")
   	public WebElement _Coupons;

   		//Inside coupons page
   		@FindBy(xpath = "//*[@id='content-primary']/div/div/div/div/div[1]/ul/li[1]/a/div")
   		public WebElement _CouponsText;

   	@FindBy(xpath = "//*[@id='nav-secondary']/li[3]/a")
   	public WebElement _MobileApp;
   	
   		//Inside mobile app page
   		@FindBy(xpath = "//*[@alt='More savings with the Cub app.']")
   		public WebElement _MobileText;
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[3]/ul/li/a")
   	public WebElement _MobileFAQs; //url validation
   		
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[4]/a")
   	public WebElement _MyCubRewards;
   	
   		//Inside mobile app page
   		@FindBy(xpath = "//*[@alt='My Cub Rewards']")
   		public WebElement _MyCubRewardsText;
   	
   	//@FindAll({@FindBy(xpath = "//*[@id='my-recipe-filter-results']/tbody/tr")})
   	//public List<WebElement> _SearchNodeList;
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[4]/ul/li[1]/a")
   	public WebElement _MyCubRewardsFAQs;
   		
   		//Inside _MyCubRewards FAQs page
   		@FindBy(xpath = "//*[@alt='Frequently Asked Questions']")
   		public WebElement _MyCubRewardsFAQsText;
   		
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[4]/ul/li[2]/a")
   	public WebElement  _MyCubRewardsSummerTravel; //url validation
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[5]/a")
   	public WebElement _PromotionsAndSweepstakes;
   	
   		//Inside promotion and sweep stakes page
   		@FindBy(xpath = "//*[@id='content-primary']/div/div[1]/h1")
   		public WebElement _PromotionsAndSweepstakesText;
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[6]/a")
   	public WebElement _DiscountedTickets;
   	
   		//Inside Discounted Tickets page
   		@FindBy(xpath = "//*[@id='content-primary']/div/div[1]/h1")
   		public WebElement _DiscountedTicketsText;
   	
   	@FindBy(xpath = "//*[@id='nav-secondary']/li[7]/a")
   	public WebElement _FridayFreebieProgram;
   	
   		//Inside Friday Freebie page
   		@FindBy(xpath = "//*[@alt='Get a new Free item every week!']")
   		public WebElement  _FridayFreebieText;

   	
   	
   	// -------------------------* Methods to operate on elements *-----------------------------
   	
   	public void ClickOnSavings()
   	{
   		waitFor(_Savings);
   		_Savings.click();
   		System.out.println("Clicked on 'savings' link");
   	}
   	
   	public void ClickOnWeeklyAddSpecials()
   	{
   		waitFor(_WeeklyAdsSpecials);
   		_WeeklyAdsSpecials.click();
   		System.out.println("Clicked on 'Weekly Add specials' link");
   	}
   	
   	public String GetWeeklyAdScreenText()
   	{
   		waitFor(_WeeklyAdsText);
   		String strWeeklyAdScrnText = _WeeklyAdsText.getText();
   		return strWeeklyAdScrnText;
   	}
   	
   	public void ClickOnWeeklyAd()
   	{
   		waitFor(_WeeklyAd);
   		_WeeklyAd.click();
   		System.out.println("Clicked on 'Weekly Ad' link");
   	}
   	
   	public void ClickOnCoupons()
   	{
   		waitFor(_Coupons);
   		_Coupons.click();
   		System.out.println("Clicked on 'Coupons' link");
   	}
   	
   	public String GetCouponsText()
   	{
   		waitFor(_CouponsText);
   		String strCouponText = _CouponsText.getText();
   		return strCouponText;
   	}
   	
   	public void ClickOnMobileFAQs()
   	{
   		waitFor(_MobileFAQs);
   		_MobileFAQs.click();
   		System.out.println("Clicked on 'Mobile App' link");
   	}
   	
   	public void ClickOnMobileApp()
   	{
   		waitFor(_MobileApp);
   		_MobileApp.click();
   		System.out.println("Clicked on 'Mobile FAQs' link");
   	}
   	
   	public String GetMobileAppText()
   	{
   		waitFor(_MobileText);
   		String strMobileText = _MobileText.getText();
   		return strMobileText;
   	}
   	
   	public void ClickOnMyCubRewards()
   	{
   		waitFor(_MyCubRewards);
   		_MyCubRewards.click();
   		System.out.println("Clicked on 'My Cub Rewards' link");
   	}

   	public void ClickOnMyCubRewardsFAQs()
   	{
   		waitFor(_MyCubRewardsFAQs);
   		_MyCubRewardsFAQs.click();
   		System.out.println("Clicked on 'My Cub Rewards FAQs' link");
   	}

   	public void ClickOnMyCubRewardsSummerTravel()
   	{
   		waitFor(_MyCubRewardsSummerTravel);
   		_MyCubRewardsSummerTravel.click();
   		System.out.println("Clicked on 'My Cub Reward's summer travel' link");
   	}

   	public String GetMyRewardsText()
   	{
   		waitFor(_MyCubRewardsText);
   		String strMyCubRewardsText = _MyCubRewardsText.getText();
   		return strMyCubRewardsText;
   	}
   	
   	public void ClickOnPromotionsAndSweepstakes()
   	{
   		waitFor(_PromotionsAndSweepstakes);
   		_PromotionsAndSweepstakes.click();
   		System.out.println("Clicked on 'Promotions And Sweepstakes' link");
   	}
   	
   	public String GetPromotionsAndSweepstakesText()
   	{
   		waitFor(_PromotionsAndSweepstakesText);
   		String strPSText = _PromotionsAndSweepstakesText.getText();
   		return strPSText;
   	}
   	
   	public void ClickOnDiscountedTickets()
   	{
   		waitFor(_DiscountedTickets);
   		_DiscountedTickets.click();
   		System.out.println("Clicked on 'Discounted Tickets' link");
   	}
   	
   	public String GetDiscountedTicketsText()
   	{
   		waitFor(_DiscountedTicketsText);
   		String strDiscountTicketsText = _DiscountedTicketsText.getText();
   		return strDiscountTicketsText;
   	}
   	
   	public void ClickOnFridayFreebieProgram()
   	{
   		waitFor(_FridayFreebieProgram);
   		_FridayFreebieProgram.click();
   		System.out.println("Clicked on 'Friday Freebie Program' link");
   	}
   	
   	public String GetFridayFreebieText()
   	{
   		waitFor(_FridayFreebieText);
   		String strFridayFreebieText = _FridayFreebieText.getText();
   		return strFridayFreebieText ;
   	}
   	
   	public String GetCurrentURL()
   	{
   		String DisplayedURL = _driver.getCurrentUrl();
   		return DisplayedURL;
   	}


       
       public void clickDepartments(){
              _Departments.click();
              log.info("Click on Departments link");
       }
       public void clickMeat(){
              _MeatandSeafood.click();
              log.info("Click on Meat and Sea Food link on Departments page");
       }
       public void clickBakery(){
              _DeliandBakery.click();
              log.info("Click on Deli and Bakery link on Departments page");
       }
       public void clickFresh(){
              _FreshProduce.click();
              log.info("Click on Fresh Produce link on Departments page");
       }
       public void clickGift(){
              _GiftCards.click();
              log.info("Click on Gift Cards link on Departments page");
       }
       public void clickBeer(){
              _BeerandWine.click();
              log.info("Click on Beer and Wine link on Departments page");
       }
       public void clickPet(){
              _Pet.click();
              log.info("Click on Pet link on Departments page");
       }
       public void clickbacktoDept(){
              _backtoDept.click();
              log.info("Navigate back to Departments page");
       }
       public void clickpharmacy(){
              _pharmacy.click();
              log.info("Click on Pharmacy link");
       }
       public void clickDeptpharma(){
              _Deptpharmacy.click();
              log.info("Click on Departments link in Pharmacy page");
       }
       public void clickServices(){
              _Servicespharmacy.click();
              log.info("Click on Services link in Pharmacy page");
       }
       public void clickstorehealth(){
              _Storehealthpharmacy.click();
              log.info("Click on Store health link in Pharmacy page");
       }
       public void clickdiabetes(){
              _diabetespharmacy.click();
              log.info("Click on Diabetes link in Pharmacy page");
       }
       public void clickbacktopharma(){
              _backtoPharma.click();
              log.info("Navigate back to Pharmacy page");
       }
}
