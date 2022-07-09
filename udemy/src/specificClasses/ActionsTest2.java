package specificClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//PARENT AND CHILD WINDOW SWITCHING
		
		//Go to parent window. Click on link. Go to child window. Grab the username and enter in parent window.
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		String pId=itr.next();
		String cId=itr.next();
		driver.switchTo().window(cId);
		//xpath - //div[@class='col-md-6 text-left']/h2/span/strong
		//xpath Regex- //div[contains(@class,'col-md-6 text-left')]/h2/span/strong
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'col-md-6 text-left')]/h2/span/strong")).getText());
		//driver.findElement(By.xpath("//div[contains(@class,'text-left')]/h2/span/strong"));
		String extractedText=driver.findElement(By.xpath("//div[contains(@class,'col-md-6 text-left')]/h2/span/strong")).getText().split("&")[0].trim().split(" ")[0].trim();
		System.out.println(extractedText);
		driver.switchTo().window(pId);
		//enter username,password
		
	}

}
