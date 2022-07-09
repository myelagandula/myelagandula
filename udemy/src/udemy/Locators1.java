package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("mounica");
		driver.findElement(By.name("inputPassword")).sendKeys("samplepwd");
		
		driver.findElement(By.className("signInBtn")).click();
		
		//printing the error validation text (* Incorrect username or password)
		System.out.println(driver.findElement(By.className("error")).getText());
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());
		//System.out.println(driver.findElement(By.cssSelector("p#Idname")).getText())
		//driver.findElement(By.cssSelector("p[class='error']"));
				//driver.findElement(By.xpath("//p[@class='error']"));
				
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		
		
		//clicking on forgot password
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//2 screens within the window are moving
		Thread.sleep(1000);
		
		//creating xpath for name
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		
		//creating css locator for Email
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("johnrandom1@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		
		//creating xpathlocator for Email using indexing method 
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("johnrandom2@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//creating css locator for Email using indexing method
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("johnrandom3@gmail.com");
		
		//creating xpath using parent element for Phone Number
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9849404055");
		
		//creating css selector using class name for Reset login button
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		//printing error text using css slector using parent child path
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//click on Go to login button
		//creating xpath
		//div[class="@forgot-pwd-btn-conainer"]/button[1]
		driver.findElement(By.xpath("//div[@class='@forgot-pwd-btn-conainer']/button[1]")).click();
		
		//screen within window is moving
		Thread.sleep(1000);
		
		//Trying to login with correct password
		//css selector with Id for username
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("mounica");
		//driver.findElement(By.cssSelector("#inputUsername")).sendKeys("mounica");
		
		
		
		//using css locator regular expression for password
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		//click on checkbox
		driver.findElement(By.id("chkboxOne")).click();
		
		//click on sign in button using xpath regular expression
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		

	}

}
