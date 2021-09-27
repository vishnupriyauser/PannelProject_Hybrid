package com.urbanladder.reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.urbanladder.utilities.PropertyFileReader;

public class ReusableDrivers {

	public static WebDriver driver;//by declaring static each class uses respective driver
	private static Logger log=LogManager.getLogger( ReusableDrivers.class.getName()); 	
	
	public static WebDriver initializedriver() throws IOException
	{
		
		String bname=PropertyFileReader.loadFile().getProperty("browser");
		
		if(bname.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
			log.info("chrome driver invoked successfully");
		}
		else if(bname.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
			
		    driver=new FirefoxDriver();
		   log.info("firefox driver invoked successfully");
		}
		else
		{
			    System.setProperty("webdriver.edge.driver","./drivers/msedgedriver.exe");				
			    driver=new EdgeDriver();
			  log.info("edge driver invoked successfully");
		}	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	//implicit wait		
		return driver;	
	}
	
	public static void captureScreen(String tname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File( ".\\Screenshots\\" + tname + ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//System.out.println("Screenshot taken");
	}	
	
	
}
