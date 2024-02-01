import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Test {

	public static void main(String[] args) throws Exception {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setCapability("appium:automationName", "uiautomator2");
		options.setCapability("appium:deviceName", "udid");
		options.setCapability("appium:udid", "853abf2b");
		options.setCapability("appium:platformVersion", "13");
		options.setCapability("appium:appPackage", "com.oneplus.calculator");
		options.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
			    
			AndroidDriver driver = new AndroidDriver(
			    new URL("http://127.0.0.1:4723"), options
			);
			
			// Locate calculator elements
		
			WebElement digit9= driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_9"));
			WebElement addbutton= driver.findElement(AppiumBy.id("com.oneplus.calculator:id/op_add"));
			WebElement digit6= driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_6"));
			WebElement equalsbutton=driver.findElement(AppiumBy.id("com.oneplus.calculator:id/img_eq"));
			WebElement result= driver.findElement(AppiumBy.id("com.oneplus.calculator:id/result"));
			
			// Perform a simple addition operation (e.g., 9 + 6)
			digit9.click();
			addbutton.click();
			digit6.click();
			equalsbutton.click();
			
	        // Get the result and print it
			
			String resulttext=result.getText();
			System.out.println("Addition of two digits Result: ");
			
			/*
			 * if(result!= null) { System.out.println("The addition of 9+6 is equals to " +
			 * result.getText()); }
			 * 
			 */
			
			//multiplication
			
//			driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_8")).click();
			
			// Create a WebDriverWait with a timeout

//			WebDriverWait wait = new WebDriverWait(driverWait, 10); // Wait up to 10 seconds
//			WebElement element = wait.until(ExpectedCondition.visibilityOfElementLocated(AppiumBy.id("learnMore")));

				
			}		
	}


