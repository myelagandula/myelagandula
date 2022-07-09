package chromeOptionsAndSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesSettings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chromedriver.chromium.org/capabilities");
		driver.manage().deleteAllCookies(); //deletes all cookies
		driver.manage().deleteCookieNamed("SessionKey");//deletes specific cookie
		
	}

}
