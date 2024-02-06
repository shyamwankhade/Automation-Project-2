package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;

public class TestCasePage extends AbstractMethods{

	WebDriver driver;

	public TestCasePage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-list']/parent::a")WebElement testcases;
	
	@FindBy(xpath = "//i[@class='fa fa-home']/parent::a")WebElement homepage;
	
	public void TestCasestest() {
		implicitlywaitmethod();

		try {

			homepage.click();

			RegisterUser ru = new RegisterUser(driver);
			ru.homepagevisibiblity();

			testcases.click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/test_cases");

			System.out.println("Testcase7--> executed succesfully");
		}

		catch (Exception e) {
			System.out.println("Exception occured while navigating to the testcases page");
		}

	}

}

