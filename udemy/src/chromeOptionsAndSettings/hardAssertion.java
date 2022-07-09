package chromeOptionsAndSettings;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class hardAssertion {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1900)");
		
		List<WebElement> links=	driver.findElements(By.cssSelector("[class='gf-li'] a"));
		//java method should call this url
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int rCode=conn.getResponseCode();
			Assert.assertTrue(rCode<400,"The broken links is "+link.getText()+"with response code "+rCode);
			//Hard assertion //if condition is not true, print the message
			
			
		}
		
		
		
	}

}
