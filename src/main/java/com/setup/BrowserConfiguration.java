package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.log4testng.Logger;
import io.qameta.allure.Description;
import java.net.SocketException;

public class BrowserConfiguration {

	public static WebDriver driver;
	static Logger log = Logger.getLogger(BrowserConfiguration.class);
	static PropertiesFile properties = new PropertiesFile();

	@Description("Browser Configuration")
	public synchronized static void setup()
	{	
		String browser = properties.readFile("Browser");
		String url = properties.readFile("URL");

		if(browser.equalsIgnoreCase("GoogleChrome"))
		{
			ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--headless");
			options.addArguments("incognito");
			driver = new ChromeDriver(options);
			System.out.println("Google chrome browser is launched");
			log.info("Google chrome browser is launched");
		} 
		else if(browser.equalsIgnoreCase("MozillaFirefox"))	
		{
			FirefoxOptions options = new FirefoxOptions();
		//	options.addArguments("--headless");
			options.addArguments("incognito");
			driver = new FirefoxDriver(options);
			System.out.println("Mozilla firefox browser is launched");
			log.info("Mozilla firefox browser is launched");
		}
		else if(browser.equalsIgnoreCase("MicrosoftEdge"))
		{
			EdgeOptions options = new EdgeOptions();
		//	options.addArguments("--headless");
			options.addArguments("incognito");
			System.out.println("Microsoft edge browser is launched");
			log.info("Microsoft edge browser is launched");
		}
		else
		{
			System.out.println("Browser is not launched");
			log.error("Browser is not launched");
		}
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Application is launched");
		log.info("Application is launched");
	}  
	@Description("Quit/Close Browser")
	public void close() throws java.net.SocketException
	{
		if(driver!=null)
		{
			driver.quit();	
		}
	}
} 
