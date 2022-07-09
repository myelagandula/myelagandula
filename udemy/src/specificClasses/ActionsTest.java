package specificClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions ac=new Actions(driver);
		
		
		//moving to search textbox
		//press shift button and write text in CAPS
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		
		//select text that you entered in search - double click on text entered
		ac.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		WebElement element=driver.findElement(By.id("nav-link-accountList"));
		ac.moveToElement(element).build().perform(); //moves to specific element
		//rightclick
		ac.moveToElement(element).contextClick().build().perform();
		
	}

}
