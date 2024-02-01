package C2CMobile;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class startserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}

}
