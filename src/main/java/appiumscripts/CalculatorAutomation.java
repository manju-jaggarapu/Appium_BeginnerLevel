package appiumscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorAutomation {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		CalculatorAutomation calculator = new CalculatorAutomation();
		calculator.runCalculatorTest();
	}

	public WebDriver driver;

	public void runCalculatorTest() throws MalformedURLException {
		driver = initializeDriver();
		performAddition(2, 5);
		clearResult();
		performSubtraction(9, 3);
		quitDriver();
	}

	private WebDriver initializeDriver() throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("appium:deviceName", "udid");
		options.setCapability("appium:udid", "853abf2b");
		options.setCapability("appium:platformVersion", "13");
		options.setCapability("appium:appPackage", "com.oneplus.calculator");
		options.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		return driver;
	}

	private void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	private void clearResult() {
		WebElement clearButton = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/img_clr"));
		clearButton.click();
	}

	private void performAddition(int operand1, int operand2) {
		WebElement digit2 = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_2"));
		WebElement digit5 = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5"));
		WebElement plusButton = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/op_add"));
		WebElement equalsButton = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/img_eq"));

		digit2.click();
		plusButton.click();
		digit5.click();
		equalsButton.click();

		String result = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/result")).getText();
		System.out.println("Addition Result: " + result);
	}

	private void performSubtraction(int operand1, int operand2) {
		WebElement digit9 = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_9"));
		WebElement digit3 = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_3"));
		WebElement minusButton = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/img_op_sub"));
		WebElement equalsButton = driver.findElement(AppiumBy.id("com.oneplus.calculator:id/img_eq"));

		digit9.click();
		minusButton.click();
		digit3.click();
		equalsButton.click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Subtraction Result: " + result);
	}
}
