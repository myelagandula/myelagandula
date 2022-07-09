package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v97.page.Page.GetAppIdResponse;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentAddtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//2.add tomato 3 kg,mushroom 1 kg,pumpkin 2 kg
		String requiredItem[]= {"tomato","Mushroom","pumpkin"};
		int quantity=3;
		addItemsToCart(driver,requiredItem,quantity);
		System.out.println("items added successfully");
		
		
		
		
	}
	public static void addItemsToCart(WebDriver driver, String items[],int quantity) throws InterruptedException
	{
		List<WebElement> allNames=driver.findElements(By.xpath("//div/h4"));
		
		List<String> ItemsRequiredList=Arrays.asList(items);
		ItemsRequiredList.replaceAll(String::toLowerCase);
		int count=0;
		
		
		for(int i=0;i<allNames.size();i++)
		{
			String formattedName=allNames.get(i).getText().split("-")[0].trim().toLowerCase();
			if(ItemsRequiredList.contains(formattedName))
			{
				for(int q=1;q<quantity;q++)
				{
					driver.findElements(By.className("increment")).get(i).click();
				}				
				
				
				driver.findElements(By.cssSelector("[class='product-action'] button")).get(i).click();
				count++;
				if(count==ItemsRequiredList.size())
					break;
			}
			
		}
	}

}
