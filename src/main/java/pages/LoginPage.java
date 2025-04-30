package pages;

import org.openqa.selenium.By;

public class LoginPage {
    public By usernameField() {
        return By.id("LoginInput_UserNameOrEmailAddress");
    }

    public By passwordField() {
        return By.id("LoginInput_Password");
    }

    public By loginButton() {
        return By.name("Action");
    }
}
