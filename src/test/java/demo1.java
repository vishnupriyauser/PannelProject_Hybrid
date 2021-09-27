import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demo1 {

	//login
	public static void main(String[] args) throws InterruptedException {

		    System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
		    driver.get("https://www.urbanladder.com/");
	        driver.manage().window().maximize();
	        //driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
	        Thread.sleep(10000);
	        driver.findElement(By.cssSelector("a[data-gaaction='popup.auth.close']")).click();
	        Thread.sleep(10000);
	        
	        Actions actions = new Actions(driver);
	        
	        WebElement move=driver.findElement(By.cssSelector(".header__topBarIconList_profile-icon"));
	       
	        actions.moveToElement(move).build().perform();
	       
	        WebElement sub = driver.findElement(By.cssSelector(".login-link.authentication_popup"));
	        actions.moveToElement(sub);
	        actions.click().build().perform();   
	        Thread.sleep(20000);
	        driver.findElement(By.xpath("//input[@class='email required input_authentication']")).sendKeys("vishnu");
	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("vishnu");
	}
}
