package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeUserLocators extends PageObjectBase {

    public ChangeUserLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Change user']")
    protected WebElement titleElement;

    @FindBy(id = "id_is_staff")
    protected WebElement idIsStaffElement;

    @FindBy(id = "id_is_superuser")
    protected WebElement idIsSuperUserElement;

    @FindBy(css = "input[name='_save']")
    protected WebElement submitElement;
}
