package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class Recommendeditems extends AbstractMethods{

	WebDriver driver;

	public Recommendeditems(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}	

	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;	
	
	@FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'])[73]")WebElement firstproduct;
	
	@FindBy(xpath="//*[contains(text(),'recommended items')]")WebElement recommandeditemstext;
	
	@FindBy(xpath="(//p[@class='text-center'])[2]")WebElement viewcart;
	
	@FindBy(xpath="//*[contains(text(),'Winter Top')]")WebElement productvisibility;
	
	public void add_recommeneditems() throws IOException {
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
			js.executeScript("arguments[0].scrollIntoView();", recommandeditemstext);
			rc.innerTextEquals(recommandeditemstext, "RECOMMENDED ITEMS");
			firstproduct.click();
			viewcart.click();
			rc.elementAvailable(productvisibility, true);

			System.out.println("Testcase22--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase22 execution");
		}
	}
}
