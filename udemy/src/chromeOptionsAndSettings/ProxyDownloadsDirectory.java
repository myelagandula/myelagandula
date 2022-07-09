package chromeOptionsAndSettings;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProxyDownloadsDirectory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\\\Softwares/chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		
		
		//adding Extensions
//		ChromeOptions options = new ChromeOptions();
//		options.addExtensions(new File("/path/to/extension.crx"));
//		ChromeDriver driver = new ChromeDriver(options);
		
		
		//setting Proxy
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("myhttpproxy:3337");
		co.setCapability("proxy", proxy);
		
		//set download directory path
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		co.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=new ChromeDriver(co);
	}

}
