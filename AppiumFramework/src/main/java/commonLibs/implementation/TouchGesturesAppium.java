package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchGesturesAppium {

	AndroidDriver<WebElement> driver;

	TouchAction touchAction;

	public TouchGesturesAppium(AndroidDriver<WebElement> driver) {
		this.driver = driver;

		touchAction = new TouchAction<>(driver);
	}

	public void singleTap(WebElement element) {

		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();

	}

	public void longPress(WebElement element) {

		touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element))
				.withDuration(Duration.ofSeconds(2))).release().perform();
	}

}
