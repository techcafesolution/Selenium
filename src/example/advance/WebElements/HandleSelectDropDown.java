package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleSelectDropDown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement option=driver.findElement(By.xpath("//select[@id='country']"));
		//1. Create an object of Select class
		Select sel=new Select(option);
		Thread.sleep(2000);
		//2. Select By visible text
		sel.selectByVisibleText("United Kingdom");
		//3. Select By Value
		Thread.sleep(2000);
		sel.selectByValue("usa");
		//4. Select By index
		Thread.sleep(2000);
		sel.selectByIndex(3);
		//4. Customize Selection
		List<WebElement> options=driver.findElements(By.xpath("//select[@id='country']//option"));
		System.out.println("Size of options are:: "+options.size());
		//Apply enhanced for loop
		for(WebElement opt : options) {
			String txt=opt.getText();
			if(txt.contentEquals("France")) {
				opt.click();
				System.out.println("Select--> "+txt);
				break;
			}
			
		}
	}
}
