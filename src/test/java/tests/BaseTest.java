package tests;


import org.testng.annotations.*;
import pages.BasePage;
import pages.SearchPage;
import pages.SearchResultsPage;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        DriverManager.initialize();
    }

    @BeforeMethod
    public void openUrl()throws InterruptedException {
        DriverManager.openUrl();
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quit();
    }


    public BasePage getBasePage() {
        return new BasePage(DriverManager.getDriver());
    }

    public SearchPage getSearchPage() {
        return new SearchPage(DriverManager.getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(DriverManager.getDriver());
    }

}

