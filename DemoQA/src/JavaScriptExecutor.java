import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Start application
		driver.get("https://learn-automation.com/fluentwait-in-selenium-webdriver/");

		driver.manage().window().maximize();

		driver.findElement(By.className("dropbtn")).click();
		// Create object of WebDriverWait class and it will wait max of 20 seconds.
		// By default it will accepts in Seconds

		/*
		 * Boolean status = wait.until(new Function<WebDriver, Boolean>() {
		 * 
		 * @Override public Boolean apply(@Nullable WebDriver arg0) { // TODO
		 * Auto-generated method stub Boolean isJqueryDone = (Boolean)
		 * ((JavascriptExecutor) driver).executeScript("return jQuery.active==0"); if
		 * (!isJqueryDone) System.out.println("Jquery in progress"); return
		 * isJqueryDone; }
		 * 
		 * });
		 */
		JavaScriptExecutor.untilPageLoadComplete(driver);
	//	WebDriverWait wait = new WebDriverWait(driver, 30);
	//	WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
		driver.findElement(By.linkText("Facebook")).click();

	}

	public static void untilJqueryIsDone(WebDriver driver) {
		untilJqueryIsDone(driver, 30L);
	}

	public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds) {
		until(driver, (d) -> {
			Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone)
				System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
		}, timeoutInSeconds);
	}

	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		 webDriverWait.withTimeout(Duration.ofSeconds(timeoutInSeconds));
		try {
			webDriverWait.until(waitCondition);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, 30L);
	}

	public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
		until(driver, (d) ->
			{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}

}
