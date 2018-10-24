package com.google.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Search {

	@FindBy(xpath = "//div[@class='rc']") // list
	private List<WebElement> delete;

	// constructor
	public Page_Search(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}