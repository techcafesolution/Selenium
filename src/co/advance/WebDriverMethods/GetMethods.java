package co.advance.WebDriverMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//1. getUrl()-->Used to launch the URL return type void
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		//2. getCurrentUrl()-->Return String URL
		String URL=driver.getCurrentUrl();
		System.out.println("URL--> "+URL);
		//3. getTitle()-->Return String Title of the page.
		String title=driver.getTitle();
		System.out.println("Title Of The Page is:: "+title);
		//4. getPageSource()--> Return source of the page in String format
		String pageSource=driver.getPageSource();
		System.out.println(pageSource);
		//5. getWindowHandle()--> Return unique hash window ID in String format
		driver.findElement(By.partialLinkText("OrangeHRM, Inc")).click();
		String winID=driver.getWindowHandle();
		System.out.println("Current window ID is:: "+winID);
		//6. getWindowHandles()--> Return set of multiple unique window ID
		Set<String> winIds=driver.getWindowHandles();
		Iterator<String>it =winIds.iterator();
		while(it.hasNext()) {
			String ID=it.next();
			System.out.println(ID);
		}
		
	}
}
