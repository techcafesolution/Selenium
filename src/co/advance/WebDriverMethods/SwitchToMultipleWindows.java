package co.advance.WebDriverMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToMultipleWindows {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.partialLinkText("OrangeHRM, Inc")).click();
		Set<String> windowsID=driver.getWindowHandles();
		Iterator<String> it=windowsID.iterator();
		while(it.hasNext()) {
			String winID=it.next();
			String title=driver.switchTo().window(winID).getTitle();
			if(title.contentEquals("Human Resources Management Software | OrangeHRM")) {				
				System.out.println("Title of the Page is:: "+title);
				break;
			}
		}
		System.out.println("Current page URL is:: "+driver.getCurrentUrl());
		List<String> listID=new ArrayList<>(windowsID);
		String parentID=listID.get(0);
		driver.switchTo().window(parentID);
		System.out.println("Current page URL is:: "+driver.getCurrentUrl());
		driver.quit();
	}
}
