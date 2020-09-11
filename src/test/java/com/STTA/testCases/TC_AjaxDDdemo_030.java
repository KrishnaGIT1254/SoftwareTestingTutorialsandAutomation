package com.STTA.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AjaxDDdemo_030 extends BaseClass{
	
	@Test
	public void testAjaxDDdemo() throws IOException, Exception {

		
		  //Application Launch 
		   String url =
		  "http://aponline.gov.in/apportal/contact/sec_select.asp?sid=1";
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
		  
		  
			assertEquals(":: Government Orders ::",driver.getTitle());
			Select s=new Select(driver.findElement(By.id("Select1")));
			s.selectByIndex(1);
			
			List<WebElement> tr_collection=driver.findElements(By.xpath("//table[@id='Table9']/tbody/tr"));
			System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
			List<WebElement> td_collection1=driver.findElements(By.xpath("//table[@id='Table9']/tbody/tr/td"));
			System.out.println("NUMBER OF Columns IN THIS TABLE = "+td_collection1.size()/tr_collection.size());
			
			int row_num,col_num;
	        row_num=1;
	        for(WebElement trElement : tr_collection)
	        {
	            List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
	            //System.out.println("NUMBER OF COLUMNS="+td_collection.size());
	            col_num=1;
	            for(WebElement tdElement : td_collection)
	            {
	               
	            	System.out.println("Row # "+row_num+", Col # "+col_num  + ", Text=" +tdElement.getText());
	                col_num++;
	               
	            }
	            row_num++;
	        }
	        Thread.sleep(4000);
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
    
    if(driver.getTitle().equals(""))
	{
		Assert.assertTrue(true);
		logger.info("testAjaxDDdemo Test Passed");
	}
	else
	{
		captureScreen(driver,"testAjaxDDdemo");
		Assert.assertTrue(false);
		logger.info("testAjaxDDdemo Test failed");
	} 
    

	}		  


}
