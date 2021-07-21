import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSDemoClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("alert('Welcome to Selenium')");

	}

}
