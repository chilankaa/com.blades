package com.blades.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.blades.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void launchBrowser() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		WebDriverManager.chromedriver().setup();

		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void quitBrowser() {
//		driver.quit();
	}
}
