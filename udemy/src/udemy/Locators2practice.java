package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Locators2practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		String username="mounica";
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//driver.findElement(By.className("submit signInBtn")).click(); This is error saying compound class names not permitted -
		//dont give both the class names
		
		
		Thread.sleep(1000);
		
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText(),"Hello "+username+",");
		driver.findElement(By.className("logout-btn")).click();  //logout-btn is a single class having hifen in between
		
	}

}
