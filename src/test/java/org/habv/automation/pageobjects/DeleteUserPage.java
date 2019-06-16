package org.habv.automation.pageobjects;

import org.habv.automation.locators.DeleteUserLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DeleteUserPage extends DeleteUserLocators {
    
    public DeleteUserPage(WebDriver driver) {
        super(driver);
    }
    
    public AuthUserPage submit() {
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), AuthUserPage.class);
    }
}
