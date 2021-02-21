package com.aspl.src.BillingPages;

import java.util.List;

import javax.xml.ws.WebEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.AppenderControlArraySet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.aspl.listners.ResultListener;
import com.aspl.src.base.TestBase;


@Listeners(ResultListener.class)
public class OPBillingPage extends TestBase{

	private static final Logger logger = LogManager.getLogger(OPBillingPage.class.getName());


	@FindBy(id="ctl00_ContentPlaceHolder1_txtRegistrationNo")
	WebElement UHID_TEXT_BOX;
	@FindBy(id="ctl00_ContentPlaceHolder1_btnAddConsultation")
	WebElement GET_CONSULTATIONS_VISIT_BUTTON;
	@FindBy(id="ctl00_ContentPlaceHolder1_ibtnAddInvService")
	WebElement INVESTIGATION_BUTTON;
	@FindBy(id="ctl00_ContentPlaceHolder1_ddlEncounter")
	WebElement VISIT_NO_DROP_DOWN;
	@FindBy(xpath="//div[@class='col-md-8 col-sm-8 col-xs-8 text-right pull-right']//input[@name='ctl00$ContentPlaceHolder1$ibtnSave']")
	WebElement PROCEED_BTN_ON_INVESTIGATION_ORDER;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ddlDepartment']")
	WebElement DEPATMENT_DROP_DWON;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ddlSubDepartment']")
	WebElement SUB_DEPARTMENT_DROP_DOWN;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ddlService']")
	WebElement SERVICE_DROP_DOWN;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_cmdAddtoGrid']")
	WebElement ADD_BUTTON_ON_INVESTIGATION_ORDER;
	@FindBy(xpath="ctl00_ContentPlaceHolder1_divServicelimit")
	WebElement SERVICE_NAME_PROCEED_POP_UP;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnServicelimit']")
	WebElement PROCEED_BUTTON_ON_POP_UP;
	@FindBy(xpath="//div//input[@id='ctl00_ContentPlaceHolder1_ibtnAddSurgeryService']")
	WebElement ADD_SURGERY_BUTTON;
	@FindBy(xpath="//input[@id='btnProceed']")
	WebElement PROCEED_BUTTON_ON_SURGERY_ORDER;	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_gvService_ctl01_ibtnAddDisc']")
	WebElement CLICK_TO_ADD_SERVICE_DISCOUNT_BUTTON;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_gvService_ctl01_ibtnRemoveDisc']")
	WebElement CLICK_TO_REMOVE_SERVICE_DISCOUNT_BUTTON;
	@FindBy(xpath="//input[@id='btnApply']")
	WebElement APPLY_DISCOUNT_BUTTON;
	@FindBy(xpath="//div[@class='col-md-7 col-sm-7 text-center']//span[@id='lblMessage']")
	WebElement ALART_TEXT;
	@FindBy(xpath="//input[@id='ddlAuthorisedBy_Input']")
	WebElement AUTHORISED_BY_DROP_DOWN;
	@FindBy(xpath="//input[@id='txtDiscountPercentage']")
	WebElement DISCUNT_PERCENTAGE_TEXT_BOX;
	@FindBy(xpath="//input[@id='txtDiscountPercentage']")
	WebElement DISCOUNT_PERCENTAGE_TEXT_BOX;
	@FindBy(xpath="//input[@id='txtDiscountAmount']")
	WebElement DISCOUNT_AMOUNT_TEXT_BOX;
	@FindBy(xpath="//textarea[@id='txtNotes']")
	WebElement REASON_DROP_DOWN;
	@FindBy(xpath="//input[@id='gvBillOrderOP_ctl00_ctl02_ctl00_chkCollectionSelectCheckBox']")
	WebElement SERVICE_ALL_CHECK_BOX;
	@FindBy(xpath="//input[@id='btnProceed']")
	WebElement PROCEED_BUTTON;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnSaveConfirm']")
	WebElement SAVE_BUTTON;
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_lbtnSearchPatient']")
	WebElement UHID_LEVEL_CLICK;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlPayParty']")
	WebElement PAYER_TYPE_DROP_DOWN;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_ddlCompany_Input']")
	WebElement PAYER_FROM_DROP_DOWN;
    @FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_lblMessage']")
    WebElement GET_BILL_NO;
    @FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_gvService_ctl01_ibtnAddCopay']")
    WebElement CLICK_TO_ADD_SERVICE_COPAY;
    @FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtcoPayPercentage']")
    WebElement CO_PAYMENT_PERCENTAGE_TEXT_BOX;
    @FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnApply0']")
    WebElement APPLY_CO_PAYMENT_BUTTON;
    @FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_gvBillOrderOP_ctl00_ctl02_ctl00_chkCollectionSelectCheckBox']")
    WebElement MANUAL_CO_PAY_SERVICE_CHECK_BOX;
    @FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnProceed']")
    WebElement PROCEED_BUTTON_ON_MANUAL_CO_PAY;

