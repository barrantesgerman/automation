package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFailLocators extends PageObjectBase {

    public LoginFailLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_username")
    protected WebElement userNameElement;

    @FindBy(id = "id_password")
    protected WebElement passwordElement;

    @FindBy(css = "[type='submit']")
    protected WebElement submitElement;

    @FindBy(className = "errornote")
    protected WebElement errorNoteElement;

}
