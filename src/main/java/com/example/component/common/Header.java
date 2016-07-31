package com.example.component.common;

import com.example.common.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    private Utility utility;
    private WebDriver driver;

    @FindBy(css = "a[class='btnSignin']")
    private WebElement signInLink;

    public Header(WebDriver driver) {
        this.driver = driver;
        utility = new Utility(driver);
    }

    public boolean isSignInLinkPresent() {
        return utility.isElementExists(signInLink);
    }

    public boolean isSignInLinkClickable() {
        return utility.isElementClickable(signInLink);
    }
}
