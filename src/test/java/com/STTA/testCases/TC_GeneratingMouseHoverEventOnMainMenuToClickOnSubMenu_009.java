package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_GeneratingMouseHoverEventOnMainMenuToClickOnSubMenu_009 extends BaseClass{
	
	@Test
	public void testGeneratingMouseHoverEventOnMainMenuToClickOnSubMenu() throws IOException
	{
		//Application Launch
		
				String url = "http://only-testing-blog.blogspot.in/p/mouse-hover.html";
				driver.get(url);
				logger.info("Application URL is Launched");
				
				//Title of the Webpage
				String Title = driver.getTitle();
				System.out.println("The Title of the page is " +Title);
				logger.info("The title of the page is stored");
				
				// Storing Title length in the Int variable 
				int titleLength = driver.getTitle().length();
				System.out.println("The title length is " +titleLength);
				logger.info("The title length is stored");
				
				//current URL of the page
				String curl = driver.getCurrentUrl();
			    System.out.println("This is the Page Current URL: "+curl);
			    
			    logger.info("we got Current page URL");
			    
			    //Get domain name using java script executor
			    JavascriptExecutor javascript = (JavascriptExecutor) driver;
			    String CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
			    System.out.println("My Current URL domain name is: "+CurrentURLUsingJS);
			    logger.info("Stored the Domain name of the current url");
			    
			  //Generate mouse hover event on main menu to click on sub menu
			    Actions actions = new Actions(driver);
			    WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div"));
			    actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform();
			    
			    WebDriverWait wait = new WebDriverWait(driver, 15);
			    wait.until(ExpectedConditions.titleContains("Google"));
			    
			    
			  //below code for URL Verification
		        if (curl.equals(url)){ 
		        	 System.out.println("Verification Successful - The correct Url is opened.");
		        	 }
		        	 else {
		        	 System.out.println("Verification Failed - An incorrect Url is opened."); 
		        	 
		        	 //In case of Fail, you like to print the actual and expected URL for the record purpose 
		        	 System.out.println("Actual URL is : " + curl); 
		        	 System.out.println("Expected URL is : " + url);
		        	
		        	 }
		        
		        
		      //below code for Title Verification once action Completed if it is wrong we Captured the Screen shot
		        
		        if(driver.getTitle().equals("Google"))
				{
					Assert.assertTrue(true);
					logger.info("testGeneratingMouseHoverEventOnMainMenuToClickOnSubMenu Test Passed");
				}
				else
				{
					captureScreen(driver,"testGeneratingMouseHoverEventOnMainMenuToClickOnSubMenu");
					Assert.assertTrue(false);
					logger.info("testGeneratingMouseHoverEventOnMainMenuToClickOnSubMenu Test failed");
				} 
		        
	}

}
