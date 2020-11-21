package com.mmt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.CommonElements;
import commonLibs.implementation.TouchGestures;
import commonLibs.implementation.TouchGesturesAppium;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MmtHomepage {

	CommonElements elementControl;
	
	TouchGesturesAppium touchControl;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Hotels']//parent::android.widget.RelativeLayout)[1]")
	private WebElement hotelButton;

	public MmtHomepage(AndroidDriver<WebElement> driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		elementControl = new CommonElements();
		
		touchControl = new TouchGesturesAppium(driver);

	}

	public void hotelSearch() {
		touchControl.singleTap(hotelButton);
		
	}
}
