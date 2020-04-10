package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ReadingFontProperties_014 extends BaseClass{
	
	@Test
	public void testReadingFontProperties() throws Exception
	{
		//Application Launch
				String url = "http://only-testing-blog.blogspot.in/2014/05/login.html";
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
			    
			    //From here actual test is started
			    
			  //Locate text string element to read It's font properties.
			    WebElement text = driver.findElement(By.xpath("//h1[contains(.,'Example Login Page')]"));
			    
			    //Read font-size property and print It In console.
			    String fontSize = text.getCssValue("font-size");
			    System.out.println("Font Size -> "+fontSize);
			    logger.info("Read font-size property and printed It In console");
			    
			    //Read color property and print It In console.
			    String fontColor = text.getCssValue("color");
			    System.out.println("Font Color -> "+fontColor);
			    logger.info("Read color property and printed It In console.");
			    
			    //Read font-family property and print It In console.
			    String fontFamily = text.getCssValue("font-family");
			    System.out.println("Font Family -> "+fontFamily);
			    logger.info("Read font-family property and printed It In console.");
			    
			    //Read text-align property and print It In console.
			    String fonttxtAlign = text.getCssValue("text-align");
			    System.out.println("Font Text Alignment -> "+fonttxtAlign);
			    logger.info("Read text-align property and printed It In console.");
			    
			    logger.info("Required Action completed Successfully");
			    
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
		        
		        if(driver.getTitle().equals("Only Testing: LogIn"))
				{
					Assert.assertTrue(true);
					logger.info("testReadingFontProperties Test Passed");
				}
				else
				{
					captureScreen(driver,"testReadingFontProperties");
					Assert.assertTrue(false);
					logger.info("testReadingFontProperties Test failed");
				} 
		        
			    
			    
			    
			    
	}

}
