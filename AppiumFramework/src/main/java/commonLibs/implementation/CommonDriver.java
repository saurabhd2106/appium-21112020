package commonLibs.implementation;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonDriver {

	private AndroidDriver<WebElement> driver;

	private String currentWorkingDirectory;

	public AndroidDriver<WebElement> getDriver() {
		return driver;
	}

	public CommonDriver(DeviceSettings deviceSettings) throws Exception {

		currentWorkingDirectory = System.getProperty("user.dir");

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceSettings.getDeviceName());

		capabilities.setCapability(MobileCapabilityType.UDID, deviceSettings.getUdid());

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceSettings.getPlatformName());

		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceSettings.getPlatformVersion());

		capabilities.setCapability(MobileCapabilityType.APP, currentWorkingDirectory + "/drivers/" + deviceSettings.getApp());

		capabilities.setCapability(MobileCapabilityType.NO_RESET, true); // Don't clear the cache

		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false); // Don't reinstall the app

		URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(remoteUrl, capabilities);

	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		

		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
	}

	public void closeApp() {
		driver.close();
	}

	public void launchApp() {
		driver.launchApp(); // Re-launch the app with the capablities defined above
	}

	public void quitApp() {
		driver.quit();
	}

	public void runAppInBackground(int timeoutInSeconds) {
		driver.runAppInBackground(Duration.ofSeconds(timeoutInSeconds));
	}

	public String getDeviceTime() {
		return driver.getDeviceTime();

	}
	
	public double getBatteryInfo() {
	
		return driver.getBatteryInfo().getLevel();

	}

	public String getActivityId() {
		return driver.currentActivity();
	}

	public void getKeyboard() {
		driver.getKeyboard();
	}

	public void hideKeyboard() {

		if (driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}

	}

	public void unlockDevice() {

		if (driver.isDeviceLocked()) {
			driver.unlockDevice();
		}

	}

	public void resetApp() {
		driver.resetApp();
	}

	public void rotateScreenToPortraitMode() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	public void rotateScreenToLandscapeMode() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}

}
