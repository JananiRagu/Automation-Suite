package com.test.regression.cub.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.regression.cub.utils.Constant;
import com.test.regression.cub.utils.SuiteBase;

public class WeeklyAdsPage extends SuiteBase{
       
       WebDriver _driver;
       
       
       public WeeklyAdsPage(WebDriver driver) {
              super();
              _driver=driver;
              PageFactory.initElements(_driver, this);
       }
       
       @FindBy(xpath = "//div[@class='wl-flyer-selector-main']/ul/li[1]/a")
       private WebElement _weeklysavings;
       
       @FindBy(xpath = "//*[@id='add_to_shopping_list']")
       private WebElement _additemsbutton;
       
       @FindBy(xpath = "//*[@class='v2_close_x']/a")
       private WebElement _closeicon;
       
       @FindBy(xpath = "//*[@class='add_shopping_list wishabi-remove-shopping-list']")
       private WebElement _removeitembutton;
       
       @FindBy(xpath = "//*[@id='content-sidebar']/div[2]/div/div/div/div[4]/form/button")
       private WebElement _viewfulllist;
       
       @FindBy(xpath = "//*[@class='add_facebook']/a")
       private WebElement _facebooklink;
       
       @FindBy(xpath = "//*[@class='add_twitter']/a")
       private WebElement _twitterlink;
       
       @FindBy(xpath = "//*[@class='add_google']/a")
       private WebElement _googlelink;
       
       @FindBy(xpath = "//*[@class='add_pinterest']/a")
       private WebElement _pinterestlink;
       
       @FindBy(xpath = "//*[@class='wishabi-broadsheettopbar-share']/div[1]")
       private WebElement _facebook;
       
       @FindBy(xpath = "//*[@class='wishabi-broadsheettopbar-share']/div[2]")
       private WebElement _twitter;
       
       @FindBy(xpath = "//*[@id='wishabi-flyerarea']/div[2]/div/div[1]/div[2]/div[2]/div/div/div")
       private WebElement _help;
       
       @FindBy(xpath = "//*[@id='wishabi-flyerarea']/div[2]/div/div[1]/div[2]/div[6]/div/div/div/span")
       private WebElement _feedback;
       
       @FindBy(xpath = "html/body/div[2]/div[1]")
       private WebElement _closehelppopup;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerfooter-trailer']/div/div[1]/span[1]/a")
       private WebElement _poweredbyflipp;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerfooter-trailer']/div/div[1]/span[2]/a[1]")
       private WebElement _patent;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerfooter-trailer']/div/div[1]/span[2]/a[2]")
       private WebElement _privacy;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerfooter-trailer']/div/div[1]/span[2]/a[3]")
       private WebElement _termsofuse;
       
       @FindBy(xpath = "//*[@class='int-modal-close-x']/a")
       private WebElement _closefeedbackpopup;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerview-arrow-centerer-right']/div")
       private WebElement _rightscroll;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerfooter-page-marker-text']")
       private WebElement _pagetop;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerfooter-trailer-page']")
       private WebElement _pagedown;
       
       @FindBy(xpath = "//*[@class='wishabi-flyerview-arrow-centerer-left']/div")
       private WebElement _leftscroll;
       
       @FindBy(xpath = "//*[@class='other-flyers-count']")
       private WebElement _MoreAds;
       
       @FindBy(xpath = "//*[@class='white-label-flyer-select-container flyer-selector-full-page']/div[1]/h1")
       private WebElement _Header;
       
       @FindAll({@FindBy(xpath = "//*[@class='wl-flyer-selector-main']/ul/li")})
       private List<WebElement> _noOfAds;
       
       public void clickWeeklysavings(WebDriver driver) throws InterruptedException{
              System.out.println("Inside clickWeeklysavings method");
              driver.switchTo().frame("flipp-iframe");
              _weeklysavings.click();
              Thread.sleep(5000);        
       }
       public WebDriver clickdriver(WebDriver driver) throws InterruptedException{
              Thread.sleep(5000);
              return driver;             
       }
       public void clickadditem(){
              waitFor(_additemsbutton);
              System.out.println("Click on add item button");        
              _additemsbutton.click();
       
              System.out.println("Item added to shopping list");
       }
       public void clickremoveitem(){
              waitFor(_removeitembutton);
              System.out.println("Click on remove item button");            
              _removeitembutton.click();
       
              System.out.println("Item removed from shopping list");
       }
       public void clickcloseicon(){
              waitFor(_closeicon);
              System.out.println("Click on close pop up");           
              _closeicon.click();
              System.out.println("pop up is closed");
       }
       
       public int noOfAdsInWeeklyAdPage() throws InterruptedException{
              Thread.sleep(2000);
              int size = _noOfAds.size(); 
               return size;
       }
       
       public void clickOnMylistUnderMyTools(WebDriver driver) throws InterruptedException
       {
              Thread.sleep(10000);
              driver.navigate().to(Constant.URL+"shopping-list.html");  
       }
       public void clickviewFullList(WebDriver driver){
              System.out.println("list");
              driver.switchTo().defaultContent();
              _viewfulllist.click();
       }
       public void clickfacebook(){
              waitFor(_facebooklink);
              _facebooklink.click();
       }
       public void clicktwitter(){
              waitFor(_twitterlink);
              _twitterlink.click();
       }
       public void clickgoogle(){
              waitFor(_googlelink);
              _googlelink.click();
       }
       public void clickpinterest(){
              waitFor(_pinterestlink);
              _pinterestlink.click();
       }
       
       public void clickfb(){
              waitFor(_facebook);
              _facebook.click();
       }
       public void clicktw(){
              waitFor(_twitter);
              _twitter.click();
       }
       
       public void clickhelp(){
              waitFor(_help);
              _help.click();
       }
       public void clickfeedback(){
              waitFor(_feedback);
              _feedback.click();
       }
       public void clickclosehelp(){
              waitFor(_closehelppopup);
              _closehelppopup.click();
       }
       public void clickclosefeedback(){
              waitFor(_closefeedbackpopup);
              _closefeedbackpopup.click();
       }
       public void clickpoweredbyflipp(){
              waitFor(_poweredbyflipp);
              _poweredbyflipp.click();
       }
       public void clickpatent(){
              waitFor(_patent);
              _patent.click();
       }
       public void clickprivacy(){
              waitFor(_privacy);
              _privacy.click();
       }
       public void clicktermsofuse(){
              waitFor(_termsofuse);
              _termsofuse.click();
       }
       public void clickrightscroll(){
              waitFor(_rightscroll);
              _rightscroll.click();
       }
       public String toppageno(){
              String numbertop=_pagetop.getText();
              return numbertop;
       }
       public String downpageno(){
              String numberdown=_pagedown.getText();
              return numberdown;
       }
       public void clickleftscroll(){
              waitFor(_leftscroll);
              _leftscroll.click();
       }
       public String MoreAds(){
              String noofAds=_MoreAds.getText();
              _MoreAds.click();
              return noofAds;
       }
       public String heading(WebDriver driver){
              String header=_Header.getText();
              System.out.println(header);
              return header;
       }
       
       @FindBy(xpath = "//button[text()='Create a List']")
       private WebElement _createAList;
       
       public void clickOnCreateListButton(){
                       
                       waitFor(_createAList);
                       _createAList.click();
       }

}
     
