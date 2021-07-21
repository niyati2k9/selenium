import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver,5);
		String[] veggies = { "Brocolli", "Cauliflower", "Cucumber" };
		driver.get("https://www.rahulshettyacademy.com/#/practice-project");
		driver.findElement(By.cssSelector("#name")).sendKeys("Niyati Goyal");
		driver.findElement(By.cssSelector("#email")).sendKeys("niyatigupta2k9@gmail.com");
		driver.findElement(By.cssSelector("#form-submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Automation Practise - 1']")).click();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		addItems(driver, veggies);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		// driver.findElement(By.xpath("//h4[contains(text(),'Cucumber')]//parent::div//child::button")).click();

	}

	/**
	 * @param driver
	 * @param veggies
	 * @param j
	 */
	private static void addItems(WebDriver driver, String[] veggies) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> list = Arrays.asList(veggies);
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i).getText());
			String[] names = products.get(i).getText().split("-");
			String formattedName = names[0].trim();
			if (list.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == list.size()) {
					break;
				}
			}
		}
	}

}
