package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserLocators extends PageObjectBase {

    public AddUserLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Add user']")
    protected WebElement titleElement;

    @FindBy(id = "id_username")
    protected WebElement userNameElement;

    @FindBy(id = "id_password1")
    protected WebElement password1Element;

    @FindBy(id = "id_password2")
    protected WebElement password2Element;

    @FindBy(css = "input[name='_save']")
    protected WebElement submitElement;

}
