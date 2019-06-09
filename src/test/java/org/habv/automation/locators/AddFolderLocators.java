package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddFolderLocators extends PageObjectBase {

    public AddFolderLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_name")
    protected WebElement folderNameElement;

    @FindBy(css = "input[type='submit']")
    protected WebElement submitElement;
}
