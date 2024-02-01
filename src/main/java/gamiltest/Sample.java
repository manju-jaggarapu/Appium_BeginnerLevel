package gamiltest;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Sample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub


		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("appium:deviceName", "udid");
		options.setCapability("appium:udid", "853abf2b");
		options.setCapability("appium:platformVersion", "13");
		options.setCapability("appium:appPackage", "com.google.android.gm");
		options.setCapability("appium:appActivity", "com.google.android.gm.ConversationListActivityGmail");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	}
	
}
