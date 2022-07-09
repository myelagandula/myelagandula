package relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dimensionsWebElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameTextBox=driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(nameTextBox.getRect().getHeight());
		System.out.println(nameTextBox.getRect().getDimension().getHeight());
		
		System.out.println(nameTextBox.getRect().getDimension());  //gives width,height
		System.out.println(nameTextBox.getRect().getWidth());

	}

}
