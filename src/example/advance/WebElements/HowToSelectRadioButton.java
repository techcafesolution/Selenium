package example.advance.WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HowToSelectRadioButton {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//1. Select Radio Button
		WebElement male=driver.findElement(By.id("male"));
		WebElement female=driver.findElement(By.id("female"));
		myWait.until(ExpectedConditions.visibilityOf(male)).click();
		//2. Check button status
		if(male.isSelected()) {
			System.out.println("Male radio button is already selected..");
		} 
		
		if(female.isDisplayed()) {
			System.out.println("Yes female radio button is present..");
			if(female.isEnabled()) {
				System.out.println("Yes female radio button is enable..");
				if(female.isSelected()) {
					System.out.println("It is also selected...");
				}else {
					female.click();
					System.out.println("click on female radio button..");
				}
			}
		}
	}
}
