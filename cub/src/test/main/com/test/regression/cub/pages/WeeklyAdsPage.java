package com.test.regression.cub.pages;


import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadPropertiesFile;
import com.test.regression.cub.utils.SuiteBase;

public class WeeklyAdsPage extends SuiteBase{
       
       WebDriver _driver;
       
       ReadPropertiesFile properties = new ReadPropertiesFile();
       Logger log = Logg.createLogger();
       
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
              log.info("Click on weekly Ads saving page");
       }
       public WebDriver clickdriver(WebDriver driver) throws InterruptedException{
              Thread.sleep(5000);
              return driver;             
       }
       public void clickadditem(){
              waitFor(_additemsbutton);
              System.out.println("Click on add item button");        
              _additemsbutton.click();
              log.info("Item added to shopping list");
       }
       public void clickremoveitem(){
              waitFor(_removeitembutton);
              log.info("Click on remove item button");            
              _removeitembutton.click();
              log.info("Item removed from shopping list");
       }
       public void clickcloseicon(){
              waitFor(_closeicon);
              log.info("Click on close icon pop up");           
              _closeicon.click();
              log.info("pop up is closed");
       }
       
       public int noOfAdsInWeeklyAdPage() throws InterruptedException{
              Thread.sleep(2000);
              int size = _noOfAds.size(); 
               return size;
       }
       
       public void clickOnMylistUnderMyTools(WebDriver driver) throws InterruptedException, IOException
       {
              Thread.sleep(10000);
              driver.navigate().to(properties.getPropValue("testURL")+"shopping-list.html");  
       }
       public void clickviewFullList(WebDriver driver){
              driver.switchTo().defaultContent();
              _viewfulllist.click();
              log.info("Click on View full list");
       }
       public void clickfacebook(){
              waitFor(_facebooklink);
              _facebooklink.click();
              log.info("Click on facebook link");
       }
       public void clicktwitter(){
              waitFor(_twitterlink);
              _twitterlink.click();
              log.info("Click on twitter link");
       }
       public void clickgoogle(){
              waitFor(_googlelink);
              _googlelink.click();
              log.info("Click on google link");
       }
       public void clickpinterest(){
              waitFor(_pinterestlink);
              _pinterestlink.click();
              log.info("Click on pinterest link");
       }
       
       public void clickfb(){
              waitFor(_facebook);
              _facebook.click();
              log.info("Click on facebook link outside page");
       }
       public void clicktw(){
              waitFor(_twitter);
              _twitter.click();
              log.info("Click on twitter link outside page");
       }
       
       public void clickhelp(){
              waitFor(_help);
              _help.click();
              log.info("Click on help button");
       }
       public void clickfeedback(){
              waitFor(_feedback);
              _feedback.click();
              log.info("Click on feedback button");
       }
       public void clickclosehelp(){
              waitFor(_closehelppopup);
              _closehelppopup.click();
              log.info("Click on close help button");
       }
       public void clickclosefeedback(){
              waitFor(_closefeedbackpopup);
              _closefeedbackpopup.click();
              log.info("Click on close feedback button");
       }
       public void clickpoweredbyflipp(){
              waitFor(_poweredbyflipp);
              _poweredbyflipp.click();
              log.info("Click on poweredbyFlipp link");
       }
       public void clickpatent(){
              waitFor(_patent);
              _patent.click();
              log.info("Click on patent link");
       }
       public void clickprivacy(){
              waitFor(_privacy);
              _privacy.click();
              log.info("Click on privacy link");
       }
       public void clicktermsofuse(){
              waitFor(_termsofuse);
              _termsofuse.click();
              log.info("Click on Terms of Use link");
       }
       public void clickrightscroll(){
              waitFor(_rightscroll);
              _rightscroll.click();
              log.info("Click on right scroll button");
       }
       public String toppageno(){
              String numbertop=_pagetop.getText();
              log.info("Page number on top of the page");
              return numbertop;
       }
       public String downpageno(){
              String numberdown=_pagedown.getText();
              log.info("Page number below the page");
              return numberdown;
       }
       public void clickleftscroll(){
              waitFor(_leftscroll);
              _leftscroll.click();
              log.info("Click on left scroll button");
       }
       public String MoreAds(){
              String noofAds=_MoreAds.getText();
              _MoreAds.click();
              log.info("Click on More Ads button");
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
     
