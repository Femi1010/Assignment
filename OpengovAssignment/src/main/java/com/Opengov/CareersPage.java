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
	//FInding locators
	@FindBy(xpath="//span[@class='btn__hd']")
	WebElement viewopenposition;
	@FindBy(name="department")
	WebElement team;
	@FindBy(name="location")
	WebElement location;
	@FindAll({@FindBy(xpath = "//span[@class='boxTriggerList__hdg']")})
	List<WebElement> searchresult;
	@FindAll({@FindBy(xpath="//span[@class='boxTriggerList__txt']")})
	List<WebElement> verifylocation;
	
	//variable declaration
	private int count=0;
	private String testdate;
	private String currentcity;

	//career page consrtuctor
	public CareersPage(WebDriver aDriver)
	{
		super(aDriver);
	}
	
	//click on View Open Position button
	public  CareersPage clickViewOpenPosition()
	{
		clickElement(viewopenposition);
		return PageFactory.initElements(driver, CareersPage.class);
	}
	
	// career search functionality
	public CareersPage careerSearch() throws FileNotFoundException
	{
		//Choosing the team as Engineering  
		Select selectteam=new Select(team);
		selectteam.selectByVisibleText("Engineering");
		//choosing city as Redwood City
		Select selectcity=new Select(location);
		selectcity.selectByVisibleText("Redwood City");
		WebElement currentsearchcity = selectcity.getFirstSelectedOption();
		//Total count of search result
		count=searchresult.size();
		//System.out.println("Toatl result count"+count);
		//Search city  Redwood city
		currentcity=currentsearchcity.getText();
		//function call for test run time
		testdate=displayTestRunDate();
		//wring the result to text document file
		writingDocFile(testdate,count,currentcity);
		// Print the Date  on June 27 we have 7 open position in Redwood City.
		//System.out.println("On "+testdate+" We have "+count+" Open Position in "+currentcity);
		return PageFactory.initElements(driver, CareersPage.class);
		
	}
	
	
	public String displayTestRunDate()
	{
		//Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
								 
		//get current date time with Date()
		Date date = new Date();
								 
		// format the date
		testdate= dateFormat.format(date); 
		return testdate;			
	}
	
	//adding result to the doc type file
	public void writingDocFile(String cdate,int ccount,String ccurrentcity) throws FileNotFoundException
	{
		// creating textfile called currentopening.txt under location Users/femi/Documents/
		File writeFile=new File("/Users/femi/Documents/currentopening.txt");
		PrintWriter pw=new PrintWriter(writeFile);
		pw.println("On "+cdate+" ,We have "+ccount+" Open Position in "+ccurrentcity);
		pw.close();
	}
	
	//for Asserting  "Redwood City"
	public String getcity()
	{
		Select selectcity=new Select(location);
		WebElement assertcity = selectcity.getFirstSelectedOption();
		return assertcity.getText().toString();
		
	}

}
