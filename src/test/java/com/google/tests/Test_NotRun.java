package com.google.tests;

import org.testng.Assert;
// import org.testng.annotations.Test;

import io.qameta.allure.Step;

public class Test_NotRun {

	// #1
	@Step("Test - Test_NotRune")
	// @Test(groups = { "notrun" })
	public void test_HomePage_Title() throws Throwable {

		String act = "TRUE";
		String exp = act;

		System.out.println("### Test_NotRune ###");

		// Assert.assertEquals(actual, expected, message);
		Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
	}
}