	public OPBillingPage() {
		PageFactory.initElements(driver, this);
	}
	public void enterUHIDInUhidTextBox() {
		UHID_TEXT_BOX.sendKeys(prop.getProperty("uhid"));
		UHID_TEXT_BOX.sendKeys(Keys.ENTER);
		logger.info("Following UHID has been entered in UHID text box on OP billing screen :"+prop.getProperty("uhid"));
	}
	public void clickOnGetConsultationVisitButton() {
		clickElementByJS(driver, GET_CONSULTATIONS_VISIT_BUTTON);
		logger.info("Get Consultation Visit Button Selected on OP Billing Window");
	}
	public void clickOnInvestigationButton() {
		clickElementByJS(driver, INVESTIGATION_BUTTON);
		logger.info("Invesigation Button Selected on OP Billing Window");
	}
	public void selectVisitNoFromDropDown(String visit) {
		if(VISIT_NO_DROP_DOWN.getText().contains(visit)) {
			Select select=new Select(VISIT_NO_DROP_DOWN);
			select.selectByVisibleText(visit);
			logger.info("Following Visit no has been selected Visit From Drop Down :"+visit);
		}else {
			logger.info("Following Visit No has not been matched");
		}
	}
	public void clickOnProceedButtonOnInvestigationOrder() {
		highLightElement(driver, PROCEED_BTN_ON_INVESTIGATION_ORDER);
		clickElementByJS(driver, PROCEED_BTN_ON_INVESTIGATION_ORDER);
		logger.info("Click On Proceed Buton On Investigation Order Window");

	}
	public void selectDepatmentDropDown(String dept) {

		DEPATMENT_DROP_DWON.click();
		DEPATMENT_DROP_DWON.sendKeys(dept);
		DEPATMENT_DROP_DWON.sendKeys(Keys.ENTER);
		logger.info("Following Deptment Drop down has been selected from drop down:"+dept);
	}
	public void selectSubDepartmentFromDropDown(String subdept) {
		SUB_DEPARTMENT_DROP_DOWN.click();
		SUB_DEPARTMENT_DROP_DOWN.sendKeys(subdept);
		SUB_DEPARTMENT_DROP_DOWN.sendKeys(Keys.ENTER);
		logger.info("Following Sub Deptment Drop down has been selected from drop down:"+subdept);
	}
	public void selectServicesFromDropDown(String services) throws InterruptedException {

		SERVICE_DROP_DOWN.click();
		SERVICE_DROP_DOWN.sendKeys(services);
		List<WebElement> listOfElement = driver.findElements(By.xpath("(//div[@id='ctl00_ContentPlaceHolder1_ddlService_DropDown']//ul//li/..//td)"));
		System.out.println(listOfElement.size());
		for(int i=1;i<=listOfElement.size();i++) {
			String text = driver.findElement(By.xpath("(//div[@id='ctl00_ContentPlaceHolder1_ddlService_DropDown']//ul//li/..//td)["+i+"]")).getText();
			logger.info("Following Services has been selected from drop down:"+text);
			if(text.trim().contains(services)) {
				driver.findElement(By.xpath("(//div[@id='ctl00_ContentPlaceHolder1_ddlService_DropDown']//ul//li/..//td)["+i+"]")).click();
				clickElementByJS(driver, ADD_BUTTON_ON_INVESTIGATION_ORDER);
				logger.info("Add button selected for adding services from drop down");
				clickOnProceedButton();
				Thread.sleep(5000);
				break;
			}
		}

	}
	public  void clickOnProceedButton() {
		if(SERVICE_DROP_DOWN.isDisplayed()) {
			clickElementByJS(driver, PROCEED_BUTTON_ON_POP_UP);
			logger.info("Proceed button click on after selecting the service from drop down");
		}else {
			logger.info("Proceed button not found after selecting the service from drop down");
		}
	}
	public void selectProviderFromSelectedServicesDropDown(String provider1) {
		List<WebElement> tablerows = driver.findElements(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_pnlgvService']//table//tbody//tr"));
		int tablesize = tablerows.size();
		System.out.println("Total Selected services count"+tablesize);
		for(int i=1;i<tablesize;i++) {
			WebElement provider = driver.findElement(By.xpath("(//div[@id='ctl00_ContentPlaceHolder1_pnlgvService']//table//tbody//tr)[4]//td[6]//div//table//following::td//input[@name='ctl00$ContentPlaceHolder1$gvService$ctl04$ddlDoctor']"));
			if(provider.isEnabled()) {
				try {
					provider.click();
					provider.sendKeys(provider1);
					logger.info("Following provider has been selected from Drop Down Against Services:" +provider1);
					break;
				}catch (Exception e) {
					// TODO: handle exception

				}
			}
		}

	}
	public void selectAddSurgeryButton() {
		clickElementByJS(driver, ADD_SURGERY_BUTTON);

		logger.info("Select Add surgery Button On Billing Screen");
	}
	public void selectProceedButtonOnSurgeryOrder() {
		clickElementByJS(driver, PROCEED_BUTTON_ON_SURGERY_ORDER);
		logger.info("Click on Srugery Order Proceed Button");
	}
	public void selectClickTORemoveDiscountButton() {
		clickElementByJS(driver, CLICK_TO_REMOVE_SERVICE_DISCOUNT_BUTTON);
		logger.info("Click on ClicK to Remove Service Discount Button On Billing Screen");
	}
	public void selectClickToAddDiscountButton() {
		clickElementByJS(driver, CLICK_TO_ADD_SERVICE_DISCOUNT_BUTTON);
		logger.info("Click on ClicK to Add Service Discount Button On Billing Screen");
	}
	public void selectApplyDiscountButtonOnDiscountScreen() {
		clickElementByJS(driver, APPLY_DISCOUNT_BUTTON);
		logger.info("Click On Apply Discount Button On Discount Window");
	}
	public void validatepopuptext() {
		String text = ALART_TEXT.getText();
		logger.info("Display Message Is= "+text);
	}
	public void selectAuthorisedByFromDropDown(String authorised) {
		if(!AUTHORISED_BY_DROP_DOWN.getText().contains(authorised)) 
		{
			try {
				AUTHORISED_BY_DROP_DOWN.click();
				AUTHORISED_BY_DROP_DOWN.sendKeys(authorised);
				AUTHORISED_BY_DROP_DOWN.sendKeys(Keys.ENTER);
				//driver.findElement(By.xpath("//div[@class='col-sm-5 col-md-5']//span[@id='Label1']")).click();
				logger.info("Select Authorised By Fom Drop Down on Discount Window :"+authorised);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public void enterDiscountPercentageInTextBox(String per) {
		DISCOUNT_PERCENTAGE_TEXT_BOX.sendKeys(per);
		logger.info("Following Percentage entered in Percentage Text Box :"+per);
	}
	public void enterDiscountAmountInTextBox(String amount) {
		DISCOUNT_AMOUNT_TEXT_BOX.sendKeys(amount);
		logger.info("Following Discount Amount entered in Discount Amount Text Box :"+amount);
	}
	public void selectReasonFromDropDown(String reason) {
		REASON_DROP_DOWN.sendKeys(reason);
		logger.info("Following Reason entered in Reason Text Box :"+reason);
	}
	public void selectAllServiceCheckBox() {
		clickElementByJS(driver, SERVICE_ALL_CHECK_BOX);
		logger.info("Service All check box Get Checked");

	}
	public void selectProceedButton() {
		clickElementByJS(driver, PROCEED_BUTTON);
		logger.info("Select Proceed Button on Discount window");
	}
	public void selectSaveButton() {
		clickElementByJS(driver, SAVE_BUTTON);
		logger.info("Select the save button on Billing window");
	}
	public void clickOnUhidLevel() {
		clickElementByJS(driver, UHID_LEVEL_CLICK);
		logger.info("Click On UHID level On billing Wndow ");
	}
	public void selectPayerTypeFromDropDown(String payertype) {
		Select select=new Select(PAYER_TYPE_DROP_DOWN);
		select.selectByVisibleText(payertype);
		logger.info("Following Payer Type has been selected from Type Drop Down :"+payertype);
	}
	public void selectPayerFromDropDown(String payer) {
		PAYER_FROM_DROP_DOWN.click();
		PAYER_FROM_DROP_DOWN.clear();
		PAYER_FROM_DROP_DOWN.sendKeys(payer);
		PAYER_FROM_DROP_DOWN.sendKeys(Keys.ENTER);
		logger.info("Following Payer has been selected from Payer Drop Down :"+payer);
	}
	public void getBillNoAfterSavedTheBill() {
		String text = GET_BILL_NO.getText();
		logger.info("After Save The details Bill No is :"+text);
	}
	public void clickToAddServiceCoPayIcon() {
		clickElementByJS(driver, CLICK_TO_ADD_SERVICE_COPAY);
		logger.info("Select Click To Add Service Co-Pay Icon On Billing Window");
	}
	public void enterCoPaymentInTextBox(String copercentage) {
		CO_PAYMENT_PERCENTAGE_TEXT_BOX.clear();
		CO_PAYMENT_PERCENTAGE_TEXT_BOX.sendKeys(copercentage);
		logger.info("Following Co-Payment Percentage entered in Percentage Text Box :"+copercentage);
	}
	public void selectApplyCoPaymentButton() {
		clickElementByJS(driver, APPLY_CO_PAYMENT_BUTTON);
		logger.info("Select Apply Co-Payment Button On Manual Co-Payment Window");
	}
	public void selectAllServiceCheckBoxOnCoPayment() {
		clickElementByJS(driver, MANUAL_CO_PAY_SERVICE_CHECK_BOX);
		logger.info("Select All Service Check Box On Manual Co-Payment Window");
	}
	public void selectProceedButtonOnCoPaymentScreen() {
		clickElementByJS(driver, PROCEED_BUTTON_ON_MANUAL_CO_PAY);
		logger.info("Select Proceed Button On Manual Co-Payment Window");
	}
}
