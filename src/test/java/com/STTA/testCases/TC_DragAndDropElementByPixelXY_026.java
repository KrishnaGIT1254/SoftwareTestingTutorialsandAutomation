package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DragAndDropElementByPixelXY_026 extends BaseClass{
	
	@Test
	public void testDragAndDropElementByPixelXY() throws InterruptedException, IOException
	{
		//Application Launch 
		   String url =
		  "http://only-testing-blog.blogspot.in/2014/09/drag-and-drop.html";
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
		  
		  //Actual Test start from here
		  
		//Locate element which you wants to drag.
		  WebElement dragElementFrom = driver.findElement(By.xpath("//div[@id='dragdiv']"));
		    
		  //To drag and drop element by 100 pixel offset In horizontal direction X.
		  new Actions(driver).dragAndDropBy(dragElementFrom, 100, 0).build() .perform();
		  
		  //To generate alert after horizontal direction drag and drop. VIEW EXAMPLE
		  JavascriptExecutor javascript1 = (JavascriptExecutor) driver;
		  javascript1.executeScript("alert('Element Is drag and drop by 100 pixel offset In horizontal direction.');");
		  Thread.sleep(5000);
		  driver.switchTo().alert().accept();  
		  
		  //To drag and drop element by 100 pixel offset In Vertical direction Y.
		  new Actions(driver).dragAndDropBy(dragElementFrom, 0, 100).build() .perform();  
		 
		  //To generate alert after Vertical direction drag and drop.
		  javascript.executeScript("alert('Element Is drag and drop by 100 pixel offset In Vertical direction.');");
		  Thread.sleep(5000);
		  driver.switchTo().alert().accept();
		  
		  //To drag and drop element by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.
		  new Actions(driver).dragAndDropBy(dragElementFrom, -100, -100).build() .perform();
		 
		  //To generate alert after horizontal and vertical direction drag and drop.
		  javascript.executeScript("alert('Element Is drag and drop by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.');");
		  Thread.sleep(5000);
		  driver.switchTo().alert().accept();
		 

	
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
		logger.info("testDragAndDropElementByPixelXY Test Passed");
	}
	else
	{
		captureScreen(driver,"testDragAndDropElementByPixelXY");
		Assert.assertTrue(false);
		logger.info("testDragAndDropElementByPixelXY Test failed");
	} 
    
    
	

	}
}

