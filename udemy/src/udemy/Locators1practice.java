package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver","E:\\Softwares\\chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("https://rahulshettyacademy.com/locatorspractice/");
				driver.findElement(By.id("inputUsername")).sendKeys("name");
				//driver.findElement(By.id("inputUsername")).sendKeys("mounica");
				driver.findElement(By.name("inputPassword")).sendKeys("password");
				driver.findElement(By.className("signInBtn")).click();
				
				//css selectors
				//tagname.classname or .classname
				//tagname#id or #id
				//tagname[attribute='value']
				System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
				System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
				
				//click on forgot password
				driver.findElement(By.partialLinkText("Forgot")).click();
				
				driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("mounica");
				
				//for email use xpath
				driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Mo1@gmail.com");
				
				//for email use xpath with attribute-parent child indexing
				driver.findElement(By.xpath("//input[type='text'][2]")).sendKeys("Mo2@gmail.com");
				
				//for email use css selector with attribute-parent child indexing
				driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Mo3@gmail.com");
				
				//for phone number use tag names-indexing
				driver.findElement(By.xpath("//form/input[3]")).sendKeys("9849404055");
				
				//getting the text
				driver.findElement(By.cssSelector("form p")).getText();
				
				//customized css with regular expression
				//<input type="password" placeholder="Password" name="inputPassword" value="" xpath="1">
				driver.findElement(By.cssSelector("input[type*='pass]")).sendKeys("passsword");
				
				//customized xpath with regular expression
				//<button class="submit signInBtn" type="submit" xpath="1">Sign In</button>
				//give both the class names
				//driver.findElement(By.xpath("button[@class='submit signInBtn']")).click();
				//button[contains(@class,'submit'')]
				///for By.classname give only one class name
				
				
				//<div class="forgot-pwd-container">
				//<a href="#" style="" xpath="1">Forgot your password?</a>
				//</div>
				////div[contains(@class,'forgot')]/a
				
				//<div class="login-container" xpath="1">
				//<h2>Hello mounica,</h2>
				//<h1>Welcome to <strong style="color: rgb(255, 75, 43);">Rahul Shetty </strong>Academy</h1><p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.</p>
				//<button class="logout-btn">Log Out</button></div>
				//css div[class='login-container'] h2
				//xpath //div[@class='login-container']/h2
				
				//button text
				//<button class="logout-btn" xpath="1">Log Out</button>
				//xpath        //button[text()='Log Out'] or //*[text()='Log Out']
				//No css syntax for this
				
				
	}

}
