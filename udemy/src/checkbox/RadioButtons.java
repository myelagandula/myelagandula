package checkbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1")); //prints true
		
		Assert.assertTrue(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1"));
		//driver.findElement(By.className("picker-second")).getAttribute("style").contains("1");
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		if(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1")){
			System.out.println("enabled");
		}
		else {
			System.out.println("return date calendar disabled");
		}

	}

}
