package gamiltest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class SendEmail {

	public static void main(String[] args) throws Exception {
		Capabilities mail = new Capabilities();
		WebDriver driver = mail.initializeDriver();
		mail.initialPage(driver);
		SendEmail mail2 = new SendEmail();
		mail2.gmail(driver);
	}

	public void gmail(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		takeMeToGmail(driver);
		emailCompose(driver);
		subj(driver);
//		emailBody(driver);
		WebElement element = attachements(driver);
		attachFile(driver, element);
		sendEmail(driver);

	}

	private void takeMeToGmail(WebDriver driver) throws InterruptedException {
		WebElement TakeMe = driver.findElement(AppiumBy.id("com.google.android.gm:id/action_done"));
		TakeMe.click();
		// Click Allow in notification popup
		WebElement Allow = driver
				.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
		Allow.click();
		// Click Dismiss button
		WebElement Dismiss = driver.findElement(AppiumBy.id("com.google.android.gm:id/dismiss_button"));
		Dismiss.click();

	}

	private void emailCompose(WebDriver driver) throws InterruptedException {
		// Click Compose button
		WebElement Compose = driver.findElement(AppiumBy.id("com.google.android.gm:id/compose_button"));
		Compose.click();
		// get from mail address from the From filed
		WebElement From = driver.findElement(AppiumBy.id("com.google.android.gm:id/spinner_account_address"));
		String text = From.getText();
		System.out.println("Print text:" + text);
		String FromEmail = "manjusri455@gmail.com";

		if (text.equals(FromEmail)) {
//		if (text==FromEmail)("=="accept for primitive data type) {
			System.out.println("Text matched. Executing the code...");
			WebElement To = driver.findElement(AppiumBy.xpath(
					"//android.view.ViewGroup[@resource-id=\"com.google.android.gm:id/peoplekit_autocomplete_chip_group\"]/android.widget.EditText"));
			To.sendKeys("manju.jaggarapu@cognine.com");
		} else {
//			WebElement FromMail = driver.findElement(AppiumBy.id("com.google.android.gm:id/spinner_account_address"));
			From.sendKeys("manjusri455@gmail.com");
		}

		WebElement SelectEmail = driver.findElement(AppiumBy.xpath(
				"//android.widget.RelativeLayout[@resource-id=\"com.google.android.gm:id/peoplekit_listview_flattened_row\"]/android.widget.RelativeLayout[2]"));
		SelectEmail.click();

	}

	private void subj(WebDriver driver) {

		// Enter subject
		WebElement Subject = driver.findElement(AppiumBy.id("com.google.android.gm:id/subject"));
		Subject.click();
		Subject.sendKeys("Sample Appium Email");
	}

	private void emailBody(WebDriver driver) throws InterruptedException {

		// Compose Email Body
		WebElement EmailBody = driver.findElement(AppiumBy.id("com.google.android.gm:id/composearea_tap_trap_bottom"));
		EmailBody.click();
//		Thread.sleep(2000);
//		EmailBody.sendKeys("Hello");
		WebElement body = driver.findElement(AppiumBy.id("com.google.android.gm:id/body_wrapper"));
//		WebElement body = driver.findElement(AppiumBy.xpath(
//				"//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/wc_body_layout\"]/android.webkit.WebView/android.webkit.WebView/android.widget.EditText"));
//		WebElement sendbody = driver.findElement(AppiumBy.xpath(
//				"//android.widget.LinearLayout[@resource-id=\"com.google.android.gm:id/wc_body_layout\"]/android.webkit.WebView/android.webkit.WebView"));

		body.sendKeys("Hello Appium");
	}

	private WebElement attachements(WebDriver driver) throws InterruptedException {
		// click attach icon
		WebElement Attach = driver.findElement(AppiumBy.id("com.google.android.gm:id/add_attachment"));
		Attach.click();
		Thread.sleep(2000);

		// get the text of first option in attachment
		WebElement item1 = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.google.android.gm:id/title\" and @text=\"Attach file\"]"));
		String listvalue1 = item1.getText();
//		System.out.println(listvalue1);

		// get the text of second option in attachment
		WebElement item2 = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.google.android.gm:id/title\" and @text=\"Insert from Drive\"]"));
		String listvalue2 = item2.getText();
//		System.out.println(listvalue2);

		// passing list values into an array
		String[] attachlist = { listvalue1, listvalue2 };

		System.out.println("Print list of attachement options");

		for (int i = 0; i < attachlist.length; i++) {
			System.out.println(attachlist[i]);
		}
		return item1;
	}

	private void attachFile(WebDriver driver, WebElement listvalue1) {

		listvalue1.click();
		System.out.println("Successfully click on the Attach file option");

		// select a file
		WebElement File = driver.findElement(AppiumBy.xpath(
				"(//android.widget.LinearLayout[@resource-id=\"com.google.android.documentsui:id/item_root\"])[1]/android.widget.LinearLayout"));
		File.click();

	}

	private void sendEmail(WebDriver driver) {
		// Send Email
		WebElement Send = driver.findElement(AppiumBy.id("com.google.android.gm:id/send"));
		Send.click();

		System.out.println("Email Send Successfully...");
	}

}
