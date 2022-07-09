import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		//scrolling within table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");//for vertical scroll
		js.executeScript("document.querySelector('.tableFixHead').scrollLeft=5000");//for horizontal scroll
		
		
		//add amount which is last column in the table
		//xpath for Amount column total 9 values is //div[@class='tableFixHead' ] //td[4]
		//css for the same is div[class='tableFixHead' ] td:nth-child(4)
		//This is used if there are more than one table
		//If there is only one table in the page use //td[4] as xpath (OR) td:nth-child(4)
		List<WebElement> amountValues=driver.findElements(By.cssSelector("div[class='tableFixHead' ] td:nth-child(4)"));
		int totalSum=0;
		for(int i=0;i<amountValues.size();i++)
		{
			String numberInString=driver.findElements(By.cssSelector("div[class='tableFixHead' ] td:nth-child(4)")).get(i).getText();
			int numberInInt=Integer.parseInt(numberInString);
			totalSum=totalSum+numberInInt;
		}
		
		System.out.println(totalSum);
		int totalFromPage=Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		//without parsing into int, if we give directly in assert, it is giving error
		Assert.assertEquals(totalSum,totalFromPage);
		
	}

}
