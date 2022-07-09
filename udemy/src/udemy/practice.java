package udemy;

import java.sql.Driver;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		String items[]= {"cucumber","Beans","carrot"}; int quantity=3;
		addItems(driver,items,quantity);
		System.out.println("items added successdully");
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		String code="rahulshettyacademy";
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter')]")).sendKeys(code);
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		
	}
	
	public static void addItems(WebDriver driver,String[] items,int quantity)
	{
		List<String> itemsList=Arrays.asList(items);
		itemsList.replaceAll(String::toLowerCase);
		int count=0;
		List<WebElement> ItemsAvailable =driver.findElements(By.cssSelector("h4[class='product-name']"));
		for(int i=0;i<ItemsAvailable.size();i++)
		{
			String formattedName=ItemsAvailable.get(i).getText().split(" ")[0].trim().toLowerCase();
			if(itemsList.contains(formattedName))
			{
				for(int j=1;j<quantity;j++)
				{
					driver.findElements(By.cssSelector("[class='increment']")).get(i).click();  //click 2 times
					
				}
				driver.findElements(By.cssSelector("[class='product-action'] button")).get(i).click();
				count++;
				if(count==itemsList.size())
					break;
			}
		}
	}
}
