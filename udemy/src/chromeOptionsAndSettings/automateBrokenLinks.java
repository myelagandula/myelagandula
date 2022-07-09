package chromeOptionsAndSettings;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.Connection;
import org.openqa.selenium.net.Urls;

public class automateBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Inspect->Network->XHR click on broken link, go to All->see the status code : if status code>400
		
		//1.get all URLs tied to the links
		String url=driver.findElement(By.linkText("SoapUI")).getAttribute("href");
		//2.java method should call URL and get the status code
		HttpsURLConnection con=(HttpsURLConnection)new URL(url).openConnection();
		con.setRequestMethod("HEAD");
		con.connect();
		int responseCode=con.getResponseCode();
		System.out.println(responseCode);
	}

}
