package com.aspl.src.RegistrationPage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aspl.src.base.TestBase;


public class RegistrationPage extends TestBase {
	private static final Logger logger = LogManager.getLogger(RegistrationPage.class.getName());

	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_dropTitle_Input']")
	WebElement TITLE_DROP_DOWN;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtFname']")
	WebElement FIRST_NAME;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtMName']")
	WebElement MIDDLE_NAME;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtLame']")
	WebElement LAST_NAME;
	@FindBy(id="ctl00_ContentPlaceHolder1_dropSex_Input")
	WebElement GENDER_DROP_DOWN;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_dtpDateOfBirth_dateInput']")
	WebElement DOB;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtYear']")
	WebElement AGE_YEAR_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtMonth")
	WebElement AGE_MONTH_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtDays")
	WebElement AGE_DATE_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtParentof")
	WebElement LEGAL_GUARDIAN;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtMothername")
	WebElement MOTHER_NAME;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtFatherName")
	WebElement FATHER_NAME;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPMobile")
	WebElement MOBILE_NUMBER;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtLAddress1")
	WebElement ADDRESS_TEXT_BOX;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$dropLCountry']")
	WebElement COUNTRY_DROP_DWN;
	@FindBy(id="ctl00_ContentPlaceHolder1_dropLState_Input")
	WebElement STATE_DROP_DWN;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$dropLCity']")
	WebElement DISTRICT_CITY;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ddlCityArea']")
	WebElement AREA_DROP_DOWN;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtLPin")
	WebElement PIN_CODE_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtPEmailID")
	WebElement EMAIL_ID_BOX;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$dropNationality']")
	WebElement NATIONALITY_DROP_DOWN;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$dropIdentityType']")
	WebElement IDENTITY_TYPE;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtIdentityNumber")
	WebElement IDENTITY_TEXT_BOX;
	@FindBy(xpath="//h2[text()='Mandatory field details !!!']")
	WebElement MANDATORY_FIELD_DETAILS;
	@FindBy(id="ctl00_ContentPlaceHolder1_rdoGuardian_0")
	WebElement NAME_AS_GUARDIAN_YES_RADIO_BTN;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlRelation_Input")
	WebElement NAME_AS_GUARDIAN_RELATIONSHIP;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtEmergencyContactNo")
	WebElement NAME_AS_GUARDIAN_CONTACT_NO;
	@FindBy(id="ctl00_ContentPlaceHolder1_chkVIP")
	WebElement VIP_CHECK_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtVIPNarration")
	WebElement NARRATION_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement MAIN_SAVE_BUTTON;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtAccountNo']")
	WebElement UHID_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnNew")
	WebElement NEW_BUTTON;
	@FindBy(id="ctl00_ContentPlaceHolder1_txteditreason")
	WebElement EDIT_REASON_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnSave")
	WebElement UPDATE_BUTTON;
	@FindBy(id="ctl00_ContentPlaceHolder1_lblMessage")
	WebElement UPDATED_TEXT_MSG;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_ddlRegistrationType_Input']")
	WebElement REGISTRATION_TYPE_DROP_DOWN;
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_lbtnSearchPatient']")
	WebElement UHID_LEVEL_CLICK;
	@FindBy(xpath="//a[text()='Mother UHID']")
	WebElement MOTHER_UHID_LEVEL_CLICK;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtMothergNo']")
	WebElement MOTHER_UHID_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlDeliveryType_Input")
    WebElement DELIVERY_TYPE;
	@FindBy(id="ctl00_ContentPlaceHolder1_dtpDeliveryDateTime_dateInput")
	WebElement DELIVERY_DATE;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtWeight")
	WebElement NEW_BORN_BABY_WEIGHT;
	@FindBy(id="ctl00_ContentPlaceHolder1_txtHeight")
	WebElement NEW_BORN_BABY_HEIGHT;
    
    
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	public void selectTitleFromTitleDropDown(String title) 
	{
		//driver.waitForElementPresent(TITLE_DROP_DOWN);
		try {
			Select titleDropDown=new Select(TITLE_DROP_DOWN);
			titleDropDown.selectByVisibleText(title);
		}
		catch (Exception e) {


		}
		//logger.info("Following Title has been selected from Title Dropdown : " + title);
	}
	public void enterFirstName(String firstName) {
		FIRST_NAME.sendKeys(firstName);
		//logger.info("First Name has been added as : " +  firstName);

	}
	public void enterMiddleName(String middleName) {

		MIDDLE_NAME.sendKeys(middleName);
		//logger.info("Middle Name has been added as : " +  middleName);

	}
	public void enterLastName(String lastName) {
		LAST_NAME.sendKeys(lastName);
		//logger.info("Last Name has been added as : " +  lastName);

	}
	public void selectGenderFromGenderDropDown() {
		String value=GENDER_DROP_DOWN.getAttribute("value");
		System.out.println("Value of value Attribute:"+value);
	}
	public void selectGenderFromDropDown(String gender) {
		GENDER_DROP_DOWN.sendKeys(gender);
	}
	public void enterDob(String dob) {
		DOB.sendKeys(dob);
		//DOB.click();
		clickAnyWhereOnScreen();
		//DOB.clear();
		//logger.info("Following DOB has been added : " + dob);
	}
	public void enterAge(String year,String month,String date) {
		AGE_YEAR_TEXT_BOX.clear();
		AGE_MONTH_TEXT_BOX.clear();
		AGE_DATE_TEXT_BOX.clear();
		AGE_YEAR_TEXT_BOX.sendKeys(year);
		AGE_MONTH_TEXT_BOX.sendKeys(month);
		AGE_DATE_TEXT_BOX.sendKeys(date);
		//logger.info("Year:"+year+"Month:"+month+"DATE:"+date);
	}
	public void enterLegalGuardianName(String guardian) {
		LEGAL_GUARDIAN.sendKeys(guardian);
		//logger.info("Legal Guardian Name:"+guardian);
	}
	public void enterMotherNameInTextBox(String mothername) {
		MOTHER_NAME.sendKeys(mothername);
		//logger.info("Mother Name is :"+mothername);
	}
	public void enterFatherNameInTextBox(String fathername) {
		FATHER_NAME.clear();
		FATHER_NAME.sendKeys(fathername);
		//logger.info("Father Name is :"+fathername);
	}
	public void enterMobileNumber(String mobile) {
		MOBILE_NUMBER.sendKeys(mobile);
		//logger.info("Following MOBILE NO has been added : " + mobile);
	}
	public boolean verifyInvalidMobileNoAlertMessage(String message) throws InterruptedException{

		if(driver.findElements(By.xpath("//h2[text()='Mandatory field details !!!']")).size()>0) 
		{
			if(driver.findElement(By.xpath("//h2[text()='Mandatory field details !!!']")).getText().contains(message))
			{
				driver.findElement(By.xpath("//a[text()='Close  ']")).click();
				//logger.info("Alert SHowing up when adding Invalid Message");
				return true;
			}
			else{
				return false;
			}
		}
		return true; 

	}
	public void enterAddressInTextBox(String address) {
		ADDRESS_TEXT_BOX.clear();
		ADDRESS_TEXT_BOX.sendKeys(address);
		//logger.info("Enter Pateint Address :"+address);

	}
	public void selectCountryFromDropDown(String country) {
		COUNTRY_DROP_DWN.clear();
		COUNTRY_DROP_DWN.sendKeys(country);
		clickAnyWhereOnScreen();
		//logger.info("Following Country has been selected from Country  Dropdown :"+country);
	}
	public void selectStateFromDropDown(String state) {
		STATE_DROP_DWN.clear();
		STATE_DROP_DWN.sendKeys(state);
		clickAnyWhereOnScreen();
		//logger.info("Following State has been selected from State Dropdown :"+state);
	}
	public void selectDistrictORCityFromDropDown(String city) throws InterruptedException {
		DISTRICT_CITY.click();
		DISTRICT_CITY.clear();
		Thread.sleep(1000);
		DISTRICT_CITY.sendKeys(city);
		clickAnyWhereOnScreen();

		//logger.info("Following City has been selected from City Dropdown :"+city);
	}
	public void selectAreaFromDropDown(String area) {
		AREA_DROP_DOWN.click();
		AREA_DROP_DOWN.clear();
		AREA_DROP_DOWN.sendKeys(area);
		clickAnyWhereOnScreen();
		//Select select=new Select(AREA_DROP_DOWN);
		//select.selectByVisibleText(area);
		//logger.info("Following Area has been selected from Area Dropdown :"+area);
	}
	public void enterPinCodeInTextBox(String pinCode) {
		PIN_CODE_TEXT_BOX.clear();
		PIN_CODE_TEXT_BOX.sendKeys(pinCode);
		//logger.info("Following PinCode has been entered in PinCode TextBox :"+pinCode);
	}
	public void enterEmailInTextBox(String email) {
		EMAIL_ID_BOX.sendKeys(email);
		//logger.info("Following Email has been entered in Email TextBox :"+email);
	}
	public void selectNationalityFromDropDown(String nationality) {
		NATIONALITY_DROP_DOWN.click();
		NATIONALITY_DROP_DOWN.clear();
		NATIONALITY_DROP_DOWN.sendKeys(nationality);
		clickAnyWhereOnScreen();

		//logger.info("Following Nationality has been selected from Nationality Dropdown : " + nationality);
	}
	public void selectIdentityTypeFromDropDown(String idcard) {
		IDENTITY_TYPE.click();
		Select titleDropDown = new Select(IDENTITY_TYPE);
		titleDropDown.selectByVisibleText(idcard);
		//logger.info("Following ID Card has been selected from ID Card Dropdown : " + idcard);
	}
	public void enterIdentityInTextBox(String identity) {
		IDENTITY_TEXT_BOX.sendKeys(identity);
		//logger.info("Following Identity has been entered in Identity TextBox :"+identity);
	}
	public void nameAsGuardianRadioButton() {
		if(!NAME_AS_GUARDIAN_YES_RADIO_BTN.isSelected()) {
			NAME_AS_GUARDIAN_YES_RADIO_BTN.click();
			//logger.info("Following Name As Guardian check box has been selected")
		}else {
			//logger.info("Following Name As Guardian check box has not been selected")
		}
	}
	public void selectRelationshipFromDropDown(String relationship) {
		NAME_AS_GUARDIAN_RELATIONSHIP.click();
		NAME_AS_GUARDIAN_RELATIONSHIP.sendKeys(relationship);
		clickAnyWhereOnScreen();
		//Select select=new Select(NAME_AS_GUARDIAN_RELATIONSHIP);
		//select.selectByVisibleText(relationship);
		//logger.info("Following Relationship has been selected from Relationship Dropdown : " + relationship);
	}
	public void enterContactNoInTextBox(String contactNo) {
		NAME_AS_GUARDIAN_CONTACT_NO.sendKeys(contactNo);
		//logger.info("Following Contact No has been entered in Contact No TextBox :"+contactNo);
	}
	public void validateVIPCheckBox() {
		if(!VIP_CHECK_BOX.isSelected()) {
			clickElementByJS(driver, VIP_CHECK_BOX);
			//logger.info("Following VIP check box has been selected after check the Check Box")
		}else {
			//logger.info("Following VIP check box has not been selected")
		}
	}
	public void vipCheckBoxNarrationInTextBox(String narration) {
		NARRATION_TEXT_BOX.sendKeys(narration);
		//logger.info("Following VIP Narration has been entered  after check the Check Box")
	}
	public void selectSaveButton() {
		clickElementByJS(driver,MAIN_SAVE_BUTTON );
		//logger.info("Following Save Button has been selected")
	}
	public void enterUHIDInUhidTextBox() {
		UHID_TEXT_BOX.clear();
		UHID_TEXT_BOX.sendKeys(prop.getProperty("uhid"));
		UHID_TEXT_BOX.sendKeys(Keys.ENTER);
	}
	public void selectNewButton() {
		clickElementByJS(driver, NEW_BUTTON);
	}
	public void enterEditReasonInTextBox(String reason) {
		EDIT_REASON_TEXT_BOX.sendKeys(reason);
		//logger.info(Following Edit Reason Has been entered after Update Patient Details :"+reason);
	}
	public void updatePatientDetailByUpdateButton() {
		clickElementByJS(driver, UPDATE_BUTTON);

	}
	public void updateDeatilAlart() {
		String text=UPDATED_TEXT_MSG.getText();
		System.out.println("text :"+text);
	}
	public void selectRegistrationTypeFromDropDown(String registrationtype) {
		if(!REGISTRATION_TYPE_DROP_DOWN.getText().contains(registrationtype)) {
			REGISTRATION_TYPE_DROP_DOWN.click();
			REGISTRATION_TYPE_DROP_DOWN.sendKeys(registrationtype);
			REGISTRATION_TYPE_DROP_DOWN.sendKeys(Keys.ENTER);

		}else {

			System.out.println("Not matched");
		}

	}
	public void clickOnUhidLevel() {
		clickElementByJS(driver, UHID_LEVEL_CLICK);
	}
	public void clickOnMotherUHIDLevel() {
		clickElementByJS(driver, MOTHER_UHID_LEVEL_CLICK);
	}
	public void selectPatientFromPatientDetailsGrid() {
		try {
			List<WebElement> rowselection = driver.findElements(By.xpath("//div[@id='UpdatePanel1']//table[@id='gvEncounter_ctl00']//tbody//tr"));
			int gridsize = rowselection.size();
			System.out.println("Total Grid Patient rows :"+gridsize);
			for(int i=2;i<=gridsize;i++) {
				if(rowselection.size()>0) {
					String selectedpateintuhid = driver.findElement(By.xpath("(//div[@id='UpdatePanel1']//table[@id='gvEncounter_ctl00']//tbody//tr)["+i+"]//td[2]")).getText();
					logger.info("Following Selected patient UHID After serach from the grid :"+selectedpateintuhid);
					driver.findElement(By.xpath("(//div[@id='UpdatePanel1']//table[@id='gvEncounter_ctl00']//tbody//tr)["+i+"]//td[1]")).click();
					break;
				}else {
					logger.info("No one row present in this Grid ");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enterMotherUHIDInTextBox() {
		MOTHER_UHID_TEXT_BOX.sendKeys(prop.getProperty("motheruhid"));
		MOTHER_UHID_TEXT_BOX.sendKeys(Keys.ENTER);
	}
	public void selectDeleveryTypeFromDropDown(String deliverytype) {
		if(!DELIVERY_TYPE.getText().contains(deliverytype)) {
			//clickElementByJS(driver, DELIVERY_TYPE);
			DELIVERY_TYPE.sendKeys(deliverytype);
		}else {
			System.out.println("Delievry Type not matched ");
		}
	}
    public void enterDeliveryDateInTextBox(String deliverydate) {
    	DELIVERY_DATE.sendKeys(deliverydate);
    	clickAnyWhereOnScreen();
    }
    public void enterNewBornBabyWeight(String weight) {
    	NEW_BORN_BABY_WEIGHT.sendKeys(weight);
    }
	public void enterNewBornBabyHeight(String height) {
		NEW_BORN_BABY_HEIGHT.sendKeys(height);
	}
}
