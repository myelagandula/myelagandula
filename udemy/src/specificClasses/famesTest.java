package specificClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class famesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\\\Softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//Drag and drop
		WebElement frameElement=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement); //driver.switchTo().frame(0);
		//frames with id?
		//System.out.println(driver.findElement(By.id("draggable")).getText());
		Actions ac=new Actions(driver);
		ac.dragAndDrop(driver.findElement(By.cssSelector("div#draggable")), driver.findElement(By.cssSelector("#droppable"))).build().perform();
		
		//To find Number of frames in page
		driver.findElements(By.tagName("iframe")).size();
		
		//to take the control out of frame
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Prevent propagation")).click();
		
	}

}
