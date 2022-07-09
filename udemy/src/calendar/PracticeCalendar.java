package calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		
		//closing pop up
//		int getPopupSize = driver.findElements(By.xpath("//div[@class='sumome-react-svg-image-container']")).size();
//		if(getPopupSize > 0)
//		   driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']")).click();
//		
		
		//input November 18
		
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

		//selecting month
		//if middle part does not contain inputMonth, keep clicking on next
		String inputMonth="November";
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains(inputMonth))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']"));
		}
		//selecting day
		int inputDay=18;
		
		List<WebElement> days=driver.findElements(By.cssSelector("[class='day']"));
		for(int i=0;i<days.size();i++)
		{
			if(days.get(i).getText().equals(String.valueOf(inputDay))) 
			{
				days.get(i).click();break;
			}
				
		}
			
		
		
	}

}
