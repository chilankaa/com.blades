package com.blades.tests;

import org.testng.annotations.Test;

import com.blades.base.Base;
import com.blades.pages.CreateCasePage;
import com.blades.pages.LoginPage;

public class CreateCaseTest extends Base{
	LoginPage login;
	CreateCasePage page;
	@Test
	public void newCaseCreation() {
		login= new LoginPage(driver);
		page=new CreateCasePage(driver);
		login.clickOnLogin();
		page.createNewCase("Sample", 2, 1, "Neurology", "cosmetic dermatology.","For review", "D:\\Doc1.pdf");
	}

}
