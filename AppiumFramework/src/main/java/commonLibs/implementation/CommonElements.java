package commonLibs.implementation;

import org.openqa.selenium.WebElement;

public class CommonElements {

	public void clickElement(WebElement element) {
		element.click();

	}

	public void setText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getTagName(WebElement element) {
		return element.getTagName();
	}

	public String getAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

}
