import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class demo9 {

	//google play-->verify
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		  System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        WebDriverWait d=new WebDriverWait(driver,10000);
			  
	        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-gaaction='popup.auth.close']"))).click();
	        Thread.sleep(1000);
	        
	        
	        driver.findElement(By.cssSelector("img[alt='Download Urban Ladder App from Playstore']")).click();//click google play
	        
	        Set<String> b=driver.getWindowHandles();
			Iterator<String> c=b.iterator();
			String parent =c.next();
			String Child =c.next();
			driver.switchTo().window(Child);
			
			if(driver.findElement(By.cssSelector(".gbqfi.gb_rc")).isEnabled())//verify with search bar
			{
				System.out.println("verified");
			}
			else
			{
				System.out.println("not present");
			}
			
		/*	driver.switchTo().window(parent);//back to homepage then verfied reached or not
			if(driver.findElement(By.cssSelector("a[href='../../furniture-stores?src=header']")).isEnabled())
			{
				System.out.println("verified");
			}
			else
			{
				System.out.println("not present");
			}*/
	}

}
