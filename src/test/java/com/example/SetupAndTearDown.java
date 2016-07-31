package com.example;

import com.example.common.ConfigManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class SetupAndTearDown {

    static final Logger logger = Logger.getLogger(SetupAndTearDown.class);

    public static WebDriver driver;
    private String browser;

    public SetupAndTearDown() {
        this.browser = ConfigManager.get("browser");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.debug("Tags: " + Arrays.toString(scenario.getSourceTagNames().toArray()));
        logger.debug("Starting scenario: " + scenario.getName());
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            driver = new FirefoxDriver(profile);
        } else {
            System.setProperty("webdriver.chrome.driver", ConfigManager.get("chrome.driver"));
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ConfigManager.get("pageLoadTimeout")), TimeUnit.SECONDS);
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screen, "image/png");
                logger.debug("Scenario failed!!");
            }
        }catch (Exception e) {
            logger.debug(e.getMessage());
        } finally {
            driver.quit();
        }
        logger.debug("Ending scenario: " + scenario.getName());
    }
}
