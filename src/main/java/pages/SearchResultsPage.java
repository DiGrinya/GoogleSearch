package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@role='main']//div[@class='yuRUbf'][1]")
    private WebElement firstResultLink;

    @FindBy(xpath = "//div[@role='main']//div[@class='tF2Cxc']//div[@class='yuRUbf']//a[contains(@href,'http')]")
    private List<WebElement> searchForSeleniumDev;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstLinkResult() {
        firstResultLink.click();
    }

    public boolean getFirstLinkTitle(final String keyword) {
        String title = driver.getTitle().toLowerCase();
        return title.contains(keyword);
    }

    public boolean getSearchResultsList(final String keyword) {
        int count = 0;
        for (int i = 2; i < 6; i++) {
            for (WebElement url : searchForSeleniumDev) {
                if (url.getAttribute("href").contains(keyword)) count++;
            }
                if (count>0) break;
                    driver.findElement(By.xpath("//td//a[contains(text(),'"+ i +"')]")).click();
                    new WebDriverWait(driver, 5).until(
                            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        return count > 0;
    }

}
