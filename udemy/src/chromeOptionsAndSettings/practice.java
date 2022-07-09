package chromeOptionsAndSettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
				
		WebElement student=driver.findElement(By.id("inlineRadio1"));
		String text=driver.findElement(with(By.id("inlineRadio2")).toRightOf(student)).getText();
		System.out.println("id");
		System.out.println(text);
		
		System.out.println("tagname");
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(student)).getText());
		
		System.out.println("name");
		System.out.println(driver.findElement(with(By.name("inlineRadioOptions")).toRightOf(student)).getText());
	}

}
