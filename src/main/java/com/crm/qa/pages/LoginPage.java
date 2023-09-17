package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.TestBase;

public class LoginPage extends TestBase {

	// for old website
//	@FindBy(xpath = "//input[@placeholder='Username']")
//	WebElement emailid;

	@FindBy(name = "username")
	WebElement username;

//	@FindBy(xpath = "//input[@placeholder='Password']")
//	WebElement password;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;

	@FindBy(xpath = "//img[@alt='Free CRM Software for customer relationship management, sales and support']")
	WebElement crmLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage Login(String un, String pass) {
		username.sendKeys(un);
		Password.sendKeys(pass);
		LoginBtn.click();

		return new HomePage();

	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public String validateCRMTitle() {
		return driver.getTitle();
	}

}
