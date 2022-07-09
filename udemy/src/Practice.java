import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");

		System.out.println("Total number of links :" + driver.findElements(By.tagName("a")).size());
		
		int size=driver.findElements(By.xpath("//div[@id='gf-BIG'] //td[4]/ul/li")).size();
		WebElement lastColumn=driver.findElement(By.xpath("//div[@id='gf-BIG'] //td[4]/ul"));
		for(int i=1;i<size;i++)
		{
			String click=Keys.chord(Keys.CONTROL,Keys.ENTER);
			lastColumn.findElements(By.tagName("a")).get(i).sendKeys(click);
			w.until(ExpectedConditions.numberOfWindowsToBe(i+1));
		}
	
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr=windowIds.iterator();
		itr.next();
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
	}

}
