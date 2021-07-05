package com.mypages;

import java.util.List;

import org.openqa.selenium.By;
import com.TestData.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

	//page locators valid scenario
	private By brandArrow= By.id("carMakeFilter");
	private By brandName= By.xpath("//*[@class='optionButton___95JIQ' and @value='"+TestDataSet.brand+"']");
	private By model= By.xpath("//*[@class='optionButton___3AHeR' and @value='"+TestDataSet.model+"']");
	private By km  = By.xpath("//*[@id='rangeEnd' and @data-qa-selector='select-mileage-to']");
	private By validateBrand= By.xpath("//*[@class='button___50Uee' and contains(text(),'Marke: ')]");
	private By validateModel= By.xpath("//*[@class='button___50Uee' and contains(text(),'Modell: ')]");
	private By validateKm= By.xpath("//*[@class='button___50Uee' and contains(text(),'Kilometer: ')]");
	private By headerName= By.className("header");
	private By kmArrow= By.xpath("//*[@id='mileageFilter']//*[@class='iconMenu___2Jojr']");



	//Invalid Scenario
	private By invalidBrandName= By.xpath("//*[@class='optionButton___95JIQ' and @value='"+InvalidTestDataSet.brand+"']");
	private By invalidModel= By.xpath("//*[@class='optionButton___3AHeR' and @value='"+InvalidTestDataSet.model+"']");
	
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	
	public WebElement getBrandArrow() {
		return getElement(brandArrow);
	}

	public WebElement getKmArrow() {
		return getElement(kmArrow);
	}

	public void clickdropDown() {
		getElement(kmArrow).click();;
	}

	public boolean selectBrand() {
		try {
			getElement(brandName).click();
			return true;
		}
		catch (Exception e) {
			System.out.println("Element not found" +brandName);
			e.printStackTrace();
			return false;
		}

	}

	public WebElement getModel() {
		return getElement(model);
	}

	public WebElement getHeaderName() {
		return getElement(headerName);
	}

	public String getSearchPageTitle(){
		return getPageTitle();
	}

	public String getLoginPageHeader() {
		return getTextPage(headerName);
	}

	public boolean validateFormatKm(String value)
	{
		if(value.contains(".000 km"))
		{
			return true;
		}

		else {
			System.out.println("Invalid Kilometer format: " +value);
			System.out.println("Required format: numeric value.000 km");
			return false;
		}

	}

	
	//Method to perform search on the Search Page
	public void search(String value)
	{
		getBrandArrow().click();
		if(validateFormatKm(value)) {
			if(selectBrand()){
				getModel().click();
				waitForElementPresent(kmArrow);
				getKmArrow().click();
				//clickdropDown();
				waitForElementPresent(km);
				selectFromDropDown(value, km);
			}

			else
				System.out.println("Brand " +TestDataSet.brand +" not found");
		}


	}

	public String validBrand()
	{
		return getTextPage(validateBrand);
	}

	public String validModel()
	{
		return getTextPage(validateModel);

	}

	public String validKm()
	{
		return getTextPage(validateKm);

	}
	
	

	//Method to validate invalid Brand Search
	public boolean invalidBrandSearch() {

		getBrandArrow().click();
		if(getListValue(invalidBrandName).size()== 0)
			return true;
		else
			return false;

	}
	
	
	//Method to validate invalid Model Search
	public boolean invalidModelSearch() {

		getBrandArrow().click();
		selectBrand();
		if(getListValue(invalidModel).size()== 0)
			return true;
		else
			return false;
	}
	//Method to validate invalid Model Search
	public boolean invalidKmSearch() {

		List<WebElement> kmOptions = getAllOptionsFromDropDown(km);
		for(WebElement options: kmOptions)
		{
			if(options.getText().equals(InvalidTestDataSet.kilometer))
				return false;
		}
		return true;

	}


}
