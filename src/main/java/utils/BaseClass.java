package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    @BeforeClass
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
