package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class streamSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on veg/fruit name column
		//grab the names into a list
		//sort it
		//compare if the two lists are same
		
		//1.click on veg/fruit name column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//xpath : //span[text()='Veg/fruit name']
		
		//2.grab names into a list
		List<WebElement> columnList=driver.findElements(By.xpath("//tr/td[1]"));
		
		//3.sort it
		List<String> originalList=columnList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList=columnList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4.compare the two lists
		//Assert.assertTrue(originalList.equals(sortedList));
		
		/****************************************************************/
		
		//scan the name column, if its brinjal, print its price
		List<WebElement> nameList=driver.findElements(By.xpath("//tr/td[1]"));
		System.out.println("printing names of vegetables :");
		nameList.forEach(n->System.out.println(n.getText()));
		
		List<String> priceList=nameList.stream().filter(s->s.getText().contains("Brinjal")).map(s->getPrice(s)).collect(Collectors.toList());
		priceList.forEach(p->System.out.println(p));
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
