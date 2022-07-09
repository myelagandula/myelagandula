package calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FutureYearMonthDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//closing pop-up
		int getPopupSize = driver.findElements(By.xpath("//div[@class='sumome-react-svg-image-container']")).size();
		if(getPopupSize > 0)
		   driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']")).click();
		
		String inputDay="30",inputYear="2023",inputMonth="May";
		driver.findElement(By.id("travel_date")).click();
		
		
		//selecting year
		driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).click();
		int PopupSize = driver.findElements(By.xpath("//div[@class='sumome-react-svg-image-container']")).size();
		if(PopupSize > 0)
		   driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']")).click();
		while(!driver.findElement(By.cssSelector("[class='datepicker-months'] [class='datepicker-switch']")).getText().equals("2023"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-months'] th[class='next']")).click();
		}
		
		Thread.sleep(3000);
		
		//selecting month
		List<WebElement> availableMonths=driver.findElements(By.cssSelector("[class='datepicker-months'] [class='month']"));
		for(int i=0;i<availableMonths.size();i++)
		{
			if(availableMonths.get(i).getText().equals(inputMonth))
			{
				availableMonths.get(i).click();
				break;
			}
		}
		
		//selecting day
		List<WebElement> allDays=driver.findElements(By.className("day"));
		for(int d=0;d<allDays.size();d++)
		{
			if(allDays.get(d).getText().equals(inputDay))
			{
				allDays.get(d).click();
				break;
			}
		}
	}

}
