package com.aspl.test.website.Registration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aspl.src.CommonPages.ASPLHomePage;
import com.aspl.src.CommonPages.LoginPage;
import com.aspl.src.RegistrationPage.RegistrationPage;
import com.aspl.src.base.TestBase;

public class RegistrationPageTest extends TestBase {

	LoginPage loginpage;
	ASPLHomePage homepage;
	RegistrationPage registrationPage;
	
	public RegistrationPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		registrationPage=new RegistrationPage();
	}
	@Test
	public void registrationMethod() throws InterruptedException {
		loginpage.validateLoginPageTitle();
		loginpage.validateCmpyLogo();
		homepage=loginpage.login();
		loginpage.clickOnMainMenu();
		loginpage.clickonModuleAndClickonOption("Registration");
		registrationPage.selectTitleFromTitleDropDown("Mr.");
		registrationPage.enterFirstName("Demo2");
		registrationPage.enterMiddleName("User");
		registrationPage.enterLastName("ABC");
		registrationPage.selectGenderFromGenderDropDown();
		registrationPage.enterDob("01/02/1997");
		Thread.sleep(2000);
		//registrationPage.enterAge("23", "03"," 04");
		registrationPage.enterLegalGuardianName("TestGuardian");
		Thread.sleep(2000);
		registrationPage.enterMotherNameInTextBox("TestingMother");
		registrationPage.enterFatherNameInTextBox("TestingFather");
		registrationPage.enterMobileNumber("1234");
		registrationPage.selectSaveButton();
		registrationPage.verifyInvalidMobileNoAlertMessage("Mandatory field details !!!");
		registrationPage.enterMobileNumber("1111111111");
		registrationPage.enterAddressInTextBox("Testing Address");
		registrationPage.selectCountryFromDropDown("INDIA");
		registrationPage.selectStateFromDropDown("ASSAM");
		Thread.sleep(3000);
		registrationPage.selectDistrictORCityFromDropDown("AHOPA");
		registrationPage.selectAreaFromDropDown("AHOPA");
		Thread.sleep(3000);
		//registrationPage.enterPinCodeInTextBox("782120");
		registrationPage.enterEmailInTextBox("test@gmail.com");
		//registrationPage.selectNationalityFromDropDown("INDIA");
		//registrationPage.selectIdentityTypeFromDropDown("LICENSE NO");
		registrationPage.enterIdentityInTextBox("test1251");
		registrationPage.nameAsGuardianRadioButton();
		registrationPage.selectRelationshipFromDropDown("BROTHER");
		registrationPage.enterContactNoInTextBox("222222222222");
		registrationPage.validateVIPCheckBox();
		registrationPage.vipCheckBoxNarrationInTextBox("TestingMarration");
		registrationPage.selectSaveButton();
		
		
	}
	@Test(priority = 2)
	public void updatePatientDetailMethod() {
		loginpage.validateCmpyLogo();
		homepage=loginpage.login();
		loginpage.clickOnMainMenu();
		loginpage.clickonModuleAndClickonOption("Registration");
		registrationPage.selectNewButton();
		registrationPage.enterUHIDInUhidTextBox();
		registrationPage.enterEditReasonInTextBox("Patient Details Update");
		registrationPage.updatePatientDetailByUpdateButton();
		registrationPage.updateDeatilAlart();
	}
	@Test(priority = 3)
	public void depedentPatientRegistrationMethod() throws InterruptedException {
		loginpage.validateCmpyLogo();
		homepage=loginpage.login();
		loginpage.clickOnMainMenu();
		loginpage.clickonModuleAndClickonOption("Registration");
		registrationPage.selectRegistrationTypeFromDropDown("New");
		Thread.sleep(3000);
		registrationPage.clickOnMotherUHIDLevel();
		//registrationPage.selectPatientFromPatientDetailsGrid();
		registrationPage.enterMotherUHIDInTextBox();
		Thread.sleep(3000);
		registrationPage.selectGenderFromDropDown("Male");
		registrationPage.selectDeleveryTypeFromDropDown("Normal");
		registrationPage.enterDeliveryDateInTextBox("17/02/2021 00:00 AM");
		Thread.sleep(1000);
		registrationPage.enterNewBornBabyWeight("2.6");
		registrationPage.enterNewBornBabyHeight("1");
		registrationPage.selectSaveButton();
	}
	@Test(priority = 4)
	public void updateAlreadyPatientByUHIDLevelClick() throws InterruptedException {
		loginpage.validateCmpyLogo();
		homepage=loginpage.login();
		loginpage.clickOnMainMenu();
		loginpage.clickonModuleAndClickonOption("Registration");
		registrationPage.clickOnUhidLevel();
		driver.switchTo().frame(driver.findElement(By.name("RadWindowForNew")));
		registrationPage.selectPatientFromPatientDetailsGrid();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	    registrationPage.selectCompanyRadioButton();
	    Thread.sleep(3000);
	    registrationPage.selectPayerFromDropDown("AIRPORT AUTHORITY OF INDIA");
	    registrationPage.enterEditReasonInTextBox("Patient Details Update");
		registrationPage.updatePatientDetailByUpdateButton();
		registrationPage.updateDeatilAlart();
	}
}
