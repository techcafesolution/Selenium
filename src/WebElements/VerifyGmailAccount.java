package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyGmailAccount {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AcMMx-fvpizgNFP8ott5JyuqcwUkV3mgYgxJKLECnetorVrzW4USDKcPJX138NiS3oopjJy9E0ELKA&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-16383123%3A1733881821463686&ddm=1");
		driver.findElement(By.name("identifier")).sendKeys("sanjeebavana1994@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);
		String aT=driver.getTitle();
		String eT="Gmail";
		driver.quit();
		if(aT.equalsIgnoreCase(eT)) {
			System.out.println("Test Case is Passed...");
		}else {
			System.out.println("Test Case is Failed!!!");
		}
	}
}
