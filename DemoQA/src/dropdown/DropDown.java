package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		Select se=new Select(driver.findElement(By.id("oldSelectMenu")));
		List<WebElement> ls =se.getOptions();
		for(WebElement we:ls)
		System.out.println(we.getText());
		se.selectByIndex(4);
		se.selectByVisibleText("Magenta");
		se.selectByValue("5");
		driver.quit();
		

	}

}
