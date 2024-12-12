package co.advance.WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Thread_Sleep_JavaWait {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//Used Java wait statement to avoid synchronization issue.
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.quit();
	}
}
