package calendar;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class makeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.className("langCardClose")).click();
		driver.findElement(By.xpath("//*[@class='lbl_input latoBold appendBottom10']")).click();
		
		int inputDay=10;
		String inputMonth="June 2023";
		
		ArrayList<String> displayMonths = new ArrayList<String>();
		
		
		while(!displayMonths.contains(inputMonth))
		{
			List<WebElement> twoMonths=driver.findElements(By.className("DayPicker-Caption"));
			for(WebElement eachMonth:twoMonths)
			{
				displayMonths.add(eachMonth.getText());		
			}
			driver.findElement(By.cssSelector("[aria-label='Next Month']")).click();
		}
		
		List<WebElement> days=driver.findElements(By.cssSelector("[class='DayPicker-Day']"));
		for(int i=0;i<days.size();i++)
		{
			if(days.get(i).getText().contains(String.valueOf(inputDay)))
			{
				days.get(i).click();
				break;
			}
		}
		
	}

}
