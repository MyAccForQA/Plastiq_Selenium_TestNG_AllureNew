package com.google;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Title {

	private static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/geckodriver/ios/ch/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		WebElement search = driver.findElement(By.name("q"));
		
		search.sendKeys("test automation is awesome" + Keys.ENTER);

		System.out.println("Title is " + driver.getTitle());
		
		driver.quit();
	}
}