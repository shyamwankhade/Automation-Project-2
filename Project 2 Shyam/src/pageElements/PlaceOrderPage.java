package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.Reusableclass;
@SuppressWarnings("resource")
public class PlaceOrderPage extends AbstractMethods{

	WebDriver driver;

	public PlaceOrderPage(WebDriver driverhere) {
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
	
	@FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")WebElement proceedtocheckout;
	
	@FindBy(xpath="(//p[contains(@class,'text-center')])[2]")WebElement loginbutton;
	
	@FindBy(xpath = "//*[contains(text(),' Logged in as ')]")WebElement loogedinas;	

	@FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")WebElement enteraccountinfo;
	
	@FindBy(xpath = "//input[@id='id_gender2']")WebElement title;
	
	@FindBy(xpath = "//*[contains(text(),'Account Created!')]")	WebElement accountcreatedmessage;

	@FindBy(xpath = "//*[contains(text(),'Continue')]")WebElement Continuebutton;
	
	@FindBy(xpath = "//*[contains(text(),'New User Signup!')]")WebElement newusersignup;
	
	@FindBy(xpath="//ul[@id='address_delivery']")WebElement addressdetails;
	
	@FindBy(xpath="//div[@id='cart_info']")WebElement cartinfo;
	
	@FindBy(xpath="//textarea[@class='form-control']")WebElement message;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")WebElement placeorderbutton;
	
	@FindBy(xpath="(//div[@class='alert-success alert'])[1]")WebElement alertmessage;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']/parent::a")WebElement deleteaccount;
	
	@FindBy(xpath = "//*[contains(text(),'Account Deleted!')]")WebElement accountdeletedinfo;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement login;
	
	@FindBy(xpath = "//*[contains(text(),'Login to your account')]")WebElement loginaccount;
	
	@FindBy(xpath = "//i[@class='fa fa-lock']/parent::a")WebElement logout;
	
	@FindBy(xpath="(//li[@class='address_address1 address_address2'])[2]")WebElement deliveryaddress;
	
	@FindBy(xpath="(//li[@class='address_address1 address_address2'])[5]")WebElement billingaddress;
	
	@FindBy(xpath="//*[contains(text(),'field below')]")WebElement text;
	
	@FindBy(xpath="//textarea[@class='form-control']")WebElement textarea;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")WebElement invoice;
	
	By successmessage = By.xpath("//*[contains(text(),'Your order has been placed successfully!')]");
	
	public void register_whilecheckout() throws IOException {
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

			proceedtocheckout.click();
			loginbutton.click();

			Assert.assertEquals(newusersignup.getText(), "New User Signup!");
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();

			Assert.assertEquals(enteraccountinfo.getText(), "ENTER ACCOUNT INFORMATION");
			title.click();

			rs.registrationpage();
			Assert.assertEquals(accountcreatedmessage.getText(), "ACCOUNT CREATED!");

			Continuebutton.click();
			Assert.assertEquals(loogedinas.getText(), loogedinas.getText());

			cartbutton.click();
			proceedtocheckout.click();

			rc.elementAvailable(addressdetails, true);
			rc.elementAvailable(cartinfo, true);

			String textmessage = prop.getProperty("textmessage");
			message.sendKeys(textmessage);

			placeorderbutton.click();

			rs.payment();
			Assert.assertEquals(alertmessage.getText(),alertmessage.getText());

			deleteaccount.click();
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");

			Continuebutton.click();
			System.out.println("Testcase14--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase14 execution");
		}
	}
	
	public void register_beforecheckout() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {
			Reusableclass rc = new Reusableclass(driver);
			RegisterUser ru = new RegisterUser(driver);
			ru.homepagevisibiblity();
			
			Assert.assertEquals(newusersignup.getText(), "New User Signup!");
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();

			Assert.assertEquals(enteraccountinfo.getText(), "ENTER ACCOUNT INFORMATION");
			title.click();
		
			rs.registrationpage();
			Assert.assertEquals(accountcreatedmessage.getText(), "ACCOUNT CREATED!");

			Continuebutton.click();
			Assert.assertEquals(loogedinas.getText(), loogedinas.getText());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);

			Hoveranyelement(select_firstproduct);
			addcart1.click();
			viewcart.click();

			js.executeScript("arguments[0].scrollIntoView();", homepage);

			cartbutton.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

			proceedtocheckout.click();
			
			rc.elementAvailable(addressdetails, true);
			rc.elementAvailable(cartinfo, true);

			String textmessage = prop.getProperty("textmessage");
			message.sendKeys(textmessage);

			placeorderbutton.click();

			rs.payment();
			Assert.assertEquals(alertmessage.getText(),alertmessage.getText());
			deleteaccount.click();
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");
			Continuebutton.click();
			
			System.out.println("Testcase15--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase15 execution");
		}
	}
	
	public void login_beforecheckout() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

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
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);

			Hoveranyelement(select_firstproduct);
			addcart1.click();
			viewcart.click();

			js.executeScript("arguments[0].scrollIntoView();", homepage);

			cartbutton.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

			proceedtocheckout.click();
			
			rc.elementAvailable(addressdetails, true);
			rc.elementAvailable(cartinfo, true);

			String textmessage = prop.getProperty("textmessage");
			message.sendKeys(textmessage);

			placeorderbutton.click();

			rs.payment();
			Assert.assertEquals(alertmessage.getText(),alertmessage.getText());
			deleteaccount.click();
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");
			Continuebutton.click();
			
			System.out.println("Testcase16--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase16 execution");
		}
	}
	
	
	public void addressdetails_verify() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		
		FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir") + ("\\src\\testData\\ProjectData.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fs1);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String address = (sheet.getRow(9).getCell(1)).toString();	
		
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
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);

			Hoveranyelement(select_firstproduct);
			addcart1.click();
			viewcart.click();

			js.executeScript("arguments[0].scrollIntoView();", homepage);
			cartbutton.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");
			proceedtocheckout.click();
			rc.innerTextEquals(deliveryaddress, address);
			rc.innerTextEquals(billingaddress, address);
			deleteaccount.click();
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");
			Continuebutton.click();
			
			System.out.println("Testcase23--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase23 execution");
		}
	}
	
	public void downloadinvoice() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		try {
			Reusableclass rc= new Reusableclass (driver);
			rc.urlEquals("https://automationexercise.com/");
			login.click();
			
			ReusableMethods rs = new ReusableMethods(driver);
			rs.signup();
			rs.registrationpage();
			Continuebutton.click();
			
			Assert.assertEquals(loogedinas.getText(), loogedinas.getText());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", scrolldown);

			Hoveranyelement(select_firstproduct);
			addcart1.click();
			viewcart.click();
			cartbutton.click();
			
			cartbutton.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/view_cart");

			proceedtocheckout.click();
			
			cartbutton.click();
			proceedtocheckout.click();
			rc.elementAvailable(addressdetails, true);
			rc.elementAvailable(cartinfo, true);
			
			js.executeScript("arguments[0].scrollIntoView();", text);
			String textmessage = prop.getProperty("textmessage");textarea.sendKeys(textmessage);
			placeorderbutton.click();
			rs.payment();					
			try{
				visibility_Of_Element_Located(successmessage);
			}catch(Exception e){
			    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
			}
			
			invoice.click();
			Continuebutton.click();
			deleteaccount.click();
			Assert.assertEquals(accountdeletedinfo.getText(), "ACCOUNT DELETED!");
			Continuebutton.click();			
			
			System.out.println("Testcase24--> executed succesfully");

		} catch (Exception e) {
			System.out.println("Exception occured in testcase24 execution");
		}
	}
}


