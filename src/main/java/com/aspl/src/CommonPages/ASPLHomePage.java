package com.aspl.src.CommonPages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.aspl.src.base.TestBase;

public class ASPLHomePage extends TestBase {

	private static final Logger logger=LogManager.getLogger(ASPLHomePage.class.getName());
	String reportpath=System.getProperty("user.dir")+"/extent_report/"+this.getClass().getSimpleName()+"_"+"ExtentReport"+".html";
	
	public ASPLHomePage() {
		PageFactory.initElements(driver, this);
	}
	public void billingModuleMenuOPtion(String option) {
		WebElement options = driver.findElement(By.xpath("//div[@id='ctl00_tvCategory']//table//tbody//tr//a[text()='"+option+"']"));
		highLightElement(driver, options);
		clickElementByJS(driver, options);
		System.out.println("Following Option selection from Billing Menu:"+option);
	}
	public static String getDateTime() {
		String sDateTime = "";
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			String strTime = sdfTime.format(now);
			strTime = strTime.replace(":", "-");
			sDateTime = "D" + strDate + "_T" + strTime;
		} catch (Exception e) {
			System.err.println(e);
		}
		return sDateTime;
	}

	public static String takeSnapShotAndRetPath(String
			methodName) throws Exception {

		String FullSnapShotFilePath = "";

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		String sFilename ="Screenshot-" +methodName+getDateTime() + ".png";
		System.out.println("Screenshotfile name is "+sFilename); 
		FullSnapShotFilePath= System.getProperty("user.dir") +"/output/" + sFilename;
		System.out.println("FullSnapShotFilePath name is "+FullSnapShotFilePath);
		FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));

		return FullSnapShotFilePath; 
	}
	public  void switchWindow(int windownumber) 
	{
		driver.switchTo().window(driver.getWindowHandles().toArray()[windownumber].toString());
	}
	public void alartMsgWindow() {
		Alert alart=driver.switchTo().alert();
		String alertMsg=driver.switchTo().alert().getText();
		logger.info("Alart Message Text is :"+alertMsg);
		alart.accept();
	}
	
	//open new tab in the same window.
	public String openNewTab(){
	       String parentHandle = driver.getWindowHandle();
	        ((JavascriptExecutor)driver).executeScript("window.open()");
	        String currentHandle ="";
	                // below driver is your webdriver object
	        Set<String> win  = driver.getWindowHandles();   

	        Iterator<String> it =  win.iterator();
	        if(win.size() > 0){
	            while(it.hasNext()){
	                String handle = it.next();
	                if (handle.equalsIgnoreCase(parentHandle)){
	                    driver.switchTo().window(handle);
	                    currentHandle = handle;
	                }
	            }
	        }
	        else{
	            System.out.println("Unable to switch");
	        }
	        return currentHandle;
	}
		public WebDriver switchOnFrameWindow(String name) {
			driver.switchTo().frame(driver.findElement(By.name(name)));
			return driver.switchTo().defaultContent();
		}
	}

