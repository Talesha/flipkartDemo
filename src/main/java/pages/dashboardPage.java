package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardPage {

	private WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchTextField;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitBtn;

	@FindBy(xpath = "//a[@title='Mobiles']")
	public WebElement mobileFilter;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]/..")
	public WebElement flipkartAssuredCheckBox;

	@FindBy(xpath = "//div[text()='Price -- High to Low']")
	public WebElement highToLowPrice;

	@FindBy(xpath = "//span[text()='Login']")
	public WebElement LoginPoPUp;

	@FindBy(xpath = "//button[text()='✕']")
	public WebElement CrossIcon;

	@FindBy(xpath = "//*[@id='container']/div/div[3]/div/div[2]/div/div/div/div/a/div[2]/div[1]/div[1]")
	public List<WebElement> listOfProductName;

	@FindBy(xpath = "//*[@id='container']/div/div[3]/div/div[2]/div/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]")
	public List<WebElement> listOfProductPrice;

	@FindBy(xpath = "//form[@action='/search']//ul//span")
	public List<WebElement> listOfSearch;

	@FindBy(xpath = "//span[text()='RETRY']")
	public WebElement retryBtn;

	@FindBy(xpath = "//*[@id='container']/div/div[3]/div[1]/div[2]/div/div/div/div/a")
	public List<WebElement> listOfLinkText;

	@FindBy(xpath="//div[text()='SAMSUNG']/..")
	public WebElement brandLabel;
	
	public dashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// create account
	public void searchProduct(String productName) {
		searchTextField.click();
		searchTextField.sendKeys("Samsung Galaxy S10");
		// selectValFromSearchList(productName);
		submitBtn.click();
		if (retryBtn.isDisplayed()) {
			retryBtn.click();
		}
	}

	public void clickOnMobileFilter() {
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(mobileFilter));
			mobileFilter.click();
		} catch (Exception ele) {
			System.out.println("Element not available");
		}
	}

	public void clickOnFlipAssured() {
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(flipkartAssuredCheckBox));
			flipkartAssuredCheckBox.click();
		} catch (Exception ele) {
			System.out.println("Flip Assured Element not available");
		}

	}

	public void clickOnHighToLow() {
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(highToLowPrice));
			highToLowPrice.click();
		} catch (Exception ele) {
			System.out.println("Element not available");
		}
	}

	public void clickOnCrossIcon() {
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginPoPUp));
			CrossIcon.click();
		} catch (Exception ele) {
			System.out.println("Element not available");
		}
	}

	public void printPrductNameAndPrice() {
		for (int i = 0; i < listOfProductName.size(); i++) {
			System.out.println("Product Name : " + listOfProductName.get(i).getText() + " Product Price : "
					+ listOfProductPrice.get(i).getText());
		}
	}

	public void printProductLinkText() {
		for (int i = 0; i < listOfLinkText.size(); i++) {
			System.out.println("Product Link Text : " + listOfLinkText.get(i).getAttribute("href"));
		}
	}

	public void selectValFromSearchList(String val) {
		for (WebElement ele : listOfSearch) {
			if (ele.getText().contains(val)) {
				ele.click();
			}
		}
	}

	public void selectBrandName() {
		brandLabel.click();
	}
}
