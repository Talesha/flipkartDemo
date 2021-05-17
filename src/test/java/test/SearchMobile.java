package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.dashboardPage;


public class SearchMobile extends TestBase{
	@BeforeMethod
	public void beforeMethod(){
		dashboard = new dashboardPage(driver);
		}
	
	@AfterMethod
    public void afterMethod() {
       // System.out.println("In side after test method");
    }
	
    @Test
    public void searchMobileAndFetchResult() {
    	dashboard.clickOnCrossIcon();
    	dashboard.searchProduct("Samsung Galaxy S10");
    	dashboard.clickOnMobileFilter();
    	dashboard.clickOnFlipAssured();
    	dashboard.selectBrandName();
    	dashboard.clickOnHighToLow();
    	dashboard.printPrductNameAndPrice();
    	dashboard.printProductLinkText();
    }
    

}
