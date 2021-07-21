package Xpathaxes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AxesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Start application
		driver.get("https://money.rediff.com/gainers");

		driver.manage().window().maximize();

		// Xpath axes
		// self node
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'India Motor Part')]//self::a")).getText());

		System.out.println(
				driver.findElement(By.xpath("//a[contains(text(),'India Motor Part')]//parent::td")).getText());

		List<WebElement> child = driver
				.findElements(By.xpath("//a[contains(text(),'India Motor Part')]//ancestor::tr/child::*"));
		System.out.println(child.size());

		System.out
				.println(driver.findElements(By.xpath("//a[contains(text(),'India Motor Part')]/following::*")).size());

		System.out.println(driver
				.findElements(By.xpath("//a[contains(text(),'India Motor Part')]/parent::td/following-sibling::*")).size());
		
		System.out.println(driver.findElements(By.xpath("//a[contains(text(),'India Motor Part')]/ancestor::tr/preceding::*")).size());
		
		System.out.println(driver.findElements(By.xpath("//a[contains(text(),'India Motor Part')]/ancestor::tr/preceding-sibling::*")).size());

		driver.close();

	}

}
