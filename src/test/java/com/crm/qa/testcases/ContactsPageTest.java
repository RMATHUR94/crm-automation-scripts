package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	Testutil testutil;
	ContactsPage contactPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialzation();
		homepage = new HomePage();
		testutil = new Testutil();
		contactPage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = 	loginpage.Login(prop.getProperty("username2"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactPage = homepage.clickOnContactPage();
	}
	
	@Test(priority =1)
	public void verifyContactsPageLabel()
	{
		boolean flag = contactPage.vefifyContactsLabel();
		Assert.assertTrue(flag,"contacts lebel is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCrmTestData()
	{
		Object data[][] = Testutil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 2,dataProvider="getCrmTestData")
	public void validateCreateNewContact(String title,String firstname,String lastname,String company)
	{
		homepage.clickOnNewContactsLink();
		//contactPage.createNewContact("Mr.","peter","Gomez","Google");
		contactPage.createNewContact(title, firstname, company, lastname);
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
