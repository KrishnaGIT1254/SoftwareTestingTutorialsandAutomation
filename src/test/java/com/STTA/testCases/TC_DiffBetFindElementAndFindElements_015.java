package com.STTA.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DiffBetFindElementAndFindElements_015 extends BaseClass{
	@Test
	public void testDiffBetFindElementAndFindElements() throws Exception
	{
		//Application Launch
				String url = "http://only-testing-blog.blogspot.in/2014/01/textbox.html";
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
			    
			  //From Here Actual test Start
			    
			    
			    WebElement option = driver.findElement(By.xpath("//option[@id='country5']"));
			    System.out.print(option.getAttribute("id")+" - "+option.getText());
			    logger.info("findElement will locate only targeted element and then print its id and text in console");
			    List<WebElement> options= driver.findElements(By.xpath("//option"));
			    System.out.println(options.size());
			    logger.info("");
			    for(int i=0;i<options.size();i++)
			    {
			     String str = options.get(i).getAttribute("id")+" - "+options.get(i).getText();
			     System.out.println(str);
			     
			    }
			    logger.info("findElements will locate all those elements of current page which are under given xpath = //option. for loop is used to print all those element's id and text in console.\r\n" + 
			    		"");
			    
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
		        
		        if(driver.getTitle().equals("Only Testing: TextBox"))
				{
					Assert.assertTrue(true);
					logger.info("testDiffBetFindElementAndFindElements Test Passed");
				}
				else
				{
					captureScreen(driver,"testDiffBetFindElementAndFindElements");
					Assert.assertTrue(false);
					logger.info("testDiffBetFindElementAndFindElements Test failed");
				} 
			    
			    
	}

}
