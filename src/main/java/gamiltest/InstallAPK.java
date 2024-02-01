package gamiltest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class InstallAPK {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("appium:deviceName", "udid");
		options.setCapability("appium:udid", "853abf2b");
		options.setCapability("appium:platformVersion", "13");
//		options.setCapability("appium:appPackage", "com.example.c2c_service_provider_app");
//		options.setCapability("appium:appActivity", "com.example.c2c_service_provider_app.MainActivity");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		boolean IsAppInstalled= driver.isAppInstalled("com.example.c2c_service_provider_app");

		if(IsAppInstalled)
		{
			
//			driver.startActivity(new Activity("com.example.c2c_service_provider_app", "com.example.c2c_service_provider_app.MainActivity") );
			
		}
		
		
		

	
}
}