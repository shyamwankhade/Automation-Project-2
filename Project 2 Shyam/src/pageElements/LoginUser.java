package pageElements;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;

public class LoginUser extends AbstractMethods{

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public LoginUser(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement login;
	
	@FindBy(xpath = "//*[contains(text(),'Login to your account')]")WebElement loginaccount;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement logout;
	
	@FindBy(xpath = "//*[contains(text(),' Logged in as ')]")WebElement loogedinas;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")WebElement accountdeletedinfo;	

	@FindBy(xpath = "//*[contains(text(),'Continue')]")	WebElement Continuebutton;

	@FindBy(xpath = "//*[contains(text(),'Your email or password is incorrect!')]")WebElement errormsg;
	
	public void loginWithCorrectCred() {
		implicitlywaitmethod();
		try {
			Reusableclass rc= new Reusableclass (driver);
			rc.urlEquals("https://automationexercise.com/");
			login.click();
			
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();

			login.click();
			logout.click();

			rc.innerTextEquals(loginaccount, "Login to your account");

			rs.login();
			rc.innerTextEquals(loogedinas, loogedinas.getText());

			deleteaccount.click();

			rc.innerTextEquals(accountdeletedinfo, "ACCOUNT DELETED!");

			Continuebutton.click();
			System.out.println("Testcase2--> executed succesfully");
		} catch (Exception e) {
			System.out.println("login with correct username and Password has encountered an exception");
		}

	}

	public void loginWithInCorrectCred() {
		implicitlywaitmethod();
		try {
			Reusableclass rc= new Reusableclass (driver);
			rc.urlEquals("https://automationexercise.com/");
			login.click();

			rc.innerTextEquals(loginaccount, "Login to your account");

			ReusableMethods rs = new ReusableMethods(driver);
			rs.login();

			rc.innerTextEquals(errormsg, "Your email or password is incorrect!");

			System.out.println("Testcase3--> executed succesfully");
		} catch (Exception e) {
			System.out.println("exception occured while using incorrect crendials");
		}

	}

	public void logoutUser() {
		implicitlywaitmethod();
		try {

			login.click();
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();

			login.click();
			logout.click();

			Reusableclass rc = new Reusableclass(driver);
			rc.innerTextEquals(loginaccount, "Login to your account");

			rs.login();
			rc.innerTextEquals(loogedinas, loogedinas.getText());

			logout.click();

			Assert.assertEquals(loginaccount.getText(), "Login to your account");

			System.out.println("Testcase4--> executed succesfully");
		} catch (Exception e) {
			System.out.println("exception occured in testcase of logoutuser");
		}
	}
}

