package example.advance.WebElements;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePaginationTable {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//1. select all value from dynamic web table.
		List<WebElement> pages=driver.findElements(By.xpath("//ul[@id='pagination']//li"));
		Iterator<WebElement> it=pages.iterator();
		while(it.hasNext()) {
			it.next().click();
			Thread.sleep(5000);
			List<WebElement>checkboxes=driver.findElements(By.xpath("//table[@id='productTable']//tr//td[4]//input"));
			for(WebElement chkbox:checkboxes) {
				chkbox.click();
				Thread.sleep(2000);
			}
			
		}
	}
}
