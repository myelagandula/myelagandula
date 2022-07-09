package udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntoduction{

	public static void main(String[] args) {
		
		//Invoking browser
		//Chrome- ChromeDriver
		//Methods -> close,get
		//create object of ChromeDriver class
		System.setProperty("webdriver.chrome.driver","E:\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.vertafore.com/");
		System.out.println("Title : "+driver.getTitle());
		System.out.println("CurrentUrl : "+driver.getCurrentUrl());
		driver.close();


	}

}
