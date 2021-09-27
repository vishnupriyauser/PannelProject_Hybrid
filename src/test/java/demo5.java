
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo5 {

	//store--viewdetails--verify
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        WebDriverWait d=new WebDriverWait(driver,10000);
			  
	        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-gaaction='popup.auth.close']"))).click();
	        
	        // driver.findElement(By.cssSelector("a[data-gaaction='popup.auth.close']")).click();

	        driver.findElement(By.xpath("//a[@href='../../furniture-stores?src=header']")).click();
	        
	        List<WebElement> list=driver.findElements(By.cssSelector("button[class='_1fVSi action-button _1njbS _1XfDi _3J6Eb']"));
	        list.get(0).click();
	        
	        // System.out.println(list.size());
	        
	 
	        String expected=driver.findElement(By.cssSelector(".no-padding.text-left.address-name")).getText();
	        if(expected.equalsIgnoreCase("Urban Ladder Furniture Store - Hadapsar"))
	        {
	        	System.out.println("valid");
	        }
	}

}
