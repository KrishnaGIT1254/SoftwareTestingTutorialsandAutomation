package com.STTA.testCases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HandlingMultipleBrowserWindows_010 extends BaseClass{
	
	@Test
	public void testHandlingMultipleBrowserWindows() throws Exception
	{
		//Application Launch
		
				String url = "http://only-testing-blog.blogspot.com/2014/01/textbox.html";
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
			    
			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			    driver.findElement(By.xpath("//b[contains(.,'Open New Page')]")).click();
			    
			    // Get and store both window handles in array
			    Set<String> AllWindowHandles = driver.getWindowHandles();
			    String window1 = (String) AllWindowHandles.toArray()[0];
			    System.out.print("window1 handle code = "+AllWindowHandles.toArray()[0]);
			    String window2 = (String) AllWindowHandles.toArray()[1];
			    System.out.print("\nwindow2 handle code = "+AllWindowHandles.toArray()[1]);
			    
			    //Switch to window2(child window) and performing actions on it.
			    driver.switchTo().window(window2);
			    driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
			   // driver.findElement(By.xpath("//input[@value='Bike']")).click();
			    driver.findElement(By.xpath("//input[@value='Car']")).click();
			    driver.findElement(By.xpath("//input[@value='Boat']")).click();
			    driver.findElement(By.xpath("//input[@value='male']")).click();
			    Thread.sleep(5000);
			    
			    //Switch to window1(parent window) and performing actions on it.
			    driver.switchTo().window(window1);
			    driver.findElement(By.xpath("//option[@id='country6']")).click();
			    driver.findElement(By.xpath("//input[@value='female']")).click();
			    driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
			    driver.switchTo().alert().accept();
			    Thread.sleep(5000);
			    
			    //Once Again switch to window2(child window) and performing actions on it.
			    driver.switchTo().window(window2);
			    driver.findElement(By.xpath("//input[@name='fname']")).clear();
			    driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Name Changed");
			    Thread.sleep(5000);
			    driver.close();
			    
			    
			    //Once Again switch to window1(parent window) and performing actions on it.
			    driver.switchTo().window(window1);
			    driver.findElement(By.xpath("//input[@value='male']")).click();
			    Thread.sleep(5000);
			    
			    
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
					logger.info("testHandlingMultipleBrowserWindows Test Passed");
				}
				else
				{
					captureScreen(driver,"testHandlingMultipleBrowserWindows");
					Assert.assertTrue(false);
					logger.info("testHandlingMultipleBrowserWindows Test failed");
				} 
	}

}
