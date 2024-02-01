package gamiltest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Capabilities {
	// Instance variable to store the object
//	public UiAutomator2Options options;

	public WebDriver initializeDriver() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("appium:deviceName", "udid");
		options.setCapability("appium:udid", "853abf2b");
		options.setCapability("appium:platformVersion", "13");
		options.setCapability("appium:appPackage", "com.google.android.gm");
		options.setCapability("appium:appActivity", "com.google.android.gm.ConversationListActivityGmail");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		return driver;
	}
	

//	public void appcapability(WebDriver driver) {
//		options.setCapability("appium:appPackage", "com.google.android.gm");
//		options.setCapability("appium:appActivity", "com.google.android.gm.ConversationListActivityGmail");
////	}

	public void initialPage(WebDriver driver) throws Exception {

		WebElement Gotit = driver.findElement(AppiumBy.id("com.google.android.gm:id/welcome_tour_got_it"));
		Gotit.click();
//			addAnotherEmail(driver);
	}

}
