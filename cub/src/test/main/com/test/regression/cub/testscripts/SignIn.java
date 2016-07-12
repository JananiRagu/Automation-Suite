package com.test.regression.cub.testscripts;

import java.io.IOException;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import com.test.regression.cub.pages.CubHome;
import com.test.regression.cub.utils.Logg;
import com.test.regression.cub.utils.ReadXML;
import com.test.regression.cub.utils.SuiteBase;

public class SignIn extends SuiteBase {

	CubHome cubHome;
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();

	@Test(priority=1, enabled=true)
	
	public void validLogin() {
		try {
			
		// Retrieving test data for valid login
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "carded-user");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");

		cubHome = new CubHome(_driver);
			log.info("Test Data Used >>>>>>>");
			log.info("User Name : " + userId);
			log.info("Password : " + password);
		
		cubHome.clickSignInLink();
		
		cubHome.enterLoginDetails(userId, password);

		cubHome.clickSignInButton();
		
		boolean result = cubHome.isLogOutButtonPresent();
		System.out.println("Result is " + result);
		Assert.assertTrue(result);
		
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());		
		} catch (IOException ioe) {
			log.info(ioe.getMessage());		
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());		
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());		
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());		
		} catch (Exception e) {
			log.info(e.getMessage());		
		}
	}
	
	@Test(priority=2,enabled=true) 
	  public void inValidLogin(){
		
		try {
		// Retrieving test data for valid login
		Map<String, String> invalidLogin = readxml.getUserData("TestData.xml", "invalid-user");
		String userId = invalidLogin.get("UserName");
		String password = invalidLogin.get("password");

		cubHome = new CubHome(_driver);
		
			log.info("Test Data Used >>>>>>>");
			log.info("User Name" + userId);
			log.info("Password" + password);
			
		cubHome.clickSignInLink();
			
		cubHome.enterLoginDetails(userId, password);
			
		cubHome.clickSignInButton();
		
		Assert.assertTrue(cubHome.isPasswordIncorrectTextPresent());
	
		} catch (InterruptedException ie) {
			log.info(ie.getMessage());		
		} catch (IOException ioe) {
			log.info(ioe.getMessage());		
		} catch (XPathExpressionException xee) {
			log.info(xee.getMessage());		
		} catch (ParserConfigurationException pce) {
			log.info(pce.getMessage());		
		} catch (SAXException saxe) {
			log.info(saxe.getMessage());		
		} catch (Exception e) {
			log.info(e.getMessage());		
		}
	 
	}
	
}
