package calendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(9000);
		
		
		driver.findElement(By.id("travel_date")).click();
		
		
		//selecting month
		String inputMonth="Dec";
		List<WebElement> futureMonths=driver.findElements(By.className("month"));
		for(int m=0;m<futureMonths.size();m++)
		{
			String eachfutureMonth=driver.findElements(By.className("month")).get(m).getText();
			if(eachfutureMonth.equalsIgnoreCase("dec"))
			{
				driver.findElements(By.className("month")).get(m).click();
				break;
			}
		}
		
		
		
		String inputDay="25";
		
		//Grab comon attribute, put into a list and iterate
		List<WebElement> futureDates=driver.findElements(By.className("day"));
		for(int i=0;i<futureDates.size();i++)
		{
			String textOfeachFutureDay=driver.findElements(By.className("day")).get(i).getText();
			if(textOfeachFutureDay.equals(inputDay)) 
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		//clicked on day 25

	}

}
