    package com.example.common;

    import org.apache.log4j.Logger;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.NoSuchElementException;
    import org.openqa.selenium.TimeoutException;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.ExpectedCondition;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.util.List;


    public class Utility {

        private WebDriver driver;
        private JavascriptExecutor jsExecutor;
        private Logger logger = Logger.getLogger(Utility.class);

        public Utility(WebDriver driver) {
            this.driver = driver;
            jsExecutor = (JavascriptExecutor) driver;
        }

        public void waitForElementExists(WebElement element, int seconds) {
            try {
                new WebDriverWait(driver, seconds).ignoring(NoSuchElementException.class)
                        .until(ExpectedConditions.visibilityOf(element));
            }catch (TimeoutException te) {
                logger.debug("Unable to find element on the page after waiting " + seconds + " seconds due to: " + te.getMessage());
            }
        }

        public void waitForElementsExists(List<WebElement> elements, int seconds) {
            try {
                new WebDriverWait(driver, seconds).ignoring(NoSuchElementException.class)
                        .until(ExpectedConditions.visibilityOfAllElements(elements));
            }catch (TimeoutException te) {
                logger.debug("Unable to find elements on the page after waiting " + seconds + " seconds due to: " + te.getMessage());
            }
        }

        public boolean isElementExists(WebElement element) {
            boolean flag = false;
            try {
                flag = element.isDisplayed();
            } catch (Exception e) {
                logger.debug("Element not visible on the page");
            }
            return flag;
        }

        public boolean isElementClickable(WebElement element) {
            boolean flag = false;
            try {
                flag = element.isEnabled();
            } catch (Exception e) {
                logger.debug("Element not clickable");
            }
            return flag;
        }

        public boolean waitForPageToLoad() {
            boolean flag = false;
            try {
                new WebDriverWait(driver, 60).ignoring(NoSuchElementException.class)
                        .until((ExpectedCondition<Boolean>) webDriver -> {
                            return (Boolean) jsExecutor.executeScript(
                                    "return window.jQuery != undefined && jQuery.active === 0 && document.readyState === 'complete'"
                            );
                        });
                flag = true;
            } catch (Exception e) {
                logger.debug("Wait for Page Load Failed due to :" + e.getMessage());
            }
            return flag;
        }

        public void moveToElement(WebElement element) {
            try {
                waitForElementExists(element, 10);
                new Actions(driver).moveToElement(element).build().perform();
            } catch (Exception e) {
                logger.debug("Unable to move mouse to the element due to: " + e.getMessage());
            }
        }

        public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
            try {
                waitForElementExists(sourceElement, 10);
                waitForElementExists(destinationElement, 10);
                new Actions(driver).dragAndDrop(sourceElement, destinationElement).build().perform();
            } catch (Exception e) {
                logger.debug("Unable to drag and drop element due to: " + e.getMessage());
            }
        }

        public boolean isElementInFocus(WebElement element) {
            boolean flag = false;
            try {
                waitForElementExists(element, 10);
                flag = (Boolean) jsExecutor.executeScript("document.activeElement === arguments[0]", element);
            } catch (Exception e) {
                logger.debug("Unable to find element is in focus due to: " + e.getMessage());
            }
            return flag;
        }
    }
