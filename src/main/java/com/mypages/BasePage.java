package com.mypages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends Pages {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getTextPage(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element= null;
		try {
			waitForElementPresent(locator);
			element=driver.findElement(locator);
			return element;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch (Exception e) {
			System.out.println("Execption occured while element was waiting " +locator.toString());
		}

	}

	@Override
	public List<?> getListValue(By locator) {
		try {
			waitForElementPresent(locator);
			return driver.findElements(locator);
		}
		catch (Exception e) {
			System.out.println("Execption occured while element was waiting " +locator.toString());
			return null;
		}

	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}
		catch (Exception e) {
			System.out.println("Execption occured while waiting for title" +title);
		}

	}

	@Override
	public void selectFromDropDown(String value, By locator) {
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(value);
	}

	@Override
	public List<WebElement> getAllOptionsFromDropDown(By locator) {
		Select s = new Select(getElement(locator));
		return s.getOptions();
	}

}
