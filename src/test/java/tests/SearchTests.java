package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {

    private String SEARCH_KEYWORD = "automation";
    private String SEARCH_FOR_SELENIUM = "epam.ua";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getSearchPage().searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPage().clickOnFirstLinkResult();
        assertTrue(getSearchResultsPage().getFirstLinkTitle(SEARCH_KEYWORD.toLowerCase()));
    }

    @Test(priority = 2)
    public void checkSearchResultsForSeleniumLink() {
        getSearchPage().searchByKeyword(SEARCH_KEYWORD);
        getSearchPage().implicitWait(5);
        assertTrue(getSearchResultsPage().getSearchResultsList(SEARCH_FOR_SELENIUM));

    }

}

