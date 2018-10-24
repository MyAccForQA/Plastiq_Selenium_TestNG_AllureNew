package com.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class Page_Home {

	@FindBy(name = "q")
	private WebElement search;

	// constructor
	public Page_Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@Step("findAndFillField_Search")
	public WebElement findAndFillField_Search(String key) {

		search.sendKeys(key + Keys.ENTER);

		return search;
	}
}