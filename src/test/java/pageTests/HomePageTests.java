package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePageObjects;

public class HomePageTests {
	
	HomePageObjects homePage;
	BasePage bp;

	public HomePageTests() {
		homePage = new HomePageObjects();
		bp = new BasePage();
	}

	@Test
	public void tab() {
		Assert.assertTrue(bp.elementFound(homePage.women()));
		Assert.assertTrue(bp.elementFound(homePage.dresses()));
		Assert.assertTrue(bp.elementFound(homePage.tshirts()));
	}
	
	@Test(groups = {"Regression"})
	public void PageHeader() {	
		homePage.clickWomenTab();
		Assert.assertTrue(homePage.getPageHeader().equals("WOMEN"));	
		homePage.clickDressTab();
		Assert.assertTrue(homePage.getPageHeader().equals("DRESSES"));	
		homePage.clickTshirtTab();
		Assert.assertTrue(homePage.getTshirtHeader().equals("CATALOG"));
	}
	
	@Test (enabled = true)
	public void newsletterTest() {
		homePage.clickNewsletter();
		homePage.newsletterSend();
		homePage.clickNewsbutton();
		
		}
	
	@Test (groups = {"Regression","Functional"})
	public void verifyAddtoCartButtonDisplay() {
		homePage.homeUrl();
		homePage.mouseHover();		
	}
	

}
