package org.habv.automation.pageobjects;

import org.habv.automation.locators.EditFolderLocators;
import org.openqa.selenium.WebDriver;

public class EditFolderPage extends EditFolderLocators {

    public EditFolderPage(WebDriver driver) {
        super(driver);
    }

    public void fillFolderName(String folderName) {
        this.folderNameElement.clear();
        this.folderNameElement.sendKeys(folderName);
    }

    public void submit() {
        this.submitElement.submit();
    }

}
