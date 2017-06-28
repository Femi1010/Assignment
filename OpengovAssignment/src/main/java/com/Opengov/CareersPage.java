package com.Opengov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BasePageObject
{
	@FindBy(xpath="//span[@class='btn__hd']")
	WebElement viewopenposition;

	public CareersPage(WebDriver aDriver)
	{
		super(aDriver);
	}
	public void GetMessage()
	{
		System.out.println("hello");
		
	}
	

}
