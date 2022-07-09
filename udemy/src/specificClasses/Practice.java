package specificClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/popup.php");
		
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr=windowIds.iterator();
		
		String pId=driver.getWindowHandle();
		String parent=itr.next();
		String cId=itr.next();
		driver.switchTo().window(cId);
		driver.findElement(By.cssSelector("[name='emailid']")).sendKeys("mouni.y18@gmail.com");
		driver.findElement(By.cssSelector("[name='btnLogin']")).click();
		System.out.println(driver.findElement(By.xpath("//tr/td/h3")).getText());
		driver.close();
		driver.switchTo().window(pId);
		driver.switchTo().window(parent);
		String textInParent=driver.findElement(By.cssSelector("[class='barone']")).getText();
		System.out.println(textInParent);
		
//		String pId=itr.next();
//		String cId=itr.next();
//		
//		driver.switchTo().window(cId);
//		driver.findElement(By.cssSelector("[name='emailid']")).sendKeys("mouni.y18@gmail.com");
//		driver.findElement(By.cssSelector("[name='btnLogin']")).click();
//		System.out.println(driver.findElement(By.xpath("//tr/td/h3")).getText());
//		
//		driver.close();
//		driver.switchTo().window(pId);
//		System.out.println(driver.findElement(By.linkText("Click Here")).getText());
		
	}

}
