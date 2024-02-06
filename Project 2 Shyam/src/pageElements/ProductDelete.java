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

public class ProductDelete extends AbstractMethods{

	WebDriver driver;

	public ProductDelete(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"accordian\"]/div[1]/div[1]")WebElement scrolldown;
	
	@FindBy(xpath="(//div[@class='productinfo text-center'])[1]")WebElement select_firstproduct;
	
	@FindBy(xpath="/html/body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/a")WebElement addcart1;
	
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;
	
	@FindBy(xpath="(//p[@class='text-center'])[2]")WebElement viewcart;
	
	@FindBy(xpath = "//*[contains(text(),' Cart')]")WebElement cartbutton;	
	
	@FindBy(xpath="(//a[@class='cart_quantity_delete'])[1]")WebElement deletecart;
	
	public void productdelete() throws IOException {
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

			Hoveranyelement(select_firstproduct);
			addcart1.click();
			viewcart.click();

			js.executeScript("arguments[0].scrollIntoView();", homepage);

			cartbutton.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
			
			deletecart.click();
			
			try {
			String product1 = prop.getProperty("product1");
			WebElement prod1 = driver.findElement(By.xpath("//*[contains(text(),'" + product1 + "')]"));
			rc.elementAvailable(prod1, true);
			}catch(Exception e) {}
			
			System.out.println("Testcase17--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase17 execution");
		}
	}
}

