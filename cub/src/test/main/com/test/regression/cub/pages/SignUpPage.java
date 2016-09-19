package com.test.regression.cub.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.SuiteBase;

public class SignUpPage extends SuiteBase{
	
	WebDriver _driver;
	Logger log = Logg.createLogger();
	
	public SignUpPage(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

	@FindBy(xpath = "//a[text()='Sign Up']")
	private WebElement _signUpLink;
	
	@FindBy(id = "ss-email-input")
	private WebElement _userName;
	
	@FindBy(id = "ss-password-login")
	private WebElement _password;
	
	@FindBy(xpath = "//button[text()='Continue']") 
	private WebElement _continueButton;
	
	@FindBy(xpath = "//a[text()='Sign in!']")
	private WebElement _signInLinkInSignUpPopup;
	
	@FindBy(id = "confirm-rewards-no-no")
	private WebElement _dontWantCardRadio;
	
	@FindBy(id = "confirm-rewards-yes")
	private WebElement _yesHaveCardRadio;
	
	@FindBy(id = "confirm-rewards-no-yes")
	private WebElement _noButWantCardRadio;
	
	@FindBy(xpath = "//a[text()='Log Out']")
	private WebElement _logOut;
	
	@FindBy(id = "ss-signup-firstname")
	private WebElement _firstName;
	
	@FindBy(id = "ss-signup-lastname")
	private WebElement _lastName;
	
	@FindBy(id = "address1")
	private WebElement _address1;
	
	@FindBy(id = "address2")
	private WebElement _address2;
	
	@FindBy(id = "city")
	private WebElement _city;
	
	@FindBy(id = "state")
	private WebElement _state;
	
	@FindBy(id = "zip")
	private WebElement _zip;
	
	@FindBy(id = "ss-signup-homephone-1")
	private WebElement _homephone1;
	
	@FindBy(id = "ss-signup-homephone-2")
	private WebElement _homephone2;
	
	@FindBy(id = "ss-signup-homephone-3")
	private WebElement _homephone3;
	
	@FindBy(id = "ss-signup-mobilephone-1")
	private WebElement _mobilephone1;
	
	@FindBy(id = "ss-signup-mobilephone-2")
	private WebElement _mobilephone2;
	
	@FindBy(id = "ss-signup-mobilephone-3")
	private WebElement _mobilephone3;
	
	@FindBy(id = "ss-signup-cardlessid-1")
	private WebElement _cardless1;
	
	@FindBy(id = "ss-signup-cardlessid-2")
	private WebElement _cardless2;
	
	@FindBy(id = "QAS_AcceptOriginal")
	private WebElement _useThisAddress;
	
	@FindBy(id = "ss-add-rewards-lastname-input")
	private WebElement _lastNameInAddRewardsPopup;
	
	@FindBy(id = "ss-add-rewards-card-number-input")
	private WebElement _rewardsNumInAddRewardsPopup;
	
	@FindBy(id = "ss-add-rewards-cardlessid-input-7")
	private WebElement _cardlessId1InAddRewardsPopup;
	
	@FindBy(id = "ss-add-rewards-cardlessid-input-4")
	private WebElement _cardlessId2InAddRewardsPopup;
	
	@FindBy(xpath = "//div[@class='ss-cardconfirm-container ss-inner-container']/a")
	private WebElement _closeButtonInRewardsCardPopup;
	
	@FindBy(xpath = "//p[text()=' This looks like an invalid email address.']")
	private WebElement _invalidEmailText;
	
	@FindBy(xpath = "//li[text()='6-20 characters long']")
	private WebElement _invalidPasswordText;
	
	@FindBy(xpath = "//a[@class='ss-close-button']")
	private WebElement _closeSignUpPopup;
	
	public void clickOnClosePopUp() throws InterruptedException
	{
		waitFor(_closeSignUpPopup);
		_closeSignUpPopup.click();
		log.info("Pop up closed successfully..");
		Thread.sleep(5000);
		
		
     }
	
	public boolean isSignUpPopupPresent(){
		
		if(_closeSignUpPopup.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void clickSignUpLink() throws InterruptedException{
		waitFor(_signUpLink);
		_signUpLink.click();
		
		log.info("Clicked on SignUp Link..");
	}
	
	
	public void clickSignInLinkInSignUpPopup() throws InterruptedException{
		waitFor(_signInLinkInSignUpPopup);
		_signInLinkInSignUpPopup.click();
		
		log.info("Clicked on SignIn Link in SignUp popup..");
	}
	
	public void enterSignUpDetails(String UserName, String Password){
		waitFor(_userName);
		_userName.clear();
		_userName.sendKeys(UserName);
		waitFor(_password);
		_password.clear();
		_password.sendKeys(Password);
		_password.sendKeys(Keys.ENTER);
		
		log.info("Entered SignUp Username and Password");
		
	}
	
	
	
	public boolean isInvalidEmailTextPresent(){
		return _invalidEmailText.isDisplayed();
	}
	
	public boolean isInvalidPasswordTextPresent(){
		return _invalidPasswordText.isDisplayed();
	} 
	
/*	public void clickContinueButtonNoCheck() throws InterruptedException{
		
		waitFor(_continueButton);
		_continueButton.click();
		
		
	}*/
	
	public void clickContinueButton() throws InterruptedException{
		
		Thread.sleep(5000);
		
		System.out.println("Continue Button presence flag :" + _continueButton.isEnabled());
		
		if(_continueButton.isEnabled())
		_continueButton.click();
		
		log.info("Clicked on Continue Button");
	}
	
	public void closeRewardsCardPopup(){
		
		waitFor(_closeButtonInRewardsCardPopup);
		_closeButtonInRewardsCardPopup.click();
		
		log.info("Didnt Select any option in Rewards Card popup, Just Closed the popup");
	}
	
	public void clickDontWantCardRadio() throws InterruptedException{
		
		waitFor(_dontWantCardRadio);
		
		_dontWantCardRadio.click();
		
		log.info("Selected 'No, I dont want card' option");
		
	}
	
	public void clickNoButWantCardRadio() throws InterruptedException{
		
		waitFor(_noButWantCardRadio);
		
		_noButWantCardRadio.click();
		
		log.info("Selected 'No, But I want one' option");
		
	}
	public void clickYesHaveCardRadio() throws InterruptedException{
		
		waitFor(_yesHaveCardRadio);
		
		_yesHaveCardRadio.click();
		
		log.info("Selected 'Yes, I have a card' option");
		
	}
	
	public void enterContactInformationInSignUp(String firstName, String lastName, String address1, String address2, String city, String  state, String zip, String homePhone, String mobilePhone, String cardlessId ){
		
		//Logger log = Logger.getLogger(SignUp_Tests.class);
		String homephone1, homephone2, homephone3;
		String mobilephone1, mobilephone2, mobilephone3;
		String cardlessId1, cardlessId2;
		homephone1 = homePhone.substring(0, 3);
		homephone2 = homePhone.substring(3, 6);
		homephone3 = homePhone.substring(6, 10);
		mobilephone1 = mobilePhone.substring(0, 3);
		mobilephone2 = mobilePhone.substring(3, 6);
		mobilephone3 = mobilePhone.substring(6, 10);
		cardlessId1 = cardlessId.substring(0, 7);
		cardlessId2 = cardlessId.substring(7, 11);
		
		waitFor(_firstName);
		_firstName.sendKeys(firstName);
		waitFor(_lastName);
		_lastName.sendKeys(lastName);
		waitFor(_address1);
		_address1.sendKeys(address1);
		waitFor(_address2);
		_address2.sendKeys(address2);
		waitFor(_city);
		_city.sendKeys(city);
		waitFor(_state);
		_state.sendKeys(state);
		waitFor(_zip);
		_zip.sendKeys(zip);
		waitFor(_homephone1);
		_homephone1.sendKeys(homephone1);
		waitFor(_homephone2);
		_homephone2.sendKeys(homephone2);
		waitFor(_homephone3);
		_homephone3.sendKeys(homephone3);
		waitFor(_mobilephone1);
		_mobilephone1.sendKeys(mobilephone1);
		waitFor(_mobilephone2);
		_mobilephone2.sendKeys(mobilephone2);
		waitFor(_mobilephone3);
		_mobilephone3.sendKeys(mobilephone3);
		waitFor(_cardless1);
		_cardless1.sendKeys(cardlessId1);
		waitFor(_cardless2);
		_cardless2.sendKeys(cardlessId2);
		_cardless2.sendKeys(Keys.ENTER);
		
		log.info("Entered the Contact Information details..");
			
	}
	
	public void clickUseThisAddressButton() throws InterruptedException{
	
		waitFor(_useThisAddress);
		_useThisAddress.click();
		
		log.info("Clicked on Use this address button on Address Verification");
		Thread.sleep(5000);
	}
	
	/*public boolean addRewardsCard_EnterDetails(String lastname, String CardNum)
	{
		log.info("Entering existing Card numder and Last name details for linking a card");
	
		_cardlessId1InAddRewardsPopup.clear();
		_cardlessId2InAddRewardsPopup.clear();
		waitFor(_logOut);
		return(_logOut.isDisplayed());

		
	}*/

	public void enterUserNameInSignUpPopup(String Username) throws InterruptedException {
		Thread.sleep(5000);
		_userName.clear();
		_userName.sendKeys(Username);
		//Thread.sleep(2000);
		_userName.sendKeys(Keys.TAB);
		
	}
	
	public void enterPasswordInSignUpPopup(String password) throws InterruptedException {
		Thread.sleep(5000);
		_password.clear();
		_password.sendKeys(password);
		
		
	}
	
	public void addRewardsCard_EnterDetails(String lastname, String CardNum)
    {
           log.info("Entering existing Card numder and Last name details for linking a card");
           
           _cardlessId1InAddRewardsPopup.clear();
           _cardlessId2InAddRewardsPopup.clear();
           waitFor(_lastNameInAddRewardsPopup);
		_lastNameInAddRewardsPopup.clear();
           _lastNameInAddRewardsPopup.sendKeys(lastname);
           waitFor(_rewardsNumInAddRewardsPopup);
		_rewardsNumInAddRewardsPopup.clear();
		_rewardsNumInAddRewardsPopup.sendKeys(CardNum);
			
           log.info("Entered existing Card numder and Last name details for linking a card");
    }
	
	public void addRewardsCard_CardNumCardlesId(String Cardnumber, String CardlessId)
	{
		log.info("Entering existing reward card number and Cardless Id details for linking a card");
		
		String cardless7 = CardlessId.substring(0, 7);
		String cardless4 = CardlessId.substring(7, 11);
		_lastNameInAddRewardsPopup.clear();
		_cardlessId1InAddRewardsPopup.clear();
		_cardlessId1InAddRewardsPopup.sendKeys(cardless7);
		_cardlessId2InAddRewardsPopup.clear();
		_cardlessId2InAddRewardsPopup.sendKeys(cardless4);
		
		waitFor(_rewardsNumInAddRewardsPopup);
		_rewardsNumInAddRewardsPopup.clear();
		_rewardsNumInAddRewardsPopup.sendKeys(Cardnumber);
		
		log.info("Entered existing reward card number and Cardless Id details for linking a card");
	}
	
	public void addRewardsCard_CardlessIdLastname(String lastname, String CardlessId)
	{
		log.info("Entering existing Last name and Cardless id details for linking a card");

		waitFor(_lastNameInAddRewardsPopup);
		_rewardsNumInAddRewardsPopup.clear();
		_lastNameInAddRewardsPopup.clear();
		_lastNameInAddRewardsPopup.sendKeys(lastname);
		String cardless7 = CardlessId.substring(0, 7);
		String cardless4 = CardlessId.substring(7, 11);
		
		_cardlessId1InAddRewardsPopup.clear();
		_cardlessId1InAddRewardsPopup.sendKeys(cardless7);
		_cardlessId2InAddRewardsPopup.clear();
		_cardlessId2InAddRewardsPopup.sendKeys(cardless4);
		
			log.info("Entered existing Last name and Cardless id details for linking a card");
	}
	
	
    
    /*public void addRewardsCard_CardNumCardlesId(String Cardnumber, String CardlessId)
    {
           log.info("Entering existing reward card number and Cardless Id details for linking a card");
           
           String cardless7 = CardlessId.substring(0, 7);
           String cardless4 = CardlessId.substring(7, 11);
           _lastNameInAddRewardsPopup.clear();
           _cardlessId1InAddRewardsPopup.clear();
           _cardlessId1InAddRewardsPopup.sendKeys(cardless7);
           _cardlessId2InAddRewardsPopup.clear();
           _cardlessId2InAddRewardsPopup.sendKeys(cardless4);
           
           waitFor(_rewardsNumInAddRewardsPopup);
           _rewardsNumInAddRewardsPopup.clear();
           _rewardsNumInAddRewardsPopup.sendKeys(Cardnumber);
           
           log.info("Entered existing reward card number and Cardless Id details for linking a card");
    }
    
    public void addRewardsCard_CardlessIdLastname(String lastname, String CardlessId)
    {
           log.info("Entering existing Last name and Cardless id details for linking a card");

           waitFor(_lastNameInAddRewardsPopup);
           _rewardsNumInAddRewardsPopup.clear();
           _lastNameInAddRewardsPopup.clear();
           _lastNameInAddRewardsPopup.sendKeys(lastname);
           String cardless7 = CardlessId.substring(0, 7);
           String cardless4 = CardlessId.substring(7, 11);
           
           _cardlessId1InAddRewardsPopup.clear();
           _cardlessId1InAddRewardsPopup.sendKeys(cardless7);
           _cardlessId2InAddRewardsPopup.clear();
           _cardlessId2InAddRewardsPopup.sendKeys(cardless4);
           
                  log.info("Entered existing Last name and Cardless id details for linking a card");
    }

	*/
}
