package example.advance.WebElements;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HowToHandlePopup {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(5000);
		//1. Handle JavaScript normal alert
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(5000);
		//2. Handle Confirm alert
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(5000);
		System.out.println(alert.getText());
		alert.dismiss();
		String altMessage=driver.findElement(By.id("demo")).getText();
		System.out.println("After handle alert message is:: "+altMessage);
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(5000);
		System.out.println(alert.getText());
		alert.accept();
		altMessage=driver.findElement(By.id("demo")).getText();
		System.out.println("After handle alert message is:: "+altMessage);
		//3. Handle Prompt pop up
		driver.findElement(By.id("promptBtn")).click();
		Thread.sleep(5000);
		alert.sendKeys("Hi I am Sanjeeb");
		alert.dismiss();
		altMessage=driver.findElement(By.id("demo")).getText();
		System.out.println("After handle alert message is:: "+altMessage);
		driver.findElement(By.id("promptBtn")).click();
		Thread.sleep(5000);
		alert.sendKeys("Hi I am Sanjeeb..");
		alert.accept();
		altMessage=driver.findElement(By.id("demo")).getText();
		System.out.println("After handle alert message is:: "+altMessage);
		//4. How to handle alert without using switch key
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(5000);
		Alert alt=myWait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alt.getText());
		alt.accept();
		//How to handle Authentication pop-up
		Thread.sleep(5000);
		driver.navigate().to("https://the-internet.herokuapp.com/basic_auth");
		//https://username:password@URL
		Thread.sleep(5000);
		driver.get("https://admin:admin@the−nternet.herokuapp.com/basic_auth");
		Thread.sleep(5000);
		driver.quit();
	}
}
