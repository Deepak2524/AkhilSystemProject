package com.aspl.src.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aspl.src.util.TestUtil;



public class TestBase {
 
	private static final Logger logger = LogManager.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {

			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"./src/main/java/com/aspl/src/config/config.properties");
			prop.load(ip);   
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browsername=prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			logger.info("browser name :"+browsername.equals("chrome"));
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"./src/test/resources/chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("Launched Chrome");
		}else if (browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"./src/test/resources/geckodriver.exe");
			driver=new FirefoxDriver();
			logger.info("Launched FireFox");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		logger.info("App Url is:"+prop.getProperty("url"));
	}

	public static void clickElementByJS(WebDriver driver,WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", element);
	}
	public void clickonModuleAndClickonOption(String option) 
	{
		WebElement options = driver.findElement(By.xpath("//div[@id='vista_toolbar1']//table//tbody//tr//td/..//b[contains(text(),'"+option+"')]"));
		highLightElement(driver, options);
		clickElementByJS(driver, options);
		logger.info("Following Option has been selected= "+option);

	}
	public void clickAnyWhereOnScreen(){
		driver.findElement(By.xpath("(//div[@class='col-md-4 col-sm-6 PaddingRightSpacing']//span)[2]")).click();
	}
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid red;');", element);

		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black');", element); 

	}
}
