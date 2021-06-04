package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class DriverManager {

    private static final String GOOGLE_SEARCH = "https://www.google.com/";

    private static WebDriver driver = null;

    private DriverManager(){}

    public static void initialize() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public  static void openUrl()
    {
        driver.get(GOOGLE_SEARCH);
    }

    public static void quit()
    {
        driver.quit();
        driver = null;
    }

}
