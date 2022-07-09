package relativeLocators;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;


public class invokingMultipleTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://rahulshettyacademy.com");
		
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr=windowIds.iterator();
		String pId=itr.next();
		String cId=itr.next();
		
		//a[contains(@href,'https://courses.rahulshettyacademy.com/p/')]
		
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
		WebElement mainElement=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1);
		String rightElement=driver.findElement(with(By.tagName("a")).toRightOf(mainElement)).getText();
		
		
		driver.switchTo().window(pId);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		System.out.println(rightElement);
		
		
		
	}

}
