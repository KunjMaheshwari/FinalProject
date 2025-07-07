package testBase;
 
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
 
public class BaseClass {
	public WebDriver driver;
 
	public Logger logger;
 
	public Properties p;
 
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
 
		// Loading the config.properties
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
 
		//logger = LogManager.getLogger(this.getClass());
 
		// If the execution is Remote in the config.properties file then ->
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
 
			capabilities.setPlatform(Platform.WIN11);
 
			// OS
 
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching os");
				return;
			}
 
			// BROWSER
			
			switch (br.toLowerCase()) {
			case "chrome":
				  ChromeOptions Roptions = new ChromeOptions();
			      Roptions.addArguments("--disable-blink-features=AutomationControlled"); // Disable automation detection
			      Roptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Remove automation flag
			      Roptions.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
				  capabilities.setBrowserName("chrome");
				  Roptions.merge(capabilities);
				  driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),Roptions);
				break;
			case "edge":
				  EdgeOptions Eoptions = new EdgeOptions();
			      Eoptions.addArguments("--disable-blink-features=AutomationControlled"); // Disable automation detection
			      Eoptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Remove automation flag
			      Eoptions.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
			      capabilities.setBrowserName("edge");
			      Eoptions.merge(capabilities);
				  driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),Eoptions);
				break;
			default:
				System.out.println("Choose a valid browser");
				return;
			}
			
			
 
		}
 
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			// If the execution is local in the config.properties file then below browser
			// setup is correct.
			System.out.println(br);
			switch (br.toLowerCase()) {
			case "chrome":
				  ChromeOptions options = new ChromeOptions();
			      options.addArguments("--disable-blink-features=AutomationControlled"); // Disable automation detection
			      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Remove automation flag
			      options.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
				  driver = new ChromeDriver(options);
				break;
			case "edge":
				  EdgeOptions Eoptions = new EdgeOptions();
			      Eoptions.addArguments("--disable-blink-features=AutomationControlled"); // Disable automation detection
			      Eoptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Remove automation flag
			      Eoptions.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
			      driver = new EdgeDriver(Eoptions);
				break;
			default:
				System.out.println("Choose a valid browser");
				return;
			}
		}
 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		//driver.get("https://www.zigwheels.com/");
		driver.manage().window().maximize();
	}
 
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}