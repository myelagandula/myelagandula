package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown=new Select(staticDropdown);
		//System.out.println(dropdown.getAllSelectedOptions());
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
	}

}
