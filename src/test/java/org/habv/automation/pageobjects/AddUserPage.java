package org.habv.automation.pageobjects;

import org.habv.automation.locators.AddUserLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends AddUserLocators {

    public AddUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return this.getBot().isElementDisplayed(this.titleElement);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    public void fillPasswod1(String password1) {
        this.password1Element.sendKeys(password1);
    }

    public void fillPasswod2(String password2) {
        this.password2Element.sendKeys(password2);
    }
    
    public ChangeUserPage submit() {
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), ChangeUserPage.class);
    }
    
}
