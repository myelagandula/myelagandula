package udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingToCart01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		//Thread.sleep(3000);
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getText().contains("Beetroot"))
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				break;
			}
		}
		
		
		
	}

}
