package navigationCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Excersise1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Code\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();  
        capabilities.setCapability("marionette",true);    
		WebDriver driver = new FirefoxDriver();
		driver.get("https://DemoQA.com");
		driver.findElement(By.xpath(".//*[@class='home-banner']/a")).click();
		driver.navigate().refresh();
	//	driver.navigate().refresh();
	//	driver.navigate().to("https://demoqa.com");

		// Close browser
	//	driver.close();
	}
}