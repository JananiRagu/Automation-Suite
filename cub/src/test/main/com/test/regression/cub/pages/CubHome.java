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

public class CubHome extends SuiteBase{
	
	WebDriver _driver;
	Logger log = Logg.createLogger();
	
	public CubHome(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}
	
	@FindBy(id="logo")
	private WebElement _Logo;
	
	
	@FindBy(xpath = "//a[text()='Sign In']")
	private WebElement _signInLink;
	
    // Below is the list of WebElements in the SignIn Popup
	
	@FindBy(id = "ss-email-input")
	private WebElement _userName;
	
	@FindBy(id = "ss-password-login")
	private WebElement _password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement _signInButton;
	
	@FindBy(id = "ss-toggle-visible-password")
	private WebElement _showChkBox;
	
	@FindBy(xpath = "//a[text()='I forgot my password']")
	private WebElement _forgotPwd;
	
	@FindBy(xpath = "//input[@class='ss-email-input']")
	private WebElement _EmailInForgotPassword;
	
	@FindBy(xpath = "//button[text()='Get my password']")
	private WebElement _getMyPasswordButton;
	
	@FindBy(xpath = "//span[text()='Whoops!']")
	private WebElement _errorMsgInForgotPassword;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement _okButtonInForgotpassword;
	
	@FindBy(xpath = "//a[text()='Go back']")
	private WebElement _goBackLinkInForgotPassword;
	
	@FindBy(xpath = "//div[@class='ss-signup-container ss-inner-container ss-alt-container']")
	private WebElement _signUpPopup;
	
	@FindBy(xpath = "//div[@class='ss-login-container ss-inner-container ss-alt-container']")
	private WebElement _signInPopup;
	
	@FindBy(xpath = "//a[text()='Sign up!']")
	private WebElement _signUp;
	
	@FindBy(id = "ss-remember-login")
	private WebElement _rememberMe;
	
	@FindBy(xpath = "//a[text()='reset your password']")
	private WebElement _pwdIncorrect;
	
	@FindBy(xpath = "//a[text()='Shopping List']")
	private WebElement _shoppingListButton;
	
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement _logOut;
	
	@FindBy(xpath="//a[text()='Find a Store']")
	private WebElement _FindAStore;
	
	// Footer links
	
			@FindBy(xpath = "//div[@class ='footer-links-container']/ul/li/a[text()='Customer Service']")
			private WebElement _CustomerService;
			
			@FindBy(xpath = "//a[text()='About Us']")
			private WebElement _AboutUs;
			
			@FindBy(xpath = "//a[text()='Careers']")
			private WebElement _Careers;
			
			@FindBy(xpath = "//a[text()='Recalls']")
			private WebElement _Recalls;
			
			@FindBy(xpath = "(//a[text()='Privacy Policy'])[2]")
			private WebElement _PrivacyPolicy;
			
			@FindBy(xpath = "//div[@class ='footer-links-container']/ul/li/a[text()='Terms of Use']")
			private WebElement _TermsOfUse;
			
	// Associates link
			
			@FindBy(xpath = "//a[text()='Associates']")
			private WebElement _Associates;
			
	// Header tabs
			
			@FindBy(xpath = "//a[text()='Savings']")
			private WebElement _Savings;
			
			@FindBy(xpath = "//a[text()='Recipes']")
			private WebElement _Recipes;
			
			@FindBy(xpath = "//a[text()='Departments']")
			private WebElement _Departments;
			
			@FindBy(xpath = "//a[text()='Pharmacy']")
			private WebElement _Pharmacy;
			
			@FindBy(xpath = "//a[text()='About']")
			private WebElement _About;
			
			@FindBy(xpath = "//a[text()='Grocery Delivery']")
			private WebElement _GroceryDelivery;
			
		
	// Search text box in home page 
			
			@FindBy(id = "inp-search")
			private WebElement _Search;

	// Home Page Tiles
			
			@FindBy(xpath = "//a[text()='Weekly Ads']")
			private WebElement _WeeklyAdTile;
			
			@FindBy(xpath = "//div[@class='homepanel_column homepanel_column1of2']/ul/li[2]/a[text()='Coupons']")
			private WebElement _CouponTile;
			
			@FindBy(xpath = "//a[text()='Cakes & Party Trays']")
			private WebElement _CakesandPartyTile;
			
			@FindBy(xpath = "(//a[text()='My Cub Rewards'])[2]")
			private WebElement _CubRewardsTile;
			
	// Close POP UP
			
			@FindBy(xpath = "//*[@id='layout']/div[2]/div[2]/a")
			private WebElement _closePopUp;
			
			@FindBy(xpath = "//a[@class='ss-close-button']")
			private WebElement _closeSignInPopup;
			
			public void clickOnClosePopUp() throws InterruptedException
			{
				waitFor(_closeSignInPopup);
				_closeSignInPopup.click();
				log.info("Pop up closed successfully..");
				Thread.sleep(5000);
				
				
		     }
	
			public boolean isSignInPopupPresent(){
				
				if(_closeSignInPopup.isDisplayed())
					return true;
				else
					return false;
			}
			
			public boolean signUpPopupPresence(){
				if(_signUpPopup.isDisplayed())
					return true;
				else
					return false;
			}
			
