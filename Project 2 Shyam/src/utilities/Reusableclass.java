package utilities;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Reusableclass {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public Reusableclass(WebDriver driverhere) {
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	 // Method to verify the title is equal to expected title
	public void titleEquals(String expectedTitle) {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle,"Actual Title is equal to the expected Title(" + expectedTitle + ")");
	}

	 // Method to verify the url is equal to expected url
		public void urlEquals(String expectedURL) {
			String actualURL = driver.getCurrentUrl();
			assertEquals(actualURL, expectedURL,"Actual url is equal to the expected url(" + expectedURL + ")");
			
		}
		
	// Method to verify the innerHtmlText of the single webelement is equal to the expected text
	public void innerTextEquals(WebElement element, String expectedText) {
		String actualText = element.getText();
		assertEquals(actualText, expectedText);
		//System.out.println(actualText);
	}
	
	// Method to verify the innerHtmlText of the multiple webelement is equal to the expected text
	public void multipleInnerTextEquals(List<WebElement> element, String expectedText) {
		for(WebElement data: element) {
			String actualText = data.getText();
			assertEquals(actualText, expectedText);	
		}
			
	}

	// Method to verify whether the element is available in the application or not
	public void elementAvailable(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isDisplayed();
		assertEquals(actualValue, expectedValue);
		System.out.println(actualValue);
	}

	// Method to verify whether the element is enabled in the application or not
	public void elementEnabled(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue);
	}

	// Method to verify whether the element is selected in the application or not
	public void elementSelected(WebElement element, boolean expectedValue) {
		boolean actualValue = element.isEnabled();
		assertEquals(actualValue, expectedValue);
	}


}
