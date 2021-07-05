package com.MyTest;


//import org.openqa.selenium.By;
import com.TestData.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypages.SearchPage;



public class ValidSearchTest extends BaseTest {

	
	//Test to verify Title of the page
	@Test (priority=1 , enabled=true)
	public void verifySearchPageTitleTest() {
		extentTest = extent.startTest("verifySearchPageTitleTest");
		String title = page.getInstance(SearchPage.class).getSearchPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Jetzt Top-Gebrauchtwagen online kaufen | Autohero.com");

	}

	//Test to valid search field
	@Test (priority=2, enabled=true)
	public void verifySearch(){
		extentTest = extent.startTest("verifySearch");
		page.getInstance(SearchPage.class).search(TestDataSet.kilometer);
		String brand =page.getInstance(SearchPage.class).validBrand();
		Assert.assertEquals(brand, "Marke: " +TestDataSet.brand);
		String model =page.getInstance(SearchPage.class).validModel();
		Assert.assertEquals(model, "Modell: " +TestDataSet.model);
		String km =page.getInstance(SearchPage.class).validKm();
		Assert.assertEquals(km, "Kilometer: Bis " +TestDataSet.kilometer);
	}


}

