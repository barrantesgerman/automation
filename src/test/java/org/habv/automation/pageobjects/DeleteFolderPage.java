package org.habv.automation.pageobjects;

import org.habv.automation.locators.DeleteFolderLocators;
import org.openqa.selenium.WebDriver;

public class DeleteFolderPage extends DeleteFolderLocators {

    public DeleteFolderPage(WebDriver driver) {
        super(driver);
    }

    public void submit() {
        this.submitElement.submit();
    }
}
