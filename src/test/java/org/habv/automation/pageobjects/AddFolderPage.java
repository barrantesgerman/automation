package org.habv.automation.pageobjects;

import org.habv.automation.locators.AddFolderLocators;
import org.openqa.selenium.WebDriver;

public class AddFolderPage extends AddFolderLocators {
    
    public AddFolderPage(WebDriver driver) {
        super(driver);
    }
    
    public void fillFolderName(String folderName) {
        this.folderNameElement.sendKeys(folderName);
    }

    public void submit() {
        this.submitElement.submit();
    }
}
