package com.STTA.testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CaptureElementScreenshot_032 extends BaseClass {
	
	@Test
	public void testCaptureElementScreenshot() throws IOException {

		
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
		  
		//Locate Image element to capture screenshot.
	        WebElement image = driver.findElement(By.xpath("//img[@border='0']"));
	      //Call captureElementScreenshot function to capture screenshot of element.
	        captureElementScreenshot(image);
	}
	 
	 public void captureElementScreenshot(WebElement e) throws IOException {
		 
		//Capture entire page screenshot as buffer.
		  //Used TakesScreenshot, OutputType Interface of selenium and File class of java to capture screenshot of entire page.
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	  //Used selenium getSize() method to get height and width of element.
	    //Retrieve width of element.
	    int imgWidth = e.getSize().getWidth();
	  //Retrieve height of element.
	    int ImageHeight = e.getSize().getHeight(); 
	    
	    //Used selenium Point class to get x y coordinates of Image element.
	    //get location(x y coordinates) of the element.
	    Point p = e.getLocation();
	    int xcord = p.getX();
	    int ycord = p.getY();
	    
	  //Reading full image screenshot.
	    BufferedImage img = ImageIO.read(scrFile);
	    
	  //cut Image using height, width and x y coordinates parameters.
	    BufferedImage dest = img.getSubimage(imgWidth, ImageHeight, xcord, ycord);
	    ImageIO.write(dest, "jpg", scrFile);
	    
	    //Used FileUtils class of apache.commons.io.
	    //save Image screenshot In D: drive.
	    FileUtils.copyFile(scrFile, new  File("C:\\Users\\Venkatakrishna\\Desktop\\SoftwareTestingTutorialsandAutomation\\ScreeshotsTC\\Screenshot.jpg"));
	    logger.info("Required Action completed Successfully");
	    
	    
	
	    
	  //below code for Title Verification once action Completed if it is wrong we Captured the Screen shot
        
        if(driver.getTitle().equals("Only Testing: Selectable"))
		{
			Assert.assertTrue(true);
			logger.info("testCaptureElementScreenshot Test Passed");
		}
		else
		{
			captureScreen(driver,"testCaptureElementScreenshot");
			Assert.assertTrue(false);
			logger.info("testCaptureElementScreenshot Test failed");
		} 
        
	    
	 
	
     
	 
	 
	 
	 
	 }

	 
	
     
	 
	 
		  

}


