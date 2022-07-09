package udemy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingToCart02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		//Thread.sleep(3000);

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		String requiredItems[] = { "Brocolli", "Cucumber", "Beetroot", "Beans" };
		int n=0;

		for (int i = 0; i < products.size(); i++)
		{
			//Brocolli - 1 Kg
			//Brocolli , 1 Kg
			String formattedName=products.get(i).getText().split("-")[0].trim();  //extracting only name and removing space
			List<String> ListOfRequiredItems=Arrays.asList(requiredItems);     //converting array to list 
			if(ListOfRequiredItems.contains(formattedName))
			{
				n++;
				//click on Add to Cart button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(n==requiredItems.length) //if(n==ListOfRequiredItems.size())
					break;                  //no need of other iterations when our list is done iterating			
			}
			
		}
//**************************************//
	}

}
