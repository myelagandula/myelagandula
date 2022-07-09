package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filterWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("beans");
		List<WebElement> resultList=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement>  filteredList=resultList.stream().filter(s->s.getText().contains("Beans")).collect(Collectors.toList());
		Assert.assertEquals(filteredList.size(),resultList.size());
	}

}
