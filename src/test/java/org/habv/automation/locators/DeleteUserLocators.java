package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteUserLocators extends PageObjectBase {
    
    public DeleteUserLocators(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = "input[type='submit']")
    protected WebElement submitElement;
}
