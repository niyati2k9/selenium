package dynamicWebtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaveenLabsWebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		//rows
		
		String beforeXpath = "//*[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[2]";
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Total rows : " + rowCount);
		
		for (int i = 2; i <= rowCount; i++) {
			String xpath = beforeXpath + i + afterXpath;
			WebElement element = driver.findElement(By.xpath(xpath));
			System.out.println(element.getText());
		}
		
		
		//Columns
		String colBeforeXpath="//*[@id='customers']/tbody/tr[1]/th[";
		String colAfterXpath = "]";
		List<WebElement> cols=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
		int colCount= cols.size();
		System.out.println("Total cols : "+colCount);
		
		for(int i=1;i<=colCount;i++) {
			String xpath = colBeforeXpath + i+colAfterXpath;
			WebElement element = driver.findElement(By.xpath(xpath));
			System.out.println(element.getText());
		}
	}

}
