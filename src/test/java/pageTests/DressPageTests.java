package pageTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePageObjects;
import pageObjects.DressPageObjects;

public class DressPageTests {
	
	DressPageObjects dressPage;
	HomePageObjects homePage;
	BasePage bp;

	public DressPageTests() {
		dressPage = new DressPageObjects();
		homePage = new HomePageObjects();
		bp = new BasePage();
	}

	@BeforeTest
	public void beforecart() {
		homePage.clickDressTab();
	}
	
	@Test(enabled= true)
	public void sizeCheck() {
	//	homePage.clickDressTab();
		Assert.assertTrue(dressPage.elementFound(dressPage.sizeSmall()));
		Assert.assertTrue(dressPage.elementFound(dressPage.sizeMedium()));
		Assert.assertTrue(dressPage.elementFound(dressPage.sizeLarge()));
	}

	@Test(enabled= false)
	public void matchingSizeCount() {

		int actual = dressPage.getProductNumberFromHeader();
		int expected = dressPage.getProductsCount();
		System.out.println(actual);
		System.out.println(expected);
	Assert.assertTrue(actual == expected, "Failed:Count mismatched");
	
	
	}
	
	
		// Assert.assertTrue(dressPage.getProductNumberFromHeader() ==
		// dressPage.getProductsCount(), " Failed:Count mismatched");
	
	
	

	@Test(enabled= false)
	public void addToCart() {
		homePage.clickDressTab();
		dressPage.addCart();
		Assert.assertTrue(dressPage.elementFound(dressPage.cartPopUp()));
		dressPage.closePop();
		Assert.assertTrue(dressPage.verifyCart() > 0, "Failed: Cart empty");
	}
	
	

	@Test(enabled = false)
	public void dressAscendingOrder() {
	//	homePage.clickDressTab();
		dressPage.orderByAscending();	
		
		ArrayList<Double> checkPrice = new ArrayList<Double>();
		checkPrice.addAll(dressPage.verifyProductPrice());
		for (int i = 0; i < checkPrice.size() - 1; i++) {
			Assert.assertTrue(checkPrice.get(i) < (checkPrice.get(i + 1)));
		}
		}
	
	

	@Test(enabled= false)
	public void verifyDiscountPrice() {
		//homePage.clickDressTab();
		dressPage.listView().click();
		List<WebElement> pdts = dressPage.getProducts();
		for(WebElement product: pdts) {
			if(dressPage.discountProducts(product)== true) {
			Assert.assertTrue(dressPage.oldPriceList(product), "Old Price unavailable");
		}
		}
		}
		

}
