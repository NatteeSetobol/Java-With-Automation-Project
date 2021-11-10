import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class paybills {
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

		
		driver.findElement(By.cssSelector(".top_offset")).click();
	    driver.findElement(By.linkText("username")).click();
	    
	    driver.findElement(By.partialLinkText("Pay Bills")).click();
	    
	    assertEquals(driver.findElement(By.className("board-header")).getText(),"Make payments to your saved payees");

	    Select spPayee = new Select(driver.findElement(By.id("sp_payee")));
		spPayee.selectByValue("apple");

	    Select spAccount = new Select(driver.findElement(By.id("sp_account")));
		spAccount.selectByValue("4");
		
	    driver.findElement(By.id("sp_amount")).sendKeys("$100");

	    driver.findElement(By.id("sp_date")).click();
	    
	    driver.findElement(By.id("sp_date")).click();
	    driver.findElement(By.linkText("10")).click();
	    
	    driver.findElement(By.id("sp_description")).sendKeys("none");
	    driver.findElement(By.id("pay_saved_payees")).click();
	    
	    assert(driver.findElement(By.id("alert_container")).isDisplayed());
	    
	     List<WebElement> elements = driver.findElements(By.cssSelector("#alert_content > span"));
	     assert(elements.size() > 0);
	    
	    
	    	
	    

	    
		Thread.sleep(1000);

		//driver.findElement(By.id("logout_link")).click();

	    //===== CLEAN UP
		driver.close();
		driver.quit();

	}
}
