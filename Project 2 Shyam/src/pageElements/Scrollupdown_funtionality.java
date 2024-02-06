package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class Scrollupdown_funtionality extends AbstractMethods{

	WebDriver driver;

	public Scrollupdown_funtionality(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;
	
	@FindBy(xpath="//*[contains(text(),'Subscription')]")WebElement subscriptiontext;
	
	@FindBy(xpath="//a[@id='scrollUp']") WebElement scrollup;
	
	@FindBy(xpath="//*[contains(text(),'Full-Fledged')]")WebElement message;
	
	public void scrollupdown_usingarrow() throws IOException {
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
			js.executeScript("arguments[0].scrollIntoView();", subscriptiontext);
			rc.innerTextEquals(subscriptiontext, "SUBSCRIPTION");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(scrollup));
			scrollup.click();
			rc.innerTextEquals(message, "Full-Fledged practice website for Automation Engineers");

			System.out.println("Testcase25--> executed succesfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase25 execution");
		}
	}

	public void scrollupdown_withoutusingarrow() throws IOException {
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
			js.executeScript("arguments[0].scrollIntoView();", subscriptiontext);
			rc.innerTextEquals(subscriptiontext, "SUBSCRIPTION");
			js.executeScript("arguments[0].scrollIntoView();", homepage);
			rc.innerTextEquals(message, "Full-Fledged practice website for Automation Engineers");

			System.out.println("Testcase26--> executed succesfully");
		} catch (Exception e) {
			System.out.println("Exception occured in testcase26 execution");
		}
	}
}
