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

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class Subscription extends AbstractMethods{

	WebDriver driver;

	public Subscription(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;	
	
	@FindBy(xpath="//input[@id='susbscribe_email']")WebElement emailtextbox;
	
	@FindBy(xpath="//*[contains(text(),'Subscription')]")WebElement subscriptiontext;
	
	@FindBy(xpath="//button[@id='subscribe']")WebElement submitbutton;
	
	@FindBy(xpath="//*[contains(text(),'Your notification here')]")WebElement message;
	
	@FindBy(xpath = "//i[@class='fa fa-shopping-cart']/parent::a")WebElement cartpage;	
	
	
	By successmessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");
	
	public void homepage_subscription() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		try {
			homepage.click();

			RegisterUser ru = new RegisterUser(driver);
			ru.homepagevisibiblity();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(subscriptiontext, "SUBSCRIPTION");

			String emailid = prop.getProperty("emailid");
			emailtextbox.sendKeys(emailid);

			submitbutton.click();

			try {
				visibility_Of_Element_Located(successmessage);
			} catch (Exception e) {
				System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
			}

			System.out.println("Testcase10--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase9 execution");
		}
	}

	public void cartpage_subscription() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		try {
			homepage.click();

			RegisterUser ru = new RegisterUser(driver);
			ru.homepagevisibiblity();

			cartpage.click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(subscriptiontext, "SUBSCRIPTION");

			String emailid = prop.getProperty("emailid");
			emailtextbox.sendKeys(emailid);

			submitbutton.click();

			try {
				visibility_Of_Element_Located(successmessage);
			} catch (Exception e) {
				System.err.println("Error while waiting for the notification to appear: " + e.getMessage());
			}

			System.out.println("Testcase11--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase9 execution");
		}
	}
}


