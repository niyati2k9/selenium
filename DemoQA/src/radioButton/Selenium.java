package radioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Code\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.demoqa.com/radio-button");
			driver.manage().window().maximize();
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.id("yesRadio"))).click().build().perform();
			// driver.findElement(By.id("yesRadio")).click();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
