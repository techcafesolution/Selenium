package co.advance.WebDriverMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Declare Explicit selenium wait just after the declaration of instance of webDriver wait to avoid synchronization issue.
		WebDriverWait eWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		//Uses Explicit WebDriver wait.
		WebElement userName=eWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		userName.sendKeys("Admin");
		WebElement userPassword=eWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		userPassword.sendKeys("admin123");
		WebElement login=eWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		login.click();
		driver.quit();
	}
}
