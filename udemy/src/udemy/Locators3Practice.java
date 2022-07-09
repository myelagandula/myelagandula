package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		
		Locators3Practice loc=new Locators3Practice();
		String password=loc.extractPassword(driver);
		driver.findElement(By.cssSelector("button[class*='go-to-login']")).click();
		Thread.sleep(2000);
		
		String username="mounica";
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys(password);
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),"Hello "+username+',');
		Assert.assertEquals(driver.findElement(By.cssSelector("div p")).getText(),"You are successfully logged in.");
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		
		
		

	}
	public String extractPassword(WebDriver driver) {
		String extractedPwd=driver.findElement(By.xpath("//form/p")).getText();
		extractedPwd= extractedPwd.split("'")[1].split("'")[0];
		return extractedPwd;
		
	}

}
