package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();
		System.out.println("Title is " + driver.getTitle());
		WebElement uName = driver.findElement(By.xpath("//*[@id='userName']"));
		WebElement pswd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id='login']"));
		uName.sendKeys("testuser");
		pswd.sendKeys("Password@123");
		loginBtn.click();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			WebElement logoutBtn = driver.findElement(By.xpath("//button[@id='submit']"));

			if (logoutBtn.isDisplayed()) {
				logoutBtn.click();
				System.out.println("Logout successful");
			}

		} catch (Exception e) {
			System.out.println("Incorrect login");
		}
		
		driver.quit();

	}

}
