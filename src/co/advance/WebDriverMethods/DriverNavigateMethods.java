package co.advance.WebDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethods {
	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//1. navigate to(String url)
		driver.navigate().to("https://demo.nopcommerce.com/");
		//2. navigate to(URL url)
		URL myUrl=new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.navigate().to(myUrl);
		//3. navigate back()
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		//4. navigate forward()
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		//5. navigate refresh()
		driver.navigate().refresh();
		driver.quit();
	}
}
