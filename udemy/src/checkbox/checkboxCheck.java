package checkbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//css selector with regular expression
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		//for this webelement => xpath //input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']
		// xpath with regular expression //input[contains(@id,'SeniorCitizenDiscount')]
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isEnabled());
		
		//count number of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		//Since the instructor hasn't used parent-child relantionship concept and looked for all checkboxes, he got 6, when there are only 5:

		System.out.println(driver.findElements(By.xpath("//div[@id='discount-checkbox']//input[@type='checkbox']")).size());

		//This gets only checkboxes that we can actually interact with and are siblings of each other. This will give you only five.
	}	
		

}
