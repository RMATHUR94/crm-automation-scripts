package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Rahul Mathur')]")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TaskLink;
	
	@FindBy(xpath = "//a[normalize-space()='New Contact']")
	WebElement NewContactsLink;
	
	//initializing the page object

	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePagetitle()
	{
	 	String title = driver.getTitle();
	 	return title;
	}
	
	public boolean verifyUserName()
	{
		boolean flag = usernameLabel.isDisplayed();
		return flag;
	}
	
	public ContactsPage clickOnContactPage()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsPage()
	{
		DealsLink.click();
		return new DealsPage();
	}
	public TaskPage clickOnTaskLink()
	{
		TaskLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactsLink()
	{

		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();

		NewContactsLink.click();	
	}
}
