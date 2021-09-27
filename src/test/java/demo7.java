import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class demo7 {

//click help-->click ship to my city location--->verify location
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        WebDriverWait d=new WebDriverWait(driver,10000);
			  
	        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-gaaction='popup.auth.close']"))).click();
	        
	        driver.findElement(By.cssSelector(".inherit.contact-channel")).click();
	        
	        List<WebElement> listque=driver.findElements(By.cssSelector(".question.row"));
	        listque.get(0).click();
	        
	        List<WebElement> listans=driver.findElements(By.cssSelector(".answer"));
	     
	        String content=listans.get(0).getText();
	      
	        System.out.println(content.contains("Halol"));
	        
	        
	        
	        
	        
	}

}
