package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//give correct username and password
		String name="mounica";
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("submit")).click();
		//it will take sometime to load new page
		Thread.sleep(5000);
		
		//you are successfully logged in message will be displayed	
		//get above text using Tag name
		System.out.println(driver.findElement(By.tagName("p")).getText());
		//write Assertion for this text
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		
		//get hello mounica using css locator
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		//write Assertion for hello username
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+',');
		//click on Log out button
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
		

	}

}
