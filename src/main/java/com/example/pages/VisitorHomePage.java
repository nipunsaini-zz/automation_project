package com.example.pages;

import com.example.common.BasePage;
import com.example.common.ConfigManager;
import com.example.component.common.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VisitorHomePage extends BasePage{

    public Header header;
    private WebDriver driver;

    public VisitorHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        header = PageFactory.initElements(driver, Header.class);
    }

    public String getTitle() {
        return "Angie's List | Find a Local Business, Ratings, Reviews, Deals";
    }

    public void goToPage() {
        driver.get(ConfigManager.get("baseUrl"));
    }
}
