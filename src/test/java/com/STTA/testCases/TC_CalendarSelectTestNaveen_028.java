package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CalendarSelectTestNaveen_028 extends BaseClass{
	
	@Test
	public void testCalendarSelectTestNaveen() throws IOException, Exception {

		
		  //Application Launch 
		   String url =
		  "https://ui.cogmento.com/";
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
		  
		  driver.findElement(By.name("username")).sendKeys("krishnaqa829@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Krishna@123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@type='submit']")).click(); //login button
			
			driver.switchTo().frame("mainpanel");
			
			String date = "32-May-2017";
			String dateArr[] = date.split("-"); // {18,September,2017}
			String day = dateArr[0];
			String month = dateArr[1];
			String year = dateArr[2];
			
			Select select = new Select(driver.findElement(By.name("slctMonth")));
			select.selectByVisibleText(month);
			
			Select select1 = new Select(driver.findElement(By.name("slctYear")));
			select1.selectByVisibleText(year);
			
			//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
			//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]	
			//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
			
			String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
			String afterXpath = "]/td[";
			
			final int totalWeekDays = 7;
			
			//2-1 2-2 2-3 2-4 2-5 2-6 2-7
			//3-2 3-2 3-3 3-4 3-5 3-6 3-7
			boolean flag = false;
			String dayVal = null;
			for(int rowNum=2; rowNum<=7; rowNum++){
				
				for(int colNum = 1; colNum<=totalWeekDays; colNum++){
					try{
				    dayVal =driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
					}catch (NoSuchElementException e){
						System.out.println("Please enter a correct date value");
						flag = false;
						break;
					}
					System.out.println(dayVal);
					if(dayVal.equals(day)){
						driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
						flag = true;
						break;
					}				
				}
				if(flag){
					break;
				}
				
			}
			
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
	        
	        if(driver.getTitle().equals("Free CRM #1 cloud software for any business large or small"))
			{
				Assert.assertTrue(true);
				logger.info("testCalendarSelectTestNaveen Test Passed");
			}
			else
			{
				captureScreen(driver,"testCalendarSelectTestNaveen");
				Assert.assertTrue(false);
				logger.info("testCalendarSelectTestNaveen Test failed");
			} 
	        
		  
		  
		  
		  

}
	
}
