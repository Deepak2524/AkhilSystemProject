package com.aspl.src.CommonPages;

import java.awt.print.Printable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aspl.src.base.TestBase;

public class LoginPage extends TestBase{

	private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());
	@FindBy(id="txtUserID")
	WebElement username;
	@FindBy(id="txtPassword")
	WebElement password;
	@FindBy(xpath="//input[@id='btnLogin']")
	WebElement loginbtn;
	@FindBy(xpath="//div[@id='logo_Akhil']//img")
	WebElement cmpylogo;
	@FindBy(xpath="//span[@id='RAD_SLIDING_PANE_TEXT_ctl00_rsp1']")
	WebElement mainmenu;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCmpyLogo() {
		return cmpylogo.isDisplayed();
	}
	public ASPLHomePage login() {
		highLightElement(driver, username);
		username.sendKeys(prop.getProperty("username"));
		logger.info("Following User Name has been taken from Properties Files:"+prop.getProperty("username"));
		highLightElement(driver, password);
		password.sendKeys(prop.getProperty("password"));
		highLightElement(driver, loginbtn);
		clickElementByJS(driver, loginbtn);
		return new ASPLHomePage();
	}
	public void clickOnMainMenu() {
		mainmenu.click();
		System.out.println("click on Main Menu");
	}
	
}


