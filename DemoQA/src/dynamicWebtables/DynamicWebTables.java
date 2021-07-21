package dynamicWebtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		System.out.println("Table Data is:");
		List<WebElement> rows = driver.findElements(
				By.xpath(".//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
		for (int i = 0; i < rows.size(); i++) {
			System.out.println("Data of row " + (i + 1) + " is:");
			List<WebElement> colsWithData = rows.get(i).findElements(By.xpath(".//div[@class='rt-td'][text()]"));
			for (int j = 0; j < colsWithData.size(); j++) {
				System.out.println("Data at cell with Row " + (i + 1) + " Column " + (j + 1) + " : "
						+ colsWithData.get(j).getText());
			}
		}
	}

}
