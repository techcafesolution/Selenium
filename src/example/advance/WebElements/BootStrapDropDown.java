package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> options=driver.findElements(By.xpath("//select[@id='colors']//option"));
		Thread.sleep(4000);
		for(WebElement option:options) {
			String txt=option.getText();
			System.out.println(txt);
			if(txt.equalsIgnoreCase("Blue")||txt.equalsIgnoreCase("Yellow")||txt.equals("Red")) {
				option.click();
				System.out.println("Selected options-->"+txt);
			}
		}
	}
}
