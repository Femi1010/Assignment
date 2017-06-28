package com.Opengov;

import java.util.concurrent.TimeUnit;
import org.junit.After;
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
		System.setProperty("webdriver.chrome.driver", "/Users/femi/Documents/workspace/femina/driver/chromedriver");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1650, 1680));
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void test() 
	{
		System.out.println("hello");
		Homepage homepage=new Homepage(driver);
		CareersPage careerspage=homepage.open(url).clickCompanyMenu().clickCareer();
		
	}

}
