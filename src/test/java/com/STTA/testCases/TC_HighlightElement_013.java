package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HighlightElement_013 extends BaseClass{
	
	@Test
	public void testHighlightElement() throws Exception
	{
		//Application Launch
				//String url = "http://only-testing-blog.blogspot.in/2013/11/new-test.html";
				driver.get(baseURL);
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
			    
			    HighlightMyElement(driver.findElement(By.xpath("//input[@name='fname']")));
			    logger.info("element is Highlited");
			    driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
			    logger.info("Text is entered into the feild");
			    HighlightMyElement(driver.findElement(By.xpath("//button[@onclick='myFunction()']")));
			    logger.info("button is Higlited");
			    WebDriverWait wait = new WebDriverWait(driver, 15);
			    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submitButton")));
			    HighlightMyElement(driver.findElement(By.cssSelector("#submitButton")));
			    driver.findElement(By.cssSelector("#submitButton")).click();
			    logger.info("subbmitted button is highlited and clicked");
			    
			    logger.info("Required Action completed Successfully");
			    
			    
			  //below code for URL Verification
		        if (curl.equals(baseURL)){ 
		        	 System.out.println("Verification Successful - The correct Url is opened.");
		        	 }
		        	 else {
		        	 System.out.println("Verification Failed - An incorrect Url is opened."); 
		        	 
		        	 //In case of Fail, you like to print the actual and expected URL for the record purpose 
		        	 System.out.println("Actual URL is : " + curl); 
		        	 System.out.println("Expected URL is : " + baseURL);
		        	
		        	 }
		        
		      //below code for Title Verification once action Completed if it is wrong we Captured the Screen shot
		        
		        if(driver.getTitle().equals("Only Testing: New Test"))
				{
					Assert.assertTrue(true);
					logger.info("testHighlightElement Test Passed");
				}
				else
				{
					captureScreen(driver,"testHighlightElement");
					Assert.assertTrue(false);
					logger.info("testHighlightElement Test failed");
				} 
		        

			    
	}
	

}
