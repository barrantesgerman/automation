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

    public boolean isLogOutDisplayed() {
        return this.getBot().isElementDisplayed(this.logOutElementElement);
    }

    public boolean isFoldersLinkDisplayed() {
        return this.getBot().isElementDisplayed(this.foldersLinkElement);
    }

    public FilerFolderPage foldersLinkClick() {
        this.foldersLinkElement.click();
        return PageFactory.initElements(this.getDriver(), FilerFolderPage.class);
    }

    public AddUserPage addUserLinkClick() {
        this.addUserLinkElement.click();
        return PageFactory.initElements(this.getDriver(), AddUserPage.class);
    }
}
