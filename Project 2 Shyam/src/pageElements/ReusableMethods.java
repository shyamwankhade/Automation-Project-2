package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;
import utilities.ExcelUtility1;
@SuppressWarnings("resource")
public class ReusableMethods extends AbstractMethods {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ReusableMethods(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Enter Account Information')]")WebElement enteraccountinfo;
	
	@FindBy(xpath = "//input[@id='id_gender2']")WebElement title;

	@FindBy(xpath = "//input[@placeholder='Name']")WebElement name;	

	@FindBy(xpath = "//input[@id='password']")WebElement password;	

	@FindBy(xpath = "//select[@id='days']")WebElement days;
	
	@FindBy(xpath = "//select[@id='months']")WebElement months;
	
	@FindBy(xpath = "//select[@id='years']")WebElement years;	

	@FindBy(xpath = "//input[@id='newsletter']")WebElement checkbox;	

	@FindBy(xpath = "//input[@id='first_name']")WebElement firstname;
	
	@FindBy(xpath = "//input[@id='last_name']")WebElement lastname;	

	@FindBy(xpath = "//input[@id='company']")WebElement company;	

	@FindBy(xpath = "//input[@id='address1']")WebElement address;	

	@FindBy(xpath = "//input[@id='state']")WebElement state;	

	@FindBy(xpath = "//input[@id='city']")WebElement city;	

	@FindBy(xpath = "//input[@id='zipcode']")WebElement zipcode;
	
	@FindBy(xpath = "//input[@id='mobile_number']")WebElement mobno;
	
	@FindBy(xpath = "//button[text()='Create Account']")WebElement createaccount;	

	@FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")WebElement emailaddress;	

	@FindBy(xpath = "//input[@placeholder='Email Address']")WebElement email;	

	@FindBy(xpath = "//button[text()='Signup']")WebElement signup;

	@FindBy(xpath = "//button[text()='Login']")WebElement loginbutton;
	
	@FindBy(xpath = "//input[@placeholder='Password']")WebElement password1;	

	@FindBy(xpath="//input[@placeholder='Email']")WebElement email1;
	
	@FindBy(xpath = "//input[@placeholder='Subject']")WebElement subject;
		
	@FindBy(xpath = "//textarea[@placeholder='Your Message Here']")WebElement message;
	
	@FindBy(xpath = "//input[@name='name_on_card']")WebElement nameoncard;	

	@FindBy(xpath="//input[@name='card_number']")WebElement cardnum;
	
	@FindBy(xpath = "//input[@name='cvc']")WebElement cvc;
		
	@FindBy(xpath = "//input[@name='expiry_month']")WebElement expirymonth;	
	
	@FindBy(xpath = "//input[@name='expiry_year']")WebElement expiryyear;	
	
	@FindBy(xpath="//button[@class='form-control btn btn-primary submit-button']")WebElement placeorder;
	
	public void signup() throws IOException {
		ExcelUtility1 xs = new ExcelUtility1();

		String username = xs.get_Username(0, 1).toString();
		String emailid = xs.get_password(1, 1).toString();

		name.sendKeys(username);
		emailaddress.sendKeys(emailid);

		signup.click();
	}

	public void login() throws IOException {
		ExcelUtility1 xs = new ExcelUtility1();
		FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir") + ("\\src\\testData\\ProjectData.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(fs1);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String emailid = xs.get_password(1, 1).toString();
		email.sendKeys(emailid);
		password1.click();
		password1.sendKeys((sheet.getRow(2).getCell(1)).toString());

		loginbutton.click();
	}

	public void registrationpage() {
		try {
			FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir") + ("\\src\\testData\\ProjectData.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet = workbook.getSheetAt(0);

			password.click();
			password.sendKeys((sheet.getRow(2).getCell(1)).toString());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", lastname);

			XSSFCell Day = sheet.getRow(3).getCell(1);
			String day = (NumberToTextConverter.toText(Day.getNumericCellValue()));
			days.click();
			WebElement Day1 = driver.findElement(By.xpath("//*[text()='" + day + "']"));
			Day1.click();

			XSSFCell Month = sheet.getRow(4).getCell(1);
			String month = Month.toString();
			months.click();
			WebElement months1 = driver.findElement(By.xpath("//*[text()='" + month + "']"));
			months1.click();

			XSSFCell Year = sheet.getRow(5).getCell(1);
			String year = (NumberToTextConverter.toText(Year.getNumericCellValue()));
			years.click();
			WebElement years1 = driver.findElement(By.xpath("//*[text()='" + year + "']"));
			years1.click();

			checkbox.click();
			firstname.sendKeys((sheet.getRow(6).getCell(1)).toString());
			lastname.sendKeys((sheet.getRow(7).getCell(1)).toString());
			company.sendKeys((sheet.getRow(8).getCell(1)).toString());
			address.sendKeys((sheet.getRow(9).getCell(1)).toString());
			state.sendKeys((sheet.getRow(10).getCell(1)).toString());
			city.sendKeys((sheet.getRow(11).getCell(1)).toString());

			XSSFCell zipcode2 = sheet.getRow(12).getCell(1);
			String zipcode1 = (NumberToTextConverter.toText(zipcode2.getNumericCellValue()));
			zipcode.sendKeys(zipcode1);

			XSSFCell cellno2 = sheet.getRow(13).getCell(1);
			String cellno1 = (NumberToTextConverter.toText(cellno2.getNumericCellValue()));
			mobno.sendKeys(cellno1);

			js.executeScript("arguments[0].scrollIntoView();", createaccount);

			createaccount.click();
		}

		catch (Exception e) {
			System.out.println("data retrival failing from excelsheet");
		}
	}

	public void contactform() throws IOException {
		ExcelUtility1 xs = new ExcelUtility1();
		FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir") + ("\\src\\testData\\ProjectData.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(fs1);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String name1 = xs.get_password(0, 1).toString();
		name.sendKeys(name1);

		email1.sendKeys((sheet.getRow(1).getCell(1)).toString());
		subject.sendKeys((sheet.getRow(14).getCell(1)).toString());
		message.sendKeys((sheet.getRow(15).getCell(1)).toString());
	}

	public void closebrowser() {
		driver.quit();
	}

	public void payment() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		String nameoncard1 = prop.getProperty("nameoncard");
		nameoncard.sendKeys(nameoncard1);

		String cardnum1 = prop.getProperty("cardnum");
		cardnum.sendKeys(cardnum1);

		String cvc1 = prop.getProperty("cvc");
		cvc.sendKeys(cvc1);

		String expirymonth1 = prop.getProperty("expirymonth");
		expirymonth.sendKeys(expirymonth1);

		String expiryyear1 = prop.getProperty("expiryyear");
		expiryyear.sendKeys(expiryyear1);

		placeorder.click();
	}
}

