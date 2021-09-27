import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        
	        WebDriverWait d=new WebDriverWait(driver,10000);
			  
	        d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-gaaction='popup.auth.close']"))).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//input[@class='typeahead tt-input']")).click();
	}

}
