package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String password=getPassword(driver);
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		Thread.sleep(2000);
		
		String username="mounica";
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(1000);
		
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText(),"Hello "+username+",");
		driver.findElement(By.className("logout-btn")).click();
		
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		String passwordText=driver.findElement(By.className("infoMsg")).getText();
		String pwdArray1[]=passwordText.split("'");
		String pwdArray2[]=pwdArray1[1].split("'");
		String password=pwdArray2[0];
		System.out.println("password from method :"+password);
		return password;
	
		
	}

}
