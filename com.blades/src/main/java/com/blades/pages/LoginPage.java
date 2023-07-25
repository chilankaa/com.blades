package com.blades.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blades.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties=new Properties();
	@FindBy(xpath = "//input[@type='text']")
	private WebElement emailElement;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordELement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginElement;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickOnLogin() {
		
		emailElement.sendKeys(properties.getProperty("email"));
		passwordELement.click();
		passwordELement.sendKeys(properties.getProperty("password"));
		loginElement.click();
	}
}
