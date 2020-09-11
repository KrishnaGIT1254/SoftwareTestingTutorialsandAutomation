package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_GetHeightAndWidthOfElement_033 extends BaseClass {
	
	@Test
	public void testGetHeightAndWidthOfElement() throws IOException {

		
		  //Application Launch 
		   String url = "http://only-testing-blog.blogspot.com/2014/09/selectable.html";
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
		  
		 //From Here Actual test Start
		//Locate element for which you wants to get height and width.
			 WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
			 int imageWidth = image.getSize().getWidth();
			 System.out.println("Image width Is "+imageWidth+" pixels");
			 //Get height of element.
			 int imageHeight = image.getSize().getHeight();
			 System.out.println("Image Height Is "+imageWidth+" pixels");
			 
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
		        
		        if(driver.getTitle().equals("Only Testing: Selectable"))
				{
					Assert.assertTrue(true);
					logger.info("testGetHeightAndWidthOfElement Test Passed");
				}
				else
				{
					captureScreen(driver,"testGetHeightAndWidthOfElement");
					Assert.assertTrue(false);
					logger.info("testGetHeightAndWidthOfElement Test failed");
				} 
		        
		  
		  

}
}
