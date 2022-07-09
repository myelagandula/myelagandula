package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(3000);
		
		//FROM
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("[text='Jaipur (JAI)']")).click();
		
		//TO
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation1_CTNR')] //a[@value='JSA']")).click();
	}

}
