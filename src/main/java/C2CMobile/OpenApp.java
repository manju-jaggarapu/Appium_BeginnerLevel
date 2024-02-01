package C2CMobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class OpenApp {

	public static void main(String[] args) throws MalformedURLException {
		OpenApp C2C = new OpenApp();
		C2C.OpenServiceProvider();
	}

	public WebDriver driver;

	public void OpenServiceProvider() throws MalformedURLException {
		driver = initializeDriver();
//		LaunchApp();
		//quitDriver();
	}

	private WebDriver initializeDriver() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("appium:deviceName", "udid");
		options.setCapability("appium:udid", "853abf2b");
		options.setCapability("appium:platformVersion", "13");
		options.setCapability("appium:app", "C:/Users/Manju Jaggarapu/Downloads/app-release-sprint-13-v7.apk");
//		options.setCapability("appium:appWaitActivity", "com.example.c2c_service_provider_app.MainActivity");


//		options.setCapability("appium:appPackage", "com.example.c2c_service_provider_app");
//		options.setCapability("appium:appActivity", "com.example.c2c_service_provider_app.MainActivity");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		return driver;
	}

//	private void LaunchApp()  {
//		
//		//Click on Individual Login
//		WebElement Login1 = driver.findElement(AppiumBy.accessibilityId("Individual Login"));
//		Login1.click();
//		
//	
//		
//		WebElement UserID=driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]"));
//		UserID.sendKeys("8919519966");
////		String result = driver.findElement(AppiumBy.accessibilityId("Individual Login")).getText();
////		System.out.println("Login Page: " + result);
//	}



}
