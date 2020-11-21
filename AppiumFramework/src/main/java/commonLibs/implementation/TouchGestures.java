package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.android.AndroidDriver;

public class TouchGestures {

	TouchActions touchActions;

	public TouchGestures(AndroidDriver<WebElement> driver) {

		touchActions = new TouchActions(driver);
	}

	public void singleTap(WebElement element) {

		touchActions.singleTap(element).perform();

	}

	public void doubleTap(WebElement element) {

		touchActions.doubleTap(element).perform();

	}

	public void longPress(WebElement element) {

		touchActions.longPress(element).perform();

	}

	public void scroll(WebElement element, int xOffset, int yOffset) {
		touchActions.scroll(element, xOffset, yOffset).perform();
	}
}
