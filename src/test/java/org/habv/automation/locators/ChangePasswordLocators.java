package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordLocators extends PageObjectBase {
    
    public ChangePasswordLocators(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "id_password1")
    protected WebElement idPassword1Element;
    
    @FindBy(id = "id_password2")
    protected WebElement idPassword2Element;
    
    @FindBy(css = "input[type='submit']")
    protected WebElement submitElement;
    
}
