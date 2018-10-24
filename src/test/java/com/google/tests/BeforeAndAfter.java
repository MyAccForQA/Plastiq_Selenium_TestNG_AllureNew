package com.google.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.utilities.Config;

import io.qameta.allure.Step;
import io.qameta.allure.Attachment;

public class BeforeAndAfter {

	public WebDriver driver;
	// private static final long VISIBILITY_TIMEOUT = 30;

	@Step("BeforeAndAfter - @BeforeMethod - This method would execute once before run")
	@BeforeMethod // This method would execute once the test would complete
	public void setUpBeforeMethod() {
		driver = getInstance();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// wait = new WebDriverWait(driver, VISIBILITY_TIMEOUT);
		driver.manage().window().maximize();
		driver.get(Config.getPropertyFromFile("url"));
	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	@Attachment(value = "--------", type = "image/png")
	public byte[] makeScreenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "image/png")
	public byte[] makeScreenShot(String tmp) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	@Step("BeforeAndAfter - @AfterMethod - This method would execute once after run")
	@AfterMethod // This method would execute once after run
	public void setDownAfterMethod() {
		makeScreenShot();

		driver.quit();
	}

	@Step("BeforeAndAfter - getInstance")
	public WebDriver getInstance() {

		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {

			// read - -DdriverType
			String driverTypeRead = Config.getPropertyFromTerminal("driverType").toLowerCase();

			// if '-DdriverType' is not present in terminal read in file
			if (driverTypeRead == null)
				driverTypeRead = Config.getPropertyFromFile("browser");

			// switch (driverTypeRead) {
			if (driverTypeRead.equals("ch") || (driverTypeRead.equals("chrome"))) {
				System.setProperty("webdriver.chrome.driver", Config.getPropertyFromFile("mainPathToGeckoDriver")
						+ Config.getPropertyFromFile(Config.getOS() + "ch"));
				driver = new ChromeDriver();
			} else if (driverTypeRead.equals("ff") || (driverTypeRead.equals("firefox"))) {
				System.setProperty("webdriver.gecko.driver", Config.getPropertyFromFile("mainPathToGeckoDriver")
						+ Config.getPropertyFromFile(Config.getOS() + "ff"));
				driver = new FirefoxDriver();
			} else { // no yet - ie or safari
				System.setProperty("webdriver.chrome.driver", Config.getPropertyFromFile("mainPathToGeckoDriver")
						+ Config.getPropertyFromFile(Config.getOS() + "ch"));
				driver = new ChromeDriver();
			}
		}
		return driver;
	}
}