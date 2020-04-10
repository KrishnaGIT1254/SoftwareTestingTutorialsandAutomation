package com.STTA.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_HandleCheckbox_004 extends BaseClass{
	
	@Test
	public void testCheckbox() throws IOException
	{
		//Application Launch
				driver.get("http://only-testing-blog.blogspot.in/2013/11/new-test.html");
				logger.info("Application URL is Launched");
				
				String i = driver.getCurrentUrl();
			    System.out.println("This is the Page Current URL: "+i);
			    
			    logger.info("we got Current page URL");
			    
			   driver.findElement(By.xpath("//input[@value='Bike']")).click();
			    
			    boolean str1 = driver.findElement(By.xpath("//input[@value='Bike']")).isSelected();
			    
			    if(str1=true)
			    {
			    	System.out.println("Checkbox is checked");
			    }
			    else
			    {
			    	System.out.println("Check box is not checked");
			    }
			    
			    if(driver.getTitle().equals("Only Testing: New Test"))
				{
					Assert.assertTrue(true);
					logger.info("testCheckbox Test Passed");
				}
				else
				{
					captureScreen(driver,"testCheckbox");
					Assert.assertTrue(false);
					logger.info("testCheckbox Test failed");
				} 
			    
			    
			    
			    
	}
	
	@Test
	  public void testmethodone() {
	  driver.navigate().to("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	  String title = driver.getTitle();
	  System.out.print("\nCurrent page title is : "+title);
	  String Workdir = System.getProperty("user.dir");
	  String Classpackname = this.getClass().getName();
	  System.out.print("\n'"+Workdir+" -> "+Classpackname+" -> testmethodone' has been executed successfully");
	  }

}
