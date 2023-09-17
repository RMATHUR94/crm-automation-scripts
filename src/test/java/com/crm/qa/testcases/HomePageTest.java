package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	Testutil testutil;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}
	// Test cases should be separated -- independent with each other
	// before each test case launch the browser and login
	// @test -- execute test case
	// after each testcase close the browser

	@BeforeMethod
	public void setUp() {
		initialzation();
		homepage = new HomePage();
		testutil = new Testutil();
		contactPage = new ContactsPage();
		loginpage = new LoginPage();
		
		homepage = 	loginpage.Login(prop.getProperty("username2"),prop.getProperty("password"));
	}

	@Test(priority =1)
	public void verifyHomePageTitleTest() {
		String hometitle = homepage.verifyHomePagetitle();
		Assert.assertEquals(hometitle, "CRMPRO", "title doesnot match");
	}
    
	@Test(priority =2)
	public void verifyUserNameTest() {
		testutil.switchToFrame();
		boolean flag = homepage.verifyUserName();
		Assert.assertTrue(flag);
	}
    
	@Test(priority = 3)
	public void verifyCOntactsLinkTest() {
		testutil.switchToFrame();
		contactPage = homepage.clickOnContactPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
