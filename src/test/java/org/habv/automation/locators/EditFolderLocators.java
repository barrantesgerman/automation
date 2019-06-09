package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditFolderLocators extends PageObjectBase {

    public EditFolderLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_name")
    protected WebElement folderNameElement;

    @FindBy(css = "input[name=_save]")
    protected WebElement submitElement;
}
