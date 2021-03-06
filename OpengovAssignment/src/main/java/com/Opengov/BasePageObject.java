package com.Opengov;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject
{
	protected static WebDriver driver;
	
	//Super class constructor
	public BasePageObject(WebDriver aDriver)
	{
		driver=aDriver;
		driver.manage().window().maximize();
	     
	}
	
	//Explicit wait function
	protected void clickElement(WebElement e)
	{
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(e)).click();
	}

}
