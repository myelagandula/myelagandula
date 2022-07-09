package chromeOptionsAndSettings;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class httpsPrivacyError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(co);

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
	}

}
