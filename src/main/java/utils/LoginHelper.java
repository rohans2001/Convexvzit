package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pages.LoginPage;

public class LoginHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;
    private LoginPage loginPage = new LoginPage();

    public LoginHelper(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    public void performLogin(String username, String password) {
        driver.get("https://sundaytest.convexsol.co/Account/Login");

        driver.findElement(loginPage.usernameField()).sendKeys(username);
        driver.findElement(loginPage.passwordField()).sendKeys(password);
        driver.findElement(loginPage.loginButton()).click();

        // Wait for full page load
        wait.until(d -> js.executeScript("return document.readyState").equals("complete"));

        // Check if login was successful
        if (driver.getCurrentUrl().contains("Login")) {
            throw new RuntimeException("Login failed.");
        }
        Reporter.log("✅Login Successful", true);
    }
}
