package com.example.pages;

import com.example.common.BasePage;
import com.example.common.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    private WebDriver driver;
    private Utility utility;

    @FindBy(id = "UserNameTextbox")
    private WebElement usernameInput;

    @FindBy(id = "UserPasswordTextbox")
    private WebElement passwordInput;

    @FindBy(css = "input[class*='btn-yellow']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        utility = new Utility(driver);
    }

    @Override
    public String getTitle() {
        return "Angie's List Member Sign in | Reviews you can Trust";
    }

    public void goToPage() {
        driver.navigate().to("https://my.angieslist.com/AngiesList/login.aspx");
    }

    public boolean isUsernameFieldVisible() {
        return utility.isElementExists(usernameInput);
    }

    public boolean isPasswordFieldVisible() {
        return utility.isElementExists(passwordInput);
    }

    public boolean isSignInButtonVisible() {
        return utility.isElementExists(signInButton);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
}
