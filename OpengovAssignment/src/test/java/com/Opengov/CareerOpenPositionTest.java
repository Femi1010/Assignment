package com.Opengov;

import java.io.FileNotFoundException;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CareerOpenPositionTest
{
	private WebDriver driver;
	private String url="https://opengov.com/";
	

	@Before
	public void setUp() throws Exception 
	{
		//Initializing driver,implicite wait and maximizing the window
		System.setProperty("webdriver.chrome.driver", "/Users/femi/Documents/workspace/femina/driver/chromedriver");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 1680));
        
	}

	
	@After
	public void tearDown() throws Exception 
	{
		//Closing the window
		driver.quit();
	}

	@Test
	public void test() throws FileNotFoundException 
	{
		//creating homepage object and passing the driver
		Homepage homepage=new Homepage(driver);
		//finding the availability of career opening position
		CareersPage careerspage=homepage.open(url)
										.clickCompanyMenu()
										.clickCareer()
										.clickViewOpenPosition()
										.careerSearch();
		
		// asserting  each test result with expected value "RedwoodCity"
		for (int i = 0; i < careerspage.searchresult.size(); i++) 
		{
		   try
			{
				//Asserting actual result with expected Result
				Assert.assertEquals(careerspage.getcity(), careerspage.verifylocation.get(i).getText().toString());
			}
			catch(Exception e)
			{
				//Exception Handles when it shows mismatch between actual result 'Redwood City' and expected result
				e.printStackTrace();
				Assert.fail("Search Location mismatch");
				
			}
		   
			   try
			   {
				   //Asserting the career position title 
				   Assert.assertTrue(careerspage.searchresult.get(i).isDisplayed());
			   }catch(Exception e)
			   {
				   //Exception Handles when it shows mismatch between actual result 'Redwood City' and expected result
				   e.printStackTrace();
				   Assert.fail("Job Title is missing");
				
			   }
		   
		}
	
	}

}


