import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class doubt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//links in total web page
		System.out.println("Total links : "+driver.findElements(By.tagName("a")).size());
		
		
		//click each link in second column of footer
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		int secondColumnLinksSize=footer.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul/li")).size();
		System.out.println("Links in second column of footer : "+secondColumnLinksSize);
		//WebElement SecondcolumnDriver=footer.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		int x=1; int four=footer.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul/li/a")).size();
		for(int i=0;i<four;i++)
		{
			String clickOnEachTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footer.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul/li/a")).get(i).sendKeys(clickOnEachTab);
			x++;
			w.until(ExpectedConditions.numberOfWindowsToBe(x));
			
		}
		
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> itr=windowIds.iterator();
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
		
		}

}
