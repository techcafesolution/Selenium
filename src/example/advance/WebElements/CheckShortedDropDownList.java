package example.advance.WebElements;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckShortedDropDownList {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> options=driver.findElements(By.xpath("//select[@id='colors']//option"));
		System.out.println(checkOptionsShorted(options));
		options=driver.findElements(By.xpath("//select[@id='animals']//option"));
		System.out.println(checkOptionsShorted(options));
	}
	public static boolean checkOptionsShorted(List<WebElement> options) {
		List<String> originalList=new ArrayList<>();
		List<String> tempList=new ArrayList<>();
		for(WebElement option:options) {
			String txt=option.getText();
			originalList.add(txt);
			tempList.add(txt);
		}
		System.out.println("Element Before short:: ");
		System.out.println(originalList);
		System.out.println(tempList);
		System.out.println("Element After short:: ");
		Collections.sort(tempList);
		System.out.println(originalList);
		System.out.println(tempList);
		if(originalList.equals(tempList)) {
			System.out.println("List is shorted..");
			return true;
		}else {
			System.out.println("List is not shorted!!");
			return false;
		}
	}
}
