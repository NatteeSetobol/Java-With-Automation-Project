import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertFunction {
	public static void main(String[] args) throws InterruptedException {
		//======== BASIC SETUP ============
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/popcorn/Selenium/chromedriver");
		// NOTE(): System path for browser
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		

		driver.get("http://zero.webappsecurity.com");
		
		
		// ====== Test case
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
		
		assertEquals(driver.getTitle(), expectedTitle, "Title didn't match! \n");

		
		driver.findElement(By.id("signin_button")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();

		
	    driver.findElement(By.partialLinkText("Pay Bills")).click();
	    
	    driver.findElement(By.linkText("Purchase Foreign Currency")).click();
	    driver.findElement(By.id("pc_calculate_costs")).click();
	    
	    Alert jsAlert = driver.switchTo().alert();
		jsAlert.accept();
		driver.close();
		driver.quit();


	}
}
