package com.MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mypages.SearchPage;

public class InvalidSearchTest extends BaseTest {


	//Test to validate title for invalid test
	@Test (priority=1 , enabled=true)
	public void verifySearchPageTitleInvalidTest() {
		extentTest = extent.startTest("verifySearchPageTitleInvalidTest");
		String title = page.getInstance(SearchPage.class).getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Jetzt Top-Gebrauchtwagen online kaufen | Autohero.com");

	}
	
	//Test to valid invalid brand search
	@Test (priority=2, enabled=true)
	public void invalidBrandSearch(){
		extentTest = extent.startTest("invalidBrandSearch");
		Assert.assertEquals(page.getInstance(SearchPage.class).invalidBrandSearch(), true);
	}

	//Test to valid invalid model search
	@Test (priority=3, enabled=true)
	public void invalidModelSearch(){
		extentTest = extent.startTest("invalidModelSearch");
		Assert.assertEquals(page.getInstance(SearchPage.class).invalidModelSearch(), true);
	}

	//Test to valid invalid km search
	@Test (priority=4, enabled=true)
	public void invalidkm(){
		extentTest = extent.startTest("invalidkm");
		Assert.assertEquals(page.getInstance(SearchPage.class).invalidKmSearch(), true);
	}


}
