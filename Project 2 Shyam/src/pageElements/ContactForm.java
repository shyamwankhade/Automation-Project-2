package pageElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class ContactForm extends AbstractMethods {
	WebDriver driver;
	public ContactForm(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='fa fa-envelope']/parent::a")WebElement contactus;	

	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;	

	@FindBy(xpath = "//*[contains(text(),'Get In Touch')]")WebElement getintouchtext;	

	@FindBy(xpath = "//input[@class='btn btn-primary pull-left submit_form']")	WebElement submitbutton;

	@FindBy(xpath = "//div[@class='status alert alert-success']")WebElement successmsg;
	
	@FindBy(xpath = "//input[@name='upload_file']")WebElement uploadfile;
	
	public void contactform() {
		implicitlywaitmethod();

		try {
			homepage.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

			contactus.click();

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(getintouchtext, "GET IN TOUCH");

			ReusableMethods cf = new ReusableMethods(driver);
			cf.contactform();

			uploadfile.sendKeys(System.getProperty("user.dir") + ("\\src\\testData\\ProjectData.xlsx"));

			submitbutton.click();

			String message = driver.switchTo().alert().getText();
			System.out.println("Alert message = " + message);
			driver.switchTo().alert().accept();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", getintouchtext);

			rc.innerTextEquals(successmsg, "Success! Your details have been submitted successfully.");

			homepage.click();

			rc.urlEquals("https://automationexercise.com/");
			System.out.println("Testcase6--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in contacus form");
		}

	}

}

