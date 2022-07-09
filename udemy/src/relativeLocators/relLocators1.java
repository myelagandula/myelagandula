package relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class relLocators1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//print label above Email textbox
		WebElement emailBox=driver.findElement(By.cssSelector("[name='email']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(emailBox)).getText());
		
		//click submit button below dob textbox
		WebElement dobLabel=driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		driver.findElement(with(By.tagName("input")).below(dobLabel)).click();
		
		
		//Assert.assertEquals("Success! The Form has been submitted successfully!.",driver.findElement(By.className("alert-dismissible")).getText());
		
		//check checkbox to the left of "check me out if you love icecream"
		WebElement checkboxLabel=driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLabel)).click();
		
		
		//print the label of first radio button to the right of first radio button
		WebElement radioButton=driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
		
		
	}

}
