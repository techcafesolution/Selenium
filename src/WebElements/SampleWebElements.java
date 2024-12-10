package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleWebElements {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.name("q")).sendKeys("Realme");
		Thread.sleep(4000);
		driver.findElement(By.className("_2iLD__")).click();
		driver.findElement(By.linkText("Mobiles")).click();
		Thread.sleep(4000);
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.navigate().back();
		driver.quit();
	}
}
