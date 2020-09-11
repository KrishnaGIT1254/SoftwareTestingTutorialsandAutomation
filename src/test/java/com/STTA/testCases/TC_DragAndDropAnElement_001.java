package com.STTA.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.STTA.pageObjects.DragAndDropPage;

public class TC_DragAndDropAnElement_001 extends BaseClass {

	@Test
	public void testdragAndDrop() throws IOException {

		
		  //Application Launch 
		   String url =
		  "http://only-testing-blog.blogspot.com/2014/09/drag-and-drop.html";
		  driver.get(url); 
		  logger.info("Application URL is Launched");
		  
		  //Title of the Webpage 
		  String Title = driver.getTitle();
		  System.out.println("The Title of the page is " +Title);
		  logger.info("The title of the page is stored");
		  
		  // Storing Title length in the Int variable 
		  int titleLength =
		  driver.getTitle().length(); 
		  System.out.println("The title length is " +titleLength);
		  logger.info("The title length is stored");
		  
		  //current URL of the page 
		  String curl = driver.getCurrentUrl();
		  System.out.println("This is the Page Current URL: "+curl);
		  logger.info("we got Current page URL");
		  
		  //Get domain name using java script executor 
		  JavascriptExecutor javascript =
		  (JavascriptExecutor) driver; String
		  CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
		  System.out.println("My Current URL domain name is: "+CurrentURLUsingJS);
		  logger.info("Stored the Domain name of the current url");
		  
		  
		/*
		 * // current page source String ps = driver.getPageSource();
		 * System.out.println("The current page source is "+ps);
		 * logger.info("The page source is stored");
		 * 
		 * 
		 * // Storing Page Source length in Int variable int psLength =
		 * driver.getPageSource().length();
		 * System.out.println("The Page source length is "+psLength);
		 * 
		 * logger.info("The title of the page source is stored");
		 */
		  
		 
				  
				  
				  
				  //From Here Actual test Start
				  
				  
				 
				  
				  //Locate element which you wants to drag. 
		  	
		  	//WebElement dragElementFrom =driver.findElement(By.xpath("//div[@id='dragdiv']")); 
		  	By locator =By.xpath("//div[@id='dragdiv']"); 
				  WebElement dragElementFrom = driver.findElement(locator);
				  logger.info("Located Element which we want to drag");
				  
				  //Store text of targeted element in variable 
				  String dem =dragElementFrom.getText(); 
				  System.out.println("The drag element text is"+dem); 
				  logger.info("Stored text of dragged element");
				  
				  //Locate element where you wants to drop. 
				  WebElement dropElementTo =driver.findElement(By.xpath("//div[@id='dropdiv']"));
				  logger.info("Located Element where we want to drop");
				  
				  //Use Actions class and Its members of WebDriver API to perform drag and dropoperation.
				  Actions builder = new Actions(driver); 
				  Action dragAndDrop = builder.clickAndHold(dragElementFrom) 
						  .moveToElement(dropElementTo).release(dropElementTo).build(); 
				  dragAndDrop.perform();
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
			        
			        if(driver.getTitle().equals("Only Testing: Drag and Drop"))
					{
						Assert.assertTrue(true);
						logger.info("testdragAndDrop Test Passed");
					}
					else
					{
						captureScreen(driver,"testdragAndDrop");
						Assert.assertTrue(false);
						logger.info("testdragAndDrop Test failed");
					} 
			        
		
}
}
