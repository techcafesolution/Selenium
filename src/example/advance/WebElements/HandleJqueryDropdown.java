package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJqueryDropdown {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		//Boot Strap DropDown
		driver.findElement(By.cssSelector("input#justAnInputBox")).click();
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.xpath("//li[@class='ComboTreeItemChlid']//span"));
		selectOptions(options, "choice 2","choice 2 2","choice 2 3","choice 5","choice 6","choice 6 2","choice 6 2 2");
		driver.findElement(By.cssSelector("input#justAnInputBox1")).click();
		Thread.sleep(2000);
		options=driver.findElements(By.xpath("//li[@class='ComboTreeItemParent']//span"));
		selectOptions(options, "choice 2","choice 2 2","choice 2 3","choice 5","choice 6","choice 6 2","choice 6 2 2");
	}
	public static void selectOptions(List<WebElement> options, String...strings) {
		System.out.println("Size of the Elements: "+options.size());
		for(WebElement option:options) {
			String txt=option.getText();
			for(String str:strings) {
				if(txt.equalsIgnoreCase(str)) {
					option.click();
					System.out.println("Selected-->"+txt);
				}
			}
		}
	}
}
