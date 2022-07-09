package calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarMonthDayinFuture {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(30);
		//closing the pop-up
		int getPopupSize = driver.findElements(By.xpath("//div[@class='sumome-react-svg-image-container']")).size();

		if(getPopupSize > 0)

		{

		   driver.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']")).click();

		}
		//April 23
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();


		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}


		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=dates.size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.className("day")).get(i).getText();
		if(text.equalsIgnoreCase("21"))
		{
		driver.findElements(By.className("day")).get(i).click();
		break;
		}

		}

	}
}
