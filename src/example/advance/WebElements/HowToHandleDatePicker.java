package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HowToHandleDatePicker {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		String year="1994";
		String month="Jun";
		String yyyy="2020";
		String mm="06";
		String date="21";
		//1. Handle normal date box
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(mm+"/"+date+"/"+year);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		//This technique will not work for date picker.
		//driver.findElement(By.cssSelector("input#txtDate")).sendKeys(month+"/"+date+"/"+year);
		driver.findElement(By.cssSelector("input#txtDate")).click();
		WebElement mm1=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[1]"));
		Select sel=new Select(mm1);
		sel.selectByVisibleText(month);
		Thread.sleep(3000);
		WebElement yy1=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::select[2]"));
		Select sel1=new Select(yy1);
		sel1.selectByVisibleText(yyyy);
		Thread.sleep(3000);
		List<WebElement> options=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement option:options) {
			String dd=option.getText();
			if(dd.equals(date)) {
				option.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
