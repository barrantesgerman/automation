package org.habv.automation.botstyle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BotStyle {

    private final WebDriver driver;

    /**
     * Constructor
     *
     * @param driver Webdriver instance
     */
    public BotStyle(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method waits for an element to be present
     *
     * @param timeoutInSeconds Time to wait
     * @param element The element to wait for
     * @return
     */
    public WebElement waitForElementPresent(int timeoutInSeconds, final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * This method waits until an element is clickable
     *
     * @param element The element to wait for
     * @param timeoutInSeconds The maximum time to wait
     * @return the element
     */
    public WebElement waitForElementClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /**
     * This method wait for a txt element to be present, clear the txt field and
     * send a specified text
     *
     * @param element The txt input web element
     * @param text The text to fill the txt element with
     */
    public void type(WebElement element, String text) {
        waitForElementPresent(60, element);
        waitForElementClickable(element, 60);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method wait for an element to be present and click son an specified
     * element
     *
     * @param element Element to click on
     * @param timeOuts The time to wait for element to be present
     */
    public void click(WebElement element, int timeOuts) {
        waitForElementPresent(timeOuts, element);
        waitForElementClickable(element, 60);
        element.click();
    }

    /**
     * This method checks if an element is displayed or not
     *
     * @param element The element to check its presence
     * @return
     * <p>
     * True If the element is present</p>
     * <p>
     * False Otherwise</p>
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean isXPathDisplayed(String xpath, Object... params) {
        try {
            findByXPath(xpath, params);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement findByXPath(String xpath, Object... params) {
        return this.driver.findElement(By.xpath(String.format(xpath, params)));
    }

    /**
     * This method mark as check an element.
     *
     * @param element element to check
     */
    public void check(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * This method mark as uncheck an element.
     *
     * @param element element to uncheck
     */
    public void uncheck(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }
}
