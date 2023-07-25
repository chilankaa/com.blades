package com.blades.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	WebDriver driver;
	public GeneralUtilities(WebDriver driver) {
		this.driver=driver;
	}
public void selectByIndex(WebElement element, int index) {
	Select sel=new Select(element);
	sel.selectByIndex(index);
}
}
