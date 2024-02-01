package gamiltest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class LaunchGmail {

	public static void main(String[] args) throws Exception {

		LaunchGmail mail = new LaunchGmail();
		mail.gmail();

	}

	public void gmail() throws Exception {
//		StartServer();
		WebDriver driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		initialPage(driver);

	}

//	private void StartServer()
//
//	{
//
//		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//		service.start();
//	}

	private WebDriver initializeDriver() throws MalformedURLException {

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

	private void initialPage(WebDriver driver) throws Exception {

		WebElement Gotit = driver.findElement(AppiumBy.id("com.google.android.gm:id/welcome_tour_got_it"));
		Gotit.click();
		addAnotherEmail(driver);
	}

	private void addAnotherEmail(WebDriver driver) throws InterruptedException {

		// Click add another email
		WebElement addemail = driver.findElement(AppiumBy.id("com.google.android.gm:id/setup_addresses_add_another"));
		addemail.click();

		// click google
		WebElement Google = driver.findElement(AppiumBy.xpath(
				"(//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/account_setup_item\"])[1]"));
		Google.click();
		learnMorePopup(driver);
	}

	private void learnMorePopup(WebDriver driver) throws InterruptedException {
		// click Learn more
		WebElement LearnMore = driver
				.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"learnMore\"]"));
		LearnMore.click();
		

		// click Close in learn more pop_up
		WebElement PopupClose = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Close\"]"));
		PopupClose.click();
		forgotPwd(driver);
	}

	private void forgotPwd(WebDriver driver) throws InterruptedException {
		// click Forgot password link
		WebElement Forgot = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Forgot email?\"]"));
		Forgot.click();

		// enter email or phone number
		WebElement Email = driver
				.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"recoveryIdentifierId\"]"));
		// "//android.view.View[@resource-id=\"view_container\"]/android.view.View/android.view.View/android.view.View/android.view.View"));
		Email.click();
		Email.sendKeys("8919519966");

		// click on Next button

		WebElement Next = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Next\"]"));
		Next.click();

	}

}
