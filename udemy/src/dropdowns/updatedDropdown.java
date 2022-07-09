package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		//Thread.sleep(2000); //dropdown may take 2 seconds to load all options
		
		/*int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}*/
		
		for(int i=1;i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
