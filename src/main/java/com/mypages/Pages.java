package com.mypages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Pages {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Pages(WebDriver driver)
	{
		this.driver=driver;
		this.wait= new WebDriverWait(this.driver, 15);
	}
	
	
	public abstract String getPageTitle();
	
	public abstract String getTextPage(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForPageTitle(String title);
	
	public abstract void selectFromDropDown(String value, By locator);
	
	public abstract List<?> getListValue(By locator);
	
	public abstract List<?> getAllOptionsFromDropDown(By locator);
	
	public <Tpage extends BasePage> Tpage getInstance(Class <Tpage> pageClass) {
		
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
			
		
		}
		
	}

}
