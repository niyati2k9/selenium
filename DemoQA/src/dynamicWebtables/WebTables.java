package dynamicWebtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		String value = driver.findElement(By.xpath("//div[@class='rt-resizable-header-content']")).getText();
		//System.out.println(value);
		List<WebElement> wes = driver.findElements(By.xpath("//div[contains(@class,'rt-tr-group')]"));
		//System.out.println(wes.size());
		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
		//System.out.println(rows.size());
		//System.out.println("Data of 2nd row is: \n" + rows.get(1).getText());
		List<WebElement> colsWithData = driver.findElements(By.xpath("//div[@class='rt-td'][2][text()]"));
		for(WebElement col:colsWithData)
		System.out.println(col.getText());
		driver.quit();
	}
}
