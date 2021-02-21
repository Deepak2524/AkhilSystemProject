package com.aspl.test.website.OPBilling;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriverService;
import com.aspl.listners.ResultListener;
import com.aspl.src.BillingPages.OPBillingPage;
import com.aspl.src.CommonPages.ASPLHomePage;
import com.aspl.src.CommonPages.LoginPage;
import com.aspl.src.RegistrationPage.RegistrationPage;
import com.aspl.src.base.TestBase;

@Listeners(ResultListener.class)
public class OPBillingPageTest extends TestBase {
	private static final Logger logger = LogManager.getLogger(OPBillingPageTest.class.getName());

	LoginPage loginpage;
	ASPLHomePage homepage;
	RegistrationPage registrationPage;
	OPBillingPage opbilling;

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		homepage=new ASPLHomePage();
		registrationPage=new RegistrationPage();
		opbilling=new OPBillingPage();
	}
	@Test
	public void OPBillingTestMethod() throws InterruptedException {
		loginpage.validateLoginPageTitle();
		loginpage.validateCmpyLogo();
		homepage=loginpage.login();
		loginpage.clickOnMainMenu();
		loginpage.clickonModuleAndClickonOption("Billing");
		loginpage.clickOnMainMenu();
		homepage.billingModuleMenuOPtion("OP Billing");
		opbilling.enterUHIDInUhidTextBox();
		Thread.sleep(5000);
		homepage.alartMsgWindow();
		opbilling.selectVisitNoFromDropDown("New Visit");
		opbilling.clickOnInvestigationButton();
		driver.switchTo().frame(driver.findElement(By.name("RadWindow1")));
		opbilling.selectServicesFromDropDown("24 HRS URINE COPPER");
		opbilling.selectServicesFromDropDown("3-D CT FACIAL BONE");
		opbilling.selectServicesFromDropDown("CBC");
		opbilling.selectProviderFromSelectedServicesDropDown("AMIT PATIL");
        opbilling.clickOnProceedButtonOnInvestigationOrder();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        opbilling.clickOnGetConsultationVisitButton();
        Thread.sleep(3000);
        opbilling.selectClickTORemoveDiscountButton();
        opbilling.selectClickToAddDiscountButton();
        driver.switchTo().frame(driver.findElement(By.name("RadWindow1")));
        opbilling.selectApplyDiscountButtonOnDiscountScreen();
        opbilling.validatepopuptext();
        opbilling.selectAuthorisedByFromDropDown("Admin (1)");
        Thread.sleep(2000);
        opbilling.enterDiscountPercentageInTextBox("13");
        homepage.alartMsgWindow();
        opbilling.selectReasonFromDropDown("By doctor Order");
        opbilling.selectAllServiceCheckBox();
        opbilling.selectApplyDiscountButtonOnDiscountScreen();
        Thread.sleep(2000);
        opbilling.selectProceedButton();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        opbilling.selectSaveButton();
        opbilling.getBillNoAfterSavedTheBill();
        
      }
	
	@Test(priority = 2)
	public void MakeBillWithSearchPatientUhid() throws InterruptedException {
		loginpage.validateLoginPageTitle();
		loginpage.validateCmpyLogo();
		homepage=loginpage.login();
		loginpage.clickOnMainMenu();
		loginpage.clickonModuleAndClickonOption("Billing");
		loginpage.clickOnMainMenu();
		homepage.billingModuleMenuOPtion("OP Billing");
		opbilling.clickOnUhidLevel();
		driver.switchTo().frame(driver.findElement(By.name("RadWindow1")));
		registrationPage.selectPatientFromPatientDetailsGrid();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		homepage.alartMsgWindow();
		opbilling.selectPayerTypeFromDropDown("Company");
		Thread.sleep(5000);
		opbilling.selectPayerFromDropDown("AIRPORTS  AUTHORITY OF INDIA");
		opbilling.clickOnInvestigationButton();
		driver.switchTo().frame(driver.findElement(By.name("RadWindow1")));
		opbilling.selectServicesFromDropDown("24 HRS URINE COPPER");
		opbilling.selectServicesFromDropDown("3-D CT FACIAL BONE");
		//opbilling.selectServicesFromDropDown("CBC");
		//opbilling.selectProviderFromSelectedServicesDropDown("AMIT PATIL");
        opbilling.clickOnProceedButtonOnInvestigationOrder();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        opbilling.clickOnGetConsultationVisitButton();
        Thread.sleep(3000);
        opbilling.clickToAddServiceCoPayIcon();
        driver.switchTo().frame(driver.findElement(By.name("RadWindow1")));
        opbilling.enterCoPaymentInTextBox("5435");
        opbilling.selectApplyCoPaymentButton();
        Thread.sleep(2000);
        homepage.alartMsgWindow();
        opbilling.enterCoPaymentInTextBox("12");
        opbilling.selectAllServiceCheckBoxOnCoPayment();
        opbilling.selectApplyCoPaymentButton();
        opbilling.selectProceedButtonOnCoPaymentScreen();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        opbilling.selectSaveButton();
        opbilling.getBillNoAfterSavedTheBill();
        
	}
}