			public boolean signInPopupPresence(){
				if(_signInPopup.isDisplayed())
					return true;
				else
					return false;
			}
			
			public void clickSignUpLinkInSignInPopup() throws InterruptedException{
				waitFor(_signUp);
				_signUp.click();
				
				log.info("Clicked on SignIn Link in SignUp popup..");
			}
			
	//Method to click on Logo
	
	public void clickOnLogo(){
			waitFor(_Logo);
			_Logo.click();
	}

	//Method to click SignOut link in Home page
	

	public void clickOnLogOutLink()
	{
		waitFor(_logOut);
		_logOut.click();
	}


//Methods to click Header tabs  in Home page
	
	public void clickOnSavings()
	{
		waitFor(_Savings);
		_Savings.click();
	}	
	
	
	public void clickOnRecipes()
	{
		waitFor(_Recipes);
		_Recipes.click();
	}	
	
	public void clickOnDepartments()
	{
		waitFor(_Departments);
		_Departments.click();
	}	
	
	public void clickOnPharmacy()
	{
		waitFor(_Pharmacy);
		_Pharmacy.click();
	}
	
	
	public void clickOnAbout()
	{
		waitFor(_About);
		_About.click();
	}
	
	
	public void clickOnGroceryDelivery()
	{
		waitFor(_GroceryDelivery);
		_GroceryDelivery.click();
	}

//Methods to click Footer links  in Home page
	
	public void clickOnAboutUs()
	{
		waitFor(_AboutUs);
		_AboutUs.click();
	}
	
	public void clickCareers()
	{
		waitFor(_Careers);
		_Careers.click();
	}
	
	public void clickRecalls()
	{
		waitFor(_Recalls);
		_Recalls.click();
	}
	
	public void clickPrivacyPolicy()
	{
		waitFor(_PrivacyPolicy);
		_PrivacyPolicy.click();
	}
	
	
	public void clickTermsOfUse()
	{
		waitFor(_TermsOfUse);
		_TermsOfUse.click();
	}
	
	
	public void clickCustomerService()
	{
		waitFor(_CustomerService);
		_CustomerService.click();
	}
	
//Methods to click tiles in Home Page
	
	public void clickWeeklyAdTile()
	{
		waitFor(_WeeklyAdTile);
		_WeeklyAdTile.click();
	}
	
	
	public void clickCouponTile(WebDriver driver)
	{
		
		Actions actions = new Actions(driver);

		actions.moveToElement(_CouponTile).click().perform();
		//waitFor(_CouponTile);
		//_CouponTile.click();
	}
	
	
	public void clickCakesandPartyTile()
	{
		waitFor(_CakesandPartyTile);
		_CakesandPartyTile.click();
	}
	

	public void clickCubRewardsTile()
	{
		waitFor(_CubRewardsTile);
		_CubRewardsTile.click();
	}
	
		
	
	public void clickSignInLink() throws InterruptedException{
		waitFor(_signInLink);
		_signInLink.click();
		
		log.info("SignIn Link Clicked");
	
		
	}
	
	public void enterLoginDetails(String UserName, String Password){
		waitFor(_userName);
		_userName.clear();
		_userName.sendKeys(UserName);
		
		waitFor(_password);
		_password.clear();
		_password.sendKeys(Password);
		
		log.info("Entered login Details");
	}
	
	public void clickSignInButton() throws InterruptedException
	{
		Thread.sleep(5000);
		
		waitFor(_signInButton);
		_signInButton.click();
		
		log.info("SignInButton Clicked");
		Thread.sleep(5000);
	}
	
	public void completeSignIn(String UserName, String Password) throws InterruptedException{
		
		clickSignInLink();
		
		enterLoginDetails(UserName, Password);
		
		clickSignInButton();
		Thread.sleep(5000);
	}
	

	public boolean isLogOutButtonPresent(){
				
		try {
			waitFor(_logOut);
			boolean logOutButton = _logOut.isDisplayed();
				log.info("LogOut Button Status : "+logOutButton);
            return logOutButton;
            
          } catch (NoSuchElementException e) {
            return false;
          }catch (TimeoutException ex) {
              return false;
            }	
	}
	
	public boolean isPasswordIncorrectTextPresent(){
		waitFor(_pwdIncorrect);
		boolean pwdIncorrectText = _pwdIncorrect.isDisplayed();
		log.info("Password Incorrect Text Status : "+pwdIncorrectText);
		return(pwdIncorrectText);
		
	}
	
	
	public void clickOnForgotPassword(){
		waitFor(_forgotPwd);
		_forgotPwd.click();
	}
	
	public boolean enterEmailInForgotPasswordPopupNValidate(String email){
		waitFor(_EmailInForgotPassword);
		_EmailInForgotPassword.clear();
		_EmailInForgotPassword.sendKeys(email);
		_getMyPasswordButton.click();
		
		if(_errorMsgInForgotPassword.isDisplayed())
			return false;
		else {
			waitFor(_okButtonInForgotpassword);
			_okButtonInForgotpassword.click();
			return true;
		}
	}
	
	public void clickAssociates()
	{
		waitFor(_Associates);
		_Associates.click();
	}
}

