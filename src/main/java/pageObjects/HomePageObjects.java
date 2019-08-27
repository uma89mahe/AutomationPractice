package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends BasePage{
	

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement women;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement dresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tshirts;

	@FindBy(xpath = "//*[@id='categories_block_left']/h2")
	private WebElement pageHeader;

	@FindBy(xpath = "//*[@class='row']//*[@id='layered_block_left']/p")
	private WebElement tshirtHeader;

	@FindBy(xpath = "//*[@id='newsletter_block_left']//input[@id='newsletter-input']")
	private WebElement newsletter;

	@FindBy(xpath = "//*[@id='columns']//p[@class='alert alert-success']")
	private WebElement subalert;

	@FindBy(xpath = "//*[@class='block_content']//button[@name='submitNewsletter']")
	private WebElement newsbutton;

	@FindBy(xpath = "//p[@class='alert alert-danger']")
	private WebElement danger;

	@FindBys(@FindBy(xpath = "//*[@id='homefeatured']//*[@class='product-container']"))
	private List<WebElement> allProducts;

	@FindBys(@FindBy(xpath = "//*[@id='homefeatured']//*[@class='right-block']//a/span[text()='Add to cart']"))
	private List<WebElement> AddtoCart;

	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public WebElement women() {
		return women;
	}

	public WebElement dresses() {
		return dresses;
	}

	public WebElement tshirts() {
		return tshirts;
	}

	public String getPageHeader() {
		return getTxt(pageHeader);

	}

	public void clickWomenTab() {
		women.click();
	}

	public String getTshirtHeader() {
		return getTxt(tshirtHeader);
	}

	public void clickDressTab() {
		dresses.click();
	}

	public void clickTshirtTab() {
		tshirts.click();
	}

	public void newsletterSend() {
		int random = new Random().nextInt(500000);
		String email = "Automation" + random + "@gmail.com";
		pageScroll(newsletter);
		newsletter.sendKeys(email);
		
	}

	public void clickNewsbutton() {
		newsbutton.click();
	}

	public void clickNewsletter() {
		newsletter.click();
	}

	public String getNewsAlert() {
		return getTxt(subalert);
	}

	public String getNewsdanger() {
		return getTxt(danger);
	}

	public void homeUrl() {
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	public void mouseHover() {
		Actions ac = new Actions(driver);
		for (int i = 0; i < allProducts.size(); i++) {
			ac.moveToElement(allProducts.get(i)).build().perform();
			if (AddtoCart.get(i).isDisplayed()) {
				System.out.println("Add to Cart Displayed");
			}
		}
	}


	


}
