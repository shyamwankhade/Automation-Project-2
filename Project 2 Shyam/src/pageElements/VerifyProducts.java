package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class VerifyProducts extends AbstractMethods{

	WebDriver driver;

	public VerifyProducts(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='material-icons card_travel']/parent::a")WebElement product;	

	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;	

	@FindBy(xpath = "(//*[contains(text(),'All Products')])[2]")WebElement allproductpage;	

	@FindBy(xpath = "//div[@class='features_items']")WebElement productlist;
	
	@FindBy(xpath = "(//*[contains(text(),'View Product')])[1]")WebElement firstproduct;
	
	@FindBy(xpath = "//div[@class='product-information']")WebElement productinfo;
	
	@FindBy(xpath = "//input[@id='search_product']")WebElement searchproduct;
	
	@FindBy(xpath = "//button[@id='submit_search']")WebElement searchbutton;
	
	@FindBy(xpath="(//div[@class='panel-heading'])[3]")WebElement category;
	
	@FindBy(xpath="//*[contains(text(),'Searched Products')]") WebElement searchproducttext;
	
	@FindBy(xpath="//div[@class='features_items']")WebElement featureitems;
	
	@FindBy(xpath="(//div[@class='productinfo text-center'])[1]")WebElement select_firstproduct;
	
	@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'])[1]")WebElement addcart1;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")WebElement continueshopping_button;
			
	@FindBy(xpath="//*[contains(text(),'View Cart')]") WebElement viewcartbutton;
	
	@FindBy(xpath="//*[@id=\"accordian\"]/div[1]/div[1]")WebElement scrolldown;
	
	@FindBy(xpath="//input[@id='quantity']")WebElement quantity;
	
	@FindBy(xpath="//button[@class='btn btn-default cart']")WebElement addcartbutton;
	
	@FindBy(xpath="//*[contains(text(),'Category')]")WebElement categorytext;
	
	@FindBy(xpath = "//*[contains(text(),' Cart')]")WebElement cartbutton;	
	
	@FindBy(xpath="//a[text()='Winter Top']")WebElement wintertop;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement login;
	
	@FindBy(xpath = "//*[contains(text(),'Login to your account')]")WebElement loginaccount;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement logout;
	
	@FindBy(xpath = "//*[contains(text(),' Logged in as ')]")WebElement loogedinas;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")WebElement accountdeletedinfo;	

	@FindBy(xpath = "//*[contains(text(),'Continue')]")	WebElement Continuebutton;

	@FindBy(xpath="(//button[@class='disabled'])[1]") WebElement quantity1;
	
	@FindBy(xpath="//a[@href='/product_details/1']") WebElement viewproduct1;
	
	@FindBy(xpath="//a[text()='Write Your Review']")WebElement userreview;
	
	@FindBy(xpath="//input[@id='name']")WebElement name;
	
	@FindBy(xpath="//input[@id='email']")WebElement emailid;
	
	@FindBy(xpath="//textarea[@id='review']")WebElement review;
	
	@FindBy(xpath="//button[@id='button-review']")WebElement submitbutton;
	
	By successmessage = By.xpath("//*[contains(text(),'Thank you for your review')]");
	
	public void verifyProdQuantity() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			Reusableclass rc = new Reusableclass(driver);
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);

			firstproduct.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
			rc.elementAvailable(productinfo, true);

			quantity.click();
			quantity.sendKeys(Keys.CONTROL + "a");
			quantity.sendKeys(Keys.DELETE);

			String qunty = prop.getProperty("quantity");
			quantity.sendKeys(qunty);

			addcartbutton.click();
			viewcartbutton.click();

			String expectedquantity = quantity1.getText();
			rc.innerTextEquals(quantity1, expectedquantity);

			System.out.println("Testcase13--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase13 execution");
		}
	}

	public void prodsearch_verify_cartafterlogin() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			Reusableclass rc = new Reusableclass(driver);
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
			product.click();

			rc.innerTextEquals(allproductpage, "ALL PRODUCTS");

			System.out.println("clicking on the search product textbox");
			String searchproduct1 = prop.getProperty("searchproduct");
			searchproduct.sendKeys(searchproduct1);

			searchbutton.click();

			rc.innerTextEquals(searchproducttext, "SEARCHED PRODUCTS");

			rc.elementAvailable(featureitems, true);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", categorytext);

			Hoveranyelement(select_firstproduct);
			addcart1.click();

			viewcartbutton.click();
			rc.elementAvailable(wintertop, true);

			login.click();
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();
			login.click();
			logout.click();
			rc.innerTextEquals(loginaccount, "Login to your account");
			rs.login();
			rc.innerTextEquals(loogedinas, loogedinas.getText());

			cartbutton.click();
			rc.elementAvailable(wintertop, true);

			deleteaccount.click();
			rc.innerTextEquals(accountdeletedinfo, "ACCOUNT DELETED!");
			Continuebutton.click();

			System.out.println("Testcase20--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase20 execution");
		}

	}

	public void addreview() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {

			Reusableclass rc = new Reusableclass(driver);
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");
			product.click();
			rc.innerTextEquals(allproductpage, "ALL PRODUCTS");
			rc.elementAvailable(productlist, true);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", category);
			viewproduct1.click();
			Assert.assertEquals(userreview.getText(), "WRITE YOUR REVIEW");

			String name1 = prop.getProperty("name");
			name.sendKeys(name1);
			String emailid1 = prop.getProperty("emailid");
			emailid.sendKeys(emailid1);
			String review1 = prop.getProperty("review");
			review.sendKeys(review1);
			js.executeScript("arguments[0].scrollIntoView();", submitbutton);
			submitbutton.click();

			try {
				visibility_Of_Element_Located(successmessage);
			} catch (Exception e) {
				System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
			}

			System.out.println("Testcase21--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase21 execution");
		}

	}
}

