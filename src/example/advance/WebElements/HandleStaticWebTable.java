package example.advance.WebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaticWebTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//1. Handle specific row data for specific column
		String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]/td[1]")).getText();
		String subjectName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]/td[3]")).getText();
		String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]/td[4]")).getText();
		System.out.printf("Book Name: %s \nSubject Name: %s \nPrice: %s",bookName,subjectName,price);
		System.out.println();
		//2. Handle entire table data
		for(int i=1; i<=6;i++) {
			for(int j=1; j<=4;j++) {
				if(i==1) {
					String header=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//th["+j+"]")).getText();
					System.out.print(header+"\t");
				}else {
				String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td["+j+"]")).getText();
					System.out.print(data+"\t");
				}
			}
			System.out.println();
		}
	}
}
