package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_OpenTabAndSwitchingBetweenTabs_035 extends BaseClass{
	
	@Test
	public void testOpenTabAndSwitchingBetweenTabs() throws IOException, Exception {

		
		  //Application Launch 
		   String url = "http://only-testing-blog.blogspot.com/2014/04/calc.html";
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
		  
		//Open tab 2 using CTRL + t keys.
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		  //Open URL In 2nd tab.
		  driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
		  
		  //Call switchToTab() function to switch to 1st tab
		  switchToTab();
		  //perform required actions on tab 1.
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id='6']")).click();
		  driver.findElement(By.xpath("//input[@id='plus']"));
		  driver.findElement(By.xpath("//input[@id='3']"));
		  driver.findElement(By.xpath("//input[@id='equals']"));
		  
		  //Call switchToTab() function to switch to 2nd tab.
		  switchToTab();
		  //perform required actions on tab 2.
		  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("hi");
		  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("test");
		  
		  //Call switchToTab() function to switch to 1st tab
		  switchToTab();
		  //perform required actions on tab 1.
		  String str = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		  System.out.println("Sum result Is -> "+str);
		 } 
		 
		 public void switchToTab() throws IOException {
		  //Switching between tabs using CTRL + tab keys.
		  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		  //Switch to current selected tab's content.
		  driver.switchTo().defaultContent(); 
		  
		  
		  
		 


		//below code for Title Verification once action Completed if it is wrong we Captured the Screen shot
	        
	     /*   if(driver.getTitle().equals("Only Testing: Form"))
			{
				Assert.assertTrue(true);
				logger.info("testOpenTabAndSwitchingBetweenTabs Test Passed");
			}
			else
			{
				captureScreen(driver,"testOpenTabAndSwitchingBetweenTabs");
				Assert.assertTrue(false);
				logger.info("testOpenTabAndSwitchingBetweenTabs Test failed");
			} 
	        */
	        
	        
}
		 
		 
		 
}
