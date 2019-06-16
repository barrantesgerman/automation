package org.habv.automation.pageobjects;

import org.habv.automation.locators.DashBoardLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage extends DashBoardLocators {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangePasswordDisplayed() {
        return this.getBot().isElementDisplayed(this.changePasswordElement);
    }
    
    public boolean isUserNameDisplayed(String name) {
        return this.getBot().isXPathDisplayed(this.userNameElement, name);
    }

    public boolean isLogOutDisplayed() {
        return this.getBot().isElementDisplayed(this.logOutElement);
    }

    public boolean isFoldersLinkDisplayed() {
        return this.getBot().isElementDisplayed(this.foldersLinkElement);
    }

    public boolean isUsersLinkDisplayed() {
        return this.getBot().isElementDisplayed(this.usersLinkElement);
    }

    public FilerFolderPage foldersLinkClick() {
        this.foldersLinkElement.click();
        return PageFactory.initElements(this.getDriver(), FilerFolderPage.class);
    }

    public AuthUserPage usersLinkClick() {
        this.usersLinkElement.click();
        return PageFactory.initElements(this.getDriver(), AuthUserPage.class);
    }
}
