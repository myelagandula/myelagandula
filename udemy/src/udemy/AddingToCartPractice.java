package udemy;



import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class AddingToCartPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//implicit wait : driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String inputProducts[]={"Tomato","beans"};
		addItemsToCart(driver,inputProducts);
		driver.findElement(By.className("cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		String inputPromoCode="rahulshettyacademy";
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys(inputPromoCode);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		
		
	}
	
	public static void addItemsToCart(WebDriver driver,String[] inputProds)
	{
		List<WebElement> allProductNames=driver.findElements(By.xpath("//*[@class='product-name']"));
		int n=0;
		//i= 5&6
		for(int i=0;i<allProductNames.size();i++)
		{
			String eachProduct=allProductNames.get(i).getText();  //Tomato - 1 Kg
			String formattedProduct=eachProduct.split("-")[0].trim().toLowerCase(); //tomato
			
			List<String> inputProductsList=Arrays.asList(inputProds);
			inputProductsList.replaceAll(String::toLowerCase);  //{"tomato","beans"}
		
			
			if(inputProductsList.contains(formattedProduct))
				
			{
				System.out.println("-------------");
				System.out.println(formattedProduct);
				n++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(n==inputProductsList.size())
					break;
			}
		}
	}

}
