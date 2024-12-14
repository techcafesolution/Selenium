package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenDropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
		Thread.sleep(5000);
		List<WebElement> options=driver.findElements(By.xpath("//div[@role='option']//span"));
		System.out.println("Total no of options are:: "+options.size());
		for(WebElement option:options) {
			String txt=option.getText();
			System.out.println(txt);
			if(txt.equalsIgnoreCase("Part-Time Internship")) {
				option.click();
				System.out.println("Selected==>"+txt);
			}
		}
	}
}
