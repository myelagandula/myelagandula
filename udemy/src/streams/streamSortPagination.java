package streams;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class streamSortPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> priceList;
		do {
			List<WebElement> namesList=driver.findElements(By.xpath("//tr/td[1]"));
			priceList=namesList.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
			if(priceList.size()<1)
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}while(priceList.size()<1);
		
		priceList.forEach(p->System.out.println(p));
		
		
	}
	public static String getPrice(WebElement s)
	{
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
