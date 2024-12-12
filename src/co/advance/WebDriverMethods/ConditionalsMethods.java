package co.advance.WebDriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalsMethods {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://practice.expandtesting.com/radio-buttons");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement element=driver.findElement(By.xpath("//input[@id='black']"));
		//1. isDisplay()--> Return boolean value and check element is display or not.
		if(element.isDisplayed()) {
			System.out.println("Yes element is visible..");
		}else {
			System.out.println("No element is not visible!!");
		}
		//2. isEnable()-->Use to check element is enable or disable and return boolean value.
		if(element.isEnabled()) {
			System.out.println("Yes element is enable...");
		}else {
			System.out.println("No element is not enable!!");
		}
		//3. isSelected()-->Use to check element is selected or not and return boolean value.
		if(element.isSelected()) {
			System.out.println("Yes element is selected...");
		}else {
			System.out.println("No element is not selected!!!");
		}
		
		//click the element and then check
		element.click();
		
		if(element.isSelected()) {
			System.out.println("Yes element is selected...");
		}else {
			System.out.println("No element is not selected!!!");
		}
		driver.quit();
	}
}
