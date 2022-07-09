import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class interviewQuestions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. count total no. of links in the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.count no. of links in footer
		System.out.println(driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());
		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
		
		
		//WebElement footer=driver.findElement(By.id("gf-BIG")); limiting web driver scope
		//footer.findElements(By.tagName("a")).size();
		
		//3.count no. of links in first column links in footer
		System.out.println(driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li")).size());
//		System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li")).size());
//		WebElement footer=driver.findElement(By.id("gf-BIG"));
//		System.out.println(footer.findElements(By.xpath("//table/tbody/tr/td[1]/ul")).size());
		
		//4.click on each link and check if the pages are opening
		System.out.println("Number of links to be opened are :");
		System.out.println(driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li")).size());
		int n=driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li")).size();
		//oth index link is not working
//		for(int i=1;i<n;i++)
//		{
//		  driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li")).get(i).click();
//		  Set<String> windowIds=driver.getWindowHandles();
//		  Iterator<String> itr=windowIds.iterator();
//		  String currentWindow=itr.next();
//		  driver.switchTo().window(currentWindow);
//		  driver.switchTo().defaultContent();
//		}
		
//		for(int i=1;i<n;i++)
//		{
//		  driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li")).get(i).click();
//		  String currentWindowHandle=driver.getWindowHandle();
//		  driver.switchTo().window(currentWindowHandle);
//		  driver.navigate().back(); //will wait wach time to load
//		}
		
		for(int i=1;i<n;i++)
		{
		  
		  //open each link in new tab
		  //After opening all tabs, at the end go to each tab and get the title of it
			//open each link in new tab by clicking ctrl and clicking on link
			String clickingString=Keys.chord(Keys.CONTROL,Keys.ENTER);
			//driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li")).get(i).click(); instead of click, use keyboard event using sendKeys()
			driver.findElements(By.xpath("//table/tbody/tr/td[1]/ul/li[@class='gf-li']")).get(i).sendKeys(clickingString);
			Thread.sleep(5000);
		}
		//end of for loop- opens all tabs
		
			Set<String> windowIds=driver.getWindowHandles();
			Iterator<String> itr=windowIds.iterator();
			while(itr.hasNext())
			{
				//itr.next() results a string- window Id
				driver.switchTo().window(itr.next());
				System.out.println(driver.getTitle());
			}
		
		
		
		
	}

}
