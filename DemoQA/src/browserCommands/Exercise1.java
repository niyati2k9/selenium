package browserCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver", "C:\\Code\\chromedriver.exe");
		 WebDriver driver= new ChromeDriver();
		 driver.get("https://demoqa.com/forms");
		 System.out.println(driver.getTitle()+" ");
		 System.out.println(driver.getTitle().length());
		 String currentUrl=driver.getCurrentUrl();
		 if(currentUrl.equals("https://demoqa.com/forms")) {
			 System.out.println("true");
		 }
		 System.out.println(driver.getPageSource().length());
		 driver.close();
	}

}
