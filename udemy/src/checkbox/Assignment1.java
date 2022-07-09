package checkbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1st question
		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//count number of checkboxes in the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		//parent to child traversal
		System.out.println(driver.findElements(By.cssSelector("div[class='right-align']  input[type='checkbox']")).size());
		
		}

}
