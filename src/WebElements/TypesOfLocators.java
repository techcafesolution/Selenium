package WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TypesOfLocators {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium\\\\chromedriver-win64\\\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AcMMx-cvKguvFY1W8ZqAPR47CwIggAi8xV8l1PkLikdDhs4duD5APOr4KSVZeBJ-VzvVMk2WhldhRA&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S1041322048%3A1733889213645026&ddm=1");
		//1. By id
		Thread.sleep(2000);
		driver.findElement(By.id("identifierId")).sendKeys("edureka123@gmail.com");
		//2. By name
		Thread.sleep(2000);
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Realme 10 pro");
		//3. By class Name
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("gLFyf")).sendKeys("Selenium");
		//4. By Partial LinkText
		Thread.sleep(2000);
		driver.navigate().to("https://www.yahoo.com/");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Mail")).click();
		//5. By Partial LinkText
		driver.navigate().to("https://login.yahoo.com/?.src=ym&pspid=159600001&activity=mail-direct&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Forgot username?")).click();
		//6. By CSS Selector
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#username")).sendKeys("sanjeebavana@yahoo.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".phone-no")).clear();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#username")).sendKeys("sanjeebavana1994@yahoo.com");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sanjeebdash@gmail.com");
		driver.quit();
	}
}
