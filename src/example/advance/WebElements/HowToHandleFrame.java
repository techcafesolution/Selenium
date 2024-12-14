package example.advance.WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToHandleFrame {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		//1. Switch to first Frame
		driver.switchTo().frame(frame1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		//2. Come out to default content
		driver.switchTo().defaultContent();
		//3. Switch to second Frame
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("To Java");
		//4. Come out to default content
		driver.switchTo().defaultContent();
		//5. Switch to third frame
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("To Selenium");
		//6. switch to i-frame.
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[2]")).click();
		//7. Come out to default content
		driver.switchTo().defaultContent();
		//5. Switch to fourth frame
		WebElement frame4=driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("To BDD");
		//8. Come out to default content
		driver.switchTo().defaultContent();
		//9. Switch to fourth frame
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("To Playwright");
		Thread.sleep(2000);
		//10. Switch to default content
		driver.switchTo().defaultContent();
		driver.close();
	}
}
