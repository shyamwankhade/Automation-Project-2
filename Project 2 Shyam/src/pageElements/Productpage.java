package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class Productpage extends AbstractMethods{

	WebDriver driver;

	public Productpage(WebDriver driverhere) {
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
	
    @FindBy(xpath="(//div[@class='productinfo text-center'])[2]")WebElement select_secondproduct;
	
	@FindBy(xpath="(//a[@data-product-id='2'])[2]")WebElement addcart2;
	
	@FindBy(xpath="//*[contains(text(),'View Cart')]") WebElement viewcartbutton;
	
	@FindBy(xpath="(//*[contains(text(),'Rs. 500')])[1]")WebElement actualprice1;
	@FindBy(xpath="(//*[contains(text(),'Rs. 400')])[1]")WebElement actualprice2;
	
	@FindBy(xpath="(//*[contains(text(),'Rs. 500')])[2]")WebElement totalprice1;
	@FindBy(xpath="(//*[contains(text(),'Rs. 400')])[2]")WebElement totalprice2;
	
	@FindBy(xpath="(//button[@class='disabled'])[1]") WebElement quantity1;
	@FindBy(xpath="(//button[@class='disabled'])[2]") WebElement quantity2;
	
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
	
	public void productdetailspage() {
		implicitlywaitmethod();

		try {
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

			product.click();

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(allproductpage, "ALL PRODUCTS");
			rc.elementAvailable(productlist, true);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", firstproduct);

			firstproduct.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/product_details/1");
			rc.elementAvailable(productinfo, true);

			System.out.println("Testcase8--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase8 execution");
		}

	}

	public void searchproduct() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

			product.click();

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(allproductpage, "ALL PRODUCTS");

			System.out.println("clicking on the search product textbox");
			String searchproduct1 = prop.getProperty("searchproduct");
			searchproduct.sendKeys(searchproduct1);

			searchbutton.click();

			rc.innerTextEquals(searchproducttext, "SEARCHED PRODUCTS");

			rc.elementAvailable(featureitems, true);

			System.out.println("Testcase9--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase9 execution");
		}
	}

	public void addproducts() throws IOException {
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

			Hoveranyelement(select_firstproduct);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);
			addcart1.click();

			continueshopping_button.click();
			Hoveranyelement(select_secondproduct);
			addcart2.click();

			viewcartbutton.click();

			String product1 = prop.getProperty("product1");
			WebElement prod1 = driver.findElement(By.xpath("//*[contains(text(),'" + product1 + "')]"));
			rc.elementAvailable(prod1, true);

			String product2 = prop.getProperty("product2");
			WebElement prod2 = driver.findElement(By.xpath("//*[contains(text(),'" + product2 + "')]"));
			rc.elementAvailable(prod2, true);

			// Verify first product
			try {
				String expectedPrice1 = "Rs. 500";
				rc.innerTextEquals(actualprice1, expectedPrice1);

				String expectedtotalprice = totalprice1.getText();
				rc.innerTextEquals(totalprice1, expectedtotalprice);

				String expectedquantity = quantity1.getText();
				rc.innerTextEquals(quantity1, expectedquantity);
			} catch (Exception e) {
			}

			// Verify second product

			try {
				String expectedPrice1 = "Rs. 400";
				rc.innerTextEquals(actualprice2, expectedPrice1);

				String expectedtotalprice = totalprice2.getText();
				rc.innerTextEquals(totalprice2, expectedtotalprice);

				String expectedquantity = quantity2.getText();
				rc.innerTextEquals(quantity2, expectedquantity);
			} catch (Exception e) {
			}

			System.out.println("Testcase12--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase12 execution");
		}
	}

}

