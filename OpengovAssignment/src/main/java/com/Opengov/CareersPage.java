package com.Opengov;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CareersPage extends BasePageObject
{
	@FindBy(xpath="//span[@class='btn__hd']")
	WebElement viewopenposition;
	@FindBy(name="department")
	WebElement team;
	@FindBy(name="location")
	WebElement location;
	//@FindAll({@FindBy(xpath = "//ul[@class='boxTriggerList']")})
	@FindAll({@FindBy(xpath = "//span[@class='boxTriggerList__hdg']")})
	List<WebElement> searchresult;
	private static int count=0;
	public static String testdate;
	private static String currentcity;

	public CareersPage(WebDriver aDriver)
	{
		super(aDriver);
	}
	public  CareersPage clickViewOpenPosition()
	{
		clickElement(viewopenposition);
		return PageFactory.initElements(driver, CareersPage.class);
	}
	public CareersPage careerSearch()
	{
		Select selectteam=new Select(team);
		selectteam.selectByVisibleText("Engineering");
		Select selectcity=new Select(location);
		selectcity.selectByVisibleText("Redwood City");
		WebElement currentsearchcity = selectcity.getFirstSelectedOption();
		count=searchresult.size();
	
		System.out.println("Toatl result count"+count);

		currentcity=currentsearchcity.getText();
	
		
		//Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
						 
		//get current date time with Date()
		Date date = new Date();
						 
		// Now format the date
		 testdate= dateFormat.format(date); 
		System.out.println("On testing************ "+testdate);
		// Print the Date  on June 27 we have 7 open position in Redwood City.
		System.out.println("On "+testdate+" We have "+count+" Open Position in "+currentcity);
		return PageFactory.initElements(driver, CareersPage.class);
		
	}
	public CareersPage writingDocFile() throws FileNotFoundException
	{
		System.out.println("On testing "+testdate);
		File writeFile=new File("/Users/femi/Documents/currentopening.txt");
		PrintWriter pw=new PrintWriter(writeFile);
		pw.println("On "+this.testdate+" We have "+this.count+" Open Position in "+this.currentcity);
		pw.close();
		return PageFactory.initElements(driver, CareersPage.class);
	}
	

}
