package example.advance.WebElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HowToSelectCheckBox {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		//1. Select Single checkBox.
		WebElement checkBox=driver.findElement(By.xpath("//input[@id='tuesday']"));
		myWait.until(ExpectedConditions.visibilityOf(checkBox)).click();
		//2. Unselect a Single checkBox.
		if(checkBox.isDisplayed()) {
			if(checkBox.isEnabled()) {
				if(checkBox.isSelected()) {
					checkBox.click();
				}
			}
		}
		//3. Select multiple checkBox
		List<WebElement> chkBoxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		chkBoxes=myWait.until(ExpectedConditions.visibilityOfAllElements(chkBoxes));
		for(WebElement chkBox : chkBoxes) {
			if(chkBox.isEnabled()) {
				chkBox.click();
			}
		}
		
		//4. Deselect all checkBoxes.
		for(WebElement chkBox : chkBoxes) {
			if(chkBox.isSelected()) {
				chkBox.click();
			}
		}
		
		//5. Select specific checkBoxes
		String name="'monday'";
		driver.findElement(By.xpath("//input[@class='form-check-input' and @id="+name+"]")).click();
	}
}
