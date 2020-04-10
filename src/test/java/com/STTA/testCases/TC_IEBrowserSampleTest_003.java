package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;

public class TC_IEBrowserSampleTest_003 extends BaseClass{
	
	//@Ignore
	@Test
	public void testCal() throws IOException
	{
		  // Load sample calc test URL.
		 driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");
		 logger.info("Application URL is Launched");
		 String i = driver.getCurrentUrl();
		 System.out.println("This is the Page Current URL: "+i);
		 logger.info("we got Current page URL");
		 driver.findElement(By.xpath("//input[@id='1']")).click();
		 logger.info("1 is Clicked ");
		  driver.findElement(By.xpath("//input[@id='plus']")).click();
		  logger.info("+ is Clicked ");
		  driver.findElement(By.xpath("//input[@id='6']")).click();
		  logger.info("6 is Clicked ");
		  driver.findElement(By.xpath("//input[@id='equals']")).click();
		  logger.info(" = is Clicked ");
		  String result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		  System.out.println("Calc test result Is : " + result);
		  logger.info("Result is displayed");
		  
		  if(driver.getTitle().equals("Only Testing: Calc"))
			{
				Assert.assertTrue(true);
				logger.info(" testCal Test Passed");
			}
			else
			{
				captureScreen(driver,"testCal");
				Assert.assertTrue(false);
				logger.info("testCal Test failed");
			} 
	}
	


}
