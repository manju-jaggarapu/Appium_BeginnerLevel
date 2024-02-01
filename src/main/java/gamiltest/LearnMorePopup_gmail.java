package gamiltest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class LearnMorePopup_gmail {

		public void takeMeToGmail(WebDriver driver) {
			WebElement TakeMe = driver.findElement(AppiumBy.id("com.google.android.gm:id/action_done"));
			TakeMe.click();
			//Click Allow in notification popup
			WebElement Allow=driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
			Allow.click();
			//Click on LearnMore 
			WebElement LearnMore=driver.findElement(AppiumBy.id("com.google.android.gm:id/learn_more_button"));
			LearnMore.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			//Click on close icon in Help
			WebElement Close=driver.findElement(AppiumBy.id("Notification__add_email_gmail__Timestamp"));
			Close.click();
			
		}

	}


