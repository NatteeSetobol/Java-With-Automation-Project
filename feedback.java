import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class feedback {
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
		
		assert(driver.findElement(By.id("feedback")).isDisplayed());
		driver.findElement(By.id("feedback")).click();
		
		assert(driver.findElement(By.id("feedback-title")).isDisplayed());
		
		driver.findElement(By.id("name")).sendKeys("test name");
		driver.findElement(By.id("email")).sendKeys("test@fake.com");
		driver.findElement(By.id("subject")).sendKeys("this is a fake subject");
		driver.findElement(By.id("comment")).sendKeys("this is a test comment");
		driver.findElement(By.name("submit")).click();

		assert(driver.findElement(By.id("feedback")).isDisplayed());

		assert(driver.findElement(By.cssSelector(".offset3")).getText().contains("Thank you for your comments"));
		
		driver.close();
		driver.quit();

	}
}
