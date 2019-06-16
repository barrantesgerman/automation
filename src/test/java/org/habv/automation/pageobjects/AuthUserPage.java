package org.habv.automation.pageobjects;

import org.habv.automation.locators.AuthUserLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AuthUserPage extends AuthUserLocators {
    
    public AuthUserPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isTitleDisplayed() {
        return this.getBot().isElementDisplayed(this.titleElement);
    }

    public boolean isAddUserLinkDisplayed() {
        return this.getBot().isElementDisplayed(this.addUserLinkElement);
    }

    public boolean isUserLinkDisplayed(String userName) {
        return this.getBot().isXPathDisplayed(this.userLinkElement, userName);
    }

    public AddUserPage addUserClick() {
        this.addUserLinkElement.click();
        return PageFactory.initElements(this.getDriver(), AddUserPage.class);
    }
    
    public ChangeUserPage userLinkClick(String userName) {
        this.getBot().findByXPath(this.userLinkElement, userName).click();
        return PageFactory.initElements(this.getDriver(), ChangeUserPage.class);
    }
    
}
