package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement>browsers=driver.findElements(By.xpath("//table[@id='taskTable']//tr//td[1]"));
		for(int b=0;b<browsers.size();b++) {
			String browser=browsers.get(b).getText();
			if(browser.equalsIgnoreCase("Chrome")) {
				String expCpu=driver.findElement(By.xpath("//table[@id='taskTable']//descendant::td[contains(text(),'Chrome')]//following-sibling::td[contains(text(),'%')]")).getText();
				String actCpu=driver.findElement(By.xpath("//div[@id='displayValues']//descendant::strong[contains(text(),'%')]")).getText();
				if(expCpu.equals(actCpu)) {
					System.out.println("Value is matched-->"+expCpu);
				}else {
					System.out.println("Value is not matched!!");
				}
			}
		}
		driver.quit();
	}
}
