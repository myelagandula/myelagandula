package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("can");
		Thread.sleep(2000);
		List<WebElement> results=driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
		System.out.println("Total options for selected text : "+results.size());
		for(WebElement result:results) {
			if(result.getText().equalsIgnoreCase("CANADA")){
				//System.out.println(result.getText());
				result.click();
				
				break;
				
			}
		}
		
		
		//comes out of for loop after break;
		System.out.println("after for loop");
		System.out.println(driver.findElement(By.id("autosuggest")).getText());
		System.out.println("getAttribute : "+driver.findElement(By.id("autosuggest")).getAttribute("value"));
		System.out.println(driver.findElement(By.id("autosuggest")).getText());
		//in debug mode, it is showing different output
	}

}
