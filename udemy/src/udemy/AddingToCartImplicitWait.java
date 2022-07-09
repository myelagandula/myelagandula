package udemy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingToCartImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//after creating driver object, give implicit wait
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); This TimeUnit is deprecated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String items[]= {"Cauliflower","Carrot","Tomato"};
		addItems(driver,items);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//Thread.sleep(3000);
		String promocode="rahulshettyacademy";
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promocode);
		driver.findElement(By.cssSelector(".promoBtn")).click();
		//Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}
	public static void addItems(WebDriver driver,String items[])
	{
		List<WebElement> fullNames=driver.findElements(By.cssSelector(".product-name"));
		int n=0;
		for(int i=0;i<fullNames.size();i++)
		{
			String formattedName=fullNames.get(i).getText().split("-")[0].trim();
			//formattedName is Cauliflower
			List<String> itemsList=Arrays.asList(items);
			if(itemsList.contains(formattedName))
			{
				n++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(n==items.length)
					break;
			}
		}
	}
	
}
