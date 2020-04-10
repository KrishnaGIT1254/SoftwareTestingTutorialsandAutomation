package com.STTA.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CheckBoxRadioButtonOperations_006 extends BaseClass{
	
	@Test
	public void cbAndRbTest() throws IOException
	{
		     //Application Launch
		       String url = "http://toolsqa.com/automation-practice-form";
		       driver.get(url);
		       logger.info("Application URL is Launched");
		
		       //Title of the Webpage
				String Title = driver.getTitle();
				System.out.println("The Title of the page is " +Title);
				logger.info("The title of the page is stored");
				
				// Storing Title length in the Int variable 
				int titleLength = driver.getTitle().length();
				System.out.println("The title length is " +titleLength);
				logger.info("The title length is stored");
				
				//current URL of the page
				String curl = driver.getCurrentUrl();
			    System.out.println("This is the Page Current URL: "+curl);
			    logger.info("we got Current page URL");
			    
			  //current page source
			    String ps = driver.getPageSource();
			    System.out.println("The current page source is "+ps);
			    logger.info("The page source is stored");
			    
			 // Storing Page Source length in Int variable 
			    int psLength = driver.getPageSource().length();
			    System.out.println("The Page source length is "+psLength);
			    logger.info("The title of the page source is stored");
			    
			    
			   // Step 3 : Select the deselected Radio button (female) for category Sex (Use IsSelected method)
			    // Storing all the elements under category 'Sex' in the list of WebLements 
			    List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));
			    logger.info("Stored all the elements under category 'Sex' in the list of WebLements");
			    
			    
			    // Create a boolean variable which will hold the value (True/False)
			    boolean bValue = false;
			    logger.info("Created a boolean variable which will hold the value (True/False)");
			    
			    // This statement will return True, in case of first Radio button is selected
			    bValue = rdBtn_Sex.get(0).isSelected();
			    logger.info("This statement will return True, in case of first Radio button is selected");
			    
			    // This will check that if the bValue is True means if the first radio button is selected
			    if(bValue == true){
			    // This will select Second radio button, if the first radio button is selected by default
			    rdBtn_Sex.get(1).click();
			    }else{
			    // If the first radio button is not selected by default, the first will be selected
			    rdBtn_Sex.get(0).click();
			    }
			    
			    logger.info("Selected the deselected Radio button (female) for category Sex (Use IsSelected method)");
			    
			    //Step 4: Select the Third radio button for category 'Years of Exp' (Use Id attribute to select Radio button)
			    WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
			    rdBtn_Exp.click();
			    logger.info("Selected the Third radio button for category 'Years of Exp' (Use Id attribute to select Radio button)");
			    
			    // STep 5: Check the Check Box 'Automation Tester' for category 'Profession'( Use Value attribute to match the selection)
			    // Find the Check Box or radio button element by Name
			    List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));
			    
			    // This will tell you the number of Check Boxes are present
			    int iSize = chkBx_Profession.size();
			    
			    // Start the loop from first Check Box to last Check Boxe
			    for(int i=0; i < iSize ; i++ ){
			    // Store the Check Box name to the string variable, using 'Value' attribute
			    String sValue = chkBx_Profession.get(i).getAttribute("value");
			    
			    // Select the Check Box it the value of the Check Box is same what you are looking for
			    if (sValue.equalsIgnoreCase("Automation Tester")){
			    chkBx_Profession.get(i).click();
			    // This will take the execution out of for loop
			    break;
			    }
			    }
			    logger.info("Checked the Check Box 'Automation Tester' for category 'Profession'( Use Value attribute to match the selection)");
			    
			    // Step 6: Check the Check Box 'Selenium IDE' for category 'Automation Tool' (Use cssSelector)
			    WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
			    oCheckBox.click();
			    logger.info("Checked the Check Box 'Selenium IDE' for category 'Automation Tool' (Use cssSelector)");
			    
			    
			    if(driver.getTitle().equals("Demo Form for practicing Selenium Automation"))
				{
					Assert.assertTrue(true);
					logger.info("cbAndRbTest Test Passed");
				}
				else
				{
					captureScreen(driver,"cbAndRbTest");
					Assert.assertTrue(false);
					logger.info("cbAndRbTest Test failed");
				} 
		        
			   
	}

}
