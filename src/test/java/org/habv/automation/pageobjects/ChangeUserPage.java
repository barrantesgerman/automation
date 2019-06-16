package org.habv.automation.pageobjects;

import org.habv.automation.locators.ChangeUserLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChangeUserPage extends ChangeUserLocators {

    public ChangeUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return this.getBot().isElementDisplayed(this.titleElement);
    }

    public boolean isChangePasswordLinkDisplayed() {
        return this.getBot().isElementDisplayed(this.changePasswordLinkElement);
    }

    public boolean isDeleteLinkDisplayed() {
        return this.getBot().isElementDisplayed(this.deleteLinkElement);
    }

    public void checkStaff() {
        this.getBot().check(this.idIsStaffElement);
    }

    public void checkSuperuser() {
        this.getBot().check(this.idIsSuperUserElement);
    }

    public AuthUserPage submit() {
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), AuthUserPage.class);
    }
    
    public ChangePasswordPage changePasswordClick() {
        this.changePasswordLinkElement.click();
        return PageFactory.initElements(this.getDriver(), ChangePasswordPage.class);
    }
    
    public DeleteUserPage deleteLinkClick() {
        this.deleteLinkElement.click();
        return PageFactory.initElements(this.getDriver(), DeleteUserPage.class);
    }
}
