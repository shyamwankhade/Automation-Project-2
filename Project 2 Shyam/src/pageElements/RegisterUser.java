package pageElements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class RegisterUser extends AbstractMethods{

	WebDriver driver;	
	public RegisterUser(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	Reusableclass rc= new Reusableclass (driver);
	ReusableMethods rs = new ReusableMethods(driver);
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a") WebElement login;
	
	@FindBy(xpath = "//*[contains(text(),'New User Signup!')]")WebElement newusersignup;
	
	@FindBy(xpath = "//input[@placeholder='Name']")WebElement name;
	
	@FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")WebElement emailaddress;
	
	@FindBy(xpath = "//button[text()='Signup']")WebElement signup;	
	
	@FindBy(xpath = "//*[contains(text(),' Logged in as ')]")WebElement loogedinas;	

	@FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")WebElement enteraccountinfo;
	
	@FindBy(xpath = "//input[@id='id_gender2']")WebElement title;
	
	@FindBy(xpath = "//*[contains(text(),'Account Created!')]")	WebElement accountcreatedmessage;

	@FindBy(xpath = "//*[contains(text(),'Continue')]")WebElement Continuebutton;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")WebElement accountdeletedinfo;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement logout;
	
	@FindBy(xpath = "//*[contains(text(),'Email Address already exist!')]")WebElement errormsg;
	
	public void homepagevisibiblity() {
		implicitlywaitmethod();
		Reusableclass rc = new Reusableclass(driver);
		rc.urlEquals("https://automationexercise.com/");
		login.click();
	}

	public void userregister() throws IOException {
		implicitlywaitmethod();
		try {

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(newusersignup, "New User Signup!");
			// Assert.assertEquals(newusersignup.getText(), "New User Signup!");
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();

			Assert.assertEquals(enteraccountinfo.getText(), "ENTER ACCOUNT INFORMATION");
			title.click();

			rs.registrationpage();
			Assert.assertEquals(accountcreatedmessage.getText(), "ACCOUNT CREATED!");

			Continuebutton.click();
			Assert.assertEquals(loogedinas.getText(), loogedinas.getText());

			deleteaccount.click();
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");

			Continuebutton.click();
			System.out.println("Testcase1--> executed succesfully");
		}

		catch (Exception e) {
			System.out.println("not able to register");
		}

	}

	public void existinguser() {
		implicitlywaitmethod();

		try {
			login.click();

			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();

			login.click();
			logout.click();

			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");

			rs.signup();
			Assert.assertEquals(errormsg.getText(), "Email Address already exist!");

			rs.login();
			rc.innerTextEquals(loogedinas, loogedinas.getText());

			deleteaccount.click();

			rc.innerTextEquals(accountdeletedinfo, "ACCOUNT DELETED!");

			Continuebutton.click();

			System.out.println("Testcase5--> executed succesfully");
		} catch (Exception e) {
			System.out.println("exception occured while executing testcases for existing user");
		}

	}
}

