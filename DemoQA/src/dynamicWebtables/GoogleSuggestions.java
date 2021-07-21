package dynamicWebtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSuggestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("testing");
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[contains(@class,'wM6W7d')]"));
		System.out.println("Number of items " + list.size());
		for (WebElement we : list) {
			if (we.getText().equals("testing tools")) {
				we.click();
				break;
			}
		}

	}

}
