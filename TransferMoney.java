import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TransferMoney {
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
		
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();

		
		driver.findElement(By.cssSelector(".top_offset")).click();
	    driver.findElement(By.linkText("username")).click();
		
		Thread.sleep(1000);
		
	    driver.findElement(By.partialLinkText("Transfer Funds")).click();
	    assertEquals(driver.findElement(By.className("board-header")).getText(),"Transfer Money & Make Payments");


		
	    Select spPayee = new Select(driver.findElement(By.id("tf_fromAccountId")));
		spPayee.selectByValue("3");
		
	    Select tfToAccountId = new Select(driver.findElement(By.id("tf_toAccountId")));
	    tfToAccountId.selectByValue("4");
	    
	    driver.findElement(By.id("tf_amount")).sendKeys("100");

	    driver.findElement(By.id("btn_submit")).click();
	    

	    assertEquals(driver.findElement(By.className("board-header")).getText(),"Transfer Money & Make Payments - Verify");
	    driver.findElement(By.id("btn_submit")).click();
	    
	    driver.findElement(By.cssSelector(".alert")).click();
	    assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "You successfully submitted your transaction.");
		driver.close();
		driver.quit();


	}
}
