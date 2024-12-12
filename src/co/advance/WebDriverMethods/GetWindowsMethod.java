package co.advance.WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetWindowsMethod {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		//1. To Minimize windows
		driver.manage().window().minimize();
		//2. To maximize window
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//3. To close a specific windows.
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("OrangeHRM, Inc")).click();
		Thread.sleep(2000);
		driver.close();
		//To close all windows.
		Thread.sleep(2000);
		driver.quit();
	}
}
