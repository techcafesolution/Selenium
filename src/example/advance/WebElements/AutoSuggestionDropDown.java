package example.advance.WebElements;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(5000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@role='presentation']//div//span"));
		System.out.println("Total Number of options are:: "+options.size());
		Iterator<WebElement> it=options.iterator();
		while(it.hasNext()) {
			WebElement ele=it.next();
			String option=ele.getText();
			if(option.equalsIgnoreCase("selenium")) {
				ele.click();
				System.out.println("Select-->"+option);
			}
		}
	}
}
