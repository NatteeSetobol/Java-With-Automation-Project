import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFunction {
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
		
		WebElement searchBar = driver.findElement(By.id("searchTerm"));
		
		assert(searchBar.isDisplayed());
		assert(searchBar.isEnabled());
		
		searchBar.sendKeys("bank");
		
		searchBar.click();
		
		 assert(driver.findElement(By.tagName("h2")).getText().contains("Search Results:"));
		 assert(driver.findElement(By.linkText("Zero - Personal Banking - Loans - Credit Cards")).isDisplayed());
		 assert(driver.findElement(By.linkText("Zero - Free Access to Online Banking")).isDisplayed());

		

		
				
		driver.close();
		driver.quit();
	}
}
