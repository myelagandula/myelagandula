package checkbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class currentDateCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='IXY']")).click();
		//xpath with regular expression
		//div[contains(@id,'destinationStation1_CTNR') //a[@value='IXY']//]
		
		//selecting current date from calendar using class name
		//driver.findElement(By.className("ui-state-highlight")).click();
		
		//selecting current date from calendar using css selector ; for xpath give both class names
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		//printing the value
		System.out.println("withAtrribute : "+driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).getAttribute("value"));
		System.out.println("with getText : "+driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).getText());
	
		
		//or driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		//skipping tag name a  and no spaces for classnames
		//customized xpath requires both the class names //a[@class='ui-state-default ui-state-highlight']

	}

}
