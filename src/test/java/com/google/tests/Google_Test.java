package com.google.tests;

import org.testng.Assert;
// import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.pages.Page_Home;
import com.google.utilities.Config;

import io.qameta.allure.Step;

public class Google_Test extends BeforeAndAfter {

	// #1
	@Step("Test - test_Page_Search_Title")
	@Test(groups = { "title" })
	public void test_Page_Search_Title() throws Throwable {
		
		Page_Home home = new Page_Home(driver);
		home.findAndFillField_Search(Config.getPropertyFromFile("search")); // test automation is awesome
		
		System.out.println("Title is " + driver.getTitle());
		
		// Page_Search search = new Page_Search(driver, wait);

		String exp = Config.getPropertyFromFile("search") + " - Google Search";
		String act = driver.getTitle();

		// Assert.assertEquals(actual, expected, message);
		Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
	}
}