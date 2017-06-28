package com.Opengov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage extends BasePageObject
{
	@FindBy(xpath="//span[@class='navPrimary__hd'][contains(text(),'Company')]")
	WebElement company;
	@FindBy(xpath="//span[@class='navList__hd'][contains(text(),'Careers')]")
	WebElement career;
	
	public Homepage(WebDriver aDriver)
	{
		super(aDriver);
		// TODO Auto-generated constructor stub
	}
	public static Homepage open(String url)
	{
		driver.get(url);
		return PageFactory.initElements(driver, Homepage.class);	
	}
	public Homepage clickCompanyMenu()
	{
		clickElement(company);
		return PageFactory.initElements(driver, Homepage.class);
	}
	public CareersPage clickCareer()
	{
		clickElement(career);
		return PageFactory.initElements(driver, CareersPage.class);
	}
	

}
