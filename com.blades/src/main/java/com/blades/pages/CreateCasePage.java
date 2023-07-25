package com.blades.pages;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blades.utilities.GeneralUtilities;

public class CreateCasePage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='Case of the Week']")
	private WebElement caseElement;
	@FindBy(xpath = "//i[@class='fas fa-plus']")
	private WebElement createELement;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement titleElement;
	@FindBy(xpath="//select[@name='week']")
	private WebElement weekElement;
	@FindBy(xpath="//select[@name='year']")
	private WebElement yearElement;
	@FindBy(xpath="//div[text()='Select Category']")
	private WebElement categoryElement;
	@FindBy(xpath="//div[text()='Select Speciality']")
	private WebElement specialityElement;
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionElement;
	@FindBy (xpath = "//span[text()='Drop files here to upload']")
	private WebElement fileElement;
	@FindBy (xpath = "//a[@id='createcasebutton']")
	private WebElement publishElement;

	public CreateCasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewCase(String title, int week, int year, String category, String speciality,String desc, String path) {
		GeneralUtilities gu=new GeneralUtilities(driver);
		caseElement.click();
		createELement.click();
		
		titleElement.sendKeys(title);
		gu.selectByIndex(weekElement, week);
		gu.selectByIndex(yearElement, year);
		categoryElement.click();
		WebElement categorValue=driver.findElement(By.xpath("//span[contains(text(),'"+ category+"')]"));
		categorValue.click();
		specialityElement.click();
		WebElement specialityValue=driver.findElement(By.xpath("//span[contains(text(),'"+ speciality+"')]"));
		specialityValue.click();
		descriptionElement.click();
		descriptionElement.sendKeys(desc);
		fileElement.click();
		File choose=new File(path);
		fileElement.sendKeys(choose.getAbsolutePath());
		fileElement.sendKeys(path);
//		publishElement.click();
	}
}
