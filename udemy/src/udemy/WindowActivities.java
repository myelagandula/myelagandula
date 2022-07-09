package udemy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		//To maximize window
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		//To make window fullscreen
		driver.get("https://www.google.com/");
		driver.manage().window().fullscreen();
		
		//To navigate from one page to another
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(5000);
		
		//get will open page and wait until window is fully loaded
		//navigate does not have this mechanism
		//So first time get() method is used instead of navigate()
		
		//open google and go to other page and come back to google and go to that other page
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();

	}

}
