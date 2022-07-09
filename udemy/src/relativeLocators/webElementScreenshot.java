package relativeLocators;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameTextBox=driver.findElement(By.cssSelector("[name='name']"));
		nameTextBox.sendKeys("mounica");
		File file=nameTextBox.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("textinName.png"));
		
	}

}
