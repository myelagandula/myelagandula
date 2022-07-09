package calendar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FromToCalendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/#date-range");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("//input[@name='from']")).click();
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//selecting a date in FROM
		String fromMonth="Jun",fromDate="25";
		//div[@contains(class,'group-first')] //div[@class='ui-datepicker-month']
		Select fromDropdown=new Select(driver.findElement(By.xpath("//div[contains(@class,'group-first')] //div[@class='ui-datepicker-title']/select")));
		fromDropdown.selectByVisibleText(fromMonth);
		//List<WebElement> fromDays=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));//gives 3 months dates
		List<WebElement> fromDays=driver.findElements(By.xpath("//div[contains(@class,'group-first')]//td[@data-handler='selectDay']"));
		for(int i=0;i<fromDays.size();i++)
		{
					
			String iteratingNumber=fromDays.get(i).getText();
			if(iteratingNumber.equals("24"))
			{
				
				fromDays.get(i).click();
				break;//if this is not present, it still wants to iterate, but that calendar is not available for ietrating- staleElementReference Exception
				
			}
		}
		
		
		//selecting a date in To
		String toMonth="Dec",toDate="31";
		driver.findElement(By.id("to")).click();
		Select toDropdown=new  Select(driver.findElement(By.xpath("//div[contains(@class,'group-first')]//select")));
		toDropdown.selectByVisibleText(toMonth);
		List<WebElement> toDays=driver.findElements(By.xpath("//div[contains(@class,'group-first')]//td[@data-handler='selectDay']"));
		for(int j=0;j<toDays.size();j++)
		{
			if(toDays.get(j).getText().equals(toDate))
			{
				toDays.get(j).click();
				break;
			}
		}
		
		
	}

}
