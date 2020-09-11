package com.STTA.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HandleDynamicWebTable_020 extends BaseClass{
	
	@Test
	public void testHandleDynamicWebTable() throws Exception
	{
		//Application Launch 
				String url =
				  "http://only-testing-blog.blogspot.com/2014/05/form.html";
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
				  
				  //To locate table.
				  WebElement mytable = driver.findElement(By.xpath("//div[@id='post-body-8228718889842861683']//div//table"));
				  
				//To locate rows of table.
				  List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
				  //To calculate no of rows In table.
				  int rows_count = rows_table.size();
				  
				//Loop will execute till the last row of table.
				  for (int row=0; row<rows_count; row++){
				   //To locate columns(cells) of that specific row.
				   List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				   
				 //To calculate no of columns(cells) In that specific row.
				   int columns_count = Columns_row.size();
				   System.out.println("Number of cells In Row "+row+" are "+columns_count);
				   
				 //Loop will execute till the last cell of that specific row.
				   for (int column=0; column<columns_count; column++){
				    //To retrieve text from that specific cell.
				    String celtext = Columns_row.get(column).getText();
				    System.out.println("Cell Value Of row number "+row+" and column number "+column+" Is "+celtext);
				    
				   }
				   
				   System.out.println("--------------------------------------------------");
	}
				  
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
			        
			        if(driver.getTitle().equals("Only Testing: Form"))
					{
						Assert.assertTrue(true);
						logger.info("testHandleDynamicWebTable Test Passed");
					}
					else
					{
						captureScreen(driver,"testHandleDynamicWebTable");
						Assert.assertTrue(false);
						logger.info("testHandleDynamicWebTable Test failed");
					} 
			        

}
	
}
