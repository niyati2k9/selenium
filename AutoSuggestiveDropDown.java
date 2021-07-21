import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.id("autosuggest")).sendKeys("India");
		Thread.sleep(3000);
		// ul[@id='ui-id-1']//li//child::*
		List<WebElement> list = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement element : list) {
			if (element.getText().equals("India")) {
				element.click();
				break;
			}
		}
		System.out.println("clicked India");
	}

}
