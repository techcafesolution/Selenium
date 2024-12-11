package co.advance.Xpath;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleX_Paths {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.ebay.com/");
		//1. self relative X-path
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mobile");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//2. X-path-using contains method and text method along with index
		String inform1=driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]")).getText();
		System.out.println("Mobile complete Information is:: "+inform1);
		//3. X-path using parent
		WebElement element1=driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]//parent::div"));
		if(element1.isDisplayed()) {
			System.out.println("Yes element is visible...");
		}else {
			System.out.println("No element is not visible!!");
		}
		//4. X-path using ancestor
		WebElement element2=driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]//ancestor::a"));
		if(element2.isDisplayed()) {
			System.out.println("Yes element is visible...");
		}else {
			System.out.println("No element is not visible!!");
		}
		//5. X-path using following-sibling
		WebElement rating=driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]//ancestor::a//following-sibling::div[2]"));
		if(rating.isDisplayed()) {
			System.out.println("Yes rating is visible...");
		}else {
			System.out.println("No rating is not visible!!");
		}
		//6. X-path using descendant
		WebElement link=driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]//ancestor::a//following-sibling::div[2]//descendant::span[@class='s-item__reviews-count']"));
		if(link.isEnabled()) {
			System.out.println("Yes link is enable..");
		}else {
			System.out.println("Not link is not enable!!");
		}
		//7. X-path using child
		String productAndRating=driver.findElement
		(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]//ancestor::a//following-sibling::div[2]//descendant::span[@class='s-item__reviews-count']//child::span[1]")).getText();
		System.out.println(productAndRating);
		//8. X-path using preceding-sibling
		WebElement ele1=driver.findElement(By.xpath("(//span[contains(text(), 'Apple iPhone 11')])[1]//ancestor::a//following-sibling::div[2]//descendant::span[@class='s-item__reviews-count']//child::span[1]/parent::span//child::span[2]//preceding-sibling::span"));
		if(ele1.isDisplayed()) {
			System.out.println("Yes final element is displayed...");
			driver.quit();
		}else {
			System.out.println("No final element is not displayed!!!");
			driver.close();
		}
	}
}